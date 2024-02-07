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
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class MostrarEmpleados extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel contentPanel = new JPanel();
    private JTable table;
    private DefaultTableModel initialModel;
    private JComboBox cbOrdenar, cbTipo;
    private Empleado_DAO empleadoDAO;
    private ArrayList<Empleado_DTO> empleados;

    /**
     * Create the dialog.
     */
    public MostrarEmpleados() {
    	setTitle("Listado de empleados");
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\e.eguino\\Desktop\\2EVAL\\PROYECTOECLIPSE\\ProyectoRetoDosGit\\markel1.jpg"));
        setModal(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setBounds(100, 100, 889, 575);
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
        scrollPane.setBounds(10, 120, 855, 374);
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
        stylizeButton(btMostrar);
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
        
        JButton btDetalles = new JButton("VER DETALLES DE EMPLEADO");
        btDetalles.setBounds(468, 504, 248, 25);
        stylizeButton(btDetalles);
        contentPanel.add(btDetalles);
        btDetalles.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int[] selectedRows = table.getSelectedRows();
                if (selectedRows.length == 0) {
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún empleado.");
                } else {
                    for (int selectedRow : selectedRows) {
                        
                        String dni = (String) initialModel.getValueAt(selectedRow, 0);
                        String nombre = (String) initialModel.getValueAt(selectedRow, 1);
                        String apellido = (String) initialModel.getValueAt(selectedRow, 2);
                        Date antiguedad = (Date) initialModel.getValueAt(selectedRow, 3);
                        double salario = (double) initialModel.getValueAt(selectedRow, 4);
                        int cantComandas = (int) initialModel.getValueAt(selectedRow, 5);
                        int cantCocteles = (int) initialModel.getValueAt(selectedRow, 6);
                        String tipo = (String) initialModel.getValueAt(selectedRow, 7);

                        EmpleadoDeterminado empleadoDeterminado = new EmpleadoDeterminado(false);
                        empleadoDeterminado.setDatosEmpleado(new Empleado_DTO(dni, nombre, apellido, antiguedad, salario, cantComandas, cantCocteles, tipo));

                        empleadoDeterminado.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                        empleadoDeterminado.setVisible(true);
                    }
                }
            }
        });
        btDetalles.setFont(new Font("Tahoma", Font.BOLD, 13));
        
                JButton btVolver = new JButton("VOLVER");
                btVolver.setBounds(759, 504, 106, 25);
                stylizeButton(btVolver);
        		btVolver.setBackground(new Color(70, 130, 180));
                contentPanel.add(btVolver);
                btVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
                btVolver.addActionListener(e -> dispose());

        btMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                empleados = empleadoDAO.listarTodos();
                actualizarTabla();
            }
        });
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
    private void stylizeButton(JButton button) {
		button.setFont(new Font("Arial", Font.BOLD, 16)); 
		button.setBackground(new Color(30, 144, 255));
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false); 
	}
}
