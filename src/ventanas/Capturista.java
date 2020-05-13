package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.sql.*;
import clases.Conexion; //para poder importar métodos de esta clase
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FrontFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Capturista extends JFrame {

	private JPanel contentPane;
	String user, nombre_usuario;
	int sesion_usuario; //variable bandera ya que a este panel puede entrar tambn el admministrador, entonces para que no se cierre el programa cuando se de cerrar si esta en admon

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Capturista frame = new Capturista();
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
	public Capturista() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Capturista.class.getResource("/images/icon.png")));
		ImageIcon wallpaper = new ImageIcon ("D:\\eclipse\\DataSystem\\src\\images\\wallpaperPrincipal.jpg");
		user=login.user;
		sesion_usuario=Administrador.sesion_usuario;
	
		setSize(550, 300);
		setResizable(false);
		setTitle("Capturista");
		setLocationRelativeTo(null);
		
		if(sesion_usuario==1) {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		}else {
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}
		
		

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jLabel_NombreUsuario = new JLabel("");
		jLabel_NombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jLabel_NombreUsuario.setForeground(Color.WHITE);
		jLabel_NombreUsuario.setBounds(10, 11, 116, 20);
		contentPane.add(jLabel_NombreUsuario);
		
		JButton jButton_ImprimirCLientes = new JButton("");
		jButton_ImprimirCLientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jButton_ImprimirCLientes.setIcon(new ImageIcon(Capturista.class.getResource("/images/impresora.png")));
		jButton_ImprimirCLientes.setBounds(393, 79, 120, 100);
		contentPane.add(jButton_ImprimirCLientes);
		
		JButton jButton_GestionarClientes = new JButton("");
		jButton_GestionarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionarClientes gestionarclientes = new GestionarClientes();
				gestionarclientes.setVisible(true);;
				
			}
		});
		jButton_GestionarClientes.setIcon(new ImageIcon(Capturista.class.getResource("/images/informationuser.png")));
		jButton_GestionarClientes.setBounds(218, 79, 120, 100);
		contentPane.add(jButton_GestionarClientes);
		
		JButton jButton_RegistrarCliente = new JButton("");
		jButton_RegistrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			RegistrarClientes registrarclientes= new RegistrarClientes();
			registrarclientes.setVisible(true);
			}
		});
		jButton_RegistrarCliente.setIcon(new ImageIcon(Capturista.class.getResource("/images/add.png")));
		jButton_RegistrarCliente.setBounds(26, 79, 120, 100);
		contentPane.add(jButton_RegistrarCliente);
		
		JLabel txt_Registrar_Cliente = new JLabel("Registrar usuario");
		txt_Registrar_Cliente.setForeground(Color.WHITE);
		txt_Registrar_Cliente.setBounds(26, 190, 110, 14);
		contentPane.add(txt_Registrar_Cliente);
		
		JLabel txt_Gestionar_Usuarios = new JLabel("Gestionar clientes");
		txt_Gestionar_Usuarios.setForeground(Color.WHITE);
		txt_Gestionar_Usuarios.setBounds(218, 190, 110, 14);
		contentPane.add(txt_Gestionar_Usuarios);
		
		JLabel txt_ImprimirCLientes = new JLabel("Imprimir clientes");
		txt_ImprimirCLientes.setForeground(Color.WHITE);
		txt_ImprimirCLientes.setBounds(393, 190, 110, 14);
		contentPane.add(txt_ImprimirCLientes);
		
		JLabel lblNewLabel_1 = new JLabel("Creado por GoaHead");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(182, 234, 216, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel jLabel_Wallpaper = new JLabel("");
		jLabel_Wallpaper.setBounds(0, 0, 544, 271);
		contentPane.add(jLabel_Wallpaper);
		Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
				jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
		jLabel_Wallpaper.setIcon(icono);
		this.repaint();
		
		try {
			Connection cn = Conexion.conectar(); //buscar nombre del usuario que entró para ponerlo en el titulo
			PreparedStatement pst = cn.prepareStatement("select usuario from usuarios where username = '" +user+ "'");
			ResultSet rs= pst.executeQuery();
			if(rs.next()) {
				nombre_usuario = rs.getString("usuario");
				jLabel_NombreUsuario.setText("Welcome " +nombre_usuario);
			}
						
		}catch (SQLException ex){
			System.out.print("Error al buscar usuario " +ex);
			JOptionPane.showMessageDialog(null,"Error al buscar usuario contacte admon");
		}

		
	}

}
