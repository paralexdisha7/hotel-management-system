package hms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class AddNewEmp extends JFrame {

	/**
	 * 
	 */
	
	private JPanel contentPane;
	private JTextField EmpName;
	private JTextField UserName;
	private JTextField RePass;
	private JButton btnClear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewEmp frame = new AddNewEmp();
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
	public AddNewEmp() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddNewEmp.class.getResource("/icons/hotellogo.png")));
		setTitle("Add New Employee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100,1100,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Enter Name :");
		lblName.setBounds(97, 166, 145, 13);
		contentPane.add(lblName);
		
		JLabel lblUser = new JLabel("Enter Username :");
		lblUser.setBounds(97, 211, 145, 13);
		contentPane.add(lblUser);
		
		JLabel lblPass = new JLabel("Enter Password :");
		lblPass.setBounds(97, 255, 145, 13);
		contentPane.add(lblPass);
		
		JLabel lblRePass = new JLabel("Confirm Password : ");
		lblRePass.setBounds(97, 303, 145, 13);
		contentPane.add(lblRePass);
		
		EmpName = new JTextField();
		EmpName.setBounds(240, 159, 266, 27);
		contentPane.add(EmpName);
		EmpName.setColumns(20);
		
		UserName = new JTextField();
		UserName.setColumns(10);
		UserName.setBounds(240, 204, 266, 27);
		contentPane.add(UserName);
		
		JPasswordField Pass = new JPasswordField();
		Pass.setColumns(10);
		Pass.setBounds(240, 248, 266, 27);
		contentPane.add(Pass);
		
		RePass = new JPasswordField();
		RePass.setColumns(10);
		RePass.setBounds(240, 296, 266, 27);
		contentPane.add(RePass);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(SystemColor.inactiveCaptionBorder);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","miniproject","miniproject");
					String query=("insert into emp_data values(emp_seq.nextval,?,?,?)");
					PreparedStatement ps =con.prepareStatement(query);
					ps.setString(1, EmpName.getText());
					ps.setString(2, UserName.getText());
					@SuppressWarnings("deprecation")
					String pass1=Pass.getText();
					String pass2=RePass.getText();
					if(pass1.equals(pass2)){
						int enc_pass=pass1.hashCode();
						ps.setLong(3, enc_pass);
//						ps.setString(3, pass2);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Data Added Successfully...");
						ps.close();
						con.close();
						EmpName.setText("");
						UserName.setText("");
						Pass.setText("");
						RePass.setText("");	
					}
					else {
						JOptionPane.showMessageDialog(null, "Mismatched Passwords ..Re-enter");
						Pass.setText("");
						RePass.setText("");	
						
					}					
				}catch(Exception e1) {
					System.out.print(e1);
					JOptionPane.showMessageDialog(btnSubmit, e1);
					EmpName.setText("");
					UserName.setText("");
					Pass.setText("");
					RePass.setText("");
				}
			
			}
		});
		btnSubmit.setBounds(408, 368, 98, 42);
		contentPane.add(btnSubmit);
		
		btnClear = new JButton("Clear");
		btnClear.setBackground(SystemColor.inactiveCaptionBorder);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpName.setText("");
				UserName.setText("");
				Pass.setText("");
				RePass.setText("");
			}
		});
		btnClear.setBounds(240, 368, 98, 42);
		contentPane.add(btnClear);
		
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
		backtomenu.setBounds(421, 10, 82, 27);
		contentPane.add(backtomenu);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(AddNewEmp.class.getResource("/icons/employee.png")));
		lblNewLabel.setBounds(584, 65, 473, 443);
		contentPane.add(lblNewLabel);
	}
}
