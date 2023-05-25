package hms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NewReservation extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JTextField textAge;
	private JTextField textID;
	private JTextField textAdd;
//	private JTextField textchckin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewReservation frame = new NewReservation();
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
	public NewReservation() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewReservation.class.getResource("/icons/hotellogo.png")));
		setTitle("New Reservation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100,1100,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPhone_issue = new JLabel("");
		lblPhone_issue.setForeground(new Color(255, 0, 0));
		lblPhone_issue.setBounds(222, 115, 245, 13);
		contentPane.add(lblPhone_issue);
		
		JLabel lblEmail_issue = new JLabel("");
		lblEmail_issue.setForeground(new Color(255, 0, 0));
		lblEmail_issue.setBounds(222, 155, 245, 13);
		contentPane.add(lblEmail_issue);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName.setBounds(153, 67, 63, 13);
		contentPane.add(lblName);
		
		JLabel lblPhn = new JLabel("Phone No :");
		lblPhn.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPhn.setBounds(153, 99, 63, 13);
		contentPane.add(lblPhn);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setBounds(153, 139, 63, 13);
		contentPane.add(lblEmail);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAge.setBounds(153, 174, 63, 13);
		contentPane.add(lblAge);
		
		JLabel lbladults = new JLabel("No. of Adults :");
		lbladults.setHorizontalAlignment(SwingConstants.TRAILING);
		lbladults.setBounds(136, 207, 80, 13);
		contentPane.add(lbladults);
		
		JLabel lblchild = new JLabel("No. of Children :");
		lblchild.setHorizontalAlignment(SwingConstants.TRAILING);
		lblchild.setBounds(92, 242, 124, 13);
		contentPane.add(lblchild);
		
		textName = new JTextField();
		textName.setBounds(222, 67, 245, 19);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN ="[0-9]{10}$";
				Pattern patt=Pattern.compile(PATTERN);
				Matcher match=patt.matcher(textPhone.getText());
				if(!match.matches()) {
					lblPhone_issue.setText("invalid Phone Numbers...");					
				}else {
					lblPhone_issue.setText(null);
				}
			}
		});
		textPhone.setColumns(10);
		textPhone.setBounds(222, 96, 245, 19);
		contentPane.add(textPhone);
		
		textEmail = new JTextField();
		textEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN ="[a-zA-Z0-9]{0,30}[@][a-zA-Z0-9]{0,10}[.][a-zA-Z]{1,5}$";
				Pattern patt=Pattern.compile(PATTERN);
				Matcher match=patt.matcher(textEmail.getText());
				if(!match.matches()) {
					lblEmail_issue.setText("invalid email address...");					
				}else {
					lblEmail_issue.setText(null);
				}
			}
		});
		textEmail.setColumns(10);
		textEmail.setBounds(222, 136, 245, 19);
		contentPane.add(textEmail);
		
		textAge = new JTextField();
		textAge.setColumns(10);
		textAge.setBounds(222, 171, 245, 19);
		contentPane.add(textAge);
		
		JComboBox cb_NoofAdults = new JComboBox();
		cb_NoofAdults.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		cb_NoofAdults.setBounds(222, 204, 84, 19);
		contentPane.add(cb_NoofAdults);
		
		JComboBox cb_NoofChild = new JComboBox();
		cb_NoofChild.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2"}));
		cb_NoofChild.setBounds(222, 239, 84, 19);
		contentPane.add(cb_NoofChild);
		
		JLabel lblID = new JLabel("ID Proof No :");
		lblID.setHorizontalAlignment(SwingConstants.TRAILING);
		lblID.setBounds(136, 297, 80, 13);
		contentPane.add(lblID);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAddress.setBounds(153, 326, 63, 13);
		contentPane.add(lblAddress);
		
		JLabel lblChkin = new JLabel("Check In Date :");
		lblChkin.setHorizontalAlignment(SwingConstants.TRAILING);
		lblChkin.setBounds(114, 352, 102, 13);
		contentPane.add(lblChkin);
		
		textID = new JTextField();
		textID.setColumns(10);
		textID.setBounds(222, 297, 245, 19);
		contentPane.add(textID);
		
		textAdd = new JTextField();
		textAdd.setColumns(10);
		textAdd.setBounds(222, 323, 245, 19);
		contentPane.add(textAdd);
		
