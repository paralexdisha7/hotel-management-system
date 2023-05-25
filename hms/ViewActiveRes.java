package hms;

import java.awt.EventQueue;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ViewActiveRes extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewActiveRes frame = new ViewActiveRes();
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
	public ViewActiveRes() {
		setTitle("Current Reservations");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewActiveRes.class.getResource("/icons/hotellogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100,1100,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		try {
			Conn con=new Conn();
			ResultSet rs =con.s.executeQuery(" select * from active_res");
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(51, 80, 983, 447);
			contentPane.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			table.setBackground(SystemColor.menu);
			table.setShowVerticalLines(false);
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
			backtomenu.setBounds(994, 10, 82, 27);
			contentPane.add(backtomenu);
			
			
		}catch(Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
