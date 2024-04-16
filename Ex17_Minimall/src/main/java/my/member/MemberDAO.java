package my.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.print.DocFlavor.STRING;
import javax.sql.DataSource;

public class MemberDAO {

	private static MemberDAO instance;
	
	public static MemberDAO getInstance() {
		if(instance==null) {
			instance = new MemberDAO();
		}
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs =null;
	
	private MemberDAO() {

	 	Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/OracleDB"); 
			conn = ds.getConnection();
		} catch (NamingException | SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public int insertMember(MemberDTO mdto){
		int cnt = -1;
		String sql = "insert into members"
						+ " values(memseq.nextval,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, mdto.getName());
			ps.setString(2, mdto.getId());
			ps.setString(3, mdto.getPassword());
			ps.setString(4, mdto.getRrn1());
			ps.setString(5, mdto.getRrn2());
			ps.setString(6, mdto.getEmail());
			ps.setString(7, mdto.getHp1());
			ps.setString(8, mdto.getHp2());
			ps.setString(9, mdto.getHp3());
			ps.setString(10, mdto.getJoindate());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (ps!=null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
		return cnt;
		
	}
	
	public boolean duplicateCheckId(String id) {
		boolean flag = false;
		String sql = "select * from members where id =?";
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				flag = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (ps!=null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
		return flag;
		
	}
	
	public MemberDTO findId(MemberDTO mdto) {
		MemberDTO member = null;
		String sql = "select * from members where name =? and rrn1 =? and rrn2=?";
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, mdto.getName());
			ps.setString(2, mdto.getRrn1());
			ps.setString(3, mdto.getRrn2());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				member = getMemberBean(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (ps!=null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
		return member;
	}
	
	public MemberDTO findPwd(MemberDTO mdto) {
		MemberDTO member = null;
		String sql = "select * from members where name =? and rrn1 =? and rrn2=? and id =?";
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, mdto.getName());
			ps.setString(2, mdto.getRrn1());
			ps.setString(3, mdto.getRrn2());
			ps.setString(4, mdto.getId());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				member = getMemberBean(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (ps!=null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
		return member;
	}
	
	public MemberDTO login(String id , String password) {
		MemberDTO member = null;
		String sql = "select * from members where id =? and password=?";
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()) {
				member = getMemberBean(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (ps!=null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
		return member;
	}
	
	public MemberDTO getMemberBean(ResultSet rs) throws SQLException {
		MemberDTO member = new MemberDTO();
		
		member.setNo(rs.getInt("no"));
		member.setName(rs.getString("name"));
		member.setId(rs.getString("id"));
		member.setPassword(rs.getString("password"));
		member.setRrn1(rs.getString("rrn1"));
		member.setRrn2(rs.getString("rrn2"));
		member.setEmail(rs.getString("email"));
		member.setHp1(rs.getString("hp1"));
		member.setHp2(rs.getString("hp2"));
		member.setHp3(rs.getString("hp3"));
		member.setJoindate(rs.getString("joindate"));
		
		return member;
	}
	
}








