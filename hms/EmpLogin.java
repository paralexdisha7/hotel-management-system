package hms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class EmpLogin extends JFrame {

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
					EmpLogin frame = new EmpLogin();
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
	public EmpLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EmpLogin.class.getResource("/icons/hotellogo.png")));
		setTitle("Employee Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100,1100,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbluser = new JLabel("Username :");
		lbluser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbluser.setBounds(159, 185, 85, 19);
		contentPane.add(lbluser);
		
		JLabel lblpass = new JLabel("Password :");
		lblpass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblpass.setBounds(159, 234, 85, 13);
		contentPane.add(lblpass);
		
		textUser = new JTextField();
		textUser.setBounds(262, 183, 181, 27);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(SystemColor.inactiveCaptionBorder);
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				String user=textUser.getText();
				long passW=passwordField.getText().hashCode();
				try {
					Conn con= new Conn();
					String query = ("select * from emp_data where username ='"+user+"' and password= '"+passW+"'");
					ResultSet rs= con.s.executeQuery(query);
					if(rs.next()) {
						setVisible(false);
						EmpMenu frame = new EmpMenu();
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
		btnLogin.setBounds(321, 305, 122, 39);
		contentPane.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(262, 229, 181, 27);
		contentPane.add(passwordField);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(SystemColor.inactiveCaptionBorder);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textUser.setText("");
				passwordField.setText("");

			}
		});
		btnClear.setIcon(null);
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClear.setBounds(159, 305, 112, 39);
		contentPane.add(btnClear);
		
		JButton backtomenu = new JButton("Go back to HMS");
		backtomenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				HotelManagementSystem frame = new HotelManagementSystem();
				frame.setVisible(true);
			}
		});
		backtomenu.setBackground(SystemColor.activeCaptionBorder);
		backtomenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backtomenu.setBounds(323, 10, 157, 27);
		contentPane.add(backtomenu);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EmpLogin.class.getResource("/icons/login (1).png")));
		lblNewLabel.setBounds(572, 10, 490, 506);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Employee");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel_1.setBounds(706, 474, 157, 55);
		contentPane.add(lblNewLabel_1);
	}
}
