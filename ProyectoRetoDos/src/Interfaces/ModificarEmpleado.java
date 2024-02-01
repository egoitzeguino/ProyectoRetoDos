package Interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import ModeloDAO.Empleado_DAO;

import ModeloDTO.Empleado_DTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class ModificarEmpleado extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfDni;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfAntiguedad;
	private JTextField tfSalario;
	private JTextField tfCantCom;
	private JTextField tfCantCoc;
	private JTextField tfTipo;



	/**
	 * Create the dialog.
	 */
	public ModificarEmpleado() {
		setModal(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 531, 542);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lbDni = new JLabel("DNI:");
		lbDni.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbDni.setBounds(10, 86, 120, 13);
		contentPanel.add(lbDni);
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNombre.setBounds(10, 126, 120, 13);
		contentPanel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("APELLIDO:");
		lblApellido.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApellido.setBounds(10, 172, 120, 13);
		contentPanel.add(lblApellido);
		
		JLabel lbAntiguedad = new JLabel("ANTIGUEDAD:");
		lbAntiguedad.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbAntiguedad.setBounds(10, 218, 120, 13);
		contentPanel.add(lbAntiguedad);
		
		JLabel lbSalario = new JLabel("SALARIO:");
		lbSalario.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbSalario.setBounds(10, 266, 120, 13);
		contentPanel.add(lbSalario);
		
		JLabel lbCantComandas = new JLabel("CANT COMANDAS:");
		lbCantComandas.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbCantComandas.setBounds(10, 314, 120, 13);
		contentPanel.add(lbCantComandas);
		
		JLabel lbCantCocteles = new JLabel("CANT COCTELES:");
		lbCantCocteles.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbCantCocteles.setBounds(10, 356, 120, 13);
		contentPanel.add(lbCantCocteles);
		
		JLabel lbTipo = new JLabel("TIPO:");
		lbTipo.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbTipo.setBounds(10, 407, 120, 13);
		contentPanel.add(lbTipo);
		
		JLabel lblNewLabel_11 = new JLabel("MODIFICACION DE EMPLEADO");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(0, 0, 517, 45);
		
		lblNewLabel_11.setOpaque(true);
        lblNewLabel_11.setBackground(Color.BLACK);
        lblNewLabel_11.setForeground(Color.WHITE);
		contentPanel.add(lblNewLabel_11);
		
		tfDni = new JTextField();
		tfDni.setBounds(125, 84, 46, 19);
		contentPanel.add(tfDni);
		tfDni.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.setColumns(10);
		tfNombre.setBounds(125, 124, 134, 19);
		contentPanel.add(tfNombre);
		
		tfApellido = new JTextField();
		tfApellido.setColumns(10);
		tfApellido.setBounds(125, 170, 131, 19);
		contentPanel.add(tfApellido);
		
		tfAntiguedad = new JTextField();
		tfAntiguedad.setColumns(10);
		tfAntiguedad.setBounds(125, 216, 134, 19);
		contentPanel.add(tfAntiguedad);
		
		tfSalario = new JTextField();
		tfSalario.setColumns(10);
		tfSalario.setBounds(125, 264, 96, 19);
		contentPanel.add(tfSalario);
		
		tfCantCom = new JTextField();
		tfCantCom.setColumns(10);
		tfCantCom.setBounds(125, 312, 96, 19);
		contentPanel.add(tfCantCom);
		
		tfCantCoc = new JTextField();
		tfCantCoc.setColumns(10);
		tfCantCoc.setBounds(125, 354, 263, 19);
		contentPanel.add(tfCantCoc);
		
		tfTipo = new JTextField();
		tfTipo.setColumns(10);
		tfTipo.setBounds(125, 405, 263, 19);
		contentPanel.add(tfTipo);
		
		JButton btModificar = new JButton("MODIFICAR CLIENTE");
		btModificar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if (tfDni.getText().isEmpty() || tfNombre.getText().isEmpty() || tfApellido.getText().isEmpty()
		                || tfSalario.getText().isEmpty() || tfAntiguedad.getText().isEmpty() || tfCantCom.getText().isEmpty()
		                || tfCantCoc.getText().isEmpty() || tfTipo.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos antes de intentar modificar el empleado",
		                    "Campos vacíos", JOptionPane.WARNING_MESSAGE);
		            return; 
		        }
		    	else {
		       
		        String dni = tfDni.getText();		        
		        String nombre = tfNombre.getText();
		        String apellido = tfApellido.getText();
		        Date antiguedad = Date.valueOf(tfAntiguedad.getText());
		        double salario = Double.parseDouble(tfSalario.getText());
		        int cantComandas = Integer.parseInt(tfCantCom.getText());
		        int cantCocteles = Integer.parseInt(tfCantCoc.getText());
		        String tipo = tfTipo.getText();
		       
		        Empleado_DTO empleadoModificado = new Empleado_DTO(dni, nombre, apellido,
		        		antiguedad, salario, cantComandas, cantCocteles, tipo);

		        Empleado_DAO empleadoDAO = new Empleado_DAO();
		        boolean exito = empleadoDAO.actualizar(empleadoModificado);

		        if (exito) {
		            JOptionPane.showMessageDialog(null, "Empleado modificado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		            tfDni.setText("");
		            tfNombre.setText("");
		            tfApellido.setText("");
		            tfAntiguedad.setText("");
		            tfSalario.setText("");
		            tfCantCom.setText("");
		            tfCantCoc.setText("");
		            tfTipo.setText("");
		        } else {
		            JOptionPane.showMessageDialog(null, "Error al modificar el cliente", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		    }
		});
		btModificar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btModificar.setBounds(162, 418, 189, 52);
		contentPanel.add(btModificar);
		
		
		JLabel lblNewLabel_12 = new JLabel("Introduce DNI para buscar y modificar a empleado");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(0, 61, 517, 13);
		contentPanel.add(lblNewLabel_12);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btBuscar = new JButton("Buscar");
			btBuscar.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        if (tfDni.getText().isEmpty()) {
			            JOptionPane.showMessageDialog(null, "Por favor, introduce un DNI antes de buscar", "Campo vacío", JOptionPane.WARNING_MESSAGE);
			            return;
			        }

			        String dni = tfDni.getText();

			        Empleado_DAO empleadoDAO = new Empleado_DAO();
			        Empleado_DTO empleado = empleadoDAO.buscar(dni);

			        if (empleado != null) {
			            tfNombre.setText(empleado.getNombre());
			            tfApellido.setText(empleado.getApellido());
			            tfAntiguedad.setText(String.valueOf(empleado.getAntiguedad()));
			            tfSalario.setText(String.valueOf(empleado.getSalario()));
			            tfCantCom.setText(String.valueOf(empleado.getCantComandas()));
			            tfCantCoc.setText(String.valueOf(empleado.getCantCocteles()));
			            tfTipo.setText(empleado.getTipoEmpleado());
			        } else {
			            JOptionPane.showMessageDialog(null, "Empleado no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
			        }
			    }
			});


			btBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			buttonPane.add(btBuscar);
			{
				JButton btSalir = new JButton("Salir");
				btSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btSalir.setActionCommand("Cancel");
				buttonPane.add(btSalir);
			}
		}
	}
}
