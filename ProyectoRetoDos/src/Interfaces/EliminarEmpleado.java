package Interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
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
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class EliminarEmpleado extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel = new JPanel();
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
	public EliminarEmpleado() {
		setTitle("Baja de empleado");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\e.eguino\\Desktop\\2EVAL\\PROYECTOECLIPSE\\ProyectoRetoDosGit\\markel1.jpg"));
		setModal(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);		
		setBounds(100, 100, 561, 611);
		setLocationRelativeTo(null);
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
		lbDni.setBounds(162, 97, 54, 13);
		contentPanel.add(lbDni);
		
		JLabel lblNewLabel_11 = new JLabel("BAJA DE EMPLEADO");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(0, 0, 547, 45);
		
		lblNewLabel_11.setOpaque(true);
        lblNewLabel_11.setBackground(Color.BLACK);
        lblNewLabel_11.setForeground(Color.WHITE);
		contentPanel.add(lblNewLabel_11);
		
		tfDni = new JTextField();
		tfDni.setBounds(226, 95, 109, 19);
		contentPanel.add(tfDni);
		tfDni.setColumns(10);
		
		JButton btBorrar = new JButton("BAJA DE EMPLEADO");
		btBorrar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String dni = tfDni.getText().trim();

		        if (!dni.matches("\\d{8}[A-Z]")) {
		            JOptionPane.showMessageDialog(null, "Por favor, introduce un DNI válido (8 dígitos seguidos de una letra)", "Campo inválido", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar este empleado?", "Confirmación", JOptionPane.YES_NO_OPTION);

		        if (confirmacion == JOptionPane.YES_OPTION) {
		            Empleado_DAO empleadoDAO = new Empleado_DAO();
		            boolean exito = empleadoDAO.borrar(dni);

		            if (exito) {
		                JOptionPane.showMessageDialog(null, "Empleado eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		                tfDni.setText("");
		                tfNombre.setText("");
		                tfApellido.setText("");
		                tfAntiguedad.setText("");
		                tfSalario.setText("");
		                tfCantCom.setText("");
		                tfCantCoc.setText("");
		                tfTipo.setText("");
		            } else {
		                JOptionPane.showMessageDialog(null, "Error al eliminar el empleado", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        }
		    }
		});


		btBorrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btBorrar.setBounds(188, 491, 200, 45);
		contentPanel.add(btBorrar);
		
		JLabel lblNewLabel_12 = new JLabel("Introduce DNI para buscar y eliminar a empleado");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(0, 55, 573, 13);
		contentPanel.add(lblNewLabel_12);
		
		JButton btBuscar = new JButton("Buscar");
		btBuscar.setBounds(359, 92, 88, 23);
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
					{
						JButton btSalir = new JButton("SALIR");
						btSalir.setBounds(457, 531, 80, 33);
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
					
			        JPanel panelEmp = new JPanel();
			        panelEmp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			        panelEmp.setBounds(86, 139, 416, 342);
			        panelEmp.setBackground(new Color(135, 206, 250)); 
			        contentPanel.add(panelEmp);
			        panelEmp.setLayout(null);
			        
			        JLabel lblNombre = new JLabel("NOMBRE:");
			        lblNombre.setBounds(80, 22, 120, 13);
			        panelEmp.add(lblNombre);
			        lblNombre.setFont(new Font("Dialog", Font.PLAIN, 12));
			        
			        tfNombre = new JTextField();
			        tfNombre.setEditable(false);
			        tfNombre.setBounds(195, 20, 134, 19);
			        panelEmp.add(tfNombre);
			        tfNombre.setColumns(10);
			        
			        JLabel lblApellido = new JLabel("APELLIDO:");
			        lblApellido.setBounds(80, 68, 120, 13);
			        panelEmp.add(lblApellido);
			        lblApellido.setFont(new Font("Dialog", Font.PLAIN, 12));
			        
			        tfApellido = new JTextField();
			        tfApellido.setEditable(false);
			        tfApellido.setBounds(195, 66, 134, 19);
			        panelEmp.add(tfApellido);
			        tfApellido.setColumns(10);
			        
			        JLabel lbAntiguedad = new JLabel("ANTIGUEDAD:");
			        lbAntiguedad.setBounds(80, 114, 120, 13);
			        panelEmp.add(lbAntiguedad);
			        lbAntiguedad.setFont(new Font("Dialog", Font.PLAIN, 12));
			        
			        tfAntiguedad = new JTextField();
			        tfAntiguedad.setEditable(false);
			        tfAntiguedad.setBounds(195, 112, 134, 19);
			        panelEmp.add(tfAntiguedad);
			        tfAntiguedad.setColumns(10);
			        
			        JLabel lbSalario = new JLabel("SALARIO:");
			        lbSalario.setBounds(80, 162, 120, 13);
			        panelEmp.add(lbSalario);
			        lbSalario.setFont(new Font("Dialog", Font.PLAIN, 12));
			        
			        tfSalario = new JTextField();
			        tfSalario.setEditable(false);
			        tfSalario.setBounds(195, 160, 96, 19);
			        panelEmp.add(tfSalario);
			        tfSalario.setColumns(10);
			        
			        JLabel lbCantComandas = new JLabel("CANT COMANDAS:");
			        lbCantComandas.setBounds(80, 210, 120, 13);
			        panelEmp.add(lbCantComandas);
			        lbCantComandas.setFont(new Font("Dialog", Font.PLAIN, 12));
			        
			        tfCantCom = new JTextField();
			        tfCantCom.setEditable(false);
			        tfCantCom.setBounds(195, 208, 96, 19);
			        panelEmp.add(tfCantCom);
			        tfCantCom.setColumns(10);
			        
			        JLabel lbCantCocteles = new JLabel("CANT COCTELES:");
			        lbCantCocteles.setBounds(80, 252, 120, 13);
			        panelEmp.add(lbCantCocteles);
			        lbCantCocteles.setFont(new Font("Dialog", Font.PLAIN, 12));
			        
			        tfCantCoc = new JTextField();
			        tfCantCoc.setEditable(false);
			        tfCantCoc.setBounds(195, 250, 96, 19);
			        panelEmp.add(tfCantCoc);
			        tfCantCoc.setColumns(10);
			        
			        JLabel lbTipo = new JLabel("TIPO:");
			        lbTipo.setBounds(80, 303, 120, 13);
			        panelEmp.add(lbTipo);
			        lbTipo.setFont(new Font("Dialog", Font.PLAIN, 12));
			        
			        tfTipo = new JTextField();
			        tfTipo.setEditable(false);
			        tfTipo.setBounds(195, 301, 134, 19);
			        panelEmp.add(tfTipo);
			        tfTipo.setColumns(10);

			        JPanel panelDni = new JPanel();
			        panelDni.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			        panelDni.setBounds(116, 84, 350, 45);
			        panelDni.setBackground(new Color(135, 206, 250)); 
			        contentPanel.add(panelDni);
	}
	private void stylizeButton(JButton button) {
		button.setFont(new Font("Arial", Font.BOLD, 16)); 
		button.setBackground(new Color(30, 144, 255));
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false); 
	}
}
