package Interfaces;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ModeloDAO.Gerente_DAO;
import ModeloDTO.Gerente_DTO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class InicioSesion extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField tfUsuario;
    private JPasswordField tfContrasena;

    /**
     * Create the dialog.
     */
    public InicioSesion() {
    	setTitle("Inicio de sesion");
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\e.eguino\\Desktop\\2EVAL\\PROYECTOECLIPSE\\ProyectoRetoDosGit\\markel1.jpg"));
        setBounds(100, 100, 450, 586);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        contentPanel.setBackground(SystemColor.inactiveCaptionBorder);

        tfUsuario = new JTextField();
        tfUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
        tfUsuario.setBounds(56, 249, 337, 55);
        tfUsuario.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        tfUsuario.setHorizontalAlignment(SwingConstants.LEFT);
        tfUsuario.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPanel.add(tfUsuario);
        tfUsuario.setColumns(10);
        tfUsuario.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tfUsuario.getText().equals("Usuario")) {
                    tfUsuario.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tfUsuario.getText().isEmpty()) {
                    tfUsuario.setText("Usuario");
                }
            }
        });

        tfContrasena = new JPasswordField();
        tfContrasena.setFont(new Font("Arial", Font.PLAIN, 16));
        tfContrasena.setBounds(56, 333, 337, 55);
        tfContrasena.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        tfContrasena.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        tfContrasena.setHorizontalAlignment(SwingConstants.LEFT);
        contentPanel.add(tfContrasena);
        tfContrasena.setColumns(10);
        

        tfContrasena.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tfContrasena.getText().equals("Contraseña")) {
                    tfContrasena.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tfContrasena.getText().isEmpty()) {
                    tfContrasena.setText("Contraseña");
                }
            }
        });
        tfContrasena.setEchoChar('*');
        
        JLabel lblNewLabel_2 = new JLabel("INICIO DE SESION");
        lblNewLabel_2.setHorizontalAlignment(JLabel.CENTER);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel_2.setBounds(0, 0, 436, 51);
        lblNewLabel_2.setOpaque(true);
        lblNewLabel_2.setBackground(new Color(50, 50, 150));
        lblNewLabel_2.setForeground(Color.WHITE); 
        contentPanel.add(lblNewLabel_2);

        JButton btInicio = new JButton("INICIO DE SESION");
        btInicio.setFont(new Font("Arial", Font.PLAIN, 18));
        btInicio.setBounds(56, 416, 337, 74);
        btInicio.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contentPanel.add(btInicio);

        JLabel lblNewLabel = new JLabel("USUARIO:");
        lblNewLabel.setBounds(56, 226, 103, 13);
        contentPanel.add(lblNewLabel);

        JLabel lblContrasea = new JLabel("CONTRASEÑA:");
        lblContrasea.setBounds(56, 314, 103, 13);
        contentPanel.add(lblContrasea);

        JLabel lblImagen = new JLabel();
        lblImagen.setBounds(139, 77, 156, 139);

        ImageIcon imagenIcon = new ImageIcon("C:\\Users\\e.eguino\\Desktop\\2EVAL\\PROYECTOECLIPSE\\ProyectoRetoDosGit\\markel1.jpg");
        Image imagenOriginal = imagenIcon.getImage();

        int ancho = lblImagen.getWidth();
        int alto = lblImagen.getHeight();

        Image imagenRedimensionada = imagenOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        ImageIcon imagenRedimensionadaIcon = new ImageIcon(imagenRedimensionada);

        lblImagen.setIcon(imagenRedimensionadaIcon);
        contentPanel.add(lblImagen);

        btInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = tfUsuario.getText();
                String contrasena = tfContrasena.getText();

                Gerente_DAO gerenteDAO = new Gerente_DAO();
                Gerente_DTO gerente = gerenteDAO.buscarPorUsuario(usuario);

                if (gerente != null && gerente.getContrasena().equals(contrasena)) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                    tfUsuario.setText("");
                    tfContrasena.setText("");
                    GestionEmpleados ge = new GestionEmpleados();
                    ge.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Inténtalo de nuevo.", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        buttonPane.setBackground(SystemColor.inactiveCaptionBorder);

        JButton btVolver = new JButton("VOLVER");
        stylizeButton(btVolver);
		btVolver.setBackground(new Color(70, 130, 180));
        btVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btVolver.setActionCommand("Cancel");
        buttonPane.add(btVolver);
    }
    private void stylizeButton(JButton button) {
		button.setFont(new Font("Arial", Font.BOLD, 16)); 
		button.setBackground(new Color(30, 144, 255));
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false); 
	}
}
