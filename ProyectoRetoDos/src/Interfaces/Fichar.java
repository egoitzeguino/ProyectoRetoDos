package Interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Fichar extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfDni;
	private JTextField tfEntrada;
	private JTextField tfSalida;



	/**
	 * Create the dialog.
	 */
	public Fichar() {
		setBounds(100, 100, 570, 458);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lbTitulo = new JLabel("¡BIENVENIDO EMPLEADO!");
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbTitulo.setBounds(0, 0, 556, 51);
		contentPanel.add(lbTitulo);
		
		JLabel lblNewLabel = new JLabel("INTRODUCE DNI:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(88, 85, 114, 13);
		contentPanel.add(lblNewLabel);
		
		tfDni = new JTextField();
		tfDni.setBounds(222, 83, 114, 19);
		contentPanel.add(tfDni);
		tfDni.setColumns(10);
		
		JButton btBuscar = new JButton("BUSCAR");
		btBuscar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btBuscar.setBounds(377, 81, 85, 20);
		contentPanel.add(btBuscar);
		
		JButton btFichar = new JButton("FICHAR");
		btFichar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btFichar.setBounds(76, 174, 103, 42);
		contentPanel.add(btFichar);
		
		JLabel lbFichar = new JLabel("SI HA ENTRADO AHORA PULSE FICHAR");
		lbFichar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbFichar.setBounds(31, 151, 258, 13);
		contentPanel.add(lbFichar);
		
		JLabel lbManual = new JLabel("SI HA ENTRADO A OTRA HORA INTRODUZCA MANUALMENTE");
		lbManual.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbManual.setBounds(31, 247, 368, 13);
		contentPanel.add(lbManual);
		
		JLabel lbEntrada = new JLabel("HORARIO ENTRADA:");
		lbEntrada.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbEntrada.setBounds(31, 284, 125, 13);
		contentPanel.add(lbEntrada);
		
		tfEntrada = new JTextField();
		tfEntrada.setBounds(166, 282, 131, 19);
		contentPanel.add(tfEntrada);
		tfEntrada.setColumns(10);
		
		JLabel lbSalida = new JLabel("HORARIO SALIDA:");
		lbSalida.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbSalida.setBounds(31, 333, 125, 13);
		contentPanel.add(lbSalida);
		
		tfSalida = new JTextField();
		tfSalida.setBounds(166, 331, 131, 19);
		contentPanel.add(tfSalida);
		tfSalida.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btVolver = new JButton("VOLVER");
				btVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
				btVolver.setActionCommand("Cancel");
				buttonPane.add(btVolver);
			}
		}
	}
}
