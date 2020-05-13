package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.*;

import clases.Conexion;

import com.itextpdf.text.Chunk;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FrontFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;


public class InformacionCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txt_nombre;
	private JTextField txt_email;
	private JTextField txt_telefono;
	private JTextField txt_direccion;
	private JTextField txt_registradopor;
	private JTable jTable_equipos;
	DefaultTableModel model = new DefaultTableModel();
	int IDCliente_update =0;
	public static int IDequipo=0;
	String user ="";
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformacionCliente frame = new InformacionCliente();
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
	public InformacionCliente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestionarClientes.class.getResource("/images/icon.png")));
		ImageIcon wallpaper = new ImageIcon ("D:\\eclipse\\DataSystem\\src\\images\\wallpaperPrincipal.jpg");
		
		user=login.user;
		IDCliente_update=GestionarClientes.IDCliente_update;
		
		
		setSize(672, 493);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_titulo = new JLabel("Informaci\u00F3n del cliente:");
		lbl_titulo.setForeground(Color.WHITE);
		lbl_titulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_titulo.setBounds(10, 11, 587, 36);
		contentPane.add(lbl_titulo);
		
		JLabel lblnombre = new JLabel("Nombre");
		lblnombre.setForeground(Color.WHITE);
		lblnombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblnombre.setBounds(10, 73, 223, 22);
		contentPane.add(lblnombre);
		
		txt_nombre = new JTextField();
		txt_nombre.setForeground(Color.WHITE);
		txt_nombre.setColumns(10);
		txt_nombre.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_nombre.setBackground(new Color(102, 102, 255));
		txt_nombre.setBounds(10, 108, 223, 20);
		contentPane.add(txt_nombre);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(10, 136, 223, 22);
		contentPane.add(lblEmail);
		
		txt_email = new JTextField();
		txt_email.setForeground(Color.WHITE);
		txt_email.setColumns(10);
		txt_email.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_email.setBackground(new Color(102, 102, 255));
		txt_email.setBounds(10, 171, 223, 20);
		contentPane.add(txt_email);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTelefono.setBounds(10, 203, 223, 22);
		contentPane.add(lblTelefono);
		
		txt_telefono = new JTextField();
		txt_telefono.setForeground(Color.WHITE);
		txt_telefono.setColumns(10);
		txt_telefono.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_telefono.setBackground(new Color(102, 102, 255));
		txt_telefono.setBounds(10, 238, 223, 20);
		contentPane.add(txt_telefono);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setForeground(Color.WHITE);
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDireccin.setBounds(10, 267, 223, 22);
		contentPane.add(lblDireccin);
		
		txt_direccion = new JTextField();
		txt_direccion.setForeground(Color.WHITE);
		txt_direccion.setColumns(10);
		txt_direccion.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_direccion.setBackground(new Color(102, 102, 255));
		txt_direccion.setBounds(10, 302, 223, 20);
		contentPane.add(txt_direccion);
		
		JLabel registradopor = new JLabel("Utlima modificaci\u00F3n por:");
		registradopor.setForeground(Color.WHITE);
		registradopor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		registradopor.setBounds(10, 333, 223, 22);
		contentPane.add(registradopor);
		
		txt_registradopor = new JTextField();
		txt_registradopor.setForeground(Color.BLACK);
		txt_registradopor.setColumns(10);
		txt_registradopor.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_registradopor.setBackground(Color.WHITE);
		txt_registradopor.setBounds(10, 368, 223, 20);
		contentPane.add(txt_registradopor);
		
		JButton btn_RegistrarEquipo = new JButton("RegistrarEquipo");
		btn_RegistrarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarEquipo registarequipo = new RegistrarEquipo();
				registarequipo .setVisible(true);
				
			}
		});
		btn_RegistrarEquipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_RegistrarEquipo.setBounds(270, 284, 204, 23);
		contentPane.add(btn_RegistrarEquipo);
		
		JButton btn_ActualizarCliente = new JButton("Actualizar Cliente");
		btn_ActualizarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int validacion=0; //variable bandera
				String nombre, email, telefono, direccion;
				nombre = txt_nombre.getText().trim();
				email=txt_email.getText().trim();
				telefono=txt_telefono.getText().trim();
				direccion=txt_direccion.getText().trim();
				
				if (nombre.equals("")) {
					txt_nombre.setBackground(Color.red);
					validacion++;
				}
				if (email.equals("")) {
					txt_email.setBackground(Color.red);
					validacion++;
				}
				if (telefono.equals("")) {
					txt_telefono.setBackground(Color.red);
					validacion++;
				}
				if (direccion.equals("")) {
					txt_direccion.setBackground(Color.red);
					validacion++;
				}
				
				
				if(validacion==0) {
					try {
						Connection cn = Conexion.conectar();
						PreparedStatement pst = cn.prepareStatement(
								"update clientes set nombre_cliente=?, mail_cliente=?, tel_cliente=?, dir_cliente=?, ultima_modificacion=?"
								+ "where id_cliente = '" +IDCliente_update + "'");
						pst.setString(1, nombre);
						pst.setString(2, email);
						pst.setString(3, telefono);
						pst.setString(4, direccion);
						pst.setString(5, user);
						
						pst.executeUpdate();
						cn.close();
						Limpiar();
						
						txt_nombre.setBackground(Color.green);
						txt_email.setBackground(Color.green);
						txt_direccion.setBackground(Color.green);
						txt_registradopor.setText(user);
						
						JOptionPane.showMessageDialog(null, "Actualizacion exitosa");
						dispose();
						
					}catch(SQLException ex) {
						System.err.println("Error al sincronizar con BD" +ex);
						JOptionPane.showMessageDialog(null, "Error al comunicarse con BD comuniquese admon");
					}
										
				}else {
					JOptionPane.showMessageDialog(null, "Hay campos vacíos");
				}
					
				
				
				
			}
		});
		btn_ActualizarCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_ActualizarCliente.setBounds(270, 336, 204, 23);
		contentPane.add(btn_ActualizarCliente);
		
		JButton jButton_Creatividad = new JButton("");
		jButton_Creatividad.setIcon(new ImageIcon(InformacionCliente.class.getResource("/images/impresora.png")));
		jButton_Creatividad.setBounds(517, 267, 120, 100);
		contentPane.add(jButton_Creatividad);
		
		JLabel lblNewLabel_1 = new JLabel("Creado por GoaHead");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(278, 419, 196, 22);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(270, 58, 367, 179);
		contentPane.add(scrollPane);
		
		
		
		JLabel jLabel_Wallpaper = new JLabel("");
		jLabel_Wallpaper.setBounds(0, 0, 666, 464);
		contentPane.add(jLabel_Wallpaper);
		Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
				jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
		jLabel_Wallpaper.setIcon(icono);
		this.repaint();
		
		try { //conexion a BD tabla clientes para llenado de campos del usuario
			Connection cn = Conexion.conectar();
			PreparedStatement pst = cn.prepareStatement(
					"select * from clientes where id_cliente = '" + IDCliente_update + "'");
			ResultSet rs = pst.executeQuery(); //buscar
			
			
			
			if(rs.next()) {
				setTitle("Información del cliente" +rs.getString("nombre_cliente") + " -Sesión de: " +user);
				lbl_titulo.setText("Información del cliente " +rs.getString("nombre_cliente"));
				txt_nombre.setText(rs.getString("nombre_cliente"));
				txt_email.setText(rs.getString("mail_cliente"));
				txt_telefono.setText(rs.getString("tel_cliente"));
				txt_direccion.setText(rs.getString("dir_cliente"));
				txt_registradopor.setText(rs.getString("ultima_modificacion"));
				
			}
			cn.close();
		}catch(SQLException ex) {
			System.err.println("Error base datos" +ex);
			JOptionPane.showMessageDialog(null, "Error al conectar BD consultar admon");
		}
		
		
		try { //conexcion a BD tabla equipos para llenado de los equipos de cada cliente usando el ID com identificador
			Connection cn = Conexion.conectar();
			PreparedStatement pst = cn.prepareStatement(
					"select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente = '" +IDCliente_update +"'");
			
			ResultSet rs = pst.executeQuery();
			
			jTable_equipos = new JTable(model);  //esto tambien puede estar afuera del trycatch contal de qye esté en el constructior
			scrollPane.setViewportView(jTable_equipos);
			
			model.addColumn("ID Equipo");
			model.addColumn("Tipo de Equipo");
			model.addColumn("Marca");
			model.addColumn("Estatus");
				
			while(rs.next()) {
				Object [] fila = new Object [4];
				for (int f=0;f<4;f++) {
					fila[f] = rs.getObject(f+1);
					}
				model.addRow(fila);
					}
			cn.close();
		}catch (SQLException ex) {
			System.err.println("Error en el llenado de la tabla equipos" +ex);

		}
		
		jTable_equipos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila_point = jTable_equipos.rowAtPoint(e.getPoint()); 
				int columna_point = 0;
				
				if (fila_point > -1) { //partiendo desde cero
					IDequipo = (int)model.getValueAt(fila_point, columna_point); //casting
					InformacionCliente informacion_cliente = new InformacionCliente();
					informacion_cliente.setVisible(true);
				}
			}
		});
		
		
	}

	public void Limpiar() {
		txt_nombre.setText("");
		txt_email.setText("");
		txt_direccion.setText("");
		txt_telefono.setText("");	
	}
	
}
