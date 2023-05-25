package hms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AdminMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenu frame = new AdminMenu();
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
	public AdminMenu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminMenu.class.getResource("/icons/hotellogo.png")));
		setTitle("Admin Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100,1100,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVwEmp = new JButton("View Employee Data");
		btnVwEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ViewEmpData frame = new ViewEmpData();
				frame.setVisible(true);
			}
		});
		btnVwEmp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVwEmp.setBackground(SystemColor.inactiveCaption);
		btnVwEmp.setBounds(58, 45, 513, 27);
		contentPane.add(btnVwEmp);
		
		JButton btnAddEmp = new JButton("Add New Employee");
		btnAddEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddNewEmp frame = new AddNewEmp();
				frame.setVisible(true);
			}
		});
		btnAddEmp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddEmp.setBackground(SystemColor.inactiveCaption);
		btnAddEmp.setBounds(58, 82, 513, 27);
		contentPane.add(btnAddEmp);
		
		JButton btnUpdateEmpPass = new JButton("Update Employee Password");
		btnUpdateEmpPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				UpdateEmpPass frame = new UpdateEmpPass();
				frame.setVisible(true);
			}
		});
		btnUpdateEmpPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdateEmpPass.setBackground(SystemColor.inactiveCaption);
		btnUpdateEmpPass.setBounds(58, 119, 513, 27);
		contentPane.add(btnUpdateEmpPass);
		
		JButton btnAddNewRoom = new JButton("Add New Room");
		btnAddNewRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddNewRoom frame = new AddNewRoom();
				frame.setVisible(true);
			}
		});
		btnAddNewRoom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddNewRoom.setBackground(SystemColor.inactiveCaption);
		btnAddNewRoom.setBounds(58, 156, 513, 27);
		contentPane.add(btnAddNewRoom);
		
		JButton btnUpdateRoomTariff = new JButton("Update Room tarif");
		btnUpdateRoomTariff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				UpdateRoomTariff frame = new UpdateRoomTariff();
				frame.setVisible(true);
			}
		});
		btnUpdateRoomTariff.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdateRoomTariff.setBackground(SystemColor.inactiveCaption);
		btnUpdateRoomTariff.setBounds(58, 229, 513, 27);
		contentPane.add(btnUpdateRoomTariff);
		
		JButton btnShowPreviousReservations = new JButton("Show Previous Reservations");
		btnShowPreviousReservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ShowHistory frame = new ShowHistory();
				frame.setVisible(true);
			}
		});
		btnShowPreviousReservations.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnShowPreviousReservations.setBackground(SystemColor.inactiveCaption);
		btnShowPreviousReservations.setBounds(58, 266, 513, 27);
		contentPane.add(btnShowPreviousReservations);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				HotelManagementSystem frame = new HotelManagementSystem();
				frame.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogout.setBackground(SystemColor.info);
		btnLogout.setBounds(163, 477, 333, 27);
		contentPane.add(btnLogout);
		
		JButton btnShowRooms = new JButton("Show all Rooms");
		btnShowRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ViewAllRooms frame = new ViewAllRooms();
				frame.setVisible(true);
			}
		});
		btnShowRooms.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnShowRooms.setBackground(SystemColor.inactiveCaption);
		btnShowRooms.setBounds(58, 192, 513, 27);
		contentPane.add(btnShowRooms);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AdminMenu.class.getResource("/icons/pexels-jan-kopřiva-3989896 (1).jpg")));
		lblNewLabel.setBounds(601, 10, 475, 543);
		contentPane.add(lblNewLabel);
		
		JButton btnAddNewAdmin = new JButton("Add New Admin");
		btnAddNewAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddAdmin frame = new AddAdmin();
				frame.setVisible(true);
			}
		});
		btnAddNewAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddNewAdmin.setBackground(SystemColor.inactiveCaption);
		btnAddNewAdmin.setBounds(58, 303, 513, 27);
		contentPane.add(btnAddNewAdmin);
	}
}
