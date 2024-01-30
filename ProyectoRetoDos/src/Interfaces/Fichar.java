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
import javax.swing.border.BevelBorder;

public class Fichar extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfDni;
	private JTextField tfEntrada;
	private JTextField tfSalida;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfTipo;



	/**
	 * Create the dialog.
	 */
	public Fichar() {
		setBounds(100, 100, 797, 552);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lbTitulo = new JLabel("¡BIENVENIDO EMPLEADO!");
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbTitulo.setBounds(0, 0, 783, 51);
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
		btFichar.setBounds(133, 276, 103, 42);
		contentPanel.add(btFichar);
		
		JLabel lbFichar = new JLabel("SI HA ENTRADO AHORA PULSE FICHAR");
		lbFichar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbFichar.setBounds(88, 253, 258, 13);
		contentPanel.add(lbFichar);
		
		JLabel lbManual = new JLabel("SI HA ENTRADO A OTRA HORA INTRODUZCA MANUALMENTE");
		lbManual.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbManual.setBounds(88, 343, 368, 13);
		contentPanel.add(lbManual);
		
		JLabel lbEntrada = new JLabel("HORARIO ENTRADA:");
		lbEntrada.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbEntrada.setBounds(88, 380, 125, 13);
		contentPanel.add(lbEntrada);
		
		tfEntrada = new JTextField();
		tfEntrada.setBounds(223, 378, 131, 19);
		contentPanel.add(tfEntrada);
		tfEntrada.setColumns(10);
		
		JLabel lbSalida = new JLabel("HORARIO SALIDA:");
		lbSalida.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbSalida.setBounds(88, 429, 125, 13);
		contentPanel.add(lbSalida);
		
		tfSalida = new JTextField();
		tfSalida.setBounds(223, 427, 131, 19);
		contentPanel.add(tfSalida);
		tfSalida.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(126, 143, 80, 13);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("APELLIDO:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(309, 143, 70, 13);
		contentPanel.add(lblNewLabel_2);
		
		tfNombre = new JTextField();
		tfNombre.setEditable(false);
		tfNombre.setBounds(126, 166, 125, 28);
		contentPanel.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfApellido = new JTextField();
		tfApellido.setEditable(false);
		tfApellido.setColumns(10);
		tfApellido.setBounds(309, 166, 118, 28);
		contentPanel.add(tfApellido);
		
		JLabel lblNewLabel_3 = new JLabel("TIPO EMPLEADO:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(481, 143, 103, 13);
		contentPanel.add(lblNewLabel_3);
		
		tfTipo = new JTextField();
		tfTipo.setEditable(false);
		tfTipo.setBounds(481, 166, 125, 28);
		contentPanel.add(tfTipo);
		tfTipo.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(88, 121, 569, 103);
		contentPanel.add(panel);
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
