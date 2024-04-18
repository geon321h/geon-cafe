package my.shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.oreilly.servlet.MultipartRequest;

public class ProductDao {

private static ProductDao instance;
	
	public static ProductDao getInstance() {
		if(instance==null) {
			instance = new ProductDao();
		}
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs =null;

	public ProductDao() {

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
	
	public int insertProduct(MultipartRequest mr){
		int cnt = -1;
		String sql = "insert into product"
						+ " values(catprod.nextval,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			String pcategory_fk = mr.getParameter("pcategory_fk");
			pcategory_fk += mr.getParameter("pcode");
			
	  	 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	  	 	String pinputdate = sdf.format(new Timestamp(System.currentTimeMillis()));
	  	 	//System.out.println(pinputdate);
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, mr.getParameter("pname"));
			ps.setString(2, pcategory_fk);
			ps.setString(3, mr.getParameter("pcompany"));
			ps.setString(4, mr.getOriginalFileName("pimage"));
			ps.setInt(5, Integer.parseInt(mr.getParameter("pqty")));
			ps.setInt(6, Integer.parseInt(mr.getParameter("price")));
			ps.setString(7, mr.getParameter("pspec"));
			ps.setString(8, mr.getParameter("pcontents"));
			ps.setInt(9,Integer.parseInt(mr.getParameter("point")));
			ps.setString(10, pinputdate);
			
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
	
	public ArrayList<ProductBean> getAllProduct() {
		ProductBean product = null;
		ArrayList<ProductBean> lists = new ArrayList<>();
		String sql = "select * from product order by pnum";
		try {
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				product = getProductBean(rs);
				lists.add(product);
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
	
	public ProductBean getProductByPnum(int pnum) {
		ProductBean product = null;
		String sql = "select * from product where pnum = ?";
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pnum);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				product = getProductBean(rs);
				
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
		
		return product;
	}
	
	public ArrayList<ProductBean> getProductByPspec(String pspec) {
		ProductBean product = null;
		ArrayList<ProductBean> lists = new ArrayList<>();
		String sql = "select * from product where pspec = ?";
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, pspec);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				product = getProductBean(rs);
				lists.add(product);
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
	
	public int deleteProduct(int pnum) {
		int cnt = -1;
		String sql = "delete from product where pnum=?";
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pnum);
			
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
	
	public int updateProduct(MultipartRequest mr, String img) {
		int cnt = -1;
		String sql = "update product set pname=?,pcompany=?,pimage=?,pqty=?,price=?,pspec=?,pcontents=?,point=? where pnum=?";
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, mr.getParameter("pname"));
			ps.setString(2, mr.getParameter("pcompany"));
			ps.setString(3, img);
			ps.setInt(4, Integer.parseInt(mr.getParameter("pqty")));
			ps.setInt(5, Integer.parseInt(mr.getParameter("price")));
			ps.setString(6, mr.getParameter("pspec"));
			ps.setString(7, mr.getParameter("pcontents"));
			ps.setInt(8,Integer.parseInt(mr.getParameter("point")));
			ps.setInt(9,Integer.parseInt(mr.getParameter("pnum")));
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (NumberFormatException e) {
			cnt = -1;
			return cnt;
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
	
	public ProductBean getProductBean(ResultSet rs) throws SQLException {
		ProductBean product = new ProductBean();
		
		product.setPnum(rs.getInt("pnum"));
		product.setPname(rs.getString("pname"));
		product.setPcategory_fk(rs.getString("pcategory_fk"));
		product.setPcompany(rs.getString("pcompany"));
		product.setPimage(rs.getString("pimage"));
		product.setPqty(rs.getInt("pqty"));
		product.setPrice(rs.getInt("price"));
		product.setPspec(rs.getString("pspec"));
		product.setPcontents(rs.getString("pcontents"));
		product.setPoint(rs.getInt("point"));
		product.setPinputdate(rs.getString("pinputdate"));
		
		return product;
	}
	
}
