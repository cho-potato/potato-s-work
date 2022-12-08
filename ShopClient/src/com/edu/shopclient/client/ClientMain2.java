package com.edu.shopclient.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ClientMain2 extends JFrame {
	JPanel p_north; // 메뉴 버튼들이 올 패널
	List<MenuButton> menuList;
//	반복문 대상이 아닌 것들은 직접 작성
	MenuButton m_login;
	MenuButton m_join;
	MenuButton m_cart;

	JPanel container; // 화면전환에 사용될 루트 컨테이너 : 화면 여러 개 부착될
	Page[] pageList = new Page[4];

	public ClientMain2() {
		p_north = new JPanel();
		menuList = new ArrayList<MenuButton>();
		createMenu(); // 상품 카테고리 수 만큼 버튼 생성
//		로그인, 회원가입, 장바구니
		m_login = new MenuButton("로그인");
		m_join = new MenuButton("회가입원");
		m_cart = new MenuButton("카트트트트ㅡㅌㄹ");
		p_north.add(m_login);
		p_north.add(m_join);
		p_north.add(m_cart);

		container = new JPanel(); // 모든 페이지들을 품고 있을 패널
		container.setBackground(Color.BLACK);

		add(p_north, BorderLayout.NORTH);
		add(container);

//		페이지 생성하여 붙여넣기
		pageList[0] = new ProductPage();
		pageList[1] = new LoginPage();
		pageList[2] = new JoinPage();
		pageList[3] = new CartPage();
		for (int i = 0; i < pageList.length; i++) {
			container.add(pageList[i]);
		}

		setSize(900, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void createMenu() {
		String[] menuName = { "상dml", "하dml", "액tptjfl", "신qkf" }; // DB연동하여 가져올 예정
		for (int i = 0; i < 4; i++) {
			MenuButton menu = new MenuButton(menuName[i]);
			p_north.add(menu); // 북쪽 패널에 부착
		}
	}

//	보여질 페이지와 가려질 페이지를 처리하여 화면전환 효과
	public void showHide() {

	}

	public static void main(String[] args) {
		new ClientMain2();
	}

}
