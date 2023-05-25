package hms;

import java.awt.EventQueue;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class SearchCust extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchCust frame = new SearchCust();
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
	public SearchCust() {
		setTitle("Search Current Reservations");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SearchCust.class.getResource("/icons/hotellogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100,600,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cb_room = new JComboBox();
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","SMITA");
//			Statement smt=con.createStatement();
			Conn con=new Conn();
			String query= ("Select * from room_data where b_stat='booked'");
			ResultSet rs=con.s.executeQuery(query);
			while(rs.next()) {
				String rm_no=rs.getString("rm_no");
				cb_room.addItem(rm_no);
			}
			
//			con.close();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		cb_room.setBounds(217, 110, 283, 21);
		contentPane.add(cb_room);
		
		JLabel lblRoomNo = new JLabel("Room No :");
		lblRoomNo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRoomNo.setBounds(91, 112, 105, 17);
		contentPane.add(lblRoomNo);
		
		JLabel lblcust = new JLabel("Customer Name :");
		lblcust.setHorizontalAlignment(SwingConstants.TRAILING);
		lblcust.setBounds(114, 248, 105, 17);
		contentPane.add(lblcust);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number :");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPhoneNumber.setBounds(114, 275, 105, 17);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setBounds(114, 302, 105, 17);
		contentPane.add(lblEmail);
		
		JLabel lblCheckinDate = new JLabel("Check-in Date :");
		lblCheckinDate.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCheckinDate.setBounds(114, 329, 105, 17);
		contentPane.add(lblCheckinDate);
		
		JLabel lblRoomStatus = new JLabel("Room Cleaning Status  :");
		lblRoomStatus.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRoomStatus.setBounds(84, 356, 135, 17);
		contentPane.add(lblRoomStatus);
		
		JLabel textCname = new JLabel(" ");
		textCname.setBounds(240, 250, 219, 13);
		contentPane.add(textCname);
		
		JLabel textPhone = new JLabel("");
		textPhone.setBounds(240, 277, 219, 13);
		contentPane.add(textPhone);
		
		JLabel textMail = new JLabel("");
		textMail.setBounds(240, 304, 219, 13);
		contentPane.add(textMail);
		
		JLabel TextCheckin = new JLabel("");
		TextCheckin.setBounds(240, 331, 219, 13);
		contentPane.add(TextCheckin);
		
		JLabel textClstat = new JLabel("");
		textClstat.setBounds(240, 358, 219, 13);
		contentPane.add(textClstat);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rno=(String) cb_room.getSelectedItem();
				try {
					Conn con=new Conn();
					String query=("select * from search_cust where roomno="+rno);
					ResultSet rs=con.s.executeQuery(query);
					if(rs.next()) {
						textCname.setText(rs.getString("cname"));
						textPhone.setText(rs.getString("phone"));
						textMail.setText(rs.getString("email"));
						TextCheckin.setText(rs.getString("checkin"));
						textClstat.setText(rs.getString("cl_stat"));
						
						}
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnSearch.setBackground(SystemColor.inactiveCaptionBorder);
		btnSearch.setBounds(274, 141, 85, 29);
		contentPane.add(btnSearch);
		
		JButton backtomenu = new JButton("back");
		backtomenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				EmpMenu frame = new EmpMenu();
				frame.setVisible(true);
			}
		});
		backtomenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backtomenu.setBackground(SystemColor.activeCaptionBorder);
		backtomenu.setBounds(494, 10, 82, 27);
		contentPane.add(backtomenu);
	}
}
