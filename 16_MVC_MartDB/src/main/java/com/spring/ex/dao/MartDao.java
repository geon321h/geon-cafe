package com.spring.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spring.ex.dto.MartBean;

public class MartDao {
	
	private static MartDao instance;
	
	public static MartDao getInstance() {
		if(instance==null) {
			instance = new MartDao();
		}
		return instance;
	}
	
	String url = "jdbc:oracle:thin:@localhost:1521:orcl"; 
	String user = "sqlid";
	String pw = "sqlpw";
	
	Connection conn =null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	public MartDao() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,user,pw); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public int insert(MartBean mb) {
		int cnt = -1;
		String sql = "INSERT INTO mart VALUES(mart_seq.nextval,?,?,?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mb.getId());
			ps.setString(2, mb.getPw());
			ps.setString(3, mb.getProduct());
			ps.setString(4, mb.getTime());
			ps.setString(5, mb.getApprove());
			ps.setString(6, mb.getAgree());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	public ArrayList<MartBean> getMartAll() {
		String sql = "select * from mart order by num";
		ArrayList<MartBean> lists = new ArrayList<MartBean>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MartBean mb = new MartBean(); 
				mb.setNum(rs.getInt("num"));
				mb.setId(rs.getString("id"));
				mb.setPw(rs.getString("pw"));
				mb.setProduct(rs.getString("product"));
				mb.setTime(rs.getString("time"));
				mb.setApprove(rs.getString("approve"));
				mb.setAgree(rs.getString("agree"));
				
				lists.add(mb);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lists;
	}

}
