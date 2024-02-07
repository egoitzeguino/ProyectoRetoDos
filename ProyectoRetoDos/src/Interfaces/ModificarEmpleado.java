package Interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import ModeloDAO.Empleado_DAO;

import ModeloDTO.Empleado_DTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;

public class ModificarEmpleado extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel = new JPanel();
	private JTextField tfDni;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfAntiguedad;
	private JTextField tfSalario;
	private JTextField tfCantCom;
	private JTextField tfCantCoc;
	private JComboBox<String> cbTipo;
	private boolean dniEncontrado = false;



	/**
	 * Create the dialog.
	 */
	public ModificarEmpleado() {
		setTitle("Modificar empleado");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\e.eguino\\Desktop\\2EVAL\\PROYECTOECLIPSE\\ProyectoRetoDosGit\\markel1.jpg"));
		setModal(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 531, 599);
		setLocationRelativeTo(null);
		dniEncontrado = false;
		getContentPane().setLayout(new BorderLayout());
		contentPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("C:\\Users\\e.eguino\\Desktop\\2EVAL\\PROYECTOECLIPSE\\ProyectoRetoDosGit\\fondoazul.jpg");
                Image img = backgroundImage.getImage();
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };

        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);
		
		JLabel lbDni = new JLabel("DNI:");
		lbDni.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbDni.setBounds(158, 104, 39, 13);
		contentPanel.add(lbDni);
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNombre.setBounds(143, 154, 120, 13);
		contentPanel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("APELLIDO:");
		lblApellido.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblApellido.setBounds(143, 200, 120, 13);
		contentPanel.add(lblApellido);
		
		JLabel lbAntiguedad = new JLabel("ANTIGUEDAD:");
		lbAntiguedad.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbAntiguedad.setBounds(143, 246, 120, 13);
		contentPanel.add(lbAntiguedad);
		
		JLabel lbSalario = new JLabel("SALARIO:");
		lbSalario.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbSalario.setBounds(143, 294, 120, 13);
		contentPanel.add(lbSalario);
		
		JLabel lbCantComandas = new JLabel("CANT COMANDAS:");
		lbCantComandas.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbCantComandas.setBounds(143, 342, 120, 13);
		contentPanel.add(lbCantComandas);
		
		JLabel lbCantCocteles = new JLabel("CANT COCTELES:");
		lbCantCocteles.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbCantCocteles.setBounds(143, 384, 120, 13);
		contentPanel.add(lbCantCocteles);
		
		JLabel lbTipo = new JLabel("TIPO:");
		lbTipo.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbTipo.setBounds(143, 435, 120, 13);
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
		tfDni.setBounds(201, 102, 114, 19);
		contentPanel.add(tfDni);
		tfDni.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.setColumns(10);
		tfNombre.setBounds(258, 152, 134, 19);
		contentPanel.add(tfNombre);
		
		tfApellido = new JTextField();
		tfApellido.setColumns(10);
		tfApellido.setBounds(258, 198, 131, 19);
		contentPanel.add(tfApellido);
		
		tfAntiguedad = new JTextField();
		tfAntiguedad.setColumns(10);
		tfAntiguedad.setBounds(258, 244, 134, 19);
		contentPanel.add(tfAntiguedad);
		
		tfSalario = new JTextField();
		tfSalario.setColumns(10);
		tfSalario.setBounds(258, 292, 96, 19);
		contentPanel.add(tfSalario);
		
		tfCantCom = new JTextField();
		tfCantCom.setColumns(10);
		tfCantCom.setBounds(258, 340, 96, 19);
		contentPanel.add(tfCantCom);
		
		tfCantCoc = new JTextField();
		tfCantCoc.setColumns(10);
		tfCantCoc.setBounds(258, 382, 96, 19);
		contentPanel.add(tfCantCoc);
		
		cbTipo = new JComboBox<>(new String[]{"Camarero", "Cocinero", "Coctelero", "Gerente"});
        cbTipo.setBounds(258, 433, 134, 19);
        contentPanel.add(cbTipo);
		
		JButton btModificar = new JButton("MODIFICAR CLIENTE");
		btModificar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if (tfDni.getText().isEmpty() || tfNombre.getText().isEmpty() || tfApellido.getText().isEmpty()
		                || tfSalario.getText().isEmpty() || tfAntiguedad.getText().isEmpty() || tfCantCom.getText().isEmpty()
		                || tfCantCoc.getText().isEmpty() || cbTipo.getSelectedItem() == null ) {
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
		        String tipo = cbTipo.getSelectedItem().toString();
		       
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
		        } else {
		            JOptionPane.showMessageDialog(null, "Error al modificar el cliente", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		    }
		});
		btModificar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btModificar.setBounds(169, 480, 209, 52);
		contentPanel.add(btModificar);
		
		
		JLabel lblNewLabel_12 = new JLabel("Introduce DNI para buscar y modificar a empleado");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(0, 61, 517, 13);
		contentPanel.add(lblNewLabel_12);
		
		JButton btBuscar = new JButton("Buscar");
		btBuscar.setBounds(325, 99, 82, 23);
		contentPanel.add(btBuscar);
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
		            dniEncontrado = true;
		            tfNombre.setText(empleado.getNombre());
		            tfApellido.setText(empleado.getApellido());
		            tfAntiguedad.setText(String.valueOf(empleado.getAntiguedad()));
		            tfSalario.setText(String.valueOf(empleado.getSalario()));
		            tfCantCom.setText(String.valueOf(empleado.getCantComandas()));
		            tfCantCoc.setText(String.valueOf(empleado.getCantCocteles()));
		            cbTipo.setSelectedItem(empleado.getTipoEmpleado());
		        } else {
		            dniEncontrado = false;
		            JOptionPane.showMessageDialog(null, "Empleado no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
		        }

		        actualizarEstadoCamposTexto();
		    }
		});
		
		
					btBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
					{
						JButton btSalir = new JButton("SALIR");
						btSalir.setBounds(435, 529, 72, 23);
						stylizeButton(btSalir);
						btSalir.setBackground(new Color(70, 130, 180));
						contentPanel.add(btSalir);
						btSalir.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								dispose();
							}
						});
						btSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
						btSalir.setActionCommand("Cancel");
					}
					
					JPanel paneldni = new JPanel();
					paneldni.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
					paneldni.setBounds(118, 84, 310, 52);
					paneldni.setBackground(new Color(135, 206, 250));
					contentPanel.add(paneldni);
					
					JPanel panelEmp = new JPanel();
					panelEmp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
					panelEmp.setBounds(88, 140, 375, 329);
					panelEmp.setBackground(new Color(135, 206, 250));
					contentPanel.add(panelEmp);
	}
	private void stylizeButton(JButton button) {
		button.setFont(new Font("Arial", Font.BOLD, 16)); 
		button.setBackground(new Color(30, 144, 255));
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false); 
	}
	private void actualizarEstadoCamposTexto() {
	    tfNombre.setEditable(dniEncontrado);
	    tfApellido.setEditable(dniEncontrado);
	    tfAntiguedad.setEditable(dniEncontrado);
	    tfSalario.setEditable(dniEncontrado);
	    tfCantCom.setEditable(dniEncontrado);
	    tfCantCoc.setEditable(dniEncontrado);
	    cbTipo.setEnabled(dniEncontrado);
	}
}
