package prd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {

//	String driver ="oracle.jdbc.driver.OracleDriver";
//	String url ="jdbc:oracle:thin:@localhost:1521:orcl";
//	String user = "sqlid";
//	String pw = "sqlpw";
	Connection conn =null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public ProductDao() {
//		try {
//			
//			Class.forName(driver);
//			conn= DriverManager.getConnection(url,user,pw);
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
	
	}
	
	public ProductDao(String driver,String url,String user,String pw) {
		try {
			
			Class.forName(driver);
			conn= DriverManager.getConnection(url,user,pw);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public int insertProduct(ProductBean pb) {
		int cnt = -1;
		String sql = "insert into products(id, name, price, company,regdate) "
				+ "values( seqprd.nextval,?,?,?, sysdate)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getName());
			ps.setInt(2, pb.getPrice());
			ps.setString(3, pb.getCompany());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
//					if(conn!=null) {
//					conn.close();
//					}
					if(ps!=null) {
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} 
		
		return cnt;
		
	}
	
	public ArrayList<ProductBean> getProductList() {
		String sql = "SELECT * FROM products order by id";
		ArrayList<ProductBean> lists = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				ProductBean pb = new ProductBean();
				pb.setId(rs.getInt("id"));
				pb.setName(rs.getString("name"));
				pb.setPrice(rs.getInt("price"));
				pb.setCompany(rs.getString("company"));
				pb.setRegdate(String.valueOf(rs.getDate("regdate")));
				lists.add(pb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
//				if(conn!=null) {
//				conn.close();
//				}
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
	
	public ProductBean getProductById(int id) {
		String sql = "SELECT * FROM products where id =?";
		ProductBean pb = new ProductBean();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				pb.setId(rs.getInt("id"));
				pb.setName(rs.getString("name"));
				pb.setPrice(rs.getInt("price"));
				pb.setCompany(rs.getString("company"));
				pb.setRegdate(String.valueOf(rs.getDate("regdate")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
//				if(conn!=null) {
//					conn.close();
//				}
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
		return pb;
		
	}
	
	public int updateProduct(ProductBean pb) {
		int cnt = -1;
		String sql = "update products set name=?, price=?, company=?,regdate=? where id =? ";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getName());
			ps.setInt(2, pb.getPrice());
			ps.setString(3, pb.getCompany());
			ps.setString(4, pb.getRegdate());
			ps.setInt(5, pb.getId());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
//					if(conn!=null) {
//					conn.close();
//					}
					if(ps!=null) {
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} 
		
		return cnt;
		
	}
	
	public int deleteProduct(int id) {
		int cnt = -1;
		String sql = "delete products where id = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
//					if(conn!=null) {
//					conn.close();
//					}
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
