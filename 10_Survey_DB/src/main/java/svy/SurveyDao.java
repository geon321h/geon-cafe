package svy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SurveyDao {

	Connection conn =null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public SurveyDao() {
	
	}
	
	public SurveyDao(String driver,String url,String user,String pw) {
		try {
			
			Class.forName(driver);
			conn= DriverManager.getConnection(url,user,pw);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public int insertSurvey(SurveyBean sb) {
		int cnt = -1;
		String sql = "insert into servey values(seqsvy.nextval,?,?,?,?,?,?,?)";
		
		try {
			String part ="";
			if(sb.getPart()!=null) {
				for(String pt : sb.getPart()){
					part += pt+" ";
				}
			}else{
				part ="선택한 관심분야가 없습니다.";
			}
			ps = conn.prepareStatement(sql);
			ps.setString(1, sb.getName());
			ps.setString(2, sb.getCompany());
			ps.setString(3, sb.getEmail());
			ps.setString(4, sb.getSatisfaction());
			ps.setString(5, part);
			ps.setString(6, sb.getHowto());
			ps.setInt(7, sb.getAgree());
			
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
	
	public ArrayList<SurveyBean> getSurveyList() {
		String sql = "SELECT * FROM servey order by no";
		ArrayList<SurveyBean> lists = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				SurveyBean sb = new SurveyBean();
				sb.setNo(rs.getInt("no"));
				sb.setName(rs.getString("name"));
				sb.setCompany(rs.getString("company"));
				sb.setEmail(rs.getString("email"));
				sb.setSatisfaction(rs.getString("satisfaction"));
				if(rs.getString("part").equals("선택한 관심분야가 없습니다.")){
					String[] part = {rs.getString("part")};
					sb.setPart(part);
				}else {
					String[] part = rs.getString("part").trim().split(" ");
					sb.setPart(part);
				}
				sb.setHowto(rs.getString("howto"));
				sb.setAgree(rs.getInt("agree"));
				lists.add(sb);
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

	public int deleteSurvey(int no) {
		int cnt = -1;
		
		String sql = "delete servey where no = ? ";
			
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			
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

	public SurveyBean getSurveyByNo(int no) {
		SurveyBean sb = new SurveyBean();
		String sql = "SELECT * FROM servey where no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				sb.setNo(rs.getInt("no"));
				sb.setName(rs.getString("name"));
				sb.setCompany(rs.getString("company"));
				sb.setEmail(rs.getString("email"));
				sb.setSatisfaction(rs.getString("satisfaction"));
				String[] part = rs.getString("part").trim().split(" ");
				sb.setPart(part);
				sb.setHowto(rs.getString("howto"));
				sb.setAgree(rs.getInt("agree"));
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
		
		return sb;
	}

	public int updateSurvey(SurveyBean sb) {
		int cnt = -1;
		
		String sql = "update servey set name=?,company=?,email=?,satisfaction=?,part=?,howto=?,agree=? where no = ? ";
			
		try {
			String part ="";
			if(sb.getPart()!=null) {
				for(String pt : sb.getPart()){
					part += pt+" ";
				}
			}else{
				part ="선택한 관심분야가 없습니다.";
			}
			ps = conn.prepareStatement(sql);
			ps.setString(1, sb.getName());
			ps.setString(2, sb.getCompany());
			ps.setString(3, sb.getEmail());
			ps.setString(4, sb.getSatisfaction());
			ps.setString(5, part);
			ps.setString(6, sb.getHowto());
			ps.setInt(7, sb.getAgree());
			ps.setInt(8, sb.getNo());
			
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
