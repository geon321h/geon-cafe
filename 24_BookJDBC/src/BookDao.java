import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDao {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String id = "sqlid";
	private String pw = "sqlpw";
	
	BookDto bDto = null;
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	ArrayList<BookDto> lists = null;
	
	BookDao() {
		
		try {

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
	
	public ArrayList<BookDto> getAllBooks() {
		connect();
		lists = new ArrayList<>();
		String sql = "select * from book order by no asc";
		
		 try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();			
				while(rs.next()) { 
					int no = rs.getInt("no");
					String title =rs.getString("title");
					String author = rs.getString("author");
					String publisher = rs.getString("publisher");
					int price = rs.getInt("price");
					String day = String.valueOf(rs.getDate("day"));
					
					bDto = new BookDto();
					bDto.setNo(no);
					bDto.setTitle(title);
					bDto.setAuthor(author);
					bDto.setPublisher(publisher);
					bDto.setPrice(price);
					bDto.setDay(day);
					
					lists.add(bDto);
					
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

	public ArrayList<BookDto> getBookByChoice(String input, String column) {
		connect();
		lists = new ArrayList<>();
		String sql = "select * from book where "+column+" like ? order by no asc";
		
		 try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, input);
				rs = ps.executeQuery();			
				while(rs.next()) { 
					int no = rs.getInt("no");
					String title =rs.getString("title");
					String author = rs.getString("author");
					String publisher = rs.getString("publisher");
					int price = rs.getInt("price");
					String day = String.valueOf(rs.getDate("day"));
					
					bDto = new BookDto();
					bDto.setNo(no);
					bDto.setTitle(title);
					bDto.setAuthor(author);
					bDto.setPublisher(publisher);
					bDto.setPrice(price);
					bDto.setDay(day);
					
					lists.add(bDto);
					
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

	public int insertBook(BookDto bDto) {
		connect();
		String sql = "insert into book values(bkseq.nextval,?,?,?,?,?)";
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, bDto.getTitle());
			ps.setString(2, bDto.getAuthor());
			ps.setString(3, bDto.getPublisher());
			ps.setInt(4, bDto.getPrice());
			ps.setString(5, bDto.getDay());
			
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

	public int updateBook(BookDto bDto) {
		connect();
		String sql = "update book set Title=?,Author=?,Publisher=?,Price=?,Day=? where No = ?";
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, bDto.getTitle());
			ps.setString(2, bDto.getAuthor());
			ps.setString(3, bDto.getPublisher());
			ps.setInt(4, bDto.getPrice());
			ps.setString(5, bDto.getDay());
			ps.setInt(6, bDto.getNo());
			
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

	public int deleteBook(int no) {
		connect();
		String sql = "delete book where No = ?";
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			
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
