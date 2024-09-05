package udistrital.edu.co.view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame {

    private JPanel contentPane;
    public JButton buttonEst;
    public JButton buttonProf;

    public Ventana(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(null);
        setTitle("CONDOOOORRR");

        contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
		setLocationRelativeTo(null);
        
        init();
        setVisible(true);
    }     

    private void init(){
        buttonEst = new JButton("Estudiantes");
        buttonEst.setBounds(40, 170, 121, 43);
        contentPane.add(buttonEst);

        buttonProf = new JButton("Profesores");
        buttonProf.setBounds(225, 170, 121, 43);
        contentPane.add(buttonProf);

        JLabel lblNewLabel_1 = new JLabel("aaa");
		lblNewLabel_1.setBounds(70, 20, 250, 150);
		ImageIcon base = new ImageIcon("src/main/resources/distrital1.png");
        Image baseD = base.getImage();
        Image imageS= baseD.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalBD = new ImageIcon(imageS);
        lblNewLabel_1.setIcon(finalBD);
		contentPane.add(lblNewLabel_1);
    }
}
