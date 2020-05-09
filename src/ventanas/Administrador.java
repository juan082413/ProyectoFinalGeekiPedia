package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Administrador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrador frame = new Administrador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Administrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jLabel_Nombre_Usuario = new JLabel("New label");
		jLabel_Nombre_Usuario.setForeground(Color.WHITE);
		jLabel_Nombre_Usuario.setBounds(10, 10, 48, 14);
		contentPane.add(jLabel_Nombre_Usuario);
		
		JButton jButton_Registrar_Usuario = new JButton("");
		jButton_Registrar_Usuario.setIcon(new ImageIcon(Administrador.class.getResource("/images/addUser.png")));
		jButton_Registrar_Usuario.setBounds(40, 70, 120, 100);
		contentPane.add(jButton_Registrar_Usuario);
		
		JButton jButton_GestionarUsuarios = new JButton("");
		jButton_GestionarUsuarios.setIcon(new ImageIcon(Administrador.class.getResource("/images/informationuser.png")));
		jButton_GestionarUsuarios.setBounds(270, 70, 120, 100);
		contentPane.add(jButton_GestionarUsuarios);
		
		JButton jButton_Creatividad = new JButton("");
		jButton_Creatividad.setIcon(new ImageIcon(Administrador.class.getResource("/images/creatividad.png")));
		jButton_Creatividad.setBounds(500, 70, 120, 100);
		contentPane.add(jButton_Creatividad);
		
		JButton jButton_Capturista = new JButton("");
		jButton_Capturista.setIcon(new ImageIcon(Administrador.class.getResource("/images/capturista.png")));
		jButton_Capturista.setBounds(40, 240, 120, 100);
		contentPane.add(jButton_Capturista);
		
		JButton jButton_Tecnico = new JButton("");
		jButton_Tecnico.setIcon(new ImageIcon(Administrador.class.getResource("/images/tecnico.png")));
		jButton_Tecnico.setBounds(270, 240, 120, 100);
		contentPane.add(jButton_Tecnico);
		
		JButton jButton_AcercaDe = new JButton("");
		jButton_AcercaDe.setIcon(new ImageIcon(Administrador.class.getResource("/images/geekipedia.png")));
		jButton_AcercaDe.setBounds(500, 240, 120, 100);
		contentPane.add(jButton_AcercaDe);
		
		JLabel txt_Registrar_Usuarios = new JLabel("Regustrar Usuario");
		txt_Registrar_Usuarios.setForeground(Color.WHITE);
		txt_Registrar_Usuarios.setBounds(50, 170, 110, 14);
		contentPane.add(txt_Registrar_Usuarios);
		
		JLabel txt_Gestionar_Usuarios = new JLabel("Gestionar Usuarios");
		txt_Gestionar_Usuarios.setForeground(Color.WHITE);
		txt_Gestionar_Usuarios.setBounds(280, 170, 48, 14);
		contentPane.add(txt_Gestionar_Usuarios);
		
		JLabel txt_Creatividad = new JLabel("Creatividad");
		txt_Creatividad.setForeground(Color.WHITE);
		txt_Creatividad.setBounds(530, 170, 48, 14);
		contentPane.add(txt_Creatividad);
		
		JLabel txt_Capturista = new JLabel("Panel vista capturista");
		txt_Capturista.setForeground(Color.WHITE);
		txt_Capturista.setBounds(40, 340, 48, 14);
		contentPane.add(txt_Capturista);
		
		JLabel txt_Tecnico = new JLabel("Panel vista t\u00E9cnico");
		txt_Tecnico.setForeground(Color.WHITE);
		txt_Tecnico.setBounds(280, 340, 48, 14);
		contentPane.add(txt_Tecnico);
		
		JLabel lblAcercaDe = new JLabel("Acerca de:");
		lblAcercaDe.setForeground(Color.WHITE);
		lblAcercaDe.setBounds(530, 340, 48, 14);
		contentPane.add(lblAcercaDe);
		
		JLabel lblNewLabel = new JLabel("Creado por GoaHead");
		lblNewLabel.setBounds(280, 377, 110, 14);
		contentPane.add(lblNewLabel);
		
		JLabel jLabel_Wallpaper = new JLabel("New label");
		jLabel_Wallpaper.setBounds(0, 0, 634, 391);
		contentPane.add(jLabel_Wallpaper);
		
		setTitle("Administrador");
		setLocationRelativeTo(null);
		
		
		
		
		
		
	}

}
