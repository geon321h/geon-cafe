import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Insert {

	public static void main(String[] args) {

		// JDBC 프로그래밍 단계
		// 0. jar파일 포함
		// 1. 드라이버 로드 class.forName("")
		// 2. 계정의 접속 
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "sqlid";
		String pw = "sqlpw";
		
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			Connection conn = DriverManager.getConnection(url,id,pw);
			System.out.println("계정 접속 성공");
			
			// 3. sql문 분석
			int num = 5;
			String name ="류현진";
			String addr = "목포";
			String sql = "insert into test values(?,?,?)"; // " "안에 ;은 안된다.
			PreparedStatement ps = conn.prepareStatement(sql); // 문장을 분석한 정보가 들어간다.
			ps.setInt(1, num);
			ps.setString(2, name);
			ps.setString(3, addr);
			
			// 4. sql문 실행
			int cnt = ps.executeUpdate(); // 성공적으로 실행한 갯수가 리턴된다.
			System.out.println("cnt: " + cnt);			
			
			conn.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("계정의 접속 실패");
			e.printStackTrace();
		}
		
		
	}

}
