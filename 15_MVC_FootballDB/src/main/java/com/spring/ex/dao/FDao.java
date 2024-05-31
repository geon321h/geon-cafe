package com.spring.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spring.ex.dto.FDto;

public class FDao {

private static FDao instance;
	
	public static FDao getInstance() {
		if(instance==null) {
			instance = new FDao();
		}
		return instance;
	}
	
	String url = "jdbc:oracle:thin:@localhost:1521:orcl"; 
	String user = "sqlid";
	String pw = "sqlpw";
	
	Connection conn =null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	public FDao() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,user,pw); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}


	public int insert(FDto fdto) {
		int cnt = -1;
		String sql = "INSERT INTO football VALUES(fb_seq.nextval,?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, fdto.getId());
			ps.setString(2, fdto.getPw());
			ps.setString(3, fdto.getWin());
			ps.setString(4, fdto.getRound16());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	public ArrayList<FDto> getFootballAll() {
		String sql = "select * from football order by num";
		ArrayList<FDto> lists = new ArrayList<FDto>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				FDto dto = new FDto(); 
				dto.setNum(rs.getInt("num"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setWin(rs.getString("win"));
				dto.setRound16(rs.getString("round16"));
				
				lists.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lists;
	}
	
	public int delete(int num) {
		int cnt = -1;
		String sql = "delete football where num= ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}


	public FDto getFootball(int num) {
		String sql = "select * from football where num=?";
		FDto dto = new FDto(); 
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto.setNum(rs.getInt("num"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setWin(rs.getString("win"));
				dto.setRound16(rs.getString("round16"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}


	public int updateFB(FDto fdto) {
		int cnt = 0;
		String sql="update football set id=?, pw=?, win=?,round16=? where num=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, fdto.getId());
			ps.setString(2, fdto.getPw());
			ps.setString(3, fdto.getWin());
			ps.setString(4, fdto.getRound16());
			ps.setInt(5, fdto.getNum());
			cnt=ps.executeUpdate();

		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return cnt;
		
	}
	
}
