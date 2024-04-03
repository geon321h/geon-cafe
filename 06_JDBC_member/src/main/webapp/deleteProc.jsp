<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
deleteProc.jsp<br>
<!-- 2가지 받아서
2가지 조건으로 레코드 삭제하기 -->

<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");

	String driver = "oracle.jdbc.driver.OracleDriver";// jdbc에서 하던 초기 작업 그대로 진행
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbid = "sqlid";
	String dbpw = "sqlpw";
	
	//1
	Class.forName(driver);
	
	//2
	Connection conn = DriverManager.getConnection(url, dbid, dbpw);
	
	//3.
	String sql = "delete from member where id=? and passwd=?";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1, id);
	ps.setString(2, passwd);
	
	int cnt = -1;
	cnt = ps.executeUpdate(); 
	if(cnt==0){
		out.print("레코드 삭제 실패");
	}
	else{
		out.print("레코드 삭제 성공");
	}
	conn.close();
	ps.close();
	
	%>
	<br>
		
		
		
		
		
		
		
	
	
	
	
