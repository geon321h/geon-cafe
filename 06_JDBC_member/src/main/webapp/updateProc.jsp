<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	updateProc.jsp<br>

<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");

	String driver = "oracle.jdbc.driver.OracleDriver";// jdbc에서 하던 초기 작업 그대로 진행
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbid = "sqlid";
	String dbpw = "sqlpw";
	
	//1
	Class.forName(driver);
	
	//2
	Connection conn = DriverManager.getConnection(url, dbid, dbpw);
	
	//3.
	String sql2 = "select passwd,id from member where id=?";
	PreparedStatement ps = conn.prepareStatement(sql2);
	ps.setString(1, id);
	ResultSet rs = ps.executeQuery(); 
	if(rs.next()){
		String dpw = rs.getString("passwd");
		if(dpw.equals(passwd)){
			String sql = "update member set name=? where id=? and passwd=?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setString(2, id);
			ps.setString(3, passwd);
			
			int cnt = -1;
			cnt = ps.executeUpdate(); 
			if(cnt==0 || cnt ==-1){
				out.print("레코드 수정 실패");
			}
			else{
				out.print("레코드 수정 성공");
			}
			conn.close();
			ps.close();
		}else{
			out.print("비번이 다릅니다.");
		}// 비번이 다름
	}else{
		out.print("찾는 아이디가 없습니다.");
	}// 찾는 아이디 없음
	
	
	
	%>
	<br>
		
		
		
		
		
		
		
	
	
	
	
