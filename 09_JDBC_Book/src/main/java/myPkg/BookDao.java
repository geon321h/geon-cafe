package myPkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDao {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbid = "sqlid";
	String dbpw = "sqlpw";
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs =null;
	
	public BookDao() {
		
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
	
	public ArrayList<BookBeen> getAllBook(){
		connect();
		ArrayList<BookBeen> lists = new ArrayList<>();
		
		String sql = "select * from book order by bid asc";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();			
			
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String title =rs.getString("title");
				String author =rs.getString("author");
				String publisher =rs.getString("publisher");
				int price = rs.getInt("price");
				String reg_date =String.valueOf(rs.getDate("reg_date"));
				String delivery_price =rs.getString("delivery_price");
				String bookstore =rs.getString("bookstore");
				int quantity = rs.getInt("quantity");
				
				BookBeen bb = new BookBeen();
				bb.setBid(bid);
				bb.setTitle(title);
				bb.setAuthor(author);
				bb.setPublisher(publisher);
				bb.setPrice(price);
				bb.setReg_date(reg_date);
				bb.setDelivery_price(delivery_price);
				bb.setBookstore(bookstore);
				bb.setQuantity(quantity);
				
				lists.add(bb);
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
		
		return lists;
		
	}
	
	public int insertBook(BookBeen bb) {
		connect();
		int cnt = -1;
		String sql = "insert into book values(b_seq.nextval,?,?,?,?,?,?,?,?)";
		
		try {

			ps = conn.prepareStatement(sql);
			ps.setString(1, bb.getTitle());
			ps.setString(2, bb.getAuthor());
			ps.setString(3, bb.getPublisher());
			ps.setInt(4, bb.getPrice());
			ps.setString(5, bb.getReg_date());
			ps.setString(6, bb.getDelivery_price());
			ps.setString(7, bb.getBookstore());
			ps.setInt(8, bb.getQuantity());
			
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
	
	public int deleteBook(int bid) {
		connect();
		int cnt = -1;
		String sql = "delete from book where bid = ?";
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			
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
	
	public boolean searchTitle(String usertitle){
		boolean flag = false;
		connect();
		
		String sql = "select * from book where title =?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, usertitle);
			
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
	
	public BookBeen getBookBybid(int bid) {
		connect();
		BookBeen bb = null;
		String sql = "select * from book where bid =?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			
			rs = ps.executeQuery();			
			if(rs.next()) {
				String title =rs.getString("title");
				String author =rs.getString("author");
				String publisher =rs.getString("publisher");
				int price = rs.getInt("price");
				String reg_date =String.valueOf(rs.getDate("reg_date"));
				String delivery_price =rs.getString("delivery_price");
				String bookstore =rs.getString("bookstore");
				int quantity = rs.getInt("quantity");
				
				bb = new BookBeen();
				bb.setBid(bid);
				bb.setTitle(title);
				bb.setAuthor(author);
				bb.setPublisher(publisher);
				bb.setPrice(price);
				bb.setReg_date(reg_date);
				bb.setDelivery_price(delivery_price);
				bb.setBookstore(bookstore);
				bb.setQuantity(quantity);
				
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
		
		return bb;
		
	}
	
	public int updateBook(BookBeen bb) {
		connect();
		int cnt = -1;
		String sql = "update book set title=?,author=?,publisher=?,price=?,reg_date=?,delivery_price=?,bookstore=?,quantity=? where bid = ?";
		
		try {

			ps = conn.prepareStatement(sql);
			ps.setString(1, bb.getTitle());
			ps.setString(2, bb.getAuthor());
			ps.setString(3, bb.getPublisher());
			ps.setInt(4, bb.getPrice());
			ps.setString(5, bb.getReg_date());
			ps.setString(6, bb.getDelivery_price());
			ps.setString(7, bb.getBookstore());
			ps.setInt(8, bb.getQuantity());
			ps.setInt(9, bb.getBid());
			
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
	
	public int deleteCheckData(String[] rowcheckArr) {
		connect();
		int cnt = -1;
		String sql = "delete from book where bid=? ";
		
		try {
			
			for(int i=1;i<rowcheckArr.length;i++) {
				sql += " or bid=?";
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