//		Date date=new Date();
		
		JLabel lblidtype = new JLabel("ID Proof :");
		lblidtype.setHorizontalAlignment(SwingConstants.TRAILING);
		lblidtype.setBounds(153, 272, 63, 13);
		contentPane.add(lblidtype);
		
		JComboBox cb_id = new JComboBox();
		cb_id.setModel(new DefaultComboBoxModel(new String[] {"Aadhar Card", "Passport", "Driving License"}));
		cb_id.setBounds(222, 268, 245, 19);
		contentPane.add(cb_id);
//		System.out.print(date.getYear()+"-"+date.getMonth()+"-"+date.getDate());
		JComboBox cb_room = new JComboBox();
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","miniproject","miniproject");
			Conn con= new Conn();
//			Statement smt=con.createStatement();
			String query= ("select * from room_data where b_stat='available'");
			ResultSet rs=con.s.executeQuery(query);
			while(rs.next()) {
				String rm_no=rs.getString("rm_no");
				cb_room.addItem(rm_no);
			}
			
//			con.close();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		cb_room.setBounds(222, 375, 84, 19);
		contentPane.add(cb_room);
		
		JLabel lblRoom = new JLabel("Room No. :");
		lblRoom.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRoom.setBounds(136, 378, 80, 13);
		contentPane.add(lblRoom);
		
		JButton backbtn = new JButton("back");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					setVisible(false);
					EmpMenu frame = new EmpMenu();
					frame.setVisible(true);
			}
		});
		backbtn.setBackground(SystemColor.activeCaptionBorder);
		backbtn.setBounds(472, 10, 75, 19);
		contentPane.add(backbtn);
		
		JLabel lblChkin_1 = new JLabel("");
		lblChkin_1.setBounds(222, 352, 102, 13);
		contentPane.add(lblChkin_1);
		//		Date date=new Date();
		//		textchckin = new JTextField();
		//		textchckin.setColumns(10);
		//		textchckin.setBounds(222, 349, 245, 19);
		//		textchckin.setText("yyyy-mm-dd");
		//		contentPane.add(textchckin);
				
				JButton btnSubmit = new JButton("Submit");
				btnSubmit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String name=textName.getText();
						String phone=textPhone.getText();
						String mail=textEmail.getText();
						String age=textAge.getText();
						
						String noAdults=(String) cb_NoofAdults.getSelectedItem();
						String noChild=(String) cb_NoofChild.getSelectedItem();
						
						String idtype=(String) cb_id.getSelectedItem();
						String idPr=textID.getText();
						String add=textAdd.getText();

						String room=(String) cb_room.getSelectedItem();
//				String chckin=textchckin.getText();
						
						try {
							
							String query1="insert into curr_res (rid,cname,phone,email,age ,noadults ,nochild ,idtype ,idno,address ,checkin ,roomno )values(res_seq.nextval,'"+name+"',"+phone+",'"+mail+"',"+age+","+noAdults+","+noChild+",'"+idtype+"','"+idPr+"','"+add+"',sysdate ,"+room+")";
							String query2="update room_data set b_stat='booked' where rm_no="+room;
//					"+chckin+"
							String q3="select checkin from curr_res where roomno="+room;
						
							Conn con =new Conn();
							
							con.s.executeUpdate(query1);
							con.s.executeUpdate(query2);
							
							ResultSet rs=con.s.executeQuery(q3);
							String date;
							if(rs.next()) {
								date=rs.getString("checkin");
								lblChkin_1.setText(date);
							}
							

							JOptionPane.showMessageDialog(btnSubmit, "Reservation Successful...");
							setVisible(false);
							EmpMenu frame = new EmpMenu();
							frame.setVisible(true);
							
						}catch(Exception e1) {
							System.out.println(e1);
						}
						
						
					}
				});
				
						btnSubmit.setBackground(SystemColor.inactiveCaptionBorder);
						btnSubmit.setBounds(271, 424, 85, 28);
						contentPane.add(btnSubmit);
						
						JLabel lblNewLabel = new JLabel("");
						lblNewLabel.setIcon(new ImageIcon(NewReservation.class.getResource("/icons/pexels-mikhail-nilov-7820616 (1).jpg")));
						lblNewLabel.setBounds(561, -18, 489, 571);
						contentPane.add(lblNewLabel);
	}
}
