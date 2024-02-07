package Interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import ModeloDAO.Empleado_DAO;
import ModeloDAO.Fichaje_DAO;
import ModeloDTO.Empleado_DTO;
import ModeloDTO.Fichaje_DTO;

public class Fichar extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField tfDni;
    private JTextField tfEntrada;
    private JTextField tfSalida;
    private JTextField tfNombre;
    private JTextField tfApellido;
    private JTextField tfTipo;
    private boolean entradaRegistrada = false;

    /**
     * Create the dialog.
     */
    public Fichar() {
    	
    	setBounds(100, 100, 772, 702);
    	setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE); 
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lbTitulo = new JLabel("¡BIENVENID@ EMPLEAD@!");
        lbTitulo.setBackground(new Color(173, 216, 230)); 
        lbTitulo.setOpaque(true); 

        lbTitulo.setHorizontalAlignment(JLabel.CENTER);
        lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 26));
        lbTitulo.setBounds(0, 0, 758, 99);
        contentPanel.add(lbTitulo);

        JLabel lblNewLabel = new JLabel("INTRODUCE DNI:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(86, 122, 150, 25);
        contentPanel.add(lblNewLabel);

        tfDni = new JTextField();
        tfDni.setBounds(246, 122, 150, 25);
        contentPanel.add(tfDni);
        tfDni.setColumns(10);
		
		JLabel lbManual = new JLabel("SI HA ENTRADO A OTRA HORA INTRODUZCA MANUALMENTE ");
		lbManual.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbManual.setBounds(94, 455, 510, 13);
		contentPanel.add(lbManual);
		
		JLabel lbEntrada = new JLabel("HORARIO ENTRADA:");
		lbEntrada.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbEntrada.setBounds(94, 492, 125, 13);
		contentPanel.add(lbEntrada);
		
		tfEntrada = new JTextField();
		tfEntrada.setBounds(229, 490, 148, 19);
		contentPanel.add(tfEntrada);
		tfEntrada.setColumns(10);
		
		JLabel lbSalida = new JLabel("HORARIO SALIDA:");
		lbSalida.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbSalida.setBounds(94, 541, 125, 13);
		contentPanel.add(lbSalida);
		
		tfSalida = new JTextField();
		tfSalida.setBounds(229, 539, 131, 19);
		contentPanel.add(tfSalida);
		tfSalida.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(124, 198, 80, 13);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("APELLIDO:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(307, 198, 70, 13);
		contentPanel.add(lblNewLabel_2);
		
		tfNombre = new JTextField();
		tfNombre.setEditable(false);
		tfNombre.setBounds(124, 221, 125, 28);
		contentPanel.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfApellido = new JTextField();
		tfApellido.setEditable(false);
		tfApellido.setColumns(10);
		tfApellido.setBounds(307, 221, 118, 28);
		contentPanel.add(tfApellido);
		
		JLabel lblNewLabel_3 = new JLabel("TIPO EMPLEADO:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(479, 198, 103, 13);
		contentPanel.add(lblNewLabel_3);
		
		tfTipo = new JTextField();
		tfTipo.setEditable(false);
		tfTipo.setBounds(479, 221, 125, 28);
		contentPanel.add(tfTipo);
		tfTipo.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(86, 289, 569, 141);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbFichar = new JLabel("SI HA ENTRADO AHORA PULSE FICHAR");
		lbFichar.setBounds(26, 25, 258, 13);
		panel_1.add(lbFichar);
		lbFichar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btFichar = new JButton("FICHAR ENTRADA");
		btFichar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String dniEmpleado = tfDni.getText();
		        
		        verificarEntradaRegistrada(dniEmpleado);
		        if (!entradaRegistrada) {
		            String dniEmpleado1 = tfDni.getText();
		            Timestamp horarioEntrada = new Timestamp(System.currentTimeMillis());
		            Fichaje_DTO fichajeEntrada = new Fichaje_DTO(dniEmpleado1, horarioEntrada, null, 0.0);

		            Fichaje_DAO fichajeDAO = new Fichaje_DAO();
		            if (fichajeDAO.insertar(fichajeEntrada)) {
		                JOptionPane.showMessageDialog(null, "Fichaje de entrada registrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		                entradaRegistrada = true;
		            } else {
		                JOptionPane.showMessageDialog(null, "Error al registrar el fichaje de entrada", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Ya has registrado la entrada para hoy", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});

		btFichar.setBounds(62, 48, 155, 57);
		panel_1.add(btFichar);
		btFichar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblSiSaleAhora = new JLabel("SI SALE AHORA PULSE FICHAR");
		lblSiSaleAhora.setBounds(341, 25, 258, 13);
		panel_1.add(lblSiSaleAhora);
		lblSiSaleAhora.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btSalida = new JButton("FICHAR SALIDA");
		btSalida.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String dniEmpleado = tfDni.getText();
		        Fichaje_DAO fichajeDAO = new Fichaje_DAO();
		        Fichaje_DTO ultimoFichaje = fichajeDAO.obtenerUltimoFichajeEntrada(dniEmpleado);

		        if (ultimoFichaje != null) {
		            if (ultimoFichaje.getHorarioSalida() == null) {
		                // Se verifica que haya un horario de entrada registrado
		                Timestamp horarioEntrada = ultimoFichaje.getHorarioEntrada();
		                if (horarioEntrada != null) {
		                    ultimoFichaje.setHorarioSalida(new Timestamp(System.currentTimeMillis()));

		                    long tiempoTrabajadoMillis = ultimoFichaje.getHorarioSalida().getTime() - horarioEntrada.getTime();
		                    double horasTrabajadas = tiempoTrabajadoMillis / (1000.0 * 60.0 * 60.0);
		                    ultimoFichaje.setTotalHoras(horasTrabajadas);

		                    if (fichajeDAO.actualizar2(ultimoFichaje, obtenerDiaActual())) {
		                        JOptionPane.showMessageDialog(null, "Fichaje de salida registrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		                        entradaRegistrada = false;
		                    } else {
		                        JOptionPane.showMessageDialog(null, "Error al registrar el fichaje de salida", "Error", JOptionPane.ERROR_MESSAGE);
		                    }
		                } else {
		                    JOptionPane.showMessageDialog(null, "Debes registrar la entrada antes de fichar la salida", "Error", JOptionPane.ERROR_MESSAGE);
		                }
		            } else {
		                JOptionPane.showMessageDialog(null, "Ya se registró la salida para este día", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "No se encontró un fichaje de entrada correspondiente", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});



		btSalida.setBounds(351, 48, 155, 57);
		panel_1.add(btSalida);
		btSalida.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(86, 440, 569, 141);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btManual = new JButton("FICHAR MANUAL");
		btManual.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            String dniEmpleado = tfDni.getText();
		            String strEntrada = tfEntrada.getText();
		            String strSalida = tfSalida.getText();

		            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // Formato completo

		            java.util.Date entradaDate = dateFormat.parse(strEntrada);
		            java.util.Date salidaDate = dateFormat.parse(strSalida);

		            // Impresiones de control
		            System.out.println("Horario Entrada: " + dateFormat.format(entradaDate));
		            System.out.println("Horario Salida: " + dateFormat.format(salidaDate));

		            Timestamp horarioEntrada = new Timestamp(entradaDate.getTime());
		            Timestamp horarioSalida = new Timestamp(salidaDate.getTime());

<<<<<<< Updated upstream
		            // Calcula la diferencia entre la salida y entrada para obtener las horas trabajadas
		            long tiempoTrabajadoMillis = horarioSalida.getTime() - horarioEntrada.getTime();
		            double horasTrabajadas = tiempoTrabajadoMillis / (1000.0 * 60.0 * 60.0);

		            Fichaje_DTO fichajeManual = new Fichaje_DTO(dniEmpleado, horarioEntrada, horarioSalida, horasTrabajadas);
=======
		            Fichaje_DTO fichajeManual = new Fichaje_DTO(dniEmpleado, horarioEntrada, horarioSalida, 0.0);
>>>>>>> Stashed changes

		            Fichaje_DAO fichajeDAO = new Fichaje_DAO();
		            if (fichajeDAO.insertar(fichajeManual)) {
		                System.out.println("Fichaje manual registrado correctamente");
		                JOptionPane.showMessageDialog(null, "Fichaje manual registrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		                entradaRegistrada = true;
		                tfEntrada.setText("");
		                tfSalida.setText("");
		            } else {
		                System.out.println("Error al registrar el fichaje manual");
		                JOptionPane.showMessageDialog(null, "Error al registrar el fichaje manual", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } catch (ParseException ex) {
		            System.out.println("Error al parsear las fechas: " + ex.getMessage());
		            JOptionPane.showMessageDialog(null, "Error al parsear las fechas: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            ex.printStackTrace();
		        } catch (Exception ex) {
		            System.out.println("Error al procesar las fechas: " + ex.getMessage());
		            JOptionPane.showMessageDialog(null, "Error al procesar las fechas: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            ex.printStackTrace();
		        }
		    }
		});

        
		btManual.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btManual.setBounds(354, 50, 150, 54);
		panel_2.add(btManual);
		
		JLabel lblNewLabel_4 = new JLabel("(AAAA-MM-dd HH:mm:00)");
		lblNewLabel_4.setBounds(144, 36, 142, 13);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("(AAAA-MM-dd HH:mm:00)");
		lblNewLabel_4_1.setBounds(144, 84, 142, 13);
		panel_2.add(lblNewLabel_4_1);
		
		JButton btBuscar = new JButton("BUSCAR");
		btBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String dniBuscado = tfDni.getText();

                Empleado_DAO empleadoDAO = new Empleado_DAO();
                Empleado_DTO empleadoEncontrado = empleadoDAO.buscar(dniBuscado);

                if (empleadoEncontrado != null) {
                	lbTitulo.setText("¡BIENVENID@ " + empleadoEncontrado.getNombre().toUpperCase() + "!");
                    tfNombre.setText(empleadoEncontrado.getNombre());
                    tfApellido.setText(empleadoEncontrado.getApellido());
                    tfTipo.setText(empleadoEncontrado.getTipoEmpleado());
                } else {
                    JOptionPane.showMessageDialog(null, "DNI no encontrado", "Error DNI", JOptionPane.ERROR_MESSAGE);
                    tfNombre.setText("");
                    tfApellido.setText("");
                    tfTipo.setText("");
                }
            }
		});
		btBuscar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btBuscar.setBounds(406, 123, 110, 23);
		contentPanel.add(btBuscar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btVolver = new JButton("VOLVER");
				btVolver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
				btVolver.setActionCommand("Cancel");
				buttonPane.add(btVolver);
			}
		}

	}
    private void verificarEntradaRegistrada(String dniEmpleado) {
        Fichaje_DAO fichajeDAO = new Fichaje_DAO();
        Fichaje_DTO ultimoFichaje = fichajeDAO.obtenerUltimoFichajeEntrada(dniEmpleado);

        if (ultimoFichaje != null && ultimoFichaje.getHorarioSalida() == null) {
            entradaRegistrada = true;
            JOptionPane.showMessageDialog(null, "Ya has registrado la entrada para hoy. Puedes fichar la salida.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
<<<<<<< Updated upstream
            // Verificar si hay registros con entrada pero sin salida
            ArrayList<Fichaje_DTO> fichajesSinSalida = fichajeDAO.obtenerFichajesSinSalida();
            if (!fichajesSinSalida.isEmpty()) {
                entradaRegistrada = true;
            } else {
                entradaRegistrada = false; // Importante reiniciar el valor si no hay registros sin salida
            }
=======
            entradaRegistrada = false;
>>>>>>> Stashed changes
        }
    }

    public static LocalDate obtenerDiaActual() {
        return LocalDate.now();
    }
}