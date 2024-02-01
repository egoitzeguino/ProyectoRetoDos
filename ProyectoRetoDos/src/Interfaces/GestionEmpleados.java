package Interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionEmpleados extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();


	/**
	 * Create the dialog.
	 */
	public GestionEmpleados() {
		setBounds(100, 100, 451, 564);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("¡BIENVENIDO DE NUEVO!");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel.setBounds(10, 0, 437, 70);
			contentPanel.add(lblNewLabel);
		}
		
		JButton btAnadir = new JButton("AÑADIR EMPLEADO");
		btAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnadirEmpleado ae = new AnadirEmpleado();
				ae.setVisible(true);
			}
		});
		btAnadir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btAnadir.setBounds(0, 232, 437, 48);
		contentPanel.add(btAnadir);
		
		JButton btnEliminarEmpleado = new JButton("ELIMINAR EMPLEADO");
		btnEliminarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarEmpleado ee = new EliminarEmpleado();
				ee.setVisible(true);
			}
		});
		btnEliminarEmpleado.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminarEmpleado.setBounds(0, 275, 437, 48);
		contentPanel.add(btnEliminarEmpleado);
		
		JButton btnMostarEmpleado = new JButton("MOSTRAR TODOS LOS EMPLEADOS");
		btnMostarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarEmpleados me = new MostrarEmpleados();
				me.setVisible(true);
			}
		});
		btnMostarEmpleado.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMostarEmpleado.setBounds(0, 407, 437, 48);
		contentPanel.add(btnMostarEmpleado);
		
		JButton btVolver = new JButton("VOLVER");
		btVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btVolver.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btVolver.setBounds(342, 489, 85, 28);
		contentPanel.add(btVolver);
		
		JButton btModificarEmpleado = new JButton("MODIFICAR EMPLEADO");
		btModificarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarEmpleado me = new ModificarEmpleado();
				me.setVisible(true);
			}
		});
		btModificarEmpleado.setFont(new Font("Tahoma", Font.BOLD, 14));
		btModificarEmpleado.setBounds(0, 316, 437, 48);
		contentPanel.add(btModificarEmpleado);
		
		JButton btnDetallesDeEmpleado = new JButton("DETALLES DE EMPLEADO");
		btnDetallesDeEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpleadoDeterminado ed = new EmpleadoDeterminado();
				ed.setVisible(true);
			}
		});
		btnDetallesDeEmpleado.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDetallesDeEmpleado.setBounds(0, 361, 437, 48);
		contentPanel.add(btnDetallesDeEmpleado);
	}
}
