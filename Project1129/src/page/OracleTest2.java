package page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//1) 드라이버 로드
//2) 접속하기
//3) 쿼리수행
//4) 자원해제

public class OracleTest2 {
	
	public static void main(String[] args) {
		
//		1) 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버가 존재하지 않습니다");
			e.printStackTrace();
		}
		
//		2) 접속하기
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "java";
		String pass = "1234";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(url, user, pass);
			if(conn !=null) {
				System.out.println("CONNECTED");
			} else {
				System.out.println("FAILD");
			}
			
//			3) 쿼리문 수행
			String sql = "insert into emp2(ename, job, sal) values('Captain', 'none', 5000)";
			pstmt = conn.prepareStatement(sql);
			int result = pstmt.executeUpdate();
			if(result >0) {
				System.out.println("쿼리성공");
			} else {
				System.out.println("쿼리실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
//			4) 자원해제
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(conn !=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
	}
}
