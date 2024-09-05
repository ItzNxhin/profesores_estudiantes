package udistrital.edu.co.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
//Librerias
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
//Swing
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaEstudiantes extends JFrame {

	//Atributos y listas
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    public JButton btnAgregar;
    public JButton btnEliminar;
    public JButton btnEdiar;
	public JButton btnSalir;
	public JButton btnVolver;
    private JScrollPane scrollPane;
	DefaultListModel<String> estudiantes = new DefaultListModel<>();

	//Ventana
	public VentanaEstudiantes(DefaultListModel<String> estudiantes) throws ClassNotFoundException, IOException {
		this.estudiantes = estudiantes;
		//Ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(192, 192, 192));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setTitle("Estudiantes"); 
		setLocationRelativeTo(null);
		init();
		
	}

	private void init(){
		//Titulo
		JLabel lblNewLabel = new JLabel("Estudiantes");
		lblNewLabel.setBounds(36, 19, 583, 23);
		lblNewLabel.setFont(new Font("Stencil", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);

		//Crea lista, scrollpane y mostrar los estudiantes

		scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 53, 583, 239);
        contentPane.add(scrollPane);
        
		JList<String> list = new JList<>(estudiantes);
		scrollPane.setViewportView(list);
		
		//Agregar estudiante
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(166, 303, 89, 23);
		contentPane.add(btnAgregar);

		//Eliminar estudiante por codigo
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(265, 320, 89, 23);
		contentPane.add(btnEliminar);

		//Editar estudiante
	    btnEdiar = new JButton("Editar");
		btnEdiar.setBounds(166, 337, 89, 23);
		contentPane.add(btnEdiar);
		
		//Boton volver (Ventana principal)
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(364, 303, 89, 23);
		contentPane.add(btnVolver);
		
		// Boton salir (Terminar programa)
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(364, 337, 89, 23);
		contentPane.add(btnSalir);
		
		//Decoracion
		JLabel lblOpciones = new JLabel("Opciones: ");
		lblOpciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpciones.setFont(new Font("Stencil", Font.BOLD, 18));
		lblOpciones.setBounds(36, 322, 136, 23);
		contentPane.add(lblOpciones);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(486, 303, 100, 57);
		ImageIcon base = new ImageIcon("src/main/resources/bobo.png");
        Image baseD = base.getImage();
        Image imageS= baseD.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalBD = new ImageIcon(imageS);
        lblNewLabel_1.setIcon(finalBD);
		contentPane.add(lblNewLabel_1);
	}

	//Metodo, que sobreescribe, para poder actualizar las listas
	public void sbwrite(DefaultListModel<String> x){
        JList<String> y = new JList<>(x);
        scrollPane.setViewportView(y);
        repaint();
	}
}
