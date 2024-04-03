<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
insertProc.jsp<br>
<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String uname = request.getParameter("uname");
	String dname = request.getParameter("dname");

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbid = "sqlid";
	String dbpw = "sqlpw";
	
	Class.forName(driver);
	
	Connection conn = DriverManager.getConnection(url, dbid, dbpw);

	String sql = "insert into register values(?,?,?,?,?,?)";
	PreparedStatement ps =  conn.prepareStatement(sql);
	
	ps.setString(1, id);
	ps.setString(2, passwd);
	ps.setString(3, name);
	ps.setString(4, gender);
	ps.setString(5, uname);
	ps.setString(6, dname);
	
	int cnt = ps.executeUpdate();
	if(cnt == 0)
		out.print("삽입 실패");
	else
		out.print("삽입 성공");
	
	if(conn != null){
		conn.close();
	}
	if(ps != null){
		ps.close();
	}
	
%>

<!-- 3가지 이동 방법이 있다. -->

<meta http-equiv="refresh" content="2; url=select.jsp"> <!-- n초; 화면으로 새로고침  -->

<%
	response.sendRedirect("select.jsp"); // request 객체를 공유안함
%>

<jsp:forward page="select.jsp"/> <!-- request 객체를 공유함 --> 





