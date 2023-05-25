package hms;

import java.awt.EventQueue;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import net.proteanit.sql.*;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class ViewEmpData extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton backtomenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEmpData frame = new ViewEmpData();
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
	public ViewEmpData() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewEmpData.class.getResource("/icons/hotellogo.png")));
		setTitle("Employee Data");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100,1100,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {
			Conn con=new Conn();
			ResultSet rs =con.s.executeQuery("select eid,ename,username from emp_data");
			
			backtomenu = new JButton("back");
			backtomenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					AdminMenu frame = new AdminMenu();
					frame.setVisible(true);
				}
			});
			backtomenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
			backtomenu.setBackground(SystemColor.activeCaptionBorder);
			backtomenu.setBounds(979, 10, 82, 27);
			contentPane.add(backtomenu);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(85, 108, 976, 384);
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
