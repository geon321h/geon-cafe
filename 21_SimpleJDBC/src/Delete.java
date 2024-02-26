import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "sqlid";
		String pw = "sqlpw";
		
		try {
			// 1. 드라이버 로드
			Class.forName(driver);
			// 2. 계정에 접속
			Connection conn = DriverManager.getConnection(url,id,pw);
			// 3. sql문 작성/분석
			int num = 2;
			String sql = "delete test where num = ?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, num);
			
			int cnt = ps.executeUpdate();
			System.out.println("cnt : " + cnt);
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
