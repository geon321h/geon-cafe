package my.shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import my.member.MemberDTO;


public class CategoryDao {
	
	private static CategoryDao instance;
	
	public static CategoryDao getInstance() {
		if(instance==null) {
			instance = new CategoryDao();
		}
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs =null;

	public CategoryDao() {

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
	
	public int insertCategory(CategoryBean cb){
		int cnt = -1;
		String sql = "insert into category"
						+ " values(catseq.nextval,?,?)";
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, cb.getCode());
			ps.setString(2, cb.getCname());
			
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
	
	public ArrayList<CategoryBean> getAllCategory() {
		CategoryBean category = null;
		ArrayList<CategoryBean> lists = new ArrayList<>();
		String sql = "select * from category order by cnum";
		try {
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				category = getCategoryBean(rs);
				lists.add(category);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (ps!=null) {
					ps.close();
				}
				if (rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
		return lists;
	}
	
	public int deleteCategory(int cnum) {
		int cnt = -1;
		String sql = "delete from category where cnum=?";
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cnum);
			
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
	
	public CategoryBean getCategoryBean(ResultSet rs) throws SQLException {
		CategoryBean Category = new CategoryBean();
		
		Category.setCnum(rs.getInt("cnum"));
		Category.setCode(rs.getString("code"));
		Category.setCname(rs.getString("cname"));
		
		return Category;
	}
	
	
}
