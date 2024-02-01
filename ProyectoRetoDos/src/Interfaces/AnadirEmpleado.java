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
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import javax.swing.JComboBox;

public class AnadirEmpleado extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
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
        setModal(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setBounds(100, 100, 531, 478);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lbDni = new JLabel("DNI:");
        lbDni.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbDni.setBounds(10, 55, 120, 13);
        contentPanel.add(lbDni);

        JLabel lblNombre = new JLabel("NOMBRE:");
        lblNombre.setFont(new Font("Dialog", Font.PLAIN, 12));
        lblNombre.setBounds(10, 95, 120, 13);
        contentPanel.add(lblNombre);

        JLabel lbApel = new JLabel("APELLIDO:");
        lbApel.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbApel.setBounds(10, 141, 120, 13);
        contentPanel.add(lbApel);

        JLabel lbAntigu = new JLabel("ANTIGUEDAD:");
        lbAntigu.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbAntigu.setBounds(10, 187, 120, 13);
        contentPanel.add(lbAntigu);

        JLabel lbSal = new JLabel("SALARIO:");
        lbSal.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbSal.setBounds(10, 235, 120, 13);
        contentPanel.add(lbSal);

        JLabel lbCantCom = new JLabel("CANT COMANDAS:");
        lbCantCom.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbCantCom.setBounds(10, 283, 120, 13);
        contentPanel.add(lbCantCom);

        JLabel lbTipo = new JLabel("TIPO EMPLEADO:");
        lbTipo.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbTipo.setBounds(10, 376, 120, 13);
        contentPanel.add(lbTipo);

        JLabel lbCantCoc = new JLabel("CANT COCTELES:");
        lbCantCoc.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbCantCoc.setBounds(10, 325, 120, 13);
        contentPanel.add(lbCantCoc);

        JLabel lblNewLabel_11 = new JLabel("ALTA DE EMPLEADO");
        lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_11.setBounds(0, 0, 517, 45);

        lblNewLabel_11.setOpaque(true);
        lblNewLabel_11.setBackground(Color.BLACK);
        lblNewLabel_11.setForeground(Color.WHITE);
        contentPanel.add(lblNewLabel_11);

        tfDni = new JTextField();
        tfDni.setBounds(125, 53, 96, 19);
        contentPanel.add(tfDni);
        tfDni.setColumns(10);

        tfNombre = new JTextField();
        tfNombre.setColumns(10);
        tfNombre.setBounds(125, 93, 180, 19);
        contentPanel.add(tfNombre);

        tfApellido = new JTextField();
        tfApellido.setColumns(10);
        tfApellido.setBounds(125, 139, 180, 19);
        contentPanel.add(tfApellido);

        tfAntiguedad = new JTextField();
        tfAntiguedad.setColumns(10);
        tfAntiguedad.setBounds(125, 185, 134, 19);
        contentPanel.add(tfAntiguedad);

        tfSalario = new JTextField();
        tfSalario.setColumns(10);
        tfSalario.setBounds(125, 233, 96, 19);
        contentPanel.add(tfSalario);

        tfCantCom = new JTextField();
        tfCantCom.setColumns(10);
        tfCantCom.setBounds(125, 281, 96, 19);
        contentPanel.add(tfCantCom);

        tfCantCoc = new JTextField();
        tfCantCoc.setColumns(10);
        tfCantCoc.setBounds(125, 323, 96, 19);
        contentPanel.add(tfCantCoc);
        JLabel lblImagen = new JLabel();
        lblImagen.setBounds(357, 220, 134, 118);

        ImageIcon imagenIcon = new ImageIcon("C:\\Users\\e.eguino\\Desktop\\2EVAL\\PROYECTOECLIPSE\\ProyectoRetoDosGit\\anadir.png");
        Image imagenOriginal = imagenIcon.getImage();

        int ancho = lblImagen.getWidth();
        int alto = lblImagen.getHeight();

        Image imagenRedimensionada = imagenOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        ImageIcon imagenRedimensionadaIcon = new ImageIcon(imagenRedimensionada);

        lblImagen.setIcon(imagenRedimensionadaIcon);
        contentPanel.add(lblImagen);

        
        JComboBox<String> cbTipo = new JComboBox<>();
        cbTipo.setBounds(125, 373, 180, 21);
        cbTipo.addItem("Camarero");
        cbTipo.addItem("Coctelero");
        cbTipo.addItem("Cocinero");
        cbTipo.addItem("Gerente");
        contentPanel.add(cbTipo);

        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);

            JButton btAnadir = new JButton("Añadir");
            btAnadir.setFont(new Font("Tahoma", Font.PLAIN, 12));
            btAnadir.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!tfDni.getText().isEmpty() && !tfNombre.getText().isEmpty() && !tfAntiguedad.getText().isEmpty()
                            && !tfSalario.getText().isEmpty() && !tfCantCom.getText().isEmpty() && !tfCantCoc.getText().isEmpty()
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
            buttonPane.add(btAnadir);

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
