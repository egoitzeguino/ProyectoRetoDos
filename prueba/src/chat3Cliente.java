import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class chat3Cliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfTextoEnviar;
	private JTextArea chatArea;
	
	private static String host="192.168.105.28";
	private static final int puerto=6000;
	private static DataOutputStream out;
	private static DataInputStream in;
	private static SSLSocket socket;
	private static String nombre;

	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chat3Cliente frame = new chat3Cliente(nombre);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public chat3Cliente(String Nombre) throws UnknownHostException, IOException {
		 //InetAddress localHost = InetAddress.getLocalHost();
		//host = localHost.getHostAddress();
		
		System.setProperty("javax.net.ssl.trustStore","certificados/UsuarioAlmacenSSL");
		System.setProperty("javax.net.ssl.trustStorePassword","890123");
		
		SSLSocketFactory sfact=(SSLSocketFactory) SSLSocketFactory.getDefault();
		socket= (SSLSocket) sfact.createSocket(host, puerto);
		
		out=new DataOutputStream(socket.getOutputStream());	
		in = new DataInputStream(socket.getInputStream());
		
		this.nombre=Nombre;
		out.writeUTF(nombre);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfTextoEnviar = new JTextField();
		tfTextoEnviar.setBounds(22, 211, 298, 31);
		contentPane.add(tfTextoEnviar);
		tfTextoEnviar.setColumns(10);
		
		JButton btnNewButton = new JButton("enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sendMessage();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(341, 211, 85, 31);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 10, 404, 173);
		contentPane.add(scrollPane);
		
		chatArea = new JTextArea();
		chatArea.setEditable(false);
		scrollPane.setColumnHeaderView(chatArea);
		

        // Thread para recibir mensajes del servidor
        new Thread(() -> {
            try {
                while (true) {
                	try {
	                    String message = in.readUTF();
	                    appendMessage(message);
                	}
                	catch (EOFException e) {
                        // Si ocurre EOFException, significa que la conexión se cerró
                        System.out.println("Conexión cerrada por el servidor.");
                        tfTextoEnviar.setEnabled(false);
                        break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
	}
	
	private void sendMessage() throws IOException {
        String message = tfTextoEnviar.getText();
        if (!message.isEmpty()) {
            out.writeUTF(message);
            tfTextoEnviar.setText("");
        }
    }

    private void appendMessage(String message) {
        SwingUtilities.invokeLater(() -> {
            chatArea.append("\n" + message);
        });
    }
}
