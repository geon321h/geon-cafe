import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {

	public static void main(String[] args) {
		
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
			String sql = "select * from test order by num asc";
			PreparedStatement ps = conn.prepareStatement(sql); // 문장을 분석한 정보가 들어간다.
			
			// 4. sql문 실행
			ResultSet rs = ps.executeQuery();			
			while(rs.next()) {
				int num = rs.getInt("num");
				String name =rs.getString("name");
				String addr = rs.getString("addr");
				System.out.println(num+","+name+","+addr);
			}
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


