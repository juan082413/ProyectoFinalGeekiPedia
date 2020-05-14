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
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.sql.*;
import clases.Conexion;


public class InformacionEquipos extends JFrame {

	private JPanel contentPane;
	private JTextField txt_nombre;
	private JTextField txt_modelo;
	private JTextField txt_serie;
	int IDCliente_update =0;
	int IDequipo=0;
	String user ="",nom_cliente="";
	private JComboBox cmb_Marca;
	private JComboBox cmb_TipoEquipo;
	private JTextArea textAreaCapturista;
	private JTextArea textAreaTecnico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformacionEquipos frame = new InformacionEquipos();
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
	public InformacionEquipos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestionarClientes.class.getResource("/images/icon.png")));
		ImageIcon wallpaper = new ImageIcon ("D:\\eclipse\\DataSystem\\src\\images\\wallpaperPrincipal.jpg");
		
		user=login.user;
		IDCliente_update=GestionarClientes.IDCliente_update;
		IDequipo=InformacionCliente.IDequipo;
		

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
		lblNombreDelCliente.setBounds(23, 38, 223, 22);
		contentPane.add(lblNombreDelCliente);
		
		txt_nombre = new JTextField();
		txt_nombre.setText("");
		txt_nombre.setForeground(Color.WHITE);
		txt_nombre.setColumns(10);
		txt_nombre.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_nombre.setBackground(new Color(102, 102, 255));
		txt_nombre.setBounds(23, 71, 223, 20);
		contentPane.add(txt_nombre);
		
		JLabel lblTipoDeQuipo = new JLabel("Tipo de equipo");
		lblTipoDeQuipo.setForeground(Color.WHITE);
		lblTipoDeQuipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTipoDeQuipo.setBounds(23, 115, 223, 22);
		contentPane.add(lblTipoDeQuipo);
		
		cmb_TipoEquipo = new JComboBox();
		cmb_TipoEquipo.setModel(new DefaultComboBoxModel(new String[] {"Desktop", "Laptop"}));
		cmb_TipoEquipo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cmb_TipoEquipo.setBounds(23, 150, 80, 22);
		contentPane.add(cmb_TipoEquipo);
		
		cmb_Marca = new JComboBox();
		cmb_Marca.setModel(new DefaultComboBoxModel(new String[] {"Acer", "Lenovo", "HP", "Toshiba", "Samsung", "Hp"}));
		cmb_Marca.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cmb_Marca.setBounds(23, 216, 95, 22);
		contentPane.add(cmb_Marca);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setForeground(Color.WHITE);
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblModelo.setBounds(23, 250, 223, 22);
		contentPane.add(lblModelo);
		
		txt_modelo = new JTextField();
		txt_modelo.setForeground(Color.WHITE);
		txt_modelo.setColumns(10);
		txt_modelo.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_modelo.setBackground(new Color(102, 102, 255));
		txt_modelo.setBounds(23, 276, 223, 20);
		contentPane.add(txt_modelo);
		
		JLabel lblNmeroDeSerie = new JLabel("N\u00FAmero de serie");
		lblNmeroDeSerie.setForeground(Color.WHITE);
		lblNmeroDeSerie.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNmeroDeSerie.setBounds(23, 307, 223, 22);
		contentPane.add(lblNmeroDeSerie);
		
		txt_serie = new JTextField();
		txt_serie.setForeground(Color.WHITE);
		txt_serie.setColumns(10);
		txt_serie.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_serie.setBackground(new Color(102, 102, 255));
		txt_serie.setBounds(23, 343, 223, 20);
		contentPane.add(txt_serie);
		
		JButton btn_ActualizarEquipo = new JButton("Actualizar Cliente");
		btn_ActualizarEquipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_ActualizarEquipo.setBounds(369, 352, 204, 23);
		contentPane.add(btn_ActualizarEquipo);
		
		JLabel lblDaoReportadoY = new JLabel("Da\u00F1o reportado y observaciones:");
		lblDaoReportadoY.setForeground(Color.WHITE);
		lblDaoReportadoY.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDaoReportadoY.setBounds(286, 38, 223, 22);
		contentPane.add(lblDaoReportadoY);
		
		textAreaCapturista = new JTextArea();
		textAreaCapturista.setBounds(286, 65, 307, 107);
		contentPane.add(textAreaCapturista);
		
		textAreaTecnico = new JTextArea();
		textAreaTecnico.setBounds(286, 215, 307, 107);
		contentPane.add(textAreaTecnico);
		
		JLabel lblComentariosYActualizacin = new JLabel("Comentarios y actualizaci\u00F3n del t\u00E9cnico:");
		lblComentariosYActualizacin.setForeground(Color.WHITE);
		lblComentariosYActualizacin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblComentariosYActualizacin.setBounds(286, 183, 290, 22);
		contentPane.add(lblComentariosYActualizacin);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setForeground(Color.WHITE);
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMarca.setBounds(23, 183, 223, 22);
		contentPane.add(lblMarca);
		
		JLabel lblInformacinDelEquipo = new JLabel("Informaci\u00F3n del equipo");
		lblInformacinDelEquipo.setForeground(Color.WHITE);
		lblInformacinDelEquipo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblInformacinDelEquipo.setBounds(149, 0, 283, 27);
		contentPane.add(lblInformacinDelEquipo);
		JLabel jLabel_Wallpaper = new JLabel("New label");
		jLabel_Wallpaper.setBounds(0, 0, 624, 416);
		contentPane.add(jLabel_Wallpaper);
		Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
				jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
		jLabel_Wallpaper.setIcon(icono);
		this.repaint();
		
		
		
		try {
			Connection cn2 = Conexion.conectar();
			PreparedStatement pst2 = cn2.prepareStatement(
					"select nombre_cliente from clientes where id_cliente = '" + IDCliente_update + "'");
			ResultSet rs2 = pst2.executeQuery(); //buscar
			
			if(rs2.next()) {
				nom_cliente=rs2.getString("nombre_cliente");
				txt_nombre.setText(nom_cliente);
			}
			cn2.close();
			
		}catch(SQLException ex2) {
			System.err.println("Error base datos tabla usuarios" +ex2);
			JOptionPane.showMessageDialog(null, "Error al obtener datos del usuario consultar admon");
			
		}
		
		
		try { //CONEXION A BD PARA LLENADO DE LA INFORMACION DEL EQUIPO SELECCIONADO POR IDEQUIPO
			Connection cn = Conexion.conectar();
			PreparedStatement pst = cn.prepareStatement(
					"select * from equipos where id_equipo = '" + IDequipo + "'");
			ResultSet rs = pst.executeQuery(); //buscar
			
			
			
			if(rs.next()) {	//CONEXION A BD PARA LLENADO DE LA INFORMACION DEL EQUIPO SELECCIONADO POR IDEQUIPO
				setTitle("Información del equipo" +rs.getString("tipo_equipo") +" " +rs.getString("marca") );
				lblInformacinDelEquipo.setText("Información del equipo con número de serie: " +rs.getString("num_serie"));
				
				setTitle("el id del equipo es: " +IDequipo);
				txt_modelo.setText(rs.getString("modelo"));
				txt_serie.setText(rs.getString("num_serie"));
				cmb_TipoEquipo.setSelectedItem(rs.getString("tipo_equipo"));
				cmb_Marca.setSelectedItem(rs.getString("marca"));
				textAreaCapturista.setText(rs.getString("observaciones"));
				
				
			}
			cn.close();
		}catch(SQLException ex) {
			System.err.println("Error base datos tabla equipos" +ex);
			JOptionPane.showMessageDialog(null, "Error al obtener datos del equipo consultar admon");
		
			
			
			
			
			
		}
	}
	
	
		
	}
		
		
	


