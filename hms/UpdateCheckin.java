package hms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.sql.ResultSet;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class UpdateCheckin extends JFrame {

	private JPanel contentPane;
	private JTextField txtYyyymmdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCheckin frame = new UpdateCheckin();
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
	public UpdateCheckin() {
		setTitle("Update Check in date");
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateCheckin.class.getResource("/icons/hotellogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100,600,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cb_room = new JComboBox();
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","SMITA");
			//Statement smt=con.createStatement();
			Conn con=new Conn();
			String query= ("Select * from room_data where b_stat='booked'");
			ResultSet rs=con.s.executeQuery(query);
			//ResultSet rs=smt.executeQuery(query);
			while(rs.next()) {
				String rm_no=rs.getString("rm_no");
				cb_room.addItem(rm_no);
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		cb_room.setBounds(208, 88, 283, 21);
		contentPane.add(cb_room);
		
		JLabel lblRoomNo = new JLabel("Room No :");
		lblRoomNo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRoomNo.setBounds(82, 90, 105, 17);
		contentPane.add(lblRoomNo);
		
		JLabel lblDate = new JLabel("New Date :");
		lblDate.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDate.setBounds(47, 246, 140, 17);
		contentPane.add(lblDate);
		
		txtYyyymmdd = new JTextField();
		txtYyyymmdd.setText("yyyy-mm-dd");
		txtYyyymmdd.setBounds(208, 245, 283, 21);
		contentPane.add(txtYyyymmdd);
		txtYyyymmdd.setColumns(10);
		
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
		
		JLabel lblOldDateyyyymmdd = new JLabel("Old Date  :");
		lblOldDateyyyymmdd.setHorizontalAlignment(SwingConstants.TRAILING);
		lblOldDateyyyymmdd.setBounds(47, 206, 140, 17);
		contentPane.add(lblOldDateyyyymmdd);
		
		JLabel lblOldDate = new JLabel("");
		String rno=(String) cb_room.getSelectedItem();
		
		lblOldDate.setBounds(208, 206, 283, 17);
		contentPane.add(lblOldDate);
		
		JLabel lbl_action = new JLabel("");
		lbl_action.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_action.setBounds(188, 196, 251, 17);
		contentPane.add(lbl_action);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date=txtYyyymmdd.getText();
				String rno=(String) cb_room.getSelectedItem();
				try {
					Conn con=new Conn();
					String query=("select * from curr_res where roomno="+rno);
					ResultSet rs=con.s.executeQuery(query);
					if(rs.next()) {
						lblOldDate.setText(rs.getString("checkin"));	
						}
//					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				try {
					Conn con=new Conn();
					String query=("select * from curr_res where roomno="+rno);
					ResultSet rs=con.s.executeQuery(query);
					String q2=("UPDATE curr_res set checkin= date '"+date+"' where roomno="+rno);
					if(rs.next()) {
						con.s.executeQuery(q2);
						}
					
					
					JOptionPane.showMessageDialog(btnUpdate,"Check in date Upadated...");
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBackground(SystemColor.activeCaptionBorder);
		btnUpdate.setBounds(282, 343, 82, 27);
		contentPane.add(btnUpdate);
	}
}
