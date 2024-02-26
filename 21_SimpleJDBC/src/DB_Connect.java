import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connect {

	public static void main(String[] args) {
		
		try {
			// 0.jar 준비 (패키지 build path > configure build path > Libraries > add External jar)
			// C:\Oracle\product\12.2.0\dbhome_1\jdbc\lib\ojdbc.jar 선택
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
			
			// 2. DB 접속(연결)
			String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // localhost는 내 컴퓨터 ip주소
			String user = "sqlid";
			String pw = "sqlpw";
			
			System.out.println("DB 연결 시도합니다.");
			Connection conn = DriverManager.getConnection(url,user,pw); 
			// 접속이 되면 Connection 타입 객체에 정보가 들어감
			System.out.println("여러가지 실행중");
			
			// 3. DB접속(연결) 끊기
			conn.close();
					
		} catch (ClassNotFoundException e) {
			
			System.out.println("드라이버 로드 실패");			
			
		} catch (SQLException e) { // 3가지 조건중에 하나라도 잘못되었을 때 발생
			System.out.println("접속(연결)실패"); 
			e.printStackTrace();
		}
		

	}

}
