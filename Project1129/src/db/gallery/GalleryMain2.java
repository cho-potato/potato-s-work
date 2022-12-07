package db.gallery;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class GalleryMain2 extends JFrame implements ActionListener {
//	서쪽 영역
	JPanel p_west;
	JTextField t_title;
	JTextField t_writer;
	JTextField t_content;
	JPanel p_preview;
	JButton bt_open;
	JButton bt_regist;

//	센터 영역
	JTable table;
	JScrollPane scroll;

//	동쪽 영역
	JPanel p_east;
	JTextField t_title2;
	JTextField t_writer2;
	JTextField t_content2;
	JPanel p_preview2;
	JButton bt_edit;
	JButton bt_del;

	Image image;

	Connection conn;
	
	public GalleryMain2() {
		Dimension d1 = new Dimension(150, 500);
		Dimension d2 = new Dimension(145, 130);

		p_west = new JPanel();
		t_title = new JTextField(12);
		t_writer = new JTextField(12);
		t_content = new JTextField();
		p_preview = new JPanel() {
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setColor(Color.BLACK);
				g2.fillRect(0, 0, 145, 130);

				g2.setColor(Color.WHITE);
				if (image != null) {
					g2.drawImage(image, 0, 0, 145, 130, GalleryMain2.this);
				} else {
					g2.drawString("Choose your File", 25, 70);
				}
			}
		};
		bt_open = new JButton("열기");
		bt_regist = new JButton("등록");

		p_west.add(t_title);
		p_west.add(t_writer);
		p_west.add(t_content);
		p_west.add(p_preview);
		p_west.add(bt_open);
		p_west.add(bt_regist);

		p_west.setPreferredSize(d1);
		t_content.setPreferredSize(d2);
		p_preview.setPreferredSize(d2);
		p_preview.setBackground(Color.BLACK);

		add(p_west, BorderLayout.WEST);
//		- - - - - - - - - - - - - - - - - - - - - - -
		table = new JTable();
		scroll = new JScrollPane();
		add(scroll);
//		- - - - - - - - - - - - - - - - - - - - - - -
		p_east = new JPanel();
		t_title2 = new JTextField(12);
		t_writer2 = new JTextField(12);
		t_content2 = new JTextField();
		p_preview2 = new JPanel();
		bt_edit = new JButton("수정");
		bt_del = new JButton("삭제");

		p_east.add(t_title2);
		p_east.add(t_writer2);
		p_east.add(t_content2);
		p_east.add(p_preview2);
		p_east.add(bt_edit);
		p_east.add(bt_del);

		p_east.setPreferredSize(d1);
		t_content2.setPreferredSize(d2);
		p_preview2.setPreferredSize(d2);
		p_preview2.setBackground(Color.BLACK);

		add(p_east, BorderLayout.EAST);
//		- - - - - - - - - - - - - - - - - - - - - - -
		setSize(900, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		- - - - - - - - - - - - - - - - - - - - - - -
		bt_open.addActionListener(this);
		bt_regist.addActionListener(this);
		bt_edit.addActionListener(this);
		bt_del.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == bt_open) {

		} else if (obj == bt_regist) {

		} else if (obj == bt_edit) {

		} else if (obj == bt_del) {

		}
	}
	public void connect () {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "javase";
			String pass = "1234";
			conn = DriverManager.getConnection(url, user, pass);
			
			if(conn !=null) {
				this.setTitle("접속 성공");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new GalleryMain2();
	}

}
