import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonDao { // DB작업

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String id = "sqlid";
	private String pw = "sqlpw";
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	ArrayList<PersonBean> lists = null;
	PersonDao() {
	
		try { 

			// 1. 드라이버 로드
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("jar 파일 누락");
			e.printStackTrace();
		}
		
	}	
	
	public void connect () {
		
		try {	
			
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("접속 성공");
			
		} catch (SQLException e) {
				System.out.println("접속 실패");
				e.printStackTrace();
		}
	
	}// 2.계정에 접속
	
	public ArrayList<PersonBean> getAllPerson() {
		connect(); // 2.계정에 접속 
		lists = new ArrayList<>();
		try {
			// 3.sql문 작성/분석
			String sql = "select * from person order by num asc";
			ps = conn.prepareStatement(sql);

			// 4.sql문 실행
			rs = ps.executeQuery();			
			while(rs.next()) { // 참이면 조건식 실행
				int num = rs.getInt("num");
				String name =rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String birth = String.valueOf(rs.getDate("birth"));
				
				PersonBean pb = new PersonBean();
				pb.setNum(num);
				pb.setName(name);
				pb.setAge(age);
				pb.setGender(gender);
				pb.setBirth(birth);
				
				lists.add(pb);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				// 5.사용한 자원 반납
				if(ps != null) {
					ps.close();
				}
				if(rs != null){
					rs.close();
				}
				if(conn != null) {
					conn.close();
				}
				System.out.println("접속 종료");
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
		return lists;
		
	}
	
	public ArrayList<PersonBean> getPersonByGender(String x)	{
		connect(); // 2.계정에 접속 
		ArrayList<PersonBean> lists = new ArrayList<>();
		try {
			// 3.sql문 작성/분석
			String sql = "select * from person where gender = ? order by num asc";
			ps = conn.prepareStatement(sql);
			ps.setString(1, x);
			
			// 4.sql문 실행
			rs = ps.executeQuery();			
			while(rs.next()) { // 참이면 조건식 실행
				int num = rs.getInt("num");
				String name =rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String birth = String.valueOf(rs.getDate("birth"));
				
				PersonBean pb = new PersonBean();
				pb.setNum(num);
				pb.setName(name);
				pb.setAge(age);
				pb.setGender(gender);
				pb.setBirth(birth);
				
				lists.add(pb);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				// 5.사용한 자원 반납
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
				System.out.println("접속 종료");
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return lists;
		
	}
	
	public int insertPerson(String name, int age, String gender, String birth) {
		connect(); // 2.계정에 접속 
		int cnt = 0; // 리턴하기 위해서는 기본값이 있어야하므로 초기화해준다.
		
		try {
			
			// 3.sql문 작성/분석
			String sql = "insert into person values(perseq.nextval,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, gender);
			ps.setString(4, birth);
			
			// 4.sql문 실행
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				// 5.사용한 자원 반납
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
				System.out.println("접속 종료");
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return cnt;
		
	}

	public int deletePerson(int num) {
		connect(); // 2.계정에 접속 
		int cnt = -1; // 리턴하기 위해서는 기본값이 있어야하므로 초기화해준다.
		
		try {
			
			// 3.sql문 작성/분석
			String sql = "delete person where num = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			
			// 4.sql문 실행
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				// 5.사용한 자원 반납
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
				System.out.println("접속 종료");
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return cnt;
		
	}

	public int updatePerson(int num, String name, int age, String gender, String birth) {
		connect(); // 2.계정에 접속 
		int cnt = -1; // 리턴하기 위해서는 기본값이 있어야하므로 초기화해준다.
		
		try {
			
			// 3.sql문 작성/분석
			String sql = "update person set name=?, age=?, gender=?, birth=? where num=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, gender);
			ps.setString(4, birth);
			ps.setInt(5, num);
			
			// 4.sql문 실행
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				// 5.사용한 자원 반납
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
				System.out.println("접속 종료");
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return cnt;
	}
	
}
