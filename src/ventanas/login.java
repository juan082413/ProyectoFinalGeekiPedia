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
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;

public class login extends JFrame {

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

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 550);
		setResizable(false);
		setTitle("Acceso al sistema");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		
		
		
		
		
		
	}
	}

