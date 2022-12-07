package page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import util.ImageManager;

public class AppMain2 extends JFrame {
	JPanel p_north;
	Menu2[] menu = new Menu2[4];
	ImageManager imageManager;
	String[] path = { "res/app/introduce.png", "res/app/login.png", "res/app/member.png", "res/app/notice.png" };
	JPanel p_center;
	JPanel[] pageList = new JPanel[4];

	public static final int PAGE_WIDTH = 800;
	public static final int PAGE_HEIGHT = 400;

	public AppMain2() {
		p_north = new JPanel();
		imageManager = new ImageManager();

		p_north.setBackground(Color.RED);

		for (int i = 0; i < menu.length; i++) {
			menu[i] = new Menu2(this, imageManager.getIcon(path[i], 50, 50), 50, 50, i);
			p_north.add(menu[i]);

		}

		p_center = new JPanel();
		p_center.setBackground(Color.GRAY);

		pageList[0] = new CompanyPage();
		pageList[1] = new MemberPage2(); 
		pageList[2] = new LoginPage2(); 
		pageList[3] = new NoticePage();

		for(int i = 0; i<pageList.length; i++) {
			p_center.add(pageList[i]);			
		}

		add(p_center);
		add(p_north, BorderLayout.NORTH);

		setSize(800, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		showHide(0);
	}


	public void showHide(int currentPage) {
		for (int i = 0; i<pageList.length; i++) {

			if (currentPage==i) {
				pageList[i].setVisible(true);
			} else {
				pageList[i].setVisible(false);
			}
		}
	}

	public static void main(String[] args) {
		new AppMain2();
	}
}
