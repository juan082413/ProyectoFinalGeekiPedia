package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class RegistrarUsuarios extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarUsuarios frame = new RegistrarUsuarios();
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
	public RegistrarUsuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de usuarios");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(210, 10, 255, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(20, 50, 94, 14);
		contentPane.add(lblNewLabel_1);
		
		JTextField txt_nombre = new JTextField();
		txt_nombre.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt_nombre.setHorizontalAlignment(SwingConstants.CENTER);
		txt_nombre.setForeground(Color.WHITE);
		txt_nombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		txt_nombre.setBackground(new Color(153, 102, 255));
		txt_nombre.setBounds(20, 70, 210, 20);
		contentPane.add(txt_nombre);
		txt_nombre.setColumns(10);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setColumns(10);
		textField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		textField.setBackground(new Color(153, 102, 255));
		textField.setBounds(20, 137, 210, 20);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(20, 117, 94, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_1.setColumns(10);
		textField_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		textField_1.setBackground(new Color(153, 102, 255));
		textField_1.setBounds(380, 70, 210, 20);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nombre:");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(380, 50, 94, 14);
		contentPane.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_2.setColumns(10);
		textField_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		textField_2.setBackground(new Color(153, 102, 255));
		textField_2.setBounds(380, 137, 210, 20);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nombre:");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(380, 117, 94, 14);
		contentPane.add(lblNewLabel_1_3);
		ImageIcon wallpaper = new ImageIcon ("D:\\eclipse\\DataSystem\\src\\images\\wallpaperPrincipal.jpg");
		
		JLabel lblNewLabel_1_4 = new JLabel("Nombre:");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4.setBounds(20, 187, 94, 14);
		contentPane.add(lblNewLabel_1_4);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_3.setColumns(10);
		textField_3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		textField_3.setBackground(new Color(153, 102, 255));
		textField_3.setBounds(20, 207, 210, 20);
		contentPane.add(textField_3);
		
		JComboBox cmb_niveles = new JComboBox();
		cmb_niveles.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Capturista", "Tecnico"}));
		cmb_niveles.setBounds(20, 250, 119, 22);
		contentPane.add(cmb_niveles);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(RegistrarUsuarios.class.getResource("/images/add.png")));
		btnNewButton.setBounds(470, 170, 120, 100);
		contentPane.add(btnNewButton);
		
		JLabel jLabel_footer = new JLabel("Creado por GoaHead");
		jLabel_footer.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 18));
		jLabel_footer.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_footer.setForeground(new Color(0, 0, 0));
		jLabel_footer.setBounds(215, 286, 204, 25);
		contentPane.add(jLabel_footer);
		
		JLabel jLabel_Wallpaper = new JLabel("");
		jLabel_Wallpaper.setBounds(0, 0, 614, 311);
		contentPane.add(jLabel_Wallpaper);
		Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
				jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
		jLabel_Wallpaper.setIcon(icono);
		
		
		
	}
	
	@Override
	public Image getIconImage() {
		Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
		return retValue;
	}
}
