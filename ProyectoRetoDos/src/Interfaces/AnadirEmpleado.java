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
import java.sql.Date;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;

public class AnadirEmpleado extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel contentPanel = new JPanel();
    private JTextField tfDni;
    private JTextField tfNombre;
    private JTextField tfApellido;
    private JTextField tfAntiguedad;
    private JTextField tfSalario;
    private JTextField tfCantCom;
    private JTextField tfCantCoc;

    /**
     * Create the dialog.
     */
    public AnadirEmpleado() {
    	setTitle("Alta de empleado");
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\e.eguino\\Desktop\\2EVAL\\PROYECTOECLIPSE\\ProyectoRetoDosGit\\markel1.jpg"));
        setModal(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setBounds(100, 100, 544, 629);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        
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
        lbDni.setBounds(122, 88, 120, 13);
        contentPanel.add(lbDni);

        JLabel lblNombre = new JLabel("NOMBRE:");
        lblNombre.setFont(new Font("Dialog", Font.PLAIN, 12));
        lblNombre.setBounds(122, 128, 120, 13);
        contentPanel.add(lblNombre);

        JLabel lbApel = new JLabel("APELLIDO:");
        lbApel.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbApel.setBounds(122, 174, 120, 13);
        contentPanel.add(lbApel);

        JLabel lbAntigu = new JLabel("ANTIGUEDAD:");
        lbAntigu.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbAntigu.setBounds(122, 292, 120, 13);
        contentPanel.add(lbAntigu);

        JLabel lbSal = new JLabel("SALARIO:");
        lbSal.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbSal.setBounds(122, 340, 120, 13);
        contentPanel.add(lbSal);

        JLabel lbCantCom = new JLabel("CANT COMANDAS:");
        lbCantCom.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbCantCom.setBounds(168, 400, 120, 13);
        contentPanel.add(lbCantCom);

        JLabel lbTipo = new JLabel("TIPO EMPLEADO:");
        lbTipo.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbTipo.setBounds(122, 226, 120, 13);
        contentPanel.add(lbTipo);

        JLabel lbCantCoc = new JLabel("CANT COCTELES:");
        lbCantCoc.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbCantCoc.setBounds(168, 442, 120, 13);
        contentPanel.add(lbCantCoc);

        tfDni = new JTextField();
        tfDni.setBounds(237, 86, 96, 19);
        contentPanel.add(tfDni);
        tfDni.setColumns(10);

        tfNombre = new JTextField();
        tfNombre.setColumns(10);
        tfNombre.setBounds(237, 126, 180, 19);
        contentPanel.add(tfNombre);

        tfApellido = new JTextField();
        tfApellido.setColumns(10);
        tfApellido.setBounds(237, 172, 180, 19);
        contentPanel.add(tfApellido);

        tfAntiguedad = new JTextField();
        tfAntiguedad.setColumns(10);
        tfAntiguedad.setBounds(237, 290, 134, 19);
        contentPanel.add(tfAntiguedad);

        tfSalario = new JTextField();
        tfSalario.setColumns(10);
        tfSalario.setBounds(237, 338, 96, 19);
        contentPanel.add(tfSalario);

        tfCantCom = new JTextField();
        tfCantCom.setColumns(10);
        tfCantCom.setBounds(283, 398, 96, 19);
        contentPanel.add(tfCantCom);

        tfCantCoc = new JTextField();
        tfCantCoc.setColumns(10);
        tfCantCoc.setBounds(283, 440, 96, 19);
        contentPanel.add(tfCantCoc);



        
        JComboBox<String> cbTipo = new JComboBox<>();
        cbTipo.setBounds(237, 223, 134, 21);
        cbTipo.addItem("Camarero");
        cbTipo.addItem("Coctelero");
        cbTipo.addItem("Cocinero");
        cbTipo.addItem("Gerente");
        contentPanel.add(cbTipo);
        
                    JButton btAnadir = new JButton("AÑADIR");
                    btAnadir.setBounds(214, 496, 134, 45);
                    contentPanel.add(btAnadir);
                    btAnadir.setFont(new Font("Tahoma", Font.BOLD, 14));
                    
                                JButton btSalir = new JButton("SALIR");
                                btSalir.setBounds(424, 556, 96, 26);
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
                                
                                JLabel lblNewLabel_11 = new JLabel("ALTA DE EMPLEADO");
                                lblNewLabel_11.setOpaque(true);
                                lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
                                lblNewLabel_11.setForeground(Color.WHITE);
                                lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 20));
                                lblNewLabel_11.setBackground(Color.BLACK);
                                lblNewLabel_11.setBounds(0, 0, 530, 51);
                                contentPanel.add(lblNewLabel_11);
                                
                                JPanel panel = new JPanel();
                                panel.setBackground(new Color(135, 206, 250));
                                panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
                                panel.setBounds(26, 68, 476, 196);
                                contentPanel.add(panel);
                                
                                JPanel panel_1 = new JPanel();
                                panel_1.setBackground(new Color(135, 206, 250));
                                panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
                                panel_1.setBounds(26, 274, 476, 97);
                                contentPanel.add(panel_1);
                                
                                JPanel panel_2 = new JPanel();
                                panel_2.setBackground(new Color(135, 206, 250));
                                panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
                                panel_2.setBounds(136, 381, 287, 97);
                                contentPanel.add(panel_2);
                    btAnadir.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if (!tfDni.getText().isEmpty() && !tfNombre.getText().isEmpty() && !tfAntiguedad.getText().isEmpty()
                                    && !tfSalario.getText().isEmpty()
                                    && !cbTipo.getSelectedItem().toString().isEmpty()) {

                                try {
                                    String dni = tfDni.getText();
                                    String nombre = tfNombre.getText();
                                    String apellido = tfApellido.getText();
                                    Date antiguedad = Date.valueOf(tfAntiguedad.getText());  
                                    double salario = Double.parseDouble(tfSalario.getText());
                                    int cantcom = Integer.parseInt(tfCantCom.getText());
                                    int cantcoc = Integer.parseInt(tfCantCoc.getText());
                                    String tipo = cbTipo.getSelectedItem().toString();

                                    Empleado_DTO newEmpleado = new Empleado_DTO(dni, nombre, apellido, antiguedad, salario, cantcom, cantcoc, tipo);

                                    Empleado_DAO empleadoDAO = new Empleado_DAO();
                                    boolean success = empleadoDAO.insertar(newEmpleado);

                                    if (success) {
                                        JOptionPane.showMessageDialog(null, "¡Has añadido un empleado!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                                        tfDni.setText("");
                                        tfNombre.setText("");
                                        tfApellido.setText("");
                                        tfAntiguedad.setText("");
                                        tfSalario.setText("");
                                        tfCantCom.setText("");
                                        tfCantCoc.setText("");
                                        cbTipo.setSelectedIndex(0); 

                                    } else {
                                        JOptionPane.showMessageDialog(null, "Error al añadir el empleado a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Error en el formato de datos. Verifica que los campos numéricos sean correctos.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "¡Por favor, complete los campos obligatorios!", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });
    }
    private void stylizeButton(JButton button) {
		button.setFont(new Font("Arial", Font.BOLD, 16)); 
		button.setBackground(new Color(30, 144, 255));
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false); 
	}
}