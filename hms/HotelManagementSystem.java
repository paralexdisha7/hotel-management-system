package hms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HotelManagementSystem extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HotelManagementSystem frame = new HotelManagementSystem();
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
	public HotelManagementSystem() {
		setBackground(SystemColor.menu);
		setIconImage(Toolkit.getDefaultToolkit().getImage(HotelManagementSystem.class.getResource("/icons/hotellogo.png")));
		setTitle("Hotel Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100,1100,600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnEmp = new JButton("Employee");
		btnEmp.setBackground(Color.WHITE);
		btnEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				EmpLogin frame = new EmpLogin();
				frame.setVisible(true);
			}
		});
		btnEmp.setBounds(367, 166, 408, 37);
		btnEmp.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.setLayout(null);
		
		JLabel heading = new JLabel("Hotel Management System");
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setBackground(SystemColor.menu);
		heading.setForeground(Color.WHITE);
		heading.setFont(new Font("Baskerville Old Face", Font.BOLD, 60));
		heading.setBounds(207, 49, 730, 71);
		contentPane.add(heading);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setBackground(Color.WHITE);
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminLogin frame = new AdminLogin();
				frame.setVisible(true);
			}
		});
		btnAdmin.setBounds(367, 226, 408, 37);
		btnAdmin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(btnAdmin);
		contentPane.add(btnEmp);
		
		JLabel bg_image = new JLabel("");
		bg_image.setVerticalAlignment(SwingConstants.TOP);
		bg_image.setIcon(new ImageIcon(HotelManagementSystem.class.getResource("/icons/pexels-naim-benjelloun-2029698.jpg")));
		
		bg_image.setBounds(0, 0, 1086, 563);
		contentPane.add(bg_image);
	}
}
