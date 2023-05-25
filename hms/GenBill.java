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
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class GenBill extends JFrame {

	private JPanel contentPane;
	private JTextField textchkout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenBill frame = new GenBill();
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
	public GenBill() {
		setTitle("Check-out/Payment");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GenBill.class.getResource("/icons/hotellogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100,1100,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cb_room = new JComboBox();
		try {
			
			Conn con=new Conn();
			String query= ("Select * from room_data where b_stat='booked'");
			ResultSet rs=con.s.executeQuery(query);
			
			while(rs.next()) {
				String rm_no=rs.getString("rm_no");
				cb_room.addItem(rm_no);
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		textchkout = new JTextField();
		textchkout.setText("yyyy-mm-dd");
		textchkout.setBounds(182, 107, 283, 19);
		contentPane.add(textchkout);
		textchkout.setColumns(10);
		
		JComboBox cb_pay = new JComboBox();
		cb_pay.setModel(new DefaultComboBoxModel(new String[] {"Online", "Offline"}));
		cb_pay.setBounds(182, 132, 283, 21);
		contentPane.add(cb_pay);
		cb_room.setBounds(182, 76, 283, 21);
		contentPane.add(cb_room);
		
		JLabel lblRoomNo = new JLabel("Room No :");
		lblRoomNo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRoomNo.setBounds(56, 78, 105, 17);
		contentPane.add(lblRoomNo);
		
		JLabel lblCheckoutDate = new JLabel("Check-out Date :");
		lblCheckoutDate.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCheckoutDate.setBounds(21, 105, 140, 17);
		contentPane.add(lblCheckoutDate);
		
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
		backtomenu.setBounds(994, 10, 82, 27);
		contentPane.add(backtomenu);
		
		JLabel lblPaymentMethod = new JLabel("Payment Method :");
		lblPaymentMethod.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPaymentMethod.setBounds(21, 134, 140, 17);
		contentPane.add(lblPaymentMethod);
		
		JLabel lblNewLabel = new JLabel("Customer Name :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(604, 146, 121, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblPhoneNo = new JLabel("Phone No :");
		lblPhoneNo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPhoneNo.setBounds(604, 172, 121, 13);
		contentPane.add(lblPhoneNo);
		
		JLabel lblCheckinDate = new JLabel("Check-in Date :");
		lblCheckinDate.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCheckinDate.setBounds(604, 198, 121, 13);
		contentPane.add(lblCheckinDate);
		
		JLabel lblCheckOdate = new JLabel("Check-Out Date");
		lblCheckOdate.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCheckOdate.setBounds(604, 221, 121, 13);
		contentPane.add(lblCheckOdate);
		
		JLabel lblRoom_No = new JLabel("Room No :");
		lblRoom_No.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRoom_No.setBounds(604, 244, 121, 13);
		contentPane.add(lblRoom_No);
		
		JLabel lblNewLabel_4_1 = new JLabel(" No of Days :");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4_1.setBounds(604, 267, 121, 13);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Payment Method :");
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4_2.setBounds(604, 290, 121, 13);
		contentPane.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("Total Amount :");
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4_3.setBounds(604, 313, 121, 13);
		contentPane.add(lblNewLabel_4_3);
		
		JLabel textCust = new JLabel("");
		textCust.setBounds(775, 146, 121, 13);
		contentPane.add(textCust);
		
		JLabel textphn = new JLabel("");
		textphn.setBounds(775, 172, 121, 13);
		contentPane.add(textphn);
		
		JLabel text_ci = new JLabel("");
		text_ci.setBounds(775, 198, 121, 13);
		contentPane.add(text_ci);
		
		JLabel text_co = new JLabel("");
		text_co.setBounds(775, 221, 121, 13);
		contentPane.add(text_co);
		
		JLabel textRno = new JLabel("");
		textRno.setBounds(775, 244, 121, 13);
		contentPane.add(textRno);
		
		JLabel textdays = new JLabel("");
		textdays.setBounds(775, 267, 121, 13);
		contentPane.add(textdays);
		
		JLabel textpayM = new JLabel("");
		textpayM.setBounds(775, 290, 121, 13);
		contentPane.add(textpayM);
		
		JLabel textTot = new JLabel("");
		textTot.setBounds(775, 313, 121, 13);
		contentPane.add(textTot);
		
		JLabel lblNewLabel_4_3_1 = new JLabel("Reservation ID :");
		lblNewLabel_4_3_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4_3_1.setBounds(604, 336, 121, 13);
		contentPane.add(lblNewLabel_4_3_1);
		
		JLabel textRes = new JLabel("");
		textRes.setBounds(775, 336, 121, 13);
		contentPane.add(textRes);
		
		JLabel lbl_id = new JLabel("");
		lbl_id.setForeground(SystemColor.menu);
		lbl_id.setBounds(918, 76, 45, 13);
		contentPane.add(lbl_id);
		
		JLabel lblNewLabel_4_3_1_1 = new JLabel("Receipt ID :");
		lblNewLabel_4_3_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4_3_1_1.setBounds(604, 359, 121, 13);
		contentPane.add(lblNewLabel_4_3_1_1);
		
		JLabel textReceipt = new JLabel("");
		textReceipt.setBounds(775, 359, 121, 13);
		contentPane.add(textReceipt);
		
		JButton btnChkOut = new JButton("Check-Out");
		btnChkOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date=textchkout.getText();
				String rno=(String) cb_room.getSelectedItem();
				
				try {
					Conn con=new Conn();
					String query2=("update curr_res set checkout=date '"+date+"' where roomno="+rno);
					con.s.executeQuery(query2);
					String query=("select * from curr_res where roomno="+rno);
					ResultSet rs=con.s.executeQuery(query);
					if(rs.next()) {
						
						textCust.setText(rs.getString("cname"));	
						textphn.setText(rs.getString("phone"));	
						text_ci.setText(rs.getString("checkin"));	
						text_co.setText(rs.getString("checkout"));	
						textRno.setText(rs.getString("roomno"));			
						textpayM.setText((String) cb_pay.getSelectedItem());	
						textRes.setText(rs.getString("rid"));	
						lbl_id.setText(rs.getString("idno"));	
						
					}
					
					
					String query3=(" select * from btotal where roomno="+rno);
					ResultSet rs3=con.s.executeQuery(query3);
					if(rs3.next()) {
						textdays.setText(rs3.getString("noofdays"));
						textTot.setText(rs3.getString("btot"));
					}
					//,"+rn+")
					String query4=("insert into bill_data (b_id, btotal, paymethod, paydate,res_id) values(bill_seq.nextval,"+textTot.getText()+",'"+textpayM.getText()+"', sysdate,"+textRes.getText()+" )");
					con.s.executeQuery(query4);
					/////set room status available
					String query5=("update room_data set b_stat='available' where rm_no="+rno);
					con.s.executeQuery(query5);
					////
					String q7=("select b_id from bill_data where res_id="+ textRes.getText());
					ResultSet rs7=con.s.executeQuery(q7);
					if(rs7.next()) {
						textReceipt.setText(rs7.getString("b_id"));
					}
					
					/////add to HISTORY table???
					
					String sql1="insert into history(h_id, name, phone, indate,outdate,id_proof,billno) values ("+textRes.getText()+",'"+textCust.getText()+"',"+textphn.getText()+",'"+text_ci.getText()+"','"+text_co.getText()+"','"+lbl_id.getText()+"',"+textReceipt.getText()+")";
					con.s.execute(sql1);
					
					/////delete from curr_res table 
					String q8="delete from curr_res where roomno="+rno;
					con.s.executeQuery(q8);
								
					
					
					
					JOptionPane.showMessageDialog(btnChkOut,"Checked-Out Succesfully...");
					
					EmpMenu frame = new EmpMenu();
					frame.setVisible(true);
				
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnChkOut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChkOut.setBackground(SystemColor.activeCaptionBorder);
		btnChkOut.setBounds(209, 376, 152, 27);
		contentPane.add(btnChkOut);
		
		JButton btnGetReceipt = new JButton("Get Details");
		btnGetReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date=textchkout.getText();
				String rno=(String) cb_room.getSelectedItem();
				try {
					Conn con=new Conn();
					String query2=("update curr_res set checkout=date '"+date+"' where roomno="+rno);
					con.s.executeQuery(query2);
					String query=("select * from curr_res where roomno="+rno);
					ResultSet rs=con.s.executeQuery(query);
					if(rs.next()) {
						
						textCust.setText(rs.getString("cname"));	
						textphn.setText(rs.getString("phone"));	
						text_ci.setText(rs.getString("checkin"));	
						text_co.setText(rs.getString("checkout"));	
						textRno.setText(rs.getString("roomno"));			
						textpayM.setText((String) cb_pay.getSelectedItem());	
						textRes.setText(rs.getString("rid"));	
						lbl_id.setText(rs.getString("idno"));	
						
					}
					
					
					String query3=(" select * from btotal where roomno="+rno);
					ResultSet rs3=con.s.executeQuery(query3);
					if(rs3.next()) {
						textdays.setText(rs3.getString("noofdays"));
						textTot.setText(rs3.getString("btot"));
					}
					
					String q7=("select b_id from bill_data where res_id="+ textRes.getText());
					ResultSet rs7=con.s.executeQuery(q7);
					if(rs7.next()) {
						textReceipt.setText(rs7.getString("b_id"));
					}				
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnGetReceipt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGetReceipt.setBackground(SystemColor.activeCaptionBorder);
		btnGetReceipt.setBounds(209, 319, 152, 27);
		contentPane.add(btnGetReceipt);
	}
}
