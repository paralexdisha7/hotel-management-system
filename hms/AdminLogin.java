package hms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminLogin.class.getResource("/icons/hotellogo.png")));
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100,1100,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textUser = new JTextField();
		textUser.setColumns(10);
		textUser.setBounds(265, 205, 181, 27);
		contentPane.add(textUser);
		
		JLabel lbluser = new JLabel("Username :");
		lbluser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbluser.setBounds(162, 207, 85, 19);
		contentPane.add(lbluser);
		
		JLabel lblpass = new JLabel("Password :");
		lblpass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblpass.setBounds(162, 256, 85, 13);
		contentPane.add(lblpass);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(265, 251, 181, 27);
		contentPane.add(passwordField);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(SystemColor.inactiveCaptionBorder);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textUser.setText("");
				passwordField.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClear.setBounds(162, 385, 112, 39);
		contentPane.add(btnClear);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(SystemColor.inactiveCaptionBorder);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				try {
//					String uid=textUser.getText();
//					String upass=passwordField.getText();
//					if(uid.equals("Admin") && upass.equals("Admin@123")) {
//						JOptionPane.showMessageDialog(btnLogin, "Login Successful ");
//						setVisible(false);
//						AdminMenu frame = new AdminMenu();
//						frame.setVisible(true);
//						
//					}else {
//						JOptionPane.showMessageDialog(btnLogin, "Invalid Login id or password!");
//						textUser.setText("");
//						passwordField.setText("");
//					}
//				}catch(Exception e1) {
//					System.out.print(e1);	
//				}
				String user=textUser.getText();
				@SuppressWarnings("deprecation")
				long passW=passwordField.getText().hashCode();
				try {
//					Class.forName("oracle.jdbc.driver.OracleDriver");
//					Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","SMITA");
					Conn con= new Conn();
					String query = ("select * from admin_data where username ='"+user+"' and password= '"+passW+"'");
					ResultSet rs= con.s.executeQuery(query);
					if(rs.next()) {
						setVisible(false);
						AdminMenu frame = new AdminMenu();
						frame.setVisible(true);
						
					}else {
						
						JOptionPane.showMessageDialog(null, "Invalid Username or Password..");
						textUser.setText("");
						passwordField.setText("");
					}
					
					
				}catch(Exception e1) {
					System.out.print(e1);
					JOptionPane.showMessageDialog(btnLogin, e1);
					textUser.setText("");
					passwordField.setText("");
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.setBounds(324, 385, 122, 39);
		contentPane.add(btnLogin);
		
		JButton backtomenu = new JButton("Go back to HMS");
		backtomenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				HotelManagementSystem frame = new HotelManagementSystem();
				frame.setVisible(true);
			}
		});
		backtomenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backtomenu.setBackground(SystemColor.activeCaptionBorder);
		backtomenu.setBounds(289, 10, 157, 27);
		contentPane.add(backtomenu);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdminLogin.class.getResource("/icons/login (1).png")));
		lblNewLabel.setBounds(556, 0, 490, 506);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Admin");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel_1.setBounds(712, 481, 122, 27);
		contentPane.add(lblNewLabel_1);
	}
}
