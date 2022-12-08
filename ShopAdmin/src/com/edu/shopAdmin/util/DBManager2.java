package com.edu.shopAdmin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 이 클래스는 앱을 이루는 모든 클래스들이 new 연산자로 인스턴스를 중복생성하지 않도록 
// 안전장치를 두기 위한 SINGLE TURN패턴으로 정의
public class DBManager2 {
	private static DBManager2 instance;
	private Connection connection;

	private DBManager2() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "javase";
			String pass = "1234";

			connection = DriverManager.getConnection(url, user, pass);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static DBManager2 getInstance() {
		if (instance == null) {
			instance = new DBManager2();
		}
		return instance;
	}

	public Connection getConnection() {
		return connection;
	}

	public void release(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

//	dml인 경우에만 사용
	public void release(PreparedStatement pstmt) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

//	select의 경우
	public void release(PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}