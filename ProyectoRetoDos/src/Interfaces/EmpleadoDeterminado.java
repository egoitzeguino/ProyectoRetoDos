package Interfaces;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import ModeloDAO.Empleado_DAO;
import ModeloDTO.Empleado_DTO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmpleadoDeterminado extends JDialog {

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
    public EmpleadoDeterminado(boolean dniEditable) {
        setModal(true);
        setBounds(100, 100, 450, 445);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lbDni = new JLabel("DNI:");
        lbDni.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbDni.setBounds(10, 48, 120, 13);
        contentPanel.add(lbDni);

        tfDni = new JTextField();
        tfDni.setEditable(dniEditable);  // Establecer editable según el valor proporcionado
        tfDni.setColumns(10);
        tfDni.setBounds(125, 46, 96, 19);
        contentPanel.add(tfDni);

        JLabel lblNombre = new JLabel("NOMBRE:");
        lblNombre.setFont(new Font("Dialog", Font.PLAIN, 12));
        lblNombre.setBounds(10, 88, 120, 13);
        contentPanel.add(lblNombre);

        tfNombre = new JTextField();
        tfNombre.setEditable(false);
        tfNombre.setColumns(10);
        tfNombre.setBounds(125, 86, 180, 19);
        contentPanel.add(tfNombre);

        JLabel lbApel = new JLabel("APELLIDO:");
        lbApel.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbApel.setBounds(10, 134, 120, 13);
        contentPanel.add(lbApel);

        tfApellido = new JTextField();
        tfApellido.setEditable(false);
        tfApellido.setColumns(10);
        tfApellido.setBounds(125, 132, 180, 19);
        contentPanel.add(tfApellido);

        JLabel lbAntigu = new JLabel("ANTIGUEDAD:");
        lbAntigu.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbAntigu.setBounds(10, 180, 120, 13);
        contentPanel.add(lbAntigu);

        tfAntiguedad = new JTextField();
        tfAntiguedad.setEditable(false);
        tfAntiguedad.setColumns(10);
        tfAntiguedad.setBounds(125, 178, 134, 19);
        contentPanel.add(tfAntiguedad);

        JLabel lbSal = new JLabel("SALARIO:");
        lbSal.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbSal.setBounds(10, 228, 120, 13);
        contentPanel.add(lbSal);

        tfSalario = new JTextField();
        tfSalario.setEditable(false);
        tfSalario.setColumns(10);
        tfSalario.setBounds(125, 226, 96, 19);
        contentPanel.add(tfSalario);

        JLabel lbCantCom = new JLabel("CANT COMANDAS:");
        lbCantCom.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbCantCom.setBounds(10, 276, 120, 13);
        contentPanel.add(lbCantCom);

        tfCantCom = new JTextField();
        tfCantCom.setEditable(false);
        tfCantCom.setColumns(10);
        tfCantCom.setBounds(125, 274, 96, 19);
        contentPanel.add(tfCantCom);

        JLabel lbCantCoc = new JLabel("CANT COCTELES:");
        lbCantCoc.setFont(new Font("Dialog", Font.PLAIN, 12));
        lbCantCoc.setBounds(10, 318, 120, 13);
        contentPanel.add(lbCantCoc);

        tfCantCoc = new JTextField();
        tfCantCoc.setEditable(false);
        tfCantCoc.setColumns(10);
        tfCantCoc.setBounds(125, 316, 96, 19);
        contentPanel.add(tfCantCoc);

        JLabel lblTipo = new JLabel("TIPO:");
        lblTipo.setFont(new Font("Dialog", Font.PLAIN, 12));
        lblTipo.setBounds(10, 358, 120, 13);
        contentPanel.add(lblTipo);

        tfTipo = new JTextField();
        tfTipo.setEditable(false);
        tfTipo.setColumns(10);
        tfTipo.setBounds(125, 356, 96, 19);
        contentPanel.add(tfTipo);

        JButton btVolver = new JButton("VOLVER");
        btVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btVolver.setBounds(321, 377, 85, 21);
        contentPanel.add(btVolver);

        JButton btInforme = new JButton("INFORME DE EMPLEADO");
        btInforme.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btInforme.setBounds(246, 272, 180, 59);
        contentPanel.add(btInforme);

        JLabel lblNewLabel = new JLabel("DETALLE DE EMPLEADO");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(98, 10, 242, 26);
        contentPanel.add(lblNewLabel);

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
        btBuscar.setBounds(236, 377, 85, 21);
        contentPanel.add(btBuscar);
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
}
