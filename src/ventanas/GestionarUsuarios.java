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

import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.JScrollPane;
import java.sql.*;
import clases.Conexion;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;


public class GestionarUsuarios extends JFrame {

	
	String user;
	public static String user_update = ""; //conexión entre interfaces
	DefaultTableModel model = new DefaultTableModel(); 
	private JPanel contentPane;
	private JTable jTable_usuarios;
	private JScrollPane jScrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionarUsuarios frame = new GestionarUsuarios();
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
	public GestionarUsuarios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestionarUsuarios.class.getResource("/images/icon.png")));
		
		user = login.user;
		
		setSize(630, 330);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuarios Registrados");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(210, 10, 237, 29);
		contentPane.add(lblNewLabel);
		
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setBounds(0, 70, 630, 180);
		contentPane.add(jScrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("Creado por GoaHead");
		lblNewLabel_1.setBounds(235, 277, 127, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel jLabel_Wallpaper = new JLabel("");
		jLabel_Wallpaper.setBounds(0, 0, 630, 301);
		contentPane.add(jLabel_Wallpaper);
		ImageIcon wallpaper = new ImageIcon ("D:\\eclipse\\DataSystem\\src\\images\\wallpaperPrincipal.jpg");
		Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
				jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
		jLabel_Wallpaper.setIcon(icono);
		this.repaint();
		
		try { // llenar tabla de datos
			Connection cn = Conexion.conectar();
			PreparedStatement pst = cn.prepareStatement(
					"select id_usuario, usuario, username, tipo_nivel, estatus from usuarios");
			
			ResultSet rs = pst.executeQuery(); 
			jTable_usuarios = new JTable (model);
			jScrollPane.setViewportView(jTable_usuarios);
			
			model.addColumn("");
			model.addColumn("Nombre");
			model.addColumn("Username");
			model.addColumn("Permisos");
			model.addColumn("Estatus");
			
			while (rs.next()) { // primero lleno un vecto auxiliar llamado fila y posteriormente utilizando el metodo addRow lleno la tabla
				Object [] fila = new Object [5]; //vector tipo object para ir llenando la tabla
						for (int f=0; f<5; f++) {  //cinco columnas
							fila[f] = rs.getObject( f+1 ); //el conteo empieza en cero pero en la yabla usuarios desde 1 por eso se suma 1
														
						}
						model.addRow(fila);
	
			}
			cn.close();
			
		}catch (SQLException ex) {
			System.err.println("Error al llenar tabla " +ex);
			JOptionPane.showMessageDialog(null,"Error al llenar tabla comunique admon");
		}
		
		//generar un evento al precionar un elemento de la tabla, en este caso abrir otro panel
		jTable_usuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila_point = jTable_usuarios.rowAtPoint(e.getPoint()); 
				int columna_point = 2;
				
				if (fila_point > -1) { //partiendo desde cero
					user_update = (String)model.getValueAt(fila_point, columna_point);
					InformacionUsuario informacionusuario = new InformacionUsuario();
					informacionusuario.setVisible(true);
	
				}
				
				
			
			}
			});
			
			
		
		

		
	}
	
	@Override
	public Image getIconImage() {
		Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
		return retValue;
	}
}
