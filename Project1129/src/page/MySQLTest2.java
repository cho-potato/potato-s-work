package page;

public class MySQLTest2 {
	public static void main(String[] args) {
//		1) 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("로드성공");
			
//			2) 접속 시도
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
