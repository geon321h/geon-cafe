package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class BoardDao {

	private static BoardDao instance;
	
	public static BoardDao getInstance() {
		if(instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbid = "sqlid";
	String dbpw = "sqlpw";
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs =null;
	
	private BoardDao() {
		
		try {
			Class.forName(driver);
			
		} catch (ClassNotFoundException e) {
			System.out.println("jar 파일 누락");
			e.printStackTrace();
		}
		System.out.println("드라이브 로드");
		
	}
	
	public void conn() {
		try {
			conn = DriverManager.getConnection(url,dbid,dbpw);
		}  catch (SQLException e) {
			System.out.println("접속 실패");
			e.printStackTrace();
		}
		System.out.println("접속 성공");
	}
	
	public int getArticlesCount(){
		conn();
		int cnt = 0;
		String sql = "select count(*) cnt from board";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();			
			
			if(rs.next()) {
				cnt = rs.getInt("cnt");
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
		return cnt;
	}
	
	public ArrayList<BoardBean> getArticles(int startRow,int endRow){
		conn();
		ArrayList<BoardBean> lists = new ArrayList<>();
		
		String sql = "select num, writer, email, subject, passwd, reg_date, readcount, ref, re_step, re_level, content, ip " ;		        
		sql += "from (select rownum as rank, num, writer, email, subject, passwd, reg_date, readcount, ref, re_step, re_level, content, ip ";
		sql += "from (select num, writer, email, subject, passwd, reg_date, readcount, ref, re_step, re_level, content, ip ";
		sql += "from board  ";
		sql += "order by ref desc, re_step asc )) ";
		sql += "where rank between ? and ? ";	
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startRow);
			ps.setInt(2, endRow);
			rs = ps.executeQuery();			
			
			while(rs.next()) {
				
				BoardBean bb = new BoardBean();
				
				bb.setNum(rs.getInt("num"));
				bb.setWriter(rs.getString("writer"));
				bb.setEmail(rs.getString("email"));
				bb.setSubject(rs.getString("subject"));
				bb.setPasswd(rs.getString("passwd"));
				bb.setReg_date(rs.getTimestamp("reg_date"));
				bb.setReadcount(rs.getInt("readcount"));
				bb.setRef(rs.getInt("ref"));
				bb.setRe_step(rs.getInt("re_step"));
				bb.setRe_level(rs.getInt("re_level"));
				bb.setContent(rs.getString("content"));
				bb.setIp(rs.getString("ip"));

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
				System.out.println("접속 종료");
				e.printStackTrace();
			}	
		}
		
		return lists;
		
	}
	
	public BoardBean getArticle(int num){
		conn();
		BoardBean bb =null;
		try {
			String sql2 = "update board set readcount=readcount+1 where num = ? ";
			ps = conn.prepareStatement(sql2);
			ps.setInt(1, num);
			ps.executeUpdate();
			
			String sql = "select num, writer, email, subject, passwd, reg_date, readcount, ref, re_step, re_level, content, ip "
					+ "from board where num = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();			
			
			while(rs.next()) {
				
				bb = new BoardBean();
				
				bb.setNum(rs.getInt("num"));
				bb.setWriter(rs.getString("writer"));
				bb.setEmail(rs.getString("email"));
				bb.setSubject(rs.getString("subject"));
				bb.setPasswd(rs.getString("passwd"));
				bb.setReg_date(rs.getTimestamp("reg_date"));
				bb.setReadcount(rs.getInt("readcount"));
				bb.setRef(rs.getInt("ref"));
				bb.setRe_step(rs.getInt("re_step"));
				bb.setRe_level(rs.getInt("re_level"));
				bb.setContent(rs.getString("content"));
				bb.setIp(rs.getString("ip"));

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
	
	public int insertArticle(BoardBean bb){
		conn();
		int cnt = -1;
		String sql = "insert into board(num,writer,email,subject,passwd,reg_date,ref,re_step,re_level,content,ip) "
						+ "values(board_seq.nextval,?,?,?,?,?,board_seq.currval,0,0,?,?)";
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, bb.getWriter());
			ps.setString(2, bb.getEmail());
			ps.setString(3, bb.getSubject());
			ps.setString(4, bb.getPasswd());
			ps.setTimestamp(5, bb.getReg_date());
			ps.setString(6, bb.getContent());
			ps.setString(7, bb.getIp());
			
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
				System.out.println("접속 종료");
				e.printStackTrace();
			}	
		}
		
		return cnt;
		
	}
	
	public int deleteArticle(int num,String passwd) {
		conn();
		int cnt = -1;
		String sql = "select passwd from board where num=?";
		String sql2 = "delete from board where num=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if(rs.next()) {
				String dbpw = rs.getString("passwd");
				if(dbpw.equals(passwd)) {
					ps = conn.prepareStatement(sql2);
					ps.setInt(1, num);
					cnt = ps.executeUpdate();
				}else {
					cnt = 0;
				}
			}
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			ps.setString(2, passwd);
			
			cnt = ps.executeUpdate();
			
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
		return cnt;
		
	}
	
	public int replyArticle(BoardBean bb){
		conn();
		int cnt = -1;
		String sql = "insert into board(num,writer,email,subject,passwd,reg_date,ref,re_step,re_level,content,ip) "
						+ "values(board_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
		String sql2 = "update board set re_step = re_step+1 where ref =? and re_step > ? ";
		
		try {
			ps = conn.prepareStatement(sql2);
			ps.setInt(1, bb.getRef());
			ps.setInt(2, bb.getRe_step());
			ps.executeUpdate();
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, bb.getWriter());
			ps.setString(2, bb.getEmail());
			ps.setString(3, bb.getSubject());
			ps.setString(4, bb.getPasswd());
			ps.setTimestamp(5, bb.getReg_date());
			ps.setInt(6, bb.getRef());
			ps.setInt(7, bb.getRe_step()+1);
			ps.setInt(8, bb.getRe_level()+1);
			ps.setString(9, bb.getContent());
			ps.setString(10, bb.getIp());
			
			cnt = ps.executeUpdate();
			
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
		
		return cnt;
		
	}
	
	public BoardBean getArticleByNum(int num){
		conn();
		BoardBean bb =null;
		try {
			
			String sql = "select num, writer, email, subject, passwd, reg_date, readcount, ref, re_step, re_level, content, ip "
					+ "from board where num = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();			
			
			while(rs.next()) {
				
				bb = new BoardBean();
				
				bb.setNum(rs.getInt("num"));
				bb.setWriter(rs.getString("writer"));
				bb.setEmail(rs.getString("email"));
				bb.setSubject(rs.getString("subject"));
				bb.setPasswd(rs.getString("passwd"));
				bb.setReg_date(rs.getTimestamp("reg_date"));
				bb.setReadcount(rs.getInt("readcount"));
				bb.setRef(rs.getInt("ref"));
				bb.setRe_step(rs.getInt("re_step"));
				bb.setRe_level(rs.getInt("re_level"));
				bb.setContent(rs.getString("content"));
				bb.setIp(rs.getString("ip"));

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
	
	public int updateArticle(BoardBean bb){
		conn();
		int cnt = -1;
		String sql2 = "select passwd from board where num=?";
		String sql = "update board set writer=?,email=?,subject=?,content=? where num =?";
		
		try {
			
			ps = conn.prepareStatement(sql2);
			ps.setInt(1, bb.getNum());
			rs = ps.executeQuery();
			if(rs.next()) {
				String dbpw = rs.getString("passwd");
				if(dbpw.equals(bb.getPasswd())) {
					ps = conn.prepareStatement(sql);
					ps.setString(1, bb.getWriter());
					ps.setString(2, bb.getEmail());
					ps.setString(3, bb.getSubject());
					ps.setString(4, bb.getContent());
					ps.setInt(5, bb.getNum());
					
					cnt = ps.executeUpdate();
				}else {
					cnt = 0;
				}
			}
			
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
				System.out.println("접속 종료");
				e.printStackTrace();
			}	
		}
		
		return cnt;
		
	}
	
}
