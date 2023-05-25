package hms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class AddNewRoom extends JFrame {

	private JPanel contentPane;
	private JTextField textRno;
	private JTextField textPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewRoom frame = new AddNewRoom();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AddNewRoom() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddNewRoom.class.getResource("/icons/hotellogo.png")));
		setTitle("Add New Room");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100,1100,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton backtomenu = new JButton("back");
		backtomenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminMenu frame = new AdminMenu();
				frame.setVisible(true);
			}
		});
		
		JComboBox cb_cat = new JComboBox();
		cb_cat.setModel(new DefaultComboBoxModel(new String[] {"","Single Bed", "Double Bed"}));
		cb_cat.setBackground(SystemColor.text);
		cb_cat.setBounds(299, 256, 165, 19);
		contentPane.add(cb_cat);
		backtomenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backtomenu.setBackground(SystemColor.activeCaptionBorder);
		backtomenu.setBounds(382, 10, 82, 27);
		contentPane.add(backtomenu);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(SystemColor.inactiveCaptionBorder);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cb_cat.setSelectedItem("");
				textRno.setText("");
				textPrice.setText("");
			}
		});
		btnClear.setBounds(233, 364, 98, 42);
		contentPane.add(btnClear);
		
		JLabel lblRoomNo = new JLabel("Room Number :");
		lblRoomNo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRoomNo.setBounds(142, 214, 101, 13);
		contentPane.add(lblRoomNo);
		
		JLabel lblCategory = new JLabel("Category :");
		lblCategory.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCategory.setBounds(163, 256, 80, 13);
		contentPane.add(lblCategory);
		
		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPrice.setBounds(206, 300, 37, 13);
		contentPane.add(lblPrice);
		
		textRno = new JTextField();
		textRno.setBounds(299, 214, 165, 19);
		contentPane.add(textRno);
		textRno.setColumns(10);
		
		textPrice = new JTextField();
		textPrice.setText("2500");
		textPrice.setColumns(10);
		textPrice.setBounds(299, 300, 165, 19);
		contentPane.add(textPrice);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(SystemColor.inactiveCaptionBorder);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","miniproject","miniproject");
					String query=("insert into ROOM_DATA (RM_NO, R_CATEGORY, PRICE, B_STAT ,CL_STAT) values (?,?,?,'available','clean')");
					PreparedStatement ps =con.prepareStatement(query);
//					ps.setString(1, textRno.getText());
//					ps.setString(2, UserName.getText());
//					String pass1=Pass.getText();
//					String pass2=RePass.getText();
					ps.setString(1, textRno.getText());
					ps.setString(2, (String) cb_cat.getSelectedItem());
					ps.setString(3, textPrice.getText());	
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Added Successfully...");
					ps.close();
					con.close();
					textRno.setText("");
					textPrice.setText("2500");
					cb_cat.setSelectedItem("");
				}catch(Exception e1) {
					System.out.print(e1);
					JOptionPane.showMessageDialog(btnSubmit, e1);
					
				}
				
			}
		});
		btnSubmit.setBounds(366, 364, 98, 42);
		contentPane.add(btnSubmit);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AddNewRoom.class.getResource("/icons/hotel.png")));
		lblNewLabel.setBounds(530, 10, 528, 531);
		contentPane.add(lblNewLabel);
		
		
	}
}
