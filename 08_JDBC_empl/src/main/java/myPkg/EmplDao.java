package myPkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmplDao {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbid = "sqlid";
	String dbpw = "sqlpw";
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs =null;
	
	public EmplDao() {
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("jar 파일누락");
			e.printStackTrace();
		}
		System.out.println("드라이버 로드");
		
	}
	
	public void connect () {
		
		try {	
			conn = DriverManager.getConnection(url,dbid,dbpw);
			System.out.println("접속 성공");
		} catch (SQLException e) {
				System.out.println("접속 실패");
				e.printStackTrace();
		}
		
	}
	
	public ArrayList<EmplBeen> getAllEmpl(){
		connect();
		ArrayList<EmplBeen> lists = new ArrayList<>();
		
		String sql = "select * from empl order by eid asc";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();			
			
			while(rs.next()) {
				int eid = rs.getInt("eid");
				String name =rs.getString("name");
				int dept = rs.getInt("dept");
				int salary = rs.getInt("salary");
				
				EmplBeen eb = new EmplBeen();
				eb.setEid(eid);
				eb.setName(name);
				eb.setDept(dept);
				eb.setSalary(salary);
				
				lists.add(eb);
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
	
	public int insertEmpl(EmplBeen eb){
		connect();
		int cnt = -1;
		String sql = "insert into empl values(e_seq.nextval,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, eb.getName());
			ps.setInt(2, eb.getDept());
			ps.setInt(3, eb.getSalary());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(conn != null){
						conn.close();
					}
					if(ps != null){
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return cnt;
	}
	
	public int deleteEmpl(int eid) {
		connect();
		int cnt = -1;
		String sql = "delete from empl where eid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, eid);
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(conn != null){
						conn.close();
					}
					if(ps != null){
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return cnt;
	}
	
	public EmplBeen getEmplByEid(int eid) {
		connect();
		EmplBeen eb = null;
		String sql = "select * from empl where eid =?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, eid);
			
			rs = ps.executeQuery();			
			if(rs.next()) {
				String name =rs.getString("name");
				int dept = rs.getInt("dept");
				int salary = rs.getInt("salary");
				
				eb = new EmplBeen();
				eb.setEid(eid);
				eb.setName(name);
				eb.setDept(dept);
				eb.setSalary(salary);
				
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
		
		return eb;
		
	}
	
	public int updateEmpl(EmplBeen eb){
		connect();
		int cnt = -1;
		String sql = "update empl set name=?,dept=?,salary=? where eid =?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, eb.getName());
			ps.setInt(2, eb.getDept());
			ps.setInt(3, eb.getSalary());
			ps.setInt(4, eb.getEid());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(conn != null){
						conn.close();
					}
					if(ps != null){
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return cnt;
	}
	
	public int deleteCheckData(String[] rowcheckArr) {
		connect();
		int cnt = -1;
		String sql = "delete from empl where eid=? ";
		
		try {
			
			for(int i=1;i<rowcheckArr.length;i++) {
				sql += " or eid=?";
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
