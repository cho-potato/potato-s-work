package db;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

import util.ImageManager;

public class TableTest2 extends JFrame{
	JTextField t_id, t_name;
	JPasswordField t_pass;
	JButton bt;
	JPanel p_west;
	JTable table;
	ImageManager imageManager;
	
	
	public TableTest2() {
		t_id = new JTextField();
		t_name = new JTextField();
		t_pass = new JPasswordField();
		bt = new JButton(imageManager.getIcon("res/app/notice.png", 50, 50));
		p_west = new JPanel();
		table = new JTable();
		imageManager = new ImageManager();
		
		p_west.setPreferredSize(new Dimension(150, 500));
		Dimension d = new Dimension(130, 30);
		t_name.setPreferredSize(d);
		t_id.setPreferredSize(d);
		t_pass.setPreferredSize(d);
		bt.setPreferredSize(d);
		
		p_west.add(bt);
		p_west.add(t_name);
		p_west.add(t_id);
		p_west.add(t_pass);
		add(p_west, BorderLayout.WEST);
		
		setSize(600, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
	}
	public static void main(String[] args) {
		new TableTest2();
	}
}