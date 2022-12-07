package com.edu.shop.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.edu.shop.domain.SubCategory;
import com.edu.shop.domain.TopCategory;
import com.edu.shop.model.repository.SubCategoryDAO;
import com.edu.shop.model.repository.TopCategoryDAO;
import com.edu.shop.util.DBManager;

public class AdminMain2 extends JFrame {
	TopCategoryDAO topCategoryDAO; // Has a 관계
	SubCategoryDAO subCategoryDAO;
	DBManager dbManager = DBManager.getInstance();

	// 서쪽 영역
	JPanel p_west;
	JComboBox<String> box_top; // 상위 카테고리
	JComboBox<String> box_sub; // 하위 카테고리
	JTextField t_name; // 상품명
	JTextField t_brand; // 브랜드명
	JTextField t_price; // 가격
	JPanel preview; // 이미지 미리보기 영역 145 x 145
	JTextField t_url;// 이미지의 웹 주소
	JButton bt_preview; // 이미지 미리보기 버튼
	JButton bt_regist; // 등록버튼

	// 센터영역
	JPanel p_center; // 북쪽과 센터로 구분되어질 패널
	JPanel p_search; // 검색기능이 올려질 패널
	JComboBox<String> box_category; // 검색 구분
	JTextField t_keyword; // 검색어
	JButton bt_search; // 검색 버튼
	JTable table;
	JScrollPane scroll;

	// 동쪽 영역
	JPanel p_east;
	JComboBox<String> box_top2; // 상위 카테고리
	JComboBox<String> box_sub2; // 하위 카테고리
	JTextField t_name2; // 상품명
	JTextField t_brand2; // 브랜드명
	JTextField t_price2; // 가격
	JPanel preview2; // 이미지 미리보기 영역
	JTextField t_url2; // 이미지의 웹 주소
	JButton bt_preview2; //
	JButton bt_edit; //
	JButton bt_del; //

	public AdminMain2() {
		topCategoryDAO = new TopCategoryDAO();
		subCategoryDAO = new SubCategoryDAO();
		
		Dimension d1 = new Dimension(145, 500);
		Dimension d2 = new Dimension(145, 20);
		Dimension d3 = new Dimension(145, 145);
		
//		서쪽 영역 
		p_west = new JPanel();
		box_top = new JComboBox<String>();
		box_sub = new JComboBox<String>();
		t_name = new JTextField();
		t_brand = new JTextField();
		t_price = new JTextField();
		preview = new JPanel();
		t_url = new JTextField();
		bt_preview = new JButton("미리보기");
		bt_regist = new JButton("등록");
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
		add(p_west, BorderLayout.WEST);
		p_west.add(box_top);
		p_west.add(box_sub);
		p_west.add(t_name);
		p_west.add(t_brand);
		p_west.add(t_price);
		p_west.add(preview);
		p_west.add(t_url);
		p_west.add(bt_preview);
		p_west.add(bt_regist);
		
		p_west.setPreferredSize(d1);
		box_top.setPreferredSize(d2);
		box_sub.setPreferredSize(d2);
		t_name.setPreferredSize(d2);
		t_brand.setPreferredSize(d2);
		t_price.setPreferredSize(d2);
		t_url.setPreferredSize(d2);
		
		preview.setPreferredSize(d3);
		preview.setBackground(Color.BLACK);
//		- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
//		센터영역 
		p_center = new JPanel();
		p_search = new JPanel();
		box_category = new JComboBox<String>();
		t_keyword = new JTextField();
		bt_search = new JButton();
		table = new JTable(7,6);
		scroll = new JScrollPane(table);
//		- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
		add(p_center);
		p_center.setLayout(new BorderLayout());
		p_center.add(scroll);
		p_center.add(p_search, BorderLayout.NORTH);
		p_search.add(box_category);
		p_search.add(t_keyword);
		p_search.add(bt_search);
		
		box_category.setPreferredSize(d2);
		t_keyword.setPreferredSize(d2);
//		- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
//		동쪽 영역 
		p_east = new JPanel();
		box_top2 = new JComboBox<String>();
		box_sub2 = new JComboBox<String>();
		t_name2 = new JTextField();
		t_brand2 = new JTextField();
		t_price2 = new JTextField();
		preview2 = new JPanel();
		t_url2 = new JTextField();
		bt_preview2 = new JButton("미리보기");
		bt_edit = new JButton("수정");
		bt_del = new JButton("삭제");
//		- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
		add(p_east, BorderLayout.EAST);
		p_east.add(box_top2);
		p_east.add(box_sub2);
		p_east.add(t_name2);
		p_east.add(t_brand2);
		p_east.add(t_price2);
		p_east.add(preview2);
		p_east.add(t_url2);
		p_east.add(bt_preview2);
		p_east.add(bt_edit);
		p_east.add(bt_del);
		
		p_east.setPreferredSize(d1);
		box_top2.setPreferredSize(d2);
		box_sub2.setPreferredSize(d2);
		t_name2.setPreferredSize(d2);
		t_brand2.setPreferredSize(d2);
		t_price2.setPreferredSize(d2);
		t_url2.setPreferredSize(d2);
		
		preview2.setPreferredSize(d3);
		preview2.setBackground(Color.BLACK);
//		- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
		getTopList();
		
		setSize(900, 500);
		setVisible(true);
		setLocationRelativeTo(null);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dbManager.release(dbManager.getConnection());
			}
		});
		box_top.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
//					System.out.println(e.getItem());
					int topCategory_idx = topCategoryDAO.gettopCategoryIdx((String)e.getItem());
					
					getSubList(topCategory_idx);
				}
			}
		});
	}
//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	public void getTopList() {
		List<TopCategory> topList = topCategoryDAO.selectAll();
		box_top.addItem("카테고리 선택");
		for (TopCategory topCategory : topList) {
			box_top.addItem(topCategory.getTopcategory_name());
			
		}
	}
	public void getSubList(int topCategory_idx) {
		List<SubCategory> subList = subCategoryDAO.selectByTopCategory(topCategory_idx);
		System.out.println("getSubList"+subList.size());
		
		box_sub.addItem("하위 카테고리");
		for(int i  = 0; i<subList.size(); i++) {
		SubCategory subCategory = subList.get(i);
		box_sub.addItem(subCategory.getSubcategory_name());
		}
	}
	public static void main(String[] args) {
		new AdminMain2();
	}
}