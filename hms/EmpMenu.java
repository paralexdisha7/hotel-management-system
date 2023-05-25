package hms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class EmpMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpMenu frame = new EmpMenu();
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
	public EmpMenu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EmpMenu.class.getResource("/icons/hotellogo.png")));
		setTitle("Employee Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100,1100,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnnewRes = new JButton("New Reservation");
		btnnewRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				NewReservation frame = new NewReservation();
				frame.setVisible(true);
			}
		});
		btnnewRes.setBackground(SystemColor.inactiveCaption);
		btnnewRes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnnewRes.setBounds(53, 106, 482, 27);
		contentPane.add(btnnewRes);
		
		JButton btnSearchRes = new JButton("Search Reservation");
		btnSearchRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SearchCust frame = new SearchCust();
				frame.setVisible(true);
			}
		});
		btnSearchRes.setBackground(SystemColor.inactiveCaption);
		btnSearchRes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearchRes.setBounds(53, 143, 482, 27);
		contentPane.add(btnSearchRes);
		
		JButton btnShowRes = new JButton("Show current Reservations");
		btnShowRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ViewActiveRes frame = new ViewActiveRes();
				frame.setVisible(true);
			}
		});
		btnShowRes.setBackground(SystemColor.inactiveCaption);
		btnShowRes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnShowRes.setBounds(53, 180, 482, 27);
		contentPane.add(btnShowRes);
		
		JButton btnUpdateChkIn = new JButton("Update Check-In Date");
		btnUpdateChkIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				UpdateCheckin frame = new UpdateCheckin();
				frame.setVisible(true);
			}
		});
		btnUpdateChkIn.setBackground(SystemColor.inactiveCaption);
		btnUpdateChkIn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdateChkIn.setBounds(53, 217, 482, 27);
		contentPane.add(btnUpdateChkIn);
		
		JButton btnShowRooms = new JButton("View Available Rooms");
		btnShowRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ShowAvailRooms frame = new ShowAvailRooms();
				frame.setVisible(true);
			}
		});
		btnShowRooms.setBackground(SystemColor.inactiveCaption);
		btnShowRooms.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnShowRooms.setBounds(53, 254, 482, 27);
		contentPane.add(btnShowRooms);
		
		JButton btnChkOut = new JButton("Check-Out / Get Receipt");
		btnChkOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				GenBill frame = new GenBill();
				frame.setVisible(true);
			}
		});
		btnChkOut.setBackground(SystemColor.inactiveCaption);
		btnChkOut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChkOut.setBounds(53, 291, 482, 27);
		contentPane.add(btnChkOut);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(new Color(250, 240, 230));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				HotelManagementSystem frame = new HotelManagementSystem();
				frame.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogout.setBounds(123, 477, 333, 27);
		contentPane.add(btnLogout);
		
		JButton btnCleanStat = new JButton("Update Cleaning Status");
		btnCleanStat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				UpdateCleanStat frame = new UpdateCleanStat();
				frame.setVisible(true);
			}
		});
		btnCleanStat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCleanStat.setBackground(SystemColor.inactiveCaption);
		btnCleanStat.setBounds(53, 328, 482, 27);
		contentPane.add(btnCleanStat);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EmpMenu.class.getResource("/icons/pexels-amar-saleem-70441 (1).jpg")));
		lblNewLabel.setBounds(574, 10, 500, 543);
		contentPane.add(lblNewLabel);
	}

}
