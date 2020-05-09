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
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import clases.Conexion;


public class login extends JFrame {

	public static String user = "";
	String pass = "";
	
	
	private JPanel contentPane;
	private JLabel jLabel_Wallpaper;
	private JTextField txt_user;
	private JTextField txt_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(login.class.getResource("/images/icon.png")));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 550);
		setResizable(false);
		setTitle("Acceso al sistema");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jLabel_Footer = new JLabel("Creado por GoaHead");
		jLabel_Footer.setFont(new Font("Century Gothic", Font.BOLD, 15));
		jLabel_Footer.setBounds(110, 496, 188, 14);
		contentPane.add(jLabel_Footer);
		
		JButton jButton_Acceder = new JButton("Acceder");
		jButton_Acceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = txt_user.getText().trim();
				pass = txt_password.getText().trim();
				
				if (!user.equals("") || !pass.equals("")) { //si no hay espacios en blanco que ejecute el código
					
					try {
						Connection cn = Conexion.conectar();
						PreparedStatement pst = cn.prepareStatement("select tipo_nivel, estatus from usuarios where username = '" +user
										+ "' and password = '" +pass +"'"); //seleccione tipo nivel y estatus haciendo comparacion de user y pass
						
						ResultSet rs = pst.executeQuery();
						if (rs.next()) {
							String tipo_nivel = rs.getString("tipo_nivel");
							String estatus = rs.getString("estatus");
							
							if(tipo_nivel.equalsIgnoreCase("Administrador") && estatus.equalsIgnoreCase("Activo")) {
								dispose();
								new Administrador().setVisible(true);
								}else { if(tipo_nivel.equalsIgnoreCase("Capturista") && estatus.equalsIgnoreCase("Activo")) {
										dispose();
										new Capturista().setVisible(true);
											}else { if(tipo_nivel.equalsIgnoreCase("Tecnico") && estatus.equalsIgnoreCase("Activo")) {
													dispose();
													new Tecnico().setVisible(true);
														}else {
													}
													}
													}
						}else {
							JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos");
							txt_user.setText("");
							txt_password.setText("");
						}
						
						
					}catch (Exception ex) {
						System.err.println("Error en el botón Acceder" +ex);//envío letreros en color rojo
						JOptionPane.showMessageDialog(null, "Error al iniciar sesión contacte al administrador");
					}
					
				} else {
				JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
				}
			}
			});
		jButton_Acceder.setBackground(new Color(153, 102, 255));
		jButton_Acceder.setForeground(Color.WHITE);
		jButton_Acceder.setBounds(95, 420, 210, 35);
		contentPane.add(jButton_Acceder);
		
		txt_user = new JTextField();
		txt_user.setBackground(new Color(153, 102, 204));
		txt_user.setHorizontalAlignment(SwingConstants.CENTER);
		txt_user.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_user.setForeground(Color.WHITE);
		txt_user.setBounds(95, 330, 210, 20);
		contentPane.add(txt_user);
		txt_user.setColumns(10);
		
		txt_password = new JTextField();
		txt_password.setBackground(new Color(153, 102, 255));
		txt_password.setForeground(Color.WHITE);
		txt_password.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_password.setBounds(95, 370, 210, 20);
		contentPane.add(txt_password);
		txt_password.setColumns(10);

		JLabel jLabel_Logo = new JLabel("");
		jLabel_Logo.setBounds(68, 23, 238, 228);
		contentPane.add(jLabel_Logo);
		ImageIcon wallpaper_logo = new ImageIcon ("D:\\eclipse\\DataSystem\\src\\images\\DS.png");
		Icon icono_logo = new ImageIcon(wallpaper_logo.getImage().getScaledInstance(jLabel_Logo.getWidth(),
				jLabel_Logo.getHeight(), Image.SCALE_DEFAULT));
		jLabel_Logo.setIcon(icono_logo);
		
		jLabel_Wallpaper = new JLabel("");
		jLabel_Wallpaper.setBounds(0, 0, 400, 550);
		contentPane.add(jLabel_Wallpaper);
		ImageIcon wallpaper = new ImageIcon ("D:\\eclipse\\DataSystem\\src\\images\\wallpaperPrincipal.jpg");
		Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
				jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
		jLabel_Wallpaper.setIcon(icono);
		this.repaint();
	}
	
	@Override
	public Image getIconImage() {
		Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
		return retValue;
	}
	}

