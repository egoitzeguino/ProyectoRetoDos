package Interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

public class PantallaInicio extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PantallaInicio frame = new PantallaInicio();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PantallaInicio() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\e.eguino\\Desktop\\2EVAL\\PROYECTOECLIPSE\\ProyectoRetoDosGit\\markel1.jpg"));
    	setTitle("Tortuga Juanes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 308);
        setLocationRelativeTo(null);
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(new GradientPaint(0, 0, new Color(240, 240, 240), 0, getHeight(), new Color(200, 200, 255)));
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbTitulo = new JLabel("TORTUGA JUANES");
        lbTitulo.setFont(new Font("Arial", Font.BOLD, 30));
        lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitulo.setBounds(0, 20, 436, 50);
        contentPane.add(lbTitulo);

        JButton btFichar = new JButton("FICHAR");
        btFichar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Fichar fi = new Fichar();
                fi.setVisible(true);
            }
        });
        btFichar.setFont(new Font("Arial", Font.BOLD, 18));
        btFichar.setBounds(80, 100, 280, 60);
        btFichar.setBackground(new Color(46, 204, 113)); // Emerald Green
        btFichar.setForeground(Color.WHITE);
        contentPane.add(btFichar);

        JButton btGerente = new JButton("GESTIÓN DE EMPLEADOS");
        btGerente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InicioSesion is = new InicioSesion();
                is.setVisible(true);
            }
        });
        btGerente.setFont(new Font("Arial", Font.BOLD, 18));
        btGerente.setBounds(80, 190, 280, 60);
        btGerente.setBackground(new Color(52, 152, 219)); // Royal Blue
        btGerente.setForeground(Color.WHITE);
        contentPane.add(btGerente);

        JLabel lblImagen1 = new JLabel();
        lblImagen1.setBounds(10, 20, 50, 50);        
        ImageIcon imagenIcon1 = new ImageIcon("C:\\Users\\e.eguino\\Desktop\\2EVAL\\PROYECTOECLIPSE\\ProyectoRetoDos\\restaurante.png");
        Image imagenOriginal1 = imagenIcon1.getImage();
        int ancho1 = lblImagen1.getWidth();
        int alto1 = lblImagen1.getHeight();        
        Image imagenRedimensionada1 = imagenOriginal1.getScaledInstance(ancho1, alto1, Image.SCALE_SMOOTH);
        ImageIcon imagenRedimensionadaIcon1 = new ImageIcon(imagenRedimensionada1);
        lblImagen1.setIcon(imagenRedimensionadaIcon1);
        contentPane.add(lblImagen1);

        JLabel lblImagen2 = new JLabel();
        lblImagen2.setBounds(376, 20, 50, 50);        
        ImageIcon imagenIcon2 = new ImageIcon("C:\\Users\\e.eguino\\Desktop\\2EVAL\\PROYECTOECLIPSE\\ProyectoRetoDos\\restaurante.png");
        Image imagenOriginal2 = imagenIcon2.getImage();
        int ancho2 = lblImagen2.getWidth();
        int alto2 = lblImagen2.getHeight();        
        Image imagenRedimensionada2 = imagenOriginal2.getScaledInstance(ancho2, alto2, Image.SCALE_SMOOTH);
        ImageIcon imagenRedimensionadaIcon2 = new ImageIcon(imagenRedimensionada2);
        lblImagen2.setIcon(imagenRedimensionadaIcon2);
        contentPane.add(lblImagen2);        
    }
}
