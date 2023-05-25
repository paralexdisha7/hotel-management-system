package hms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class UpdateRoomTariff extends JFrame {

	private JPanel contentPane;
	private JTextField textprice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateRoomTariff frame = new UpdateRoomTariff();
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
	public UpdateRoomTariff() {
		setTitle("Update Room Tarif ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateRoomTariff.class.getResource("/icons/hotellogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 653, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblrno = new JLabel("Room Number :");
		lblrno.setHorizontalAlignment(SwingConstants.TRAILING);
		lblrno.setBounds(96, 115, 116, 13);
		contentPane.add(lblrno);
		
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
		cb_room.setBounds(219, 111, 279, 21);
		contentPane.add(cb_room);
		
		textprice = new JTextField();
		textprice.setText("2500");
		textprice.setBounds(219, 161, 279, 21);
		contentPane.add(textprice);
		textprice.setColumns(10);
		
		JLabel lblprice = new JLabel("Price : ");
		lblprice.setHorizontalAlignment(SwingConstants.TRAILING);
		lblprice.setBounds(96, 165, 116, 13);
		contentPane.add(lblprice);
		
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
		backtomenu.setBounds(547, 10, 82, 27);
		contentPane.add(backtomenu);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rno=(String) cb_room.getSelectedItem();
				String price=textprice.getText();
			
				try {
//					Class.forName("oracle.jdbc.driver.OracleDriver");
//					Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","SMITA");
					Conn con =new Conn();
					String query= ("update room_data set price="+price+" where RM_NO='"+rno+"'");
					con.s.executeQuery(query);
					JOptionPane.showMessageDialog(btnSubmit,"Room Price Upadated...");
					cb_room.setSelectedItem("");
					textprice.setText("2500");
					
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					cb_room.setSelectedItem("");
					textprice.setText("2500");
					
				}
			}
		});
		btnSubmit.setBounds(296, 291, 98, 42);
		contentPane.add(btnSubmit);
	}

}
