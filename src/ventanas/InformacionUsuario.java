package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.sql.*;
import clases.Conexion;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class InformacionUsuario extends JFrame {
	
	private JPanel contentPane;
	private JTextField txt_nombre;
	private JTextField txt_email;
	private JTextField txt_telefono;
	private JTextField txt_username;
	private JTextField txt_registradopor;
	String user = "", user_update = "";
	int ID;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformacionUsuario frame = new InformacionUsuario();
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
	public InformacionUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InformacionUsuario.class.getResource("/images/icon.png")));
		
		user=login.user;
		user_update= GestionarUsuarios.user_update;
		
		setSize(630, 450);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_titulo = new JLabel("Informaci\u00F3n Usuarios");
		lbl_titulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_titulo.setForeground(Color.WHITE);
		lbl_titulo.setBounds(27, 15, 587, 36);
		contentPane.add(lbl_titulo);
		
		JLabel lblnombre = new JLabel("Nombre");
		lblnombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblnombre.setForeground(Color.WHITE);
		lblnombre.setBounds(27, 62, 223, 22);
		contentPane.add(lblnombre);
		
		JLabel lblemail = new JLabel("email");
		lblemail.setForeground(Color.WHITE);
		lblemail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblemail.setBounds(27, 148, 223, 22);
		contentPane.add(lblemail);
		
		JLabel lbl_telefono = new JLabel("Telefono");
		lbl_telefono.setForeground(Color.WHITE);
		lbl_telefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_telefono.setBounds(27, 227, 223, 22);
		contentPane.add(lbl_telefono);
		
		JLabel lbl_username = new JLabel("Username");
		lbl_username.setForeground(Color.WHITE);
		lbl_username.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_username.setBounds(354, 58, 223, 22);
		contentPane.add(lbl_username);
		
		JLabel lbl_registradopor = new JLabel("Registrado por:");
		lbl_registradopor.setForeground(Color.WHITE);
		lbl_registradopor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_registradopor.setBounds(354, 227, 223, 22);
		contentPane.add(lbl_registradopor);
		
		JComboBox cmb_estatus = new JComboBox();
		cmb_estatus.setModel(new DefaultComboBoxModel(new String[] {"Activo", "Inactivo"}));
		cmb_estatus.setBounds(354, 151, 79, 22);
		contentPane.add(cmb_estatus);
		
		JComboBox cmb_niveles = new JComboBox();
		cmb_niveles.setModel(new DefaultComboBoxModel(new String[] {"Administrador\t", "Capturista", "Tecnico"}));
		cmb_niveles.setBounds(27, 311, 115, 22);
		contentPane.add(cmb_niveles);
		
		JButton btn_actualizarUsuario = new JButton("Actualizar usuario");
		btn_actualizarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int permisos_cmb, estatus_cmb, validacion=0; //validacion variable bandera
				String nombre, email, telefono, username, password, permisos_string="", estatus_string="";
				
				email=txt_email.getText().trim();
				username=txt_username.getText().trim();
				nombre=txt_nombre.getText().trim();
				telefono=txt_telefono.getText().trim();
				permisos_cmb=cmb_niveles.getSelectedIndex();
				estatus_cmb=cmb_estatus.getSelectedIndex();
				
				if(email.equals("")) {
					txt_email.setBackground(Color.red);
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
				if(username.equals("")) {
					txt_username.setBackground(Color.red);
					validacion++;
				}
				if (validacion==0) {
					if(permisos_cmb==0) {
						permisos_string="Administrador";
					}else  if(permisos_cmb==1) {
						permisos_string="Capturista";
						
							}else if(permisos_cmb==2) {
						permisos_string="Tecnico";
					}
				
				if (estatus_cmb==0) {
					estatus_string="Activo";
					
					}else if (estatus_cmb==1) {
					estatus_string="Inactivo";
				}
				
				try {
					Connection cn = Conexion.conectar();
					PreparedStatement pst = cn.prepareStatement( //consulta si el username está disponible
							"Select username from usuarios where username= '" +username + "' and not id_usuario = '" +ID + "'"); //no consultes el ID del user que se esta consultando para que permita usar el mismo username
					ResultSet rs= pst.executeQuery();
					if(rs.next()) {
						txt_username.setBackground(Color.red);
						JOptionPane.showMessageDialog(null, "El nombre de usuario no está disponible");
						
					}else { //luego de validar que el username está disponible se hace el update
						Connection cn2 = Conexion.conectar();
						PreparedStatement pst2 = cn2.prepareStatement(
								"update usuarios set usuario=?, email=?, telefono=?, username=?, tipo_nivel=?, estatus=?"
								+"where id_usuario = '" +ID + "'");
						pst2.setString(1, nombre );
						pst2.setString(2, email);
						pst2.setString(3, telefono);
						pst2.setString(4, username);
						pst2.setString(5, permisos_string);
						pst2.setString(6, estatus_string);
						
						pst2.executeUpdate();
						cn2.close();
						
						JOptionPane.showMessageDialog(null, "Modificación exitosa");	
					}
			
				}catch(SQLException ex) {
					System.err.println("Error al actualizar "+ex );
				}
				
				
				
				
				}else {
					JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
				}
				
				
				
			}
		});
		btn_actualizarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_actualizarUsuario.setBounds(383, 308, 204, 23);
		contentPane.add(btn_actualizarUsuario);
		ImageIcon wallpaper = new ImageIcon ("D:\\eclipse\\DataSystem\\src\\images\\wallpaperPrincipal.jpg");
		
		txt_nombre = new JTextField();
		txt_nombre.setBackground(new Color(102, 102, 255));
		txt_nombre.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_nombre.setForeground(Color.WHITE);
		txt_nombre.setBounds(27, 97, 223, 20);
		contentPane.add(txt_nombre);
		txt_nombre.setColumns(10);
		
		txt_email = new JTextField();
		txt_email.setForeground(Color.WHITE);
		txt_email.setColumns(10);
		txt_email.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_email.setBackground(new Color(102, 102, 255));
		txt_email.setBounds(27, 181, 223, 20);
		contentPane.add(txt_email);
		
		txt_telefono = new JTextField();
		txt_telefono.setForeground(Color.WHITE);
		txt_telefono.setColumns(10);
		txt_telefono.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_telefono.setBackground(new Color(102, 102, 255));
		txt_telefono.setBounds(27, 260, 223, 20);
		contentPane.add(txt_telefono);
		
		txt_username = new JTextField();
		txt_username.setForeground(Color.WHITE);
		txt_username.setColumns(10);
		txt_username.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_username.setBackground(new Color(102, 102, 255));
		txt_username.setBounds(354, 97, 223, 20);
		contentPane.add(txt_username);
		
		txt_registradopor = new JTextField();
		txt_registradopor.setForeground(Color.WHITE);
		txt_registradopor.setColumns(10);
		txt_registradopor.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_registradopor.setBackground(new Color(102, 102, 255));
		txt_registradopor.setBounds(354, 260, 223, 20);
		contentPane.add(txt_registradopor);
		
		JButton btn_RestaurarPassword = new JButton("Restaurar Password");
		btn_RestaurarPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RestaurarPassword restaurarpassword = new RestaurarPassword();
				restaurarpassword.setVisible(true);

			}
		});
		btn_RestaurarPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_RestaurarPassword.setBounds(383, 359, 204, 23);
		contentPane.add(btn_RestaurarPassword);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Creado por GoaHead");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(224, 382, 209, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel jLabel_Wallpaper = new JLabel("");
		jLabel_Wallpaper.setBounds(0, 0, 624, 421);
		contentPane.add(jLabel_Wallpaper);
		Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
				jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
		jLabel_Wallpaper.setIcon(icono);
		this.repaint();
		
		lbl_titulo.setText("Información del usuario: " +user_update);

		try {
			Connection cn = Conexion.conectar();
			PreparedStatement pst = cn.prepareStatement(
					"select * from usuarios where username = '" +user_update + "'" ); //buscar en la tabla usuarios la fila que tiene en username el user seleccionado por el mouse y guardado en user_update
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				ID = rs.getInt("id_usuario"); //usando ID aseguro que no haya problemas con valores reptidos en usuarios en la opcion actualizar datos si se cambia el user por ejm
				txt_nombre.setText(rs.getString("usuario"));
				txt_email.setText(rs.getString("email"));
				txt_telefono.setText(rs.getString("telefono"));
				txt_username.setText(rs.getString("username"));
				txt_registradopor.setText(rs.getString("registrado_por"));
				
				cmb_niveles.setSelectedItem(rs.getString("tipo_nivel"));
				cmb_estatus.setSelectedItem(rs.getString("estatus"));
				
				
			}
			cn.close();
			
		}catch(SQLException ex) {
			System.err.println("Error en la conexión a la BD para cargar usuario " +ex);
			JOptionPane.showMessageDialog(null, "Error en la conexión a BD comunique admon");
		}
		
		
		
	}
}
