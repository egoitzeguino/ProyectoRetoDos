package Interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;

public class GestionEmpleados extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();

    /**
     * Create the dialog.
     */
    public GestionEmpleados() {
        setBounds(100, 100, 451, 564);
        getContentPane().setLayout(new BorderLayout());

        // Panel para la imagen de fondo
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image img = new ImageIcon("C:\\Users\\e.eguino\\Desktop\\2EVAL\\PROYECTOECLIPSE\\ProyectoRetoDosGit\\fondo.png").getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };

        getContentPane().add(backgroundPanel, BorderLayout.CENTER);
        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.add(contentPanel, BorderLayout.CENTER);

        contentPanel.setOpaque(false); // Hace que el panel de contenido sea transparente para mostrar la imagen de fondo

        contentPanel.setBorder(new CompoundBorder());
        contentPanel.setLayout(null);

        // Botón Añadir Empleado
        JButton btAnadir = new JButton("AÑADIR EMPLEADO");
        stylizeButton(btAnadir);
        btAnadir.setBounds(0, 173, 437, 48);
        btAnadir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AnadirEmpleado ae= new AnadirEmpleado();
                ae.setVisible(true);
            }
        });
        contentPanel.add(btAnadir);
		
		// Botón Eliminar Empleado
		JButton btnEliminarEmpleado = new JButton("ELIMINAR EMPLEADO");
		stylizeButton(btnEliminarEmpleado);
		btnEliminarEmpleado.setBounds(0, 219, 437, 48);
		btnEliminarEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EliminarEmpleado ee= new EliminarEmpleado();
                ee.setVisible(true);
            }
        });
		contentPanel.add(btnEliminarEmpleado);
		
		// Botón Mostrar Todos los Empleados
		JButton btnMostarEmpleado = new JButton("MOSTRAR TODOS LOS EMPLEADOS");
		stylizeButton(btnMostarEmpleado);
		btnMostarEmpleado.setBounds(0, 261, 437, 48);
		btnMostarEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MostrarEmpleados me= new MostrarEmpleados();
                me.setVisible(true);
            }
        });
		contentPanel.add(btnMostarEmpleado);
		
		// Botón Modificar Empleado
		JButton btModificarEmpleado = new JButton("MODIFICAR EMPLEADO");
		stylizeButton(btModificarEmpleado);
		btModificarEmpleado.setBounds(0, 307, 437, 48);
		btModificarEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ModificarEmpleado me= new ModificarEmpleado();
                me.setVisible(true);
            }
        });
		contentPanel.add(btModificarEmpleado);
		
		// Botón Detalles de Empleado
		JButton btnDetallesDeEmpleado = new JButton("DETALLES DE EMPLEADO");
		stylizeButton(btnDetallesDeEmpleado);
		btnDetallesDeEmpleado.setBounds(0, 353, 437, 48);
		btnDetallesDeEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EmpleadoDeterminado me= new EmpleadoDeterminado(rootPaneCheckingEnabled);
                me.setVisible(true);
            }
        });
		contentPanel.add(btnDetallesDeEmpleado);
		
		// Botón Volver
		JButton btVolver = new JButton("VOLVER");
		stylizeButton(btVolver);
		btVolver.setBackground(new Color(70, 130, 180));
		btVolver.setBounds(309, 469, 118, 48);
		 btVolver.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 dispose();
             }
         });
		contentPanel.add(btVolver);
		
		JLabel lblNewLabel_2 = new JLabel("¡BIENVENIDO DE NUEVO!");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(0, 0, 436, 61);
		contentPanel.add(lblNewLabel_2);
		
		btVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
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
