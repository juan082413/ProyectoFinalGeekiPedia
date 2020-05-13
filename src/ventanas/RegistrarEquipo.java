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
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.util.Calendar;
import clases.Conexion;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarEquipo extends JFrame {

	private JPanel contentPane;
	private JTextField txt_nombre;
	private JTextField txt_modelo;
	private JTextField txt_serie;
	int IDCliente_update = 0;
	String user = "", nom_cliente ="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarEquipo frame = new RegistrarEquipo();
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
	public RegistrarEquipo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestionarClientes.class.getResource("/images/icon.png")));
		ImageIcon wallpaper = new ImageIcon ("D:\\eclipse\\DataSystem\\src\\images\\wallpaperPrincipal.jpg");
		
		user = login.user;
		IDCliente_update = GestionarClientes.IDCliente_update; //desde la clase gestionar cliente traemos esta variable
		
		setTitle("Registrar nuevo equipo para " +nom_cliente);	
		setSize(630, 445);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreDelCliente = new JLabel("Nombre del cliente:");
		lblNombreDelCliente.setForeground(Color.WHITE);
		lblNombreDelCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreDelCliente.setBounds(10, 44, 223, 22);
		contentPane.add(lblNombreDelCliente);
		
		JLabel lblTipoDeQuipo = new JLabel("Tipo de equipo");
		lblTipoDeQuipo.setForeground(Color.WHITE);
		lblTipoDeQuipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTipoDeQuipo.setBounds(10, 121, 223, 22);
		contentPane.add(lblTipoDeQuipo);
		
		JLabel lblLaptop = new JLabel("Marca");
		lblLaptop.setForeground(Color.WHITE);
		lblLaptop.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLaptop.setBounds(10, 189, 223, 22);
		contentPane.add(lblLaptop);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setForeground(Color.WHITE);
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblModelo.setBounds(10, 256, 223, 22);
		contentPane.add(lblModelo);
		
		JLabel lblNmeroDeSerie = new JLabel("N\u00FAmero de serie");
		lblNmeroDeSerie.setForeground(Color.WHITE);
		lblNmeroDeSerie.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNmeroDeSerie.setBounds(10, 313, 223, 22);
		contentPane.add(lblNmeroDeSerie);
		
		txt_nombre = new JTextField();
		txt_nombre.setForeground(Color.WHITE);
		txt_nombre.setColumns(10);
		txt_nombre.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_nombre.setBackground(new Color(102, 102, 255));
		txt_nombre.setBounds(10, 77, 223, 20);
		contentPane.add(txt_nombre);
		
		txt_modelo = new JTextField();
		txt_modelo.setForeground(Color.WHITE);
		txt_modelo.setColumns(10);
		txt_modelo.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_modelo.setBackground(new Color(102, 102, 255));
		txt_modelo.setBounds(10, 282, 223, 20);
		contentPane.add(txt_modelo);
		
		txt_serie = new JTextField();
		txt_serie.setForeground(Color.WHITE);
		txt_serie.setColumns(10);
		txt_serie.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_serie.setBackground(new Color(102, 102, 255));
		txt_serie.setBounds(10, 349, 223, 20);
		contentPane.add(txt_serie);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(273, 71, 305, 232);
		contentPane.add(textArea);
		
		JComboBox cmb_TipoEquipo = new JComboBox();
		cmb_TipoEquipo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cmb_TipoEquipo.setModel(new DefaultComboBoxModel(new String[] {"Laptop", "Desktop"}));
		cmb_TipoEquipo.setBounds(10, 156, 68, 22);
		contentPane.add(cmb_TipoEquipo);
		
		JLabel lblDaoReportadoY = new JLabel("Da\u00F1o reportado y observaciones:");
		lblDaoReportadoY.setForeground(Color.WHITE);
		lblDaoReportadoY.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDaoReportadoY.setBounds(273, 44, 223, 22);
		contentPane.add(lblDaoReportadoY);
		
		JComboBox cmb_Marca = new JComboBox();
		cmb_Marca.setModel(new DefaultComboBoxModel(new String[] {"Hp", "Samsung", "Lenovo", "Toshiba"}));
		cmb_Marca.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cmb_Marca.setBounds(10, 222, 68, 22);
		contentPane.add(cmb_Marca);
		
		JButton btn_RegistrarEquipo = new JButton("RegistrarEquipo");
		btn_RegistrarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int validacion=0; //variable bandera
				String tipo_equipo, marca, modelo, num_serie, dia_ingreso, mes_ingreso, annio_ingreso,
						estatus,observaciones;
				
				tipo_equipo = cmb_TipoEquipo.getSelectedItem().toString();
				marca=cmb_Marca.getSelectedItem().toString();
				modelo=txt_modelo.getText().trim();
				num_serie=txt_serie.getText().trim();
				observaciones = textArea.getText();
				estatus = "Nuevo Ingreso";//variable que determina estado actual del equipo
				
				Calendar calendar = Calendar.getInstance();
				dia_ingreso = Integer.toString(calendar.get(Calendar.DATE)); //convertir calendar a objeto string, capturando día de ingreso
				mes_ingreso = Integer.toString(calendar.get(Calendar.MONTH)); //convertir calendar a objeto string, capturando día de ingreso
				annio_ingreso = Integer.toString(calendar.get(Calendar.YEAR)); //convertir calendar a objeto string, capturando día de ingreso
			
				if(modelo.equals("")) {   //validar campos vacíos
					txt_modelo.setBackground(Color.red);
					validacion++;
				}
				if(num_serie.equals("")) {
					txt_serie.setBackground(Color.red);
					validacion++;
				}
				if(observaciones.equals("")) {
					textArea.setText("Sin Observaciones.");
					validacion++;
				}
				
				if(validacion==0) {
					try {
						Connection cn = Conexion.conectar();
						PreparedStatement pst = cn.prepareStatement(
								"insert into equipos values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
						pst.setInt(1,0);
						pst.setInt(2,IDCliente_update);
						pst.setString(3,tipo_equipo); 
						pst.setString(4,marca);
						pst.setString(5,modelo);
						pst.setString(6,num_serie);
						pst.setString(7,dia_ingreso);
						pst.setString(8,mes_ingreso);
						pst.setString(9,annio_ingreso);
						pst.setString(10,observaciones);
						pst.setString(11,estatus);
						pst.setString(12,user);
						pst.setString(13,""); //comentarios tecnico
						pst.setString(13,""); //nombre tecnico
						pst.setString(14,"");
						pst.executeUpdate();//decirle a la BD que suba los datos anteriores
						cn.close();
						
						txt_nombre.setBackground(Color.green);
						txt_modelo.setBackground(Color.green);
						txt_serie.setBackground(Color.green);
						
						JOptionPane.showMessageDialog(null, "Registro exitoso. " );
						dispose();
					
					}catch(SQLException ex){
						System.err.println("Error al conectar a la base de datos " +ex);
						JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos cimunique admon" );
					}
					
					
					
				}else {
					JOptionPane.showMessageDialog(null, "Debe llebar todos los campos");
				}
				
				
			}
		});
		btn_RegistrarEquipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_RegistrarEquipo.setBounds(352, 341, 204, 23);
		contentPane.add(btn_RegistrarEquipo);
		
		JLabel lblNewLabel_1 = new JLabel("Creado por GoaHead");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(254, 383, 174, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel jLabel_Wallpaper = new JLabel("New label");
		jLabel_Wallpaper.setBounds(0, 0, 624, 416);
		contentPane.add(jLabel_Wallpaper);
		Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
				jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
		jLabel_Wallpaper.setIcon(icono);
		this.repaint();
		
		
		try {
			Connection cn = Conexion.conectar();
			PreparedStatement pst = cn.prepareStatement(
					"select nombre_cliente from clientes where id_cliente = '" +IDCliente_update +"'"); //sleccione nombre cliente de la tabla clientes donde el id cliente sea el mismo de la variable idclienteupdate la cual tiene el id del cliente al que se le dió clic
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				nom_cliente= rs.getString("nombre_cliente"); //recuperando el nombre del cliente 

			}
			
		}catch(SQLException ex) {
			System.err.println("Error al conectar a la BD" +ex);
		}
		
		txt_nombre.setText(nom_cliente);
		
	
		
		
		
	}
}
