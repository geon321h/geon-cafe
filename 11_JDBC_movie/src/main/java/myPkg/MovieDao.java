package myPkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class MovieDao {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbid = "sqlid";
	String dbpw = "sqlpw";
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs =null;
	
	public MovieDao() {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,dbid,dbpw);
		} catch (ClassNotFoundException e) {
			System.out.println("jar 파일 누락");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("접속 실패");
			e.printStackTrace();
		}
		System.out.println("드라이브 로드 및 접속 성공");
		
	}
	
	public ArrayList<MovieBean> getAllMovie(){
		ArrayList<MovieBean> lists = new ArrayList<>();
		
		String sql = "select * from movie order by num asc";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();			
			
			while(rs.next()) {
				
				int num = rs.getInt("num");
				String id =rs.getString("id");
				String name =rs.getString("name");
				int age = rs.getInt("age");
				String genre =rs.getString("genre");
				String time =rs.getString("time");
				int partner = rs.getInt("partner");
				String memo =rs.getString("memo");
				
				MovieBean mb = new MovieBean();
				mb.setNum(num);
				mb.setId(id);
				mb.setName(name);
				mb.setAge(age);
				mb.setGenre(genre);
				mb.setTime(time);
				mb.setPartner(partner);
				mb.setMemo(memo);;
				
				lists.add(mb);
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
	
	public boolean searchId(String userId){
		boolean flag = false;
		String sql = "select * from movie where id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();			
			
			while(rs.next()) {
				
				flag = true;
				break;
				
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
		
		return flag;
		
	}
	
	public int deleteAllMovie(String[] rowcheckArr) {
		int cnt = -1;
		String sql = "delete from movie where num=? ";
		
		for(int i=1;i<rowcheckArr.length;i++) {
			sql += " or num=?";
		}
		try {
			ps = conn.prepareStatement(sql);
			for(int i=0;i<rowcheckArr.length;i++) {
				int row = Integer.parseInt(rowcheckArr[i]);
				ps.setInt(i+1, row);
			}
			cnt = ps.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return cnt;
		
	}
	
	public int deleteMovie(int num) {
		int cnt = -1;
		String sql = "delete from movie where num=? ";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
		
	}
	
	public int insertMovie(MovieBean mb) {
		int cnt = -1;
		String sql = "insert into movie values(mv_seq.nextval,?,?,?,?,?,?,?)";
		
		try {

			ps = conn.prepareStatement(sql);
			ps.setString(1, mb.getId());
			ps.setString(2, mb.getName());
			ps.setInt(3,mb.getAge());
			ps.setString(4, mb.getGenre());
			ps.setString(5, mb.getTime());
			ps.setInt(6, mb.getPartner());
			ps.setString(7, mb.getMemo());
			
			cnt = ps.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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
	
	public MovieBean getMovieByNum(int num) {
		MovieBean mb = null;
		String sql = "select * from movie where num =?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();			
			if(rs.next()) {
				String id =rs.getString("id");
				String name =rs.getString("name");
				int age = rs.getInt("age");
				String genre =rs.getString("genre");
				String time =rs.getString("time");
				int partner = rs.getInt("partner");
				String memo =rs.getString("memo");
				
				mb = new MovieBean();
				mb.setNum(num);
				mb.setId(id);
				mb.setName(name);
				mb.setAge(age);
				mb.setGenre(genre);
				mb.setTime(time);
				mb.setPartner(partner);
				mb.setMemo(memo);;
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
		return mb;
	}
	
	public int updateMovie(MovieBean mb) {
		int cnt = -1;
		String sql = "update movie set id=?,name=?,age=?,genre=?,time=?,partner=?,memo=? where num = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mb.getId());
			ps.setString(2, mb.getName());
			ps.setInt(3,mb.getAge());
			ps.setString(4, mb.getGenre());
			ps.setString(5, mb.getTime());
			ps.setInt(6, mb.getPartner());
			ps.setString(7, mb.getMemo());;
			ps.setInt(8, mb.getNum());
			
			cnt = ps.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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
