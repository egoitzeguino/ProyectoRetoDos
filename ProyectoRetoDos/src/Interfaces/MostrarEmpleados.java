package Interfaces;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import ModeloDAO.Empleado_DAO;
import ModeloDTO.Empleado_DTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MostrarEmpleados extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTable table;
    private DefaultTableModel initialModel;
    private JComboBox cbOrdenar, cbTipo;
    private Empleado_DAO empleadoDAO;
    private ArrayList<Empleado_DTO> empleados;

    /**
     * Create the dialog.
     */
    public MostrarEmpleados() {
        setModal(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setBounds(100, 100, 889, 600);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        DefaultComboBoxModel<String> cbModel = new DefaultComboBoxModel<>();

        empleadoDAO = new Empleado_DAO();
        contentPanel.setLayout(null);

        initialModel = new DefaultTableModel();
        initialModel.addColumn("DNI");
        initialModel.addColumn("NOMBRE");
        initialModel.addColumn("APELLIDO");
        initialModel.addColumn("ANTIGUEDAD");
        initialModel.addColumn("SALARIO");
        initialModel.addColumn("CANT COMANDAS");
        initialModel.addColumn("CANT COCTELES");
        initialModel.addColumn("TIPO");

        empleados = empleadoDAO.listarTodos();
        for (Empleado_DTO empleado : empleados) {
            initialModel.addRow(new Object[]{
                empleado.getDni(),
                empleado.getNombre(),
                empleado.getApellido(),
                empleado.getAntiguedad(),
                empleado.getSalario(),
                empleado.getCantComandas(),
                empleado.getCantCocteles(),
                empleado.getTipoEmpleado(),
            });
        }

        table = new JTable(initialModel);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 120, 855, 402);
        contentPanel.add(scrollPane);

        JLabel lblNewLabel = new JLabel("LISTADO GENERAL DE EMPLEADOS");
        lblNewLabel.setBounds(0, 0, 875, 50);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

        lblNewLabel.setOpaque(true);
        lblNewLabel.setBackground(Color.BLACK);
        lblNewLabel.setForeground(Color.WHITE);
        contentPanel.add(lblNewLabel);

        cbOrdenar = new JComboBox();
        cbOrdenar.setBounds(234, 77, 140, 33);
        contentPanel.add(cbOrdenar);
        cbOrdenar.addItem("Dni-Ascendente");
        cbOrdenar.addItem("Nombre-Ascendente");
        cbOrdenar.addItem("Salario-Ascendente");
        cbOrdenar.addItem("Dni-Descendente");
        cbOrdenar.addItem("Nombre-Descendente");
        cbOrdenar.addItem("Salario-Descendente");
        contentPanel.add(cbOrdenar);
        cbOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarArticulos();
            }
        });

        JButton btMostrar = new JButton("Mostrar Todos");
        btMostrar.setBounds(10, 77, 132, 33);
        contentPanel.add(btMostrar);
        btMostrar.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLabel lblNewLabel_1 = new JLabel("ORDENAR:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(152, 77, 72, 33);
        contentPanel.add(lblNewLabel_1);

        cbTipo = new JComboBox();
        cbTipo.setBounds(759, 77, 106, 33);
        cbTipo.addItem("Camarero");
        cbTipo.addItem("Cocinero");
        cbTipo.addItem("Coctelero");
        cbTipo.addItem("Gerente");
        cbTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoSeleccionado = (String) cbTipo.getSelectedItem();
                if (tipoSeleccionado != null) {
                    empleados = empleadoDAO.listarTodos2(tipoSeleccionado);
                    actualizarTabla();
                }
            }
        });
        contentPanel.add(cbTipo);

        JLabel lblNewLabel_2 = new JLabel("TIPO EMPLEADO:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(643, 76, 106, 33);
        contentPanel.add(lblNewLabel_2);

        btMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                empleados = empleadoDAO.listarTodos();
                actualizarTabla();
            }
        });

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton btVolver = new JButton("VOLVER");
        btVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btVolver.addActionListener(e -> dispose());

        JButton btDetalles = new JButton("VER DETALLES DE CLIENTE");
        btDetalles.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int dni = (int) table.getValueAt(selectedRow, 0);
                    Empleado_DTO selectedEmpleado = empleadoDAO.buscar(dni);
                    EmpleadoDeterminado empleadoDeterminado = new EmpleadoDeterminado();
                    empleadoDeterminado.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    empleadoDeterminado.setVisible(true);
                }
            }
        });
        btDetalles.setFont(new Font("Tahoma", Font.PLAIN, 13));
        buttonPane.add(btDetalles);
        buttonPane.add(btVolver);
    }

    private void ordenarArticulos() {
        String opcionSeleccionada = (String) cbOrdenar.getSelectedItem();

        Map<String, Comparator<Empleado_DTO>> comparadores = new HashMap<>();
        comparadores.put("Dni-Ascendente", Comparator.comparing(Empleado_DTO::getDni));
        comparadores.put("Nombre-Ascendente", Comparator.comparing(Empleado_DTO::getNombre));
        comparadores.put("Salario-Ascendente", Comparator.comparingDouble(Empleado_DTO::getSalario));
        comparadores.put("Dni-Descendente", Comparator.comparing(Empleado_DTO::getDni).reversed());
        comparadores.put("Nombre-Descendente", Comparator.comparing(Empleado_DTO::getNombre).reversed());
        comparadores.put("Salario-Descendente", Comparator.comparingDouble(Empleado_DTO::getSalario).reversed());

        Comparator<Empleado_DTO> comparador = comparadores.get(opcionSeleccionada);

        if (comparador != null) {
            empleados.sort(comparador);
            initialModel.setRowCount(0);

            for (Empleado_DTO empleado : empleados) {
                Vector<Object> fila = new Vector<>();
                fila.add(empleado.getDni());
                fila.add(empleado.getNombre());
                fila.add(empleado.getApellido());
                fila.add(empleado.getAntiguedad());
                fila.add(empleado.getSalario());
                fila.add(empleado.getCantComandas());
                fila.add(empleado.getCantCocteles());
                fila.add(empleado.getTipoEmpleado());

                initialModel.addRow(fila);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Opción de orden no reconocida", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarTabla() {
        initialModel.setRowCount(0);

        for (Empleado_DTO empleado : empleados) {
            Vector<Object> fila = new Vector<>();
            fila.add(empleado.getDni());
            fila.add(empleado.getNombre());
            fila.add(empleado.getApellido());
            fila.add(empleado.getAntiguedad());
            fila.add(empleado.getSalario());
            fila.add(empleado.getCantComandas());
            fila.add(empleado.getCantCocteles());
            fila.add(empleado.getTipoEmpleado());

            initialModel.addRow(fila);
        }
    }
}
