package com.spring.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spring.ex.dto.PDto;

public class PDao {
	
	private static PDao instance;
	
	public static PDao getInstance() {
		if(instance==null) {
			instance = new PDao();
		}
		return instance;
	}
	
	String url = "jdbc:oracle:thin:@localhost:1521:orcl"; 
	String user = "sqlid";
	String pw = "sqlpw";
	
	Connection conn =null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	public PDao() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,user,pw); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}


	public int insert(String id, String name, int age) {
		int cnt = -1;
		String sql = "INSERT INTO PERSON VALUES(person_seq.nextval,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}


	public ArrayList<PDto> selectAll() {
		String sql = "select * from person order by num";
		ArrayList<PDto> lists = new ArrayList<PDto>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				PDto dto = new PDto();
				dto.setNum(rs.getInt("num"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				
				lists.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lists;
	}


	public int delete(int num) {
		int cnt = -1;
		String sql = "delete person where num= ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

}
