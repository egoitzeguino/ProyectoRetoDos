package Interfaces;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexion.ConexionSGL;
import ModeloDAO.Empleado_DAO;
import ModeloDTO.Empleado_DTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;

public class EmpleadoDeterminado extends JDialog {

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
    public EmpleadoDeterminado(boolean dniEditable) {
    	setTitle("Detalle de empleado");
    	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\e.eguino\\Desktop\\2EVAL\\PROYECTOECLIPSE\\ProyectoRetoDosGit\\markel1.jpg"));
        setModal(true);
        setBounds(100, 100, 450, 615);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("C:\\Users\\e.eguino\\Desktop\\2EVAL\\PROYECTOECLIPSE\\ProyectoRetoDosGit\\fondomadera.jpg");
                Image img = backgroundImage.getImage();
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };

        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);

        JLabel lbDni = new JLabel("DNI:");
        lbDni.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbDni.setBounds(74, 75, 120, 13);
        contentPanel.add(lbDni);

        tfDni = new JTextField();
        tfDni.setEditable(dniEditable);  // Establecer editable según el valor proporcionado
        tfDni.setColumns(10);
        tfDni.setBounds(189, 73, 96, 19);
        contentPanel.add(tfDni);

        JLabel lblNombre = new JLabel("NOMBRE:");
        lblNombre.setFont(new Font("Dialog", Font.PLAIN, 12));
        lblNombre.setBounds(74, 155, 120, 13);
        contentPanel.add(lblNombre);

        tfNombre = new JTextField();
        tfNombre.setEditable(false);
        tfNombre.setColumns(10);
        tfNombre.setBounds(189, 153, 180, 19);
        contentPanel.add(tfNombre);

        JLabel lbApel = new JLabel("APELLIDO:");
        lbApel.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbApel.setBounds(74, 201, 120, 13);
        contentPanel.add(lbApel);

        tfApellido = new JTextField();
        tfApellido.setEditable(false);
        tfApellido.setColumns(10);
        tfApellido.setBounds(189, 199, 180, 19);
        contentPanel.add(tfApellido);

        JLabel lbAntigu = new JLabel("ANTIGUEDAD:");
        lbAntigu.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbAntigu.setBounds(74, 247, 120, 13);
        contentPanel.add(lbAntigu);

        tfAntiguedad = new JTextField();
        tfAntiguedad.setEditable(false);
        tfAntiguedad.setColumns(10);
        tfAntiguedad.setBounds(189, 245, 134, 19);
        contentPanel.add(tfAntiguedad);

        JLabel lbSal = new JLabel("SALARIO:");
        lbSal.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbSal.setBounds(74, 295, 120, 13);
        contentPanel.add(lbSal);

        tfSalario = new JTextField();
        tfSalario.setEditable(false);
        tfSalario.setColumns(10);
        tfSalario.setBounds(189, 293, 96, 19);
        contentPanel.add(tfSalario);

        JLabel lbCantCom = new JLabel("CANT COMANDAS:");
        lbCantCom.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbCantCom.setBounds(74, 343, 120, 13);
        contentPanel.add(lbCantCom);

        tfCantCom = new JTextField();
        tfCantCom.setEditable(false);
        tfCantCom.setColumns(10);
        tfCantCom.setBounds(189, 341, 96, 19);
        contentPanel.add(tfCantCom);

        JLabel lbCantCoc = new JLabel("CANT COCTELES:");
        lbCantCoc.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbCantCoc.setBounds(74, 385, 120, 13);
        contentPanel.add(lbCantCoc);

        tfCantCoc = new JTextField();
        tfCantCoc.setEditable(false);
        tfCantCoc.setColumns(10);
        tfCantCoc.setBounds(189, 383, 96, 19);
        contentPanel.add(tfCantCoc);

        JLabel lblTipo = new JLabel("TIPO:");
        lblTipo.setFont(new Font("Dialog", Font.PLAIN, 12));
        lblTipo.setBounds(74, 425, 120, 13);
        contentPanel.add(lblTipo);

        tfTipo = new JTextField();
        tfTipo.setEditable(false);
        tfTipo.setColumns(10);
        tfTipo.setBounds(189, 423, 96, 19);
        contentPanel.add(tfTipo);

        JButton btVolver = new JButton("VOLVER");
        stylizeButton(btVolver);
		btVolver.setBackground(new Color(70, 130, 180));
        btVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btVolver.setBounds(341, 547, 85, 21);
        contentPanel.add(btVolver);

        JButton btInforme = new JButton("INFORME DE EMPLEADO");
        btInforme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component parentComponent = (Component) e.getSource();
				Object[] options = {"Abrir", "Descargar", "Cancelar"};
				int opcion = JOptionPane.showOptionDialog(
				parentComponent,
				"Seleccione una opción:",
				"Opciones",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[0]);
				if (opcion == JOptionPane.YES_OPTION) {
					JasperPrint jasperPrintWindow = null;
					try {
						String dni = tfDni.getText();
	                    Map <String, Object> parametros = new HashMap();
	                    parametros.put ("dni", dni);
						jasperPrintWindow = JasperFillManager.fillReport(
								"src\\Informes\\InformeHorarioEmp.jasper",
								parametros,ConexionSGL.getInstancia().getCon());
					} catch (JRException e1) {
						e1.printStackTrace();
					}
					JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow,false);
					jasperViewer.setVisible(true);
				} else if (opcion == JOptionPane.NO_OPTION) {
					JasperPrint jasperPrint = null;
					try {
						String dni = tfDni.getText();
	                    Map <String, Object> parametros = new HashMap();
	                    parametros.put ("dni", dni);
						jasperPrint = JasperFillManager.fillReport(
								"src\\Informes\\InformeHorarioEmp.jasper",
								parametros,ConexionSGL.getInstancia().getCon());
						JasperExportManager.exportReportToPdfFile(jasperPrint, "InformeHorarioEmp.pdf");
						JOptionPane.showMessageDialog(
								null,
								"Informe descargado con éxito",
								"Descarga exitosa",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					//No hace nada
				}
				
			}
		});
        btInforme.setFont(new Font("Tahoma", Font.BOLD, 12));
        btInforme.setBounds(124, 475, 199, 59);
        contentPanel.add(btInforme);

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
        btBuscar.setBounds(295, 72, 85, 21);
        contentPanel.add(btBuscar);
        
        JLabel lblNewLabel_11 = new JLabel("DETALLE DE EMPLEADO");
        lblNewLabel_11.setOpaque(true);
        lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_11.setForeground(Color.WHITE);
        lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_11.setBackground(Color.BLACK);
        lblNewLabel_11.setBounds(0, 0, 436, 45);
        contentPanel.add(lblNewLabel_11);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel.setBounds(50, 55, 358, 59);
        contentPanel.add(panel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(135, 206, 250));
        panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel_1.setBounds(49, 130, 359, 334);
        contentPanel.add(panel_1);
    }

    public void setDatosEmpleado(Empleado_DTO empleado) {
        tfDni.setText(empleado.getDni());
        tfNombre.setText(empleado.getNombre());
        tfApellido.setText(empleado.getApellido());
        tfAntiguedad.setText(String.valueOf(empleado.getAntiguedad()));
        tfSalario.setText(String.valueOf(empleado.getSalario()));
        tfCantCom.setText(String.valueOf(empleado.getCantComandas()));
        tfCantCoc.setText(String.valueOf(empleado.getCantCocteles()));
        tfTipo.setText(empleado.getTipoEmpleado());
    }
    private void stylizeButton(JButton button) {
		button.setFont(new Font("Arial", Font.BOLD, 12)); 
		button.setBackground(new Color(30, 144, 255));
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false); 
	}
}
