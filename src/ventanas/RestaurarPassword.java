package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.sql.*;
import clases.Conexion;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; //para poder usar el método conexion a BD

public class RestaurarPassword extends JFrame {

	private JPanel contentPane;
	private JTextField txt_password;
	private JTextField txt_passwordConfirmacion;
	String user="", user_update="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurarPassword frame = new RestaurarPassword();
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
	public RestaurarPassword() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RestaurarPassword.class.getResource("/images/icon.png")));
		ImageIcon wallpaper = new ImageIcon ("D:\\eclipse\\DataSystem\\src\\images\\wallpaperPrincipal.jpg");//que onda con esta línea
		user = login.user;
		user_update = GestionarUsuarios.user_update; //recuperar usuario al que se le dió clic en la tabla usuarios
		
		setSize(360, 260);
		setResizable(false);
		setTitle("Cambio de password user: " +user_update);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		
		JLabel lbl_titulo = new JLabel("Cambio de password");
		lbl_titulo.setForeground(Color.WHITE);
		lbl_titulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_titulo.setBounds(90, 0, 235, 22);
		contentPane.add(lbl_titulo);
		
		JLabel lbl_username = new JLabel("Nuevo password");
		lbl_username.setForeground(Color.WHITE);
		lbl_username.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_username.setBounds(10, 53, 223, 22);
		contentPane.add(lbl_username);
		
		txt_password = new JTextField();
		txt_password.setForeground(Color.WHITE);
		txt_password.setColumns(10);
		txt_password.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_password.setBackground(new Color(102, 102, 255));
		txt_password.setBounds(10, 86, 167, 20);
		contentPane.add(txt_password);
		
		JLabel lbl_username_1 = new JLabel("Confirmar password");
		lbl_username_1.setForeground(Color.WHITE);
		lbl_username_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_username_1.setBounds(10, 117, 223, 22);
		contentPane.add(lbl_username_1);
		
		txt_passwordConfirmacion = new JTextField();
		txt_passwordConfirmacion.setForeground(Color.WHITE);
		txt_passwordConfirmacion.setColumns(10);
		txt_passwordConfirmacion.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_passwordConfirmacion.setBackground(new Color(102, 102, 255));
		txt_passwordConfirmacion.setBounds(10, 145, 167, 20);
		contentPane.add(txt_passwordConfirmacion);
		
		JButton btn_RestaurarPassword = new JButton("Restaurar password");
		btn_RestaurarPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password, confirmacion_password;
				
				password=txt_password.getText().trim();
				confirmacion_password=txt_passwordConfirmacion.getText().trim();
				
				if(!password.equals("") && !confirmacion_password.equals("")) {  //si los campos no están vacíos
					if(password.equals(confirmacion_password)) {
						try {
						Connection cn = Conexion.conectar();
						PreparedStatement pst = cn.prepareStatement("update usuarios set password=? where username = '" + user_update + "'"); //se para en la columna password donde el username conicida con user_update el cual es el user capturado por el mouse

						pst.setString(1,password);
						pst.executeUpdate();
						cn.close();
						
						txt_password.setBackground(Color.green);
						txt_passwordConfirmacion.setBackground(Color.green);
						JOptionPane.showMessageDialog(null, "El password fue actualizado con exito");
						
						}catch (SQLException ex) {
							
						}

					}else {
						JOptionPane.showMessageDialog(null, "El password no coincide");
					}
					
				}else { //hay algun campo vacío
					txt_password.setBackground(Color.red);
					txt_passwordConfirmacion.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "No se admite password vacío");
					
				}
				
				
			}
		});
		btn_RestaurarPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_RestaurarPassword.setBounds(168, 197, 176, 23);
		contentPane.add(btn_RestaurarPassword);
		
		JLabel jLabel_Wallpaper = new JLabel("New label");
		jLabel_Wallpaper.setBounds(0, 0, 434, 261);
		contentPane.add(jLabel_Wallpaper);
		Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
				jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
		jLabel_Wallpaper.setIcon(icono);
		this.repaint();
	}

}
