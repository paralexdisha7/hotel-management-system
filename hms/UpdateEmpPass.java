package hms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class UpdateEmpPass extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	private JPasswordField Pass;
	private JPasswordField RePass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateEmpPass frame = new UpdateEmpPass();
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
	public UpdateEmpPass() {
		setTitle("Reset Employee Password");
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateEmpPass.class.getResource("/icons/hotellogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 653, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("Enter Username :");
		lblUser.setBounds(92, 139, 145, 13);
		contentPane.add(lblUser);
		
		textUser = new JTextField();
		textUser.setColumns(10);
		textUser.setBounds(235, 132, 266, 27);
		contentPane.add(textUser);
		
		JLabel lblEnterNewPassword = new JLabel("Enter New Password :");
		lblEnterNewPassword.setBounds(92, 183, 145, 13);
		contentPane.add(lblEnterNewPassword);
		
		Pass = new JPasswordField();
		Pass.setColumns(10);
		Pass.setBounds(235, 176, 266, 27);
		contentPane.add(Pass);
		
		JLabel lblRePass = new JLabel("Confirm Password : ");
		lblRePass.setBounds(92, 231, 145, 13);
		contentPane.add(lblRePass);
		
		RePass = new JPasswordField();
		RePass.setColumns(10);
		RePass.setBounds(235, 224, 266, 27);
		contentPane.add(RePass);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(SystemColor.inactiveCaptionBorder);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textUser.setText("");
				Pass.setText("");
				RePass.setText("");
			}
		});
		btnClear.setBounds(235, 296, 98, 42);
		contentPane.add(btnClear);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(SystemColor.inactiveCaptionBorder);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=textUser.getText();
				String passW=Pass.getText();
				String passW2=RePass.getText();
				try {
					//Class.forName("oracle.jdbc.driver.OracleDriver");
					//Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","SMITA");
					Conn con= new Conn();
					
//					String query1 = ("select * from emp_data where username ='"+user+"'");
//					ResultSet rs= con.s.executeQuery(query);
					if(passW.equals(passW2)) {
						long enc_pass=passW.hashCode();
						String query = ("update emp_data set password='"+enc_pass+"' where username='"+user+"'");
						ResultSet rs= con.s.executeQuery(query);
//						con.s.executeQuery(query);
						if(rs.next()) {
							JOptionPane.showMessageDialog(btnSubmit, "Password Updated Successfully...");
							textUser.setText("");
							Pass.setText("");
							RePass.setText("");
							
						}
					}else {
						
						JOptionPane.showMessageDialog(null, "mismatched passwords...re-enter");
//						textUser.setText("");
						Pass.setText("");
						RePass.setText("");
					}
					
				}catch(Exception e1) {
					System.out.print(e1);
					JOptionPane.showMessageDialog(btnSubmit, e1);
					textUser.setText("");
					Pass.setText("");
					RePass.setText("");
				}
			}
		});
		btnSubmit.setBounds(403, 296, 98, 42);
		contentPane.add(btnSubmit);
		
		JButton backtomenu = new JButton("back");
		backtomenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminMenu frame = new AdminMenu();
				frame.setVisible(true);
			}
		});
		backtomenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backtomenu.setBackground(SystemColor.activeCaptionBorder);
		backtomenu.setBounds(509, 10, 82, 27);
		contentPane.add(backtomenu);
	}

}
