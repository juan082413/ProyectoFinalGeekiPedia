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


public class GestionarClientes extends JFrame {

	
	String user;
	public static int IDCliente_update = 0; //conexión entre interfaces
	DefaultTableModel model = new DefaultTableModel(); 
	private JPanel contentPane;
	private JTable jTable_clientes;
	private JScrollPane jScrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionarClientes frame = new GestionarClientes();
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
	public GestionarClientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestionarClientes.class.getResource("/images/icon.png")));
		ImageIcon wallpaper = new ImageIcon ("D:\\eclipse\\DataSystem\\src\\images\\wallpaperPrincipal.jpg");
		
		user = login.user;
		
		setSize(630, 330);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("clientes Registrados");
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
		Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
				jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
		jLabel_Wallpaper.setIcon(icono);
		this.repaint();
		
		try { // llenar tabla de datos
			Connection cn = Conexion.conectar();
			PreparedStatement pst = cn.prepareStatement(
					"select id_cliente, nombre_cliente, mail_cliente, tel_cliente, dir_cliente from clientes");
			
			ResultSet rs = pst.executeQuery(); 
			jTable_clientes = new JTable (model);
			jScrollPane.setViewportView(jTable_clientes);
			
			model.addColumn("");
			model.addColumn("Nombre");
			model.addColumn("email");
			model.addColumn("Teléfono");
			model.addColumn("Dirección");
			
			while (rs.next()) { // primero lleno un vecto auxiliar llamado fila y posteriormente utilizando el metodo addRow lleno la tabla
				Object [] fila = new Object [5]; //vector tipo object para ir llenando la tabla
						for (int f=0; f<5; f++) {  //cinco columnas
							fila[f] = rs.getObject( f+1 ); //el conteo empieza en cero pero en la yabla clientes desde 1 por eso se suma 1
														
						}
						model.addRow(fila);
	
			}
			cn.close();
			
		}catch (SQLException ex) {
			System.err.println("Error al llenar tabla " +ex);
			JOptionPane.showMessageDialog(null,"Error al llenar tabla comunique admon");
		}
		
		//generar un evento al precionar un elemento de la tabla, en este caso abrir otro panel
		jTable_clientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila_point = jTable_clientes.rowAtPoint(e.getPoint()); 
				int columna_point = 0;
				
				if (fila_point > -1) { //partiendo desde cero
					IDCliente_update = (int)model.getValueAt(fila_point, columna_point); //casting
					JOptionPane.showMessageDialog(null, "el id es: " +IDCliente_update);
	
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
