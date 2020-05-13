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

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import clases.Conexion;

public class RegistrarClientes extends JFrame {

	private JPanel contentPane;
	private JTextField txt_telefono;
	private JTextField txt_nombre;
	private JTextField txt_email;
	private JTextField txt_direccion;
	String user;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarClientes frame = new RegistrarClientes();
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
	public RegistrarClientes() {
		user = login.user; //usuario que inició sesión

		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarClientes.class.getResource("/images/icon.png")));
		ImageIcon wallpaper = new ImageIcon ("D:\\eclipse\\DataSystem\\src\\images\\wallpaperPrincipal.jpg");
		
		setTitle("Registrar Clientes - Sesión del usuario: " +user );
		setSize(470,352);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //evita que el programa cuando la interfaz se cierre

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroDeClientes = new JLabel("Registro de clientes");
		lblRegistroDeClientes.setForeground(Color.WHITE);
		lblRegistroDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblRegistroDeClientes.setBounds(107, 0, 255, 29);
		contentPane.add(lblRegistroDeClientes);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 54, 94, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tel\u00E9fono:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(10, 110, 94, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("email:");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(10, 167, 94, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Direcci\u00F3n");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(10, 223, 94, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel jLabel_footer = new JLabel("Creado por GoaHead");
		jLabel_footer.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_footer.setForeground(Color.BLACK);
		jLabel_footer.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 18));
		jLabel_footer.setBounds(145, 287, 204, 25);
		contentPane.add(jLabel_footer);
		
		txt_telefono = new JTextField();
		txt_telefono.setHorizontalAlignment(SwingConstants.CENTER);
		txt_telefono.setForeground(Color.WHITE);
		txt_telefono.setFont(new Font("Tahoma", Font.BOLD, 16));
		txt_telefono.setColumns(10);
		txt_telefono.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_telefono.setBackground(new Color(153, 102, 255));
		txt_telefono.setBounds(10, 135, 210, 20);
		contentPane.add(txt_telefono);
		
		txt_nombre = new JTextField();
		txt_nombre.setHorizontalAlignment(SwingConstants.CENTER);
		txt_nombre.setForeground(Color.WHITE);
		txt_nombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		txt_nombre.setColumns(10);
		txt_nombre.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_nombre.setBackground(new Color(153, 102, 255));
		txt_nombre.setBounds(10, 79, 210, 20);
		contentPane.add(txt_nombre);
		
		txt_email = new JTextField();
		txt_email.setHorizontalAlignment(SwingConstants.CENTER);
		txt_email.setForeground(Color.WHITE);
		txt_email.setFont(new Font("Tahoma", Font.BOLD, 16));
		txt_email.setColumns(10);
		txt_email.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_email.setBackground(new Color(153, 102, 255));
		txt_email.setBounds(10, 192, 210, 20);
		contentPane.add(txt_email);
		
		txt_direccion = new JTextField();
		txt_direccion.setHorizontalAlignment(SwingConstants.CENTER);
		txt_direccion.setForeground(Color.WHITE);
		txt_direccion.setFont(new Font("Tahoma", Font.BOLD, 16));
		txt_direccion.setColumns(10);
		txt_direccion.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_direccion.setBackground(new Color(153, 102, 255));
		txt_direccion.setBounds(10, 248, 210, 20);
		contentPane.add(txt_direccion);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(RegistrarClientes.class.getResource("/images/add.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre, telefono, email, direccion;
				int validacion=0;
				nombre=txt_nombre.getText().trim();
				telefono=txt_telefono.getText().trim();
				email=txt_email.getText().trim();
				direccion=txt_direccion.getText().trim();
				
				if(email.equals("")) {
					txt_email.setBackground(Color.red);
					validacion++;
				}	
		
				if(direccion.equals("")) {
					txt_direccion.setBackground(Color.red);
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
				if (validacion==0) {
					try {
						Connection cn = Conexion.conectar();
						PreparedStatement pst = cn.prepareCall(
								"insert into clientes values (?,?,?,?,?,?)");
						
						pst.setInt(1, 0);
						pst.setString(2, nombre);
						pst.setString(3, email);
						pst.setString(4, telefono);
						pst.setString(5, direccion);
						pst.setString(6, user);
						
					pst.executeUpdate();
					cn.close();
					
					Limpiar();
					txt_email.setBackground(Color.green);
					txt_telefono.setBackground(Color.green);
					txt_direccion.setBackground(Color.green);
					txt_nombre.setBackground(Color.green);
					JOptionPane.showMessageDialog(null, "Registro exitoso");
					dispose(); //cierra este panel "Registrar clientes" para liberar memoria
					
					}catch (SQLException ex){
						System.out.println("Error al registar cliente " +ex);
						JOptionPane.showMessageDialog(null, "Error comunicar con admon");
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
				}
				
				
				
			}
		});
		btnNewButton.setBounds(297, 112, 120, 100);
		contentPane.add(btnNewButton);
		
		JLabel jLabel_Wallpaper = new JLabel("");
		jLabel_Wallpaper.setBounds(0, 0, 464, 323);
		contentPane.add(jLabel_Wallpaper);
		Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
				jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
		jLabel_Wallpaper.setIcon(icono);
		this.repaint();
	}
	
	public void Limpiar() {
		txt_nombre.setText("");
		txt_direccion.setText("");
		txt_telefono.setText("");
		txt_email.setText("");
		
	}

}
