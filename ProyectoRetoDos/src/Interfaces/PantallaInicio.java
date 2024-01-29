package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class PantallaInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaInicio frame = new PantallaInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbTitulo = new JLabel("TORTUGA JUANES");
		lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setBounds(0, 0, 436, 59);
		contentPane.add(lbTitulo);
		
		JButton btFichar = new JButton("FICHAR");
		btFichar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btFichar.setBounds(126, 102, 197, 46);
		contentPane.add(btFichar);
		
		JButton btGerente = new JButton("GESTION DE EMPLEADOS");
		btGerente.setFont(new Font("Tahoma", Font.BOLD, 13));
		btGerente.setBounds(126, 162, 197, 46);
		contentPane.add(btGerente);
	}
}
