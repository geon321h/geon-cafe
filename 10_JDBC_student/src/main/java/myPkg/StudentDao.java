package myPkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.catalina.valves.rewrite.InternalRewriteMap.UpperCase;

public class StudentDao {


	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbid = "sqlid";
	String dbpw = "sqlpw";
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs =null;
	
	public StudentDao() {
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,dbid,dbpw);
		} catch (ClassNotFoundException e) {
			System.out.println("jar 파일누락");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("접속 실패");
			e.printStackTrace();
		}
		System.out.println("드라이버 로드");
		System.out.println("접속 성공");
		
	}
	
	public ArrayList<StudentBean> getAllStudents(){
		ArrayList<StudentBean> lists = new ArrayList<>();
		
		String sql = "select * from student order by num asc";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();			
			
			while(rs.next()) {
				
				int num = rs.getInt("num");
				String id =rs.getString("id");
				String passwd =rs.getString("passwd");
				String name =rs.getString("name");
				int year = rs.getInt("year");
				int month = rs.getInt("month");
				int day = rs.getInt("day");
				String hobby =rs.getString("hobby");
				int c = rs.getInt("c");
				int java = rs.getInt("java");
				int jsp = rs.getInt("jsp");
				int sum = rs.getInt("sum");
				
				StudentBean sb = new StudentBean();
				sb.setNum(num);
				sb.setId(id);
				sb.setPasswd(passwd);
				sb.setName(name);
				sb.setYear(year);
				sb.setMonth(month);
				sb.setDay(day);
				sb.setHobby(hobby);
				sb.setC(c);
				sb.setJava(java);
				sb.setJsp(jsp);
				sb.setSum(sum);
				
				lists.add(sb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs!=null) {
					rs.close();
				}
				if (ps!=null) {
					ps.close();
				}
				if (conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("접속 종료");
				e.printStackTrace();
			}	
		}
		
		return lists;
		
	}
	
	public boolean searchId(String userId){
		boolean flag = false;
		System.out.println(userId);
		String sql = "select * from student where upper(id) = upper(?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			
			rs = ps.executeQuery();			
			while(rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs!=null) {
					rs.close();
				}
				if (ps!=null) {
					ps.close();
				}
				if (conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
		return flag;
	}
	
	public int insertStudent(StudentBean sb) {
		int cnt = -1;
		String sql = "insert into student values(stu_seq.nextval,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {

			ps = conn.prepareStatement(sql);
			ps.setString(1, sb.getId());
			ps.setString(2, sb.getPasswd());
			ps.setString(3, sb.getName());
			ps.setInt(4, sb.getYear());
			ps.setInt(5, sb.getMonth());
			ps.setInt(6, sb.getDay());
			ps.setString(7, sb.getHobby());
			ps.setInt(8, sb.getC());
			ps.setInt(9, sb.getJava());
			ps.setInt(10, sb.getJsp());
			ps.setInt(11, sb.getSum());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (ps!=null) {
					ps.close();
				}
				if (conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		return cnt;
	}
	
	public StudentBean getStudentByNum(int num) {
		StudentBean sb = null;
		String sql = "select * from student where num =?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			
			rs = ps.executeQuery();			
			if(rs.next()) {
				String id =rs.getString("id");
				String passwd =rs.getString("passwd");
				String name =rs.getString("name");
				int year = rs.getInt("year");
				int month = rs.getInt("month");
				int day = rs.getInt("day");
				String hobby =rs.getString("hobby");
				int c = rs.getInt("c");
				int java = rs.getInt("java");
				int jsp = rs.getInt("jsp");
				int sum = rs.getInt("sum");
				
				sb = new StudentBean();
				sb.setNum(num);
				sb.setId(id);
				sb.setPasswd(passwd);
				sb.setName(name);
				sb.setYear(year);
				sb.setMonth(month);
				sb.setDay(day);
				sb.setHobby(hobby);
				sb.setC(c);
				sb.setJava(java);
				sb.setJsp(jsp);
				sb.setSum(sum);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs!=null) {
					rs.close();
				}
				if (ps!=null) {
					ps.close();
				}
				if (conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("접속 종료");
				e.printStackTrace();
			}	
		}
		
		return sb;
		
	}
	
	public int updateStudent(StudentBean sb) {
		int cnt = -1;
		String sql = "update student set id=?,passwd=?,name=?,year=?,month=?,day=?,hobby=?,c=?,java=?,jsp=?,sum=? where num = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, sb.getId());
			ps.setString(2, sb.getPasswd());
			ps.setString(3, sb.getName());
			ps.setInt(4, sb.getYear());
			ps.setInt(5, sb.getMonth());
			ps.setInt(6, sb.getDay());
			ps.setString(7, sb.getHobby());
			ps.setInt(8, sb.getC());
			ps.setInt(9, sb.getJava());
			ps.setInt(10, sb.getJsp());
			ps.setInt(11, sb.getSum());
			ps.setInt(12, sb.getNum());
			
			cnt = ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				if (ps!=null) {
					ps.close();
				}
				if (conn!=null) {
					conn.close(); // commit
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		return cnt;
	}
	
	public int deleteStudent(int num) {
		int cnt = -1;
		String sql = "delete from student where num = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (ps!=null) {
					ps.close();
				}
				if (conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		return cnt;
	}
	
	public int deleteAllStudent(String[] rowcheckArr) {
		int cnt = -1;
		String sql = "delete from student where num=? ";
		
		try {
			
			for(int i=1;i<rowcheckArr.length;i++) {
				sql += " or num=?";
			}
			
			ps = conn.prepareStatement(sql);
			
			for(int i=0;i<rowcheckArr.length;i++) {
				int rowcheck = Integer.parseInt(rowcheckArr[i]);
				ps.setInt(i+1, rowcheck);
			}
			
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (ps!=null) {
					ps.close();
				}
				if (conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		return cnt;
	}
	
}
