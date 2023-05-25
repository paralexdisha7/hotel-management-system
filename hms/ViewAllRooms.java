package hms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class ViewAllRooms extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAllRooms frame = new ViewAllRooms();
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
	public ViewAllRooms() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewAllRooms.class.getResource("/icons/hotellogo.png")));
		setTitle("All Rooms");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100,1100,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {
			Conn con=new Conn();
			ResultSet rs =con.s.executeQuery("select * from room_data");
			
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
			backtomenu.setBounds(994, 10, 82, 27);
			contentPane.add(backtomenu);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(76, 120, 970, 358);
			contentPane.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			table.setFillsViewportHeight(true);
			table.setBackground(SystemColor.menu);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);
		}
	

	}
}
