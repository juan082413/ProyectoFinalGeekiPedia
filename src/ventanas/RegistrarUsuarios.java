package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.sql.*;
import clases.Conexion;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RegistrarUsuarios extends JFrame {

	private JPanel contentPane;
	private JTextField txt_email;
	private JTextField txt_username;
	private JTextField txt_password;
	private JTextField txt_telefono;
	String user;
	private JTextField txt_nombre;
	private JComboBox cmb_niveles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarUsuarios frame = new RegistrarUsuarios();
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
	public RegistrarUsuarios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarUsuarios.class.getResource("/images/icon.png")));
		
		user = login.user;  //método para recuperar el username desde el panel login
		
		setTitle("Registrar usuario - Sesión de: "+user);
		setSize(630,350);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //evita que el programa cuando la interfaz se cierre

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de usuarios");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(210, 10, 255, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(20, 50, 94, 14);
		contentPane.add(lblNewLabel_1);
		
		txt_nombre = new JTextField();
		txt_nombre.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_nombre.setHorizontalAlignment(SwingConstants.CENTER);
		txt_nombre.setForeground(Color.WHITE);
		txt_nombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		txt_nombre.setBackground(new Color(153, 102, 255));
		txt_nombre.setBounds(20, 70, 210, 20);
		contentPane.add(txt_nombre);
		txt_nombre.setColumns(10);
		
		txt_email = new JTextField();
		txt_email.setHorizontalAlignment(SwingConstants.CENTER);
		txt_email.setForeground(Color.WHITE);
		txt_email.setFont(new Font("Tahoma", Font.BOLD, 16));
		txt_email.setColumns(10);
		txt_email.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_email.setBackground(new Color(153, 102, 255));
		txt_email.setBounds(20, 137, 210, 20);
		contentPane.add(txt_email);
		
		JLabel lblNewLabel_1_1 = new JLabel("e-mail");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(20, 117, 94, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txt_username = new JTextField();
		txt_username.setHorizontalAlignment(SwingConstants.CENTER);
		txt_username.setForeground(Color.WHITE);
		txt_username.setFont(new Font("Tahoma", Font.BOLD, 16));
		txt_username.setColumns(10);
		txt_username.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_username.setBackground(new Color(153, 102, 255));
		txt_username.setBounds(380, 70, 210, 20);
		contentPane.add(txt_username);
		
		JLabel lblNewLabel_1_2 = new JLabel("Username");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(380, 50, 94, 14);
		contentPane.add(lblNewLabel_1_2);
		
		txt_password = new JTextField();
		txt_password.setHorizontalAlignment(SwingConstants.CENTER);
		txt_password.setForeground(Color.WHITE);
		txt_password.setFont(new Font("Tahoma", Font.BOLD, 16));
		txt_password.setColumns(10);
		txt_password.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_password.setBackground(new Color(153, 102, 255));
		txt_password.setBounds(380, 137, 210, 20);
		contentPane.add(txt_password);
		
		JLabel lblNewLabel_1_3 = new JLabel("Password");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(380, 117, 94, 14);
		contentPane.add(lblNewLabel_1_3);
		ImageIcon wallpaper = new ImageIcon ("D:\\eclipse\\DataSystem\\src\\images\\wallpaperPrincipal.jpg");
		
		JLabel lblNewLabel_1_4 = new JLabel("Tel\u00E9fono");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4.setBounds(20, 187, 94, 14);
		contentPane.add(lblNewLabel_1_4);
		
		txt_telefono = new JTextField();
		txt_telefono.setHorizontalAlignment(SwingConstants.CENTER);
		txt_telefono.setForeground(Color.WHITE);
		txt_telefono.setFont(new Font("Tahoma", Font.BOLD, 16));
		txt_telefono.setColumns(10);
		txt_telefono.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_telefono.setBackground(new Color(153, 102, 255));
		txt_telefono.setBounds(20, 207, 210, 20);
		contentPane.add(txt_telefono);
		
		cmb_niveles = new JComboBox();
		cmb_niveles.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Capturista", "Tecnico"})); //los niveles se guardan como numero de posicion empezando en cero,en este caso son 0,1,2
		cmb_niveles.setBounds(20, 250, 119, 22);
		contentPane.add(cmb_niveles);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int permisos_cmb, validacion = 0;
				String nombre, email, telefono, username, password, permisos_string="";
				
				email = txt_email.getText().trim();
				username = txt_username.getText().trim();
				password = txt_password.getText().trim();
				nombre = txt_nombre.getText().trim();
				telefono = txt_telefono.getText().trim();
				permisos_cmb = cmb_niveles .getSelectedIndex(); //cmb_niveles es el nombre del combobox estamos recuperando la seleccion
				
				if(email.equals("")) {
					txt_email.setBackground(Color.red);
					validacion++;
				}	
					
				if(username.equals("")) {
					txt_username.setBackground(Color.red);
					validacion++;
				}
				if(password.equals("")) {
					txt_password.setBackground(Color.red);
					validacion++;
				}
				if(nombre.equals("")) {
					txt_nombre.setBackground(Color.red);
					validacion++;
				}
				if(telefono.equals("")) {
					txt_telefono.setBackground(Color.red);
					validacion++;
				}
				
				if(permisos_cmb == 0) {
					permisos_string = "Administrador";
				
				}else  if(permisos_cmb == 1) {
					permisos_string = "Capturista";
				
				}else  if(permisos_cmb == 2) {
					permisos_string = "Tecnico";
				}
			    
			try {
				Connection cn = Conexion.conectar();
				PreparedStatement pst = cn.prepareStatement(
						"select username from usuarios where username = '" +username +"'"); //validación de si ya existe el usuario en la tabla para pedir que escoja otro
				
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
				txt_username.setBackground(Color.red);
				JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible"); // no hace ningun registro en la Tabla usuarios de la BD
				cn.close();
				}else {
					cn.close(); //es necesario empezar cerrando la conexion
						
						if(validacion == 0){ //de esta manera aseguramos que ningún campo esté vacío
							try {
								Connection cn2 = Conexion.conectar();
								PreparedStatement pst2 = cn2.prepareStatement(
										"insert into usuarios values (?,?,?,?,?,?,?,?,?)");
								pst2.setInt (1, 0);
								pst2.setString (2, nombre);
								pst2.setString (3, email);
								pst2.setString (4, telefono);
								pst2.setString (5, username);
								pst2.setString (6, password);
								pst2.setString (7, permisos_string);
								pst2.setString (8, "Activo");
								pst2.setString (9, user);
								
								pst2.executeUpdate();
								cn2.close();
								
								Limpiar();//Limpiar campos de texto
								txt_email.setBackground(Color.green);
								txt_nombre.setBackground(Color.green);
								txt_username.setBackground(Color.green);
								txt_telefono.setBackground(Color.green);
								txt_password.setBackground(Color.green);
								
								JOptionPane.showMessageDialog(null, "Registro exitoso");
								dispose(); //cierra este panel "Registrar usuarios"
								
								
							}catch (SQLException ex){
							System.err.println("Error en registrar usuario" +ex);
							JOptionPane.showMessageDialog(null, "Error en registro comuniquese con el admon");
							}
							
						}else {
							JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
						}
						
					
				}
			}catch (Exception ex) {
				System.err.println("Error al validar nombre de usuario" + ex);
				JOptionPane.showMessageDialog(null, "Error al comparar usuario contacte al administrador");
				
				
			}
			}
		});
		btnNewButton.setIcon(new ImageIcon(RegistrarUsuarios.class.getResource("/images/add.png")));
		btnNewButton.setBounds(470, 170, 120, 100);
		contentPane.add(btnNewButton);
		
		JLabel jLabel_footer = new JLabel("Creado por GoaHead");
		jLabel_footer.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 18));
		jLabel_footer.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_footer.setForeground(new Color(0, 0, 0));
		jLabel_footer.setBounds(215, 286, 204, 25);
		contentPane.add(jLabel_footer);
		
		JLabel jLabel_Wallpaper = new JLabel("");
		jLabel_Wallpaper.setBounds(0, 0, 614, 311);
		contentPane.add(jLabel_Wallpaper);
		
		Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
				jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
		jLabel_Wallpaper.setIcon(icono);
		
		
	}
	
	public void Limpiar(){ // Limpiar los campos
		txt_nombre.setText("");
		txt_email.setText("");
		txt_telefono.setText("");
		txt_password.setText("");
		txt_username.setText("");
		cmb_niveles.setSelectedIndex(0);
	
	}
	
	
	
	@Override
	public Image getIconImage() {
		Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
		return retValue;
	}
}
