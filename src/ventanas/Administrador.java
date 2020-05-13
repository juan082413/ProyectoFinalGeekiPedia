package ventanas;
import java.sql.*;
 

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import clases.Conexion;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Administrador extends JFrame {

	private JPanel contentPane;
	String user, nombre_usuario;
	public static int sesion_usuario;	// variable para enviar datos entre interfaces
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Administrador.class.getResource("/images/DS.png")));
		user = login.user; // en user ya está capturado el usuario escrito en el panel login
		sesion_usuario = 1; // Variable con función bandera que usaremos en interfaces capturista y tecnico
		setSize(650,430);
		setResizable(false);
		setTitle("Administrador - Sesión de " +user);
		setLocationRelativeTo(null); //pone las ventanas en la mitad, se debe borrar los valores por defecto creados por el JFrame en el constructor
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Evitar que el programa se siga ejecutando en segundo plano a pesar de haberse cerrado la interfaz
	

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton jButton_Registrar_Usuario = new JButton("");
		jButton_Registrar_Usuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 RegistrarUsuarios registrarUsuarios = new RegistrarUsuarios();
				 registrarUsuarios.setVisible(true);
			}
		});
		jButton_Registrar_Usuario.setIcon(new ImageIcon(Administrador.class.getResource("/images/addUser.png")));
		jButton_Registrar_Usuario.setBounds(40, 70, 120, 100);
		contentPane.add(jButton_Registrar_Usuario);
		
		JButton jButton_GestionarUsuarios = new JButton("");
		jButton_GestionarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionarUsuarios gestionarUsuarios = new GestionarUsuarios();
				 gestionarUsuarios.setVisible(true);
			}
		});
		jButton_GestionarUsuarios.setIcon(new ImageIcon(Administrador.class.getResource("/images/informationuser.png")));
		jButton_GestionarUsuarios.setBounds(270, 70, 120, 100);
		contentPane.add(jButton_GestionarUsuarios);
		
		JButton jButton_Creatividad = new JButton("");
		jButton_Creatividad.setIcon(new ImageIcon(Administrador.class.getResource("/images/creatividad.png")));
		jButton_Creatividad.setBounds(500, 70, 120, 100);
		contentPane.add(jButton_Creatividad);
		
		JButton jButton_Capturista = new JButton("");
		jButton_Capturista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
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
		
		JLabel txt_Registrar_Usuarios = new JLabel("Registrar Usuario");
		txt_Registrar_Usuarios.setForeground(Color.WHITE);
		txt_Registrar_Usuarios.setBounds(50, 170, 110, 14);
		contentPane.add(txt_Registrar_Usuarios);
		
		JLabel txt_Gestionar_Usuarios = new JLabel("Gestionar Usuarios");
		txt_Gestionar_Usuarios.setForeground(Color.WHITE);
		txt_Gestionar_Usuarios.setBounds(280, 170, 110, 14);
		contentPane.add(txt_Gestionar_Usuarios);
		
		JLabel txt_Creatividad = new JLabel("Creatividad");
		txt_Creatividad.setForeground(Color.WHITE);
		txt_Creatividad.setBounds(530, 170, 90, 14);
		contentPane.add(txt_Creatividad);
		
		JLabel txt_Capturista = new JLabel("Panel vista capturista");
		txt_Capturista.setForeground(Color.WHITE);
		txt_Capturista.setBounds(40, 340, 110, 14);
		contentPane.add(txt_Capturista);
		
		JLabel txt_Tecnico = new JLabel("Panel vista t\u00E9cnico");
		txt_Tecnico.setForeground(Color.WHITE);
		txt_Tecnico.setBounds(280, 340, 110, 14);
		contentPane.add(txt_Tecnico);
		
		JLabel lblAcercaDe = new JLabel("Acerca de:");
		lblAcercaDe.setForeground(Color.WHITE);
		lblAcercaDe.setBounds(510, 340, 110, 14);
		contentPane.add(lblAcercaDe);
		
		JLabel lblNombre = new JLabel("User");
		lblNombre.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		lblAcercaDe.setForeground(Color.WHITE);
		lblNombre.setBounds(24, 36, 610, 26);
		contentPane.add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("Creado por GoaHead");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(248, 365, 216, 26);
		contentPane.add(lblNewLabel);
		
		JLabel jLabel_Wallpaper = new JLabel("New label");
		jLabel_Wallpaper.setBounds(0, 0, 644, 401);
		contentPane.add(jLabel_Wallpaper);
		ImageIcon wallpaper = new ImageIcon ("D:\\eclipse\\DataSystem\\src\\images\\wallpaperPrincipal.jpg");
		Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
				jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
		jLabel_Wallpaper.setIcon(icono);

		try {
			Connection cn = Conexion.conectar();
			PreparedStatement pst = cn.prepareStatement("select usuario from usuarios where username = '" + user +"'"); 
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				nombre_usuario = rs.getString("usuario");
				lblNombre.setText(nombre_usuario);
				
				}
			
		}catch (Exception ex){
			System.err.println("Error en conexion desde la interfaz administrador");
		
		}

		
	}
	
	@Override
	public Image getIconImage() {
		Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
		return retValue;
	}
	

}
