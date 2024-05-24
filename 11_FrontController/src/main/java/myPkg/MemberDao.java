package myPkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDao {
	
	private static MemberDao instance;
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs =null;
	
	public static MemberDao getInstance() { 
		if(instance == null) {
			instance = new MemberDao();
		}
		
		return instance;
	}
	
	public MemberDao() {
	 	Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/OracleDB"); 
			conn = ds.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		} 
	
	}

	public int insertMember(MemberBean mb) {
		int cnt = -1;
		String sql = "insert into member(num,id,passwd,name) values(m_seq.nextval,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mb.getId());
			ps.setString(2, mb.getPasswd());
			ps.setString(3, mb.getName());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(ps!=null) {
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} 
		
		return cnt;
	}

	public ArrayList<MemberBean> getAllMember() {
		ArrayList<MemberBean> lists = new ArrayList<>();
		String sql = "SELECT * FROM member order by num";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				MemberBean mb = new MemberBean();
				mb.setNum(rs.getInt("num"));
				mb.setId(rs.getString("id"));
				mb.setName(rs.getString("passwd"));
				mb.setPasswd(rs.getString("name"));
				mb.setRegister(String.valueOf(rs.getDate("register")));
				lists.add(mb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
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
		
		return lists;
	}

	public int deleteMember(int num) {
		int cnt = -1;
		
		String sql = "delete member where num = ? ";
			
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(ps!=null) {
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} 
		
		return cnt;
	}

	public MemberBean getMemberByNum(int num) {
		MemberBean mb = new MemberBean();
		String sql = "SELECT * FROM member where num =?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				mb.setNum(rs.getInt("num"));
				mb.setId(rs.getString("id"));
				mb.setName(rs.getString("passwd"));
				mb.setPasswd(rs.getString("name"));
				mb.setRegister(String.valueOf(rs.getDate("register")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
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

	public int updateMember(MemberBean mb) {
		int cnt = -1;
		
		String sql = "update member set id=?,passwd=?,name=? where num = ? ";
			
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mb.getId());
			ps.setString(2, mb.getPasswd());
			ps.setString(3, mb.getName());
			ps.setInt(4, mb.getNum());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
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
