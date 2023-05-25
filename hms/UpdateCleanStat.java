package hms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.sql.ResultSet;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class UpdateCleanStat extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCleanStat frame = new UpdateCleanStat();
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
	public UpdateCleanStat() {
		setTitle("Cleaning Status");
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateCleanStat.class.getResource("/icons/hotellogo.png")));
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
			String query= ("Select * from room_data");
			ResultSet rs=con.s.executeQuery(query);
			while(rs.next()) {
				String rm_no=rs.getString("rm_no");
				cb_room.addItem(rm_no);
			}
			
//			con.close();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		cb_room.setBounds(211, 196, 279, 21);
		contentPane.add(cb_room);
		
		JLabel lblrno = new JLabel("Room Number :");
		lblrno.setHorizontalAlignment(SwingConstants.TRAILING);
		lblrno.setBounds(88, 200, 116, 13);
		contentPane.add(lblrno);
		
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
		
		JLabel lblCleaningStatus = new JLabel("Cleaning Status :");
		lblCleaningStatus.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCleaningStatus.setBounds(88, 236, 116, 13);
		contentPane.add(lblCleaningStatus);
		
		JComboBox cb_stat = new JComboBox();
		cb_stat.setModel(new DefaultComboBoxModel(new String[] {"clean", "dirty"}));
		cb_stat.setBounds(211, 232, 279, 21);
		contentPane.add(cb_stat);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(SystemColor.inactiveCaptionBorder);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rno=(String) cb_room.getSelectedItem();
				String St=(String) cb_stat.getSelectedItem();
				try {
//					Class.forName("oracle.jdbc.driver.OracleDriver");
//					Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","SMITA");
					Conn con =new Conn();
					String query= ("update room_data set cl_stat='"+St+"' where RM_NO='"+rno+"'");
					con.s.executeQuery(query);
					JOptionPane.showMessageDialog(btnSubmit,"Room Cleaning Status Upadated...");
					cb_room.setSelectedItem("");
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					cb_room.setSelectedItem("");
					
				}
			}
		});
		btnSubmit.setBounds(254, 309, 98, 42);
		contentPane.add(btnSubmit);
	}

}
