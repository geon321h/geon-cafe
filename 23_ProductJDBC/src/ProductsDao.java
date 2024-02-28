import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductsDao {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String id = "sqlid";
	private String pw = "sqlpw";
	
	ProductsDto pDto = null;
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	ArrayList<ProductsDto> lists = null;
	
	ProductsDao() {
	
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
	
	}
	
	public ArrayList<ProductsDto> getAllProducts() {
		connect(); // 계정에 접속
		lists = new ArrayList<>();
		String sql = "select * from products order by id asc";
		 
		 try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();			
				while(rs.next()) { 
					int id = rs.getInt("id");
					String name =rs.getString("name");
					int stock = rs.getInt("stock");
					int price = rs.getInt("price");
					String category = rs.getString("category");
					String inputdate = String.valueOf(rs.getDate("inputdate"));
					
					pDto = new ProductsDto();
					pDto.setId(id);
					pDto.setName(name);
					pDto.setStock(stock);
					pDto.setPrice(price);
					pDto.setCategory(category);
					pDto.setInputdate(inputdate);
					
					lists.add(pDto);
					
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

	public ArrayList<ProductsDto> getProductsById(int inputId) {
		connect(); // 계정에 접속
		lists = new ArrayList<>();
		String sql = "select * from products where id = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, inputId);
			rs = ps.executeQuery();
			while(rs.next()) { 
				int id = rs.getInt("id");
				String name =rs.getString("name");
				int stock = rs.getInt("stock");
				int price = rs.getInt("price");
				String category = rs.getString("category");
				String inputdate = String.valueOf(rs.getDate("inputdate"));
				
				pDto = new ProductsDto();
				pDto.setId(id);
				pDto.setName(name);
				pDto.setStock(stock);
				pDto.setPrice(price);
				pDto.setCategory(category);
				pDto.setInputdate(inputdate);
				
				lists.add(pDto);
				
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

	public ProductsDto getProductsById2(int inputId) {
		connect(); // 계정에 접속
		String sql = "select * from products where id = ? ";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, inputId);
			rs = ps.executeQuery();
			if(rs.next()) { 
				int id = rs.getInt("id");
				String name =rs.getString("name");
				int stock = rs.getInt("stock");
				int price = rs.getInt("price");
				String category = rs.getString("category");
				String inputdate = String.valueOf(rs.getDate("inputdate"));
				
				pDto = new ProductsDto();
				pDto.setId(id);
				pDto.setName(name);
				pDto.setStock(stock);
				pDto.setPrice(price);
				pDto.setCategory(category);
				pDto.setInputdate(inputdate);
				
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
		return pDto;
		
	}
	
	public ArrayList<ProductsDto> getProductsByCategory(String inputCategory) {
		connect(); // 계정에 접속
		lists = new ArrayList<>();
		String sql = "select * from products where upper(category) = ? order by id asc";
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, inputCategory.toUpperCase());
			rs = ps.executeQuery();
			while(rs.next()) { 
				int id = rs.getInt("id");
				String name =rs.getString("name");
				int stock = rs.getInt("stock");
				int price = rs.getInt("price");
				String category = rs.getString("category");
				String inputdate = String.valueOf(rs.getDate("inputdate"));
				
				ProductsDto pDto = new ProductsDto();
				pDto.setId(id);
				pDto.setName(name);
				pDto.setStock(stock);
				pDto.setPrice(price);
				pDto.setCategory(category);
				pDto.setInputdate(inputdate);
				
				lists.add(pDto);
				
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

	public int insertProduct(ProductsDto pDto) {
		connect();
		String sql = "insert into products values(prdseq.nextval,?,?,?,?,?)";
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pDto.getName());
			ps.setInt(2, pDto.getStock());
			ps.setInt(3, pDto.getPrice());
			ps.setString(4, pDto.getCategory());
			ps.setString(5, pDto.getInputdate());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(ps != null) {
						ps.close();
					}
					if(ps != null) {
						conn.close();
					}
					System.out.println("접속 종료");
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return cnt;
		
	}

	public int updateProduct(ProductsDto pDto) {
		connect();
		String sql = "update products set name=?,stock=?,price=?,category=?,inputdate=? where id=?";
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pDto.getName());
			ps.setInt(2, pDto.getStock());
			ps.setInt(3, pDto.getPrice());
			ps.setString(4, pDto.getCategory());
			ps.setString(5, pDto.getInputdate());
			ps.setInt(6, pDto.getId());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(ps != null) {
						ps.close();
					}
					if(ps != null) {
						conn.close();
					}
					System.out.println("접속 종료");
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return cnt;
		
	}

	public int deleteProduct(int id) {
		connect();
		String sql = "delete products where id=?";
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(ps != null) {
						ps.close();
					}
					if(ps != null) {
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
