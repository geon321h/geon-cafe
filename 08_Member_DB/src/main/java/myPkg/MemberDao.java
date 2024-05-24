package myPkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {
	String url ="jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "sqlid";
	String pw = "sqlpw";
	Connection conn =null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public MemberDao() {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn= DriverManager.getConnection(url,user,pw);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public int insertData(MemberBean mb) {
		int cnt = -1;
		String sql = "INSERT INTO mymem VALUES (seqmem.nextval,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mb.getName());
			ps.setString(2, mb.getPassword());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(conn!=null) {
					conn.close();
					}
					if(ps!=null) {
						ps.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} 
		
		return cnt;
		
	}
	
	public int updateData(MemberBean mb) {
		int cnt = -1;
		String sql = "update mymem set name=?,password=? where id=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mb.getName());
			ps.setString(2, mb.getPassword());
			ps.setInt(3, mb.getId());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(conn!=null) {
					conn.close();
					}
					if(ps!=null) {
						ps.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} 
		
		return cnt;
		
	}
	
	public ArrayList<MemberBean> getMemberList() {
		String sql = "SELECT * FROM mymem order by id";
		ArrayList<MemberBean> lists = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				MemberBean mb = new MemberBean();
				mb.setId(rs.getInt("id"));
				mb.setName(rs.getString("name"));
				mb.setPassword(rs.getString("password"));
				lists.add(mb);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
				conn.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	} 
		
		return lists;
		
	}
	
	public MemberBean getMemberById(int id) {
		String sql = "SELECT * FROM mymem where id =?";
		MemberBean mb = new MemberBean();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				mb.setId(rs.getInt("id"));
				mb.setName(rs.getString("name"));
				mb.setPassword(rs.getString("password"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		
		return mb;
		
	}
	
	public int deleteData(int id) {
		int cnt = -1;
		String sql = "delete mymem where id = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(conn!=null) {
					conn.close();
					}
					if(ps!=null) {
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} 
		
		return cnt;
		
	}

}
