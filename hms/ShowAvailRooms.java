package hms;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ShowAvailRooms extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowAvailRooms frame = new ShowAvailRooms();
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
	public ShowAvailRooms() {
		setTitle("Available Rooms");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShowAvailRooms.class.getResource("/icons/hotellogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100,1100,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 106, 997, 387);
		contentPane.add(scrollPane);
		try {
			Conn con=new Conn();
			ResultSet rs =con.s.executeQuery(" select * from room_data where b_stat='available'");

			table = new JTable();
			scrollPane.setViewportView(table);
			table.setBackground(SystemColor.menu);
			table.setRowSelectionAllowed(false);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
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
			backtomenu.setBounds(968, 10, 82, 27);
			contentPane.add(backtomenu);
		}catch(Exception e) {
		System.out.println(e);
		JOptionPane.showMessageDialog(null, e);
		}
	}
}
