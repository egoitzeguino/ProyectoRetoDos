package Interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.Toolkit;

public class PantallaInicio extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
	private static JLabel lbEstadoCielo,lbImagenNublado;
	private static String fecha, estadoCielo;
	private static SimpleDateFormat formatoFecha;
	private static Calendar calendar;
	private static Registry registry;
	private static IGestionTerraza gestionTerraza;
	private static JLabel lbImagenLluvia;
	private static JLabel lbImagenSol;
	private static JLabel lbImagenSolLluvia;
	private static JLabel lbFecha;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
			        calendar = Calendar.getInstance();
			        
					registry = LocateRegistry.getRegistry("localhost", 1099);
			        // Se busca el objeto remoto en el registro RMI
					gestionTerraza = (IGestionTerraza) registry.lookup("GestionTerraza");
					gestionTerraza.descargarArchivo("https://www.dropbox.com/scl/fi/n461vbwu108vea6zduhia/clima.json?rlkey=36v1q4mock8wl0pxvocummzmc&dl=1", "");

			        // Obtener la fecha actual
			        fecha = formatoFecha.format(calendar.getTime());
                    PantallaInicio frame = new PantallaInicio();
                    RMI();
                    frame.lbFecha.setText(fecha);
                    frame.setImage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PantallaInicio() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\e.eguino\\Desktop\\2EVAL\\PROYECTOECLIPSE\\ProyectoRetoDosGit\\markel1.jpg"));
    	setTitle("Tortuga Juanes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 521, 385);
        setLocationRelativeTo(null);
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(new GradientPaint(0, 0, new Color(240, 240, 240), 0, getHeight(), new Color(200, 200, 255)));
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lbEstadoCielo = new JLabel("New label");
        lbEstadoCielo.setBounds(23, 104, 187, 33);
        contentPane.add(lbEstadoCielo);

        JLabel lbTitulo = new JLabel("TORTUGA JUANES");
        lbTitulo.setFont(new Font("Arial", Font.BOLD, 30));
        lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitulo.setBounds(0, 20, 507, 50);
        contentPane.add(lbTitulo);

        JButton btFichar = new JButton("FICHAR");
        btFichar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Fichar fi = new Fichar();
                fi.setVisible(true);
            }
        });
        btFichar.setFont(new Font("Arial", Font.BOLD, 18));
        btFichar.setBounds(62, 187, 374, 60);
        btFichar.setBackground(new Color(46, 204, 113)); // Emerald Green
        btFichar.setForeground(Color.WHITE);
        contentPane.add(btFichar);

        JButton btGerente = new JButton("GESTIÓN DE EMPLEADOS");
        btGerente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InicioSesion is = new InicioSesion();
                is.setVisible(true);
            }
        });
        btGerente.setFont(new Font("Arial", Font.BOLD, 18));
        btGerente.setBounds(62, 277, 374, 60);
        btGerente.setBackground(new Color(52, 152, 219)); // Royal Blue
        btGerente.setForeground(Color.WHITE);
        contentPane.add(btGerente);

        JLabel lblImagen1 = new JLabel();
        lblImagen1.setBounds(28, 20, 50, 50);        
        ImageIcon imagenIcon1 = new ImageIcon("C:\\Users\\e.eguino\\Desktop\\2EVAL\\PROYECTOECLIPSE\\ProyectoRetoDos\\restaurante.png");
        Image imagenOriginal1 = imagenIcon1.getImage();
        int ancho1 = lblImagen1.getWidth();
        int alto1 = lblImagen1.getHeight();        
        Image imagenRedimensionada1 = imagenOriginal1.getScaledInstance(ancho1, alto1, Image.SCALE_SMOOTH);
        ImageIcon imagenRedimensionadaIcon1 = new ImageIcon(imagenRedimensionada1);
        lblImagen1.setIcon(imagenRedimensionadaIcon1);
        contentPane.add(lblImagen1);

        JLabel lblImagen2 = new JLabel();
        lblImagen2.setBounds(422, 20, 50, 50);        
        ImageIcon imagenIcon2 = new ImageIcon("C:\\Users\\e.eguino\\Desktop\\2EVAL\\PROYECTOECLIPSE\\ProyectoRetoDos\\restaurante.png");
        Image imagenOriginal2 = imagenIcon2.getImage();
        int ancho2 = lblImagen2.getWidth();
        int alto2 = lblImagen2.getHeight();        
        Image imagenRedimensionada2 = imagenOriginal2.getScaledInstance(ancho2, alto2, Image.SCALE_SMOOTH);
        ImageIcon imagenRedimensionadaIcon2 = new ImageIcon(imagenRedimensionada2);
        lblImagen2.setIcon(imagenRedimensionadaIcon2);
        contentPane.add(lblImagen2);        
        

        
        lbFecha = new JLabel((String) null);
        lbFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
        lbFecha.setBounds(332, 104, 99, 32);
        contentPane.add(lbFecha);
        
        lbImagenNublado = new JLabel("");
        lbImagenNublado.setIcon(new ImageIcon("C:\\tiempo\\solNubes.png"));
        lbImagenNublado.setBounds(267, 94, 55, 53);
        contentPane.add(lbImagenNublado);
        
        lbImagenLluvia = new JLabel("");
        lbImagenLluvia.setIcon(new ImageIcon("C:\\tiempo\\lluvia.png"));
        lbImagenLluvia.setBounds(267, 94, 55, 53);
        contentPane.add(lbImagenLluvia);
        
        lbImagenSol = new JLabel("");
        lbImagenSol.setIcon(new ImageIcon("C:\\tiempo\\sol.png"));
        lbImagenSol.setBounds(267, 94, 55, 53);
        contentPane.add(lbImagenSol);
        
        lbImagenSolLluvia = new JLabel("");
        lbImagenSolLluvia.setIcon(new ImageIcon("C:\\tiempo\\lluviaConSol.png"));
        lbImagenSolLluvia.setBounds(267, 94, 55, 53);
        contentPane.add(lbImagenSolLluvia);
        
        JButton btnNewButton = new JButton("<");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				// Incrementar la fecha por un día
		        calendar.add(Calendar.DAY_OF_MONTH, -1);
		        fecha = formatoFecha.format(calendar.getTime());
		        lbFecha.setText(fecha);
		        try {
					RMI();
					setImage();
				} catch (NotBoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 8));
        btnNewButton.setBounds(220, 104, 42, 33);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton(">");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				calendar.add(Calendar.DAY_OF_MONTH, 1);
				fecha = formatoFecha.format(calendar.getTime());
				lbFecha.setText(fecha);
				try {
					RMI();
					setImage();
				} catch (NotBoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 8));
        btnNewButton_1.setBounds(430, 104, 42, 33);
        contentPane.add(btnNewButton_1);
        

    }
    public static void RMI() throws NotBoundException, IOException {
        estadoCielo = gestionTerraza.interpretarArchivo("clima.json",fecha);
        if(!estadoCielo.equals("")) {
            PantallaInicio.lbEstadoCielo.setText(estadoCielo);
        } else {
            PantallaInicio.lbEstadoCielo.setText("No hay datos del dia " + fecha);
        }
    }

	private void setImage() {
        try {
			if(estadoCielo.equals("Muy nuboso con lluvia")) {
				lbImagenNublado.setVisible(false);
				lbImagenLluvia.setVisible(true);
				lbImagenSol.setVisible(false);
				lbImagenSolLluvia.setVisible(false);
			}else if(estadoCielo.equals("Nuboso con lluvia")) {
				lbImagenNublado.setVisible(false);
				lbImagenLluvia.setVisible(true);
				lbImagenSol.setVisible(false);
				lbImagenSolLluvia.setVisible(false);
			}else if(estadoCielo.equals("Cubierto con lluvia")){
				lbImagenNublado.setVisible(false);
				lbImagenLluvia.setVisible(false);
				lbImagenSol.setVisible(false);
				lbImagenSolLluvia.setVisible(true);
			}
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
