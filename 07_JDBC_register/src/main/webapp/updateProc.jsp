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
	String gender = request.getParameter("gender");
	String uname = request.getParameter("uname");
	String dname = request.getParameter("dname");
	
	String sid = (String)session.getAttribute("sid");
	String spasswd = (String)session.getAttribute("spasswd");
	String sname = (String)session.getAttribute("sname");
	String sgender = (String)session.getAttribute("sgender");
	String suname = (String)session.getAttribute("suname");
	String sdname = (String)session.getAttribute("sdname");
	
	String driver = "oracle.jdbc.driver.OracleDriver";// jdbc에서 하던 초기 작업 그대로 진행
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbid = "sqlid";
	String dbpw = "sqlpw";
	
	Class.forName(driver);
	
	Connection conn = DriverManager.getConnection(url, dbid, dbpw);
	
		String sql = "update register set name=?, gender=?,uname=?,dname=? where id=? and passwd=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, name);
		ps.setString(2, gender);
		ps.setString(3, uname);
		ps.setString(4, dname);
		ps.setString(5, id);
		ps.setString(6, passwd);
		
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

	
	
	%>
	<br>
<%
	response.sendRedirect("select.jsp");		
%>		
		
		
		
		
	
	
	
	
