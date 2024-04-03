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
	Timestamp reg_date = new Timestamp(System.currentTimeMillis());

	String driver = "oracle.jdbc.driver.OracleDriver";// jdbc에서 하던 초기 작업 그대로 진행
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbid = "sqlid";
	String dbpw = "sqlpw";
	
	//1
	Class.forName(driver);
	
	//2
	Connection conn = DriverManager.getConnection(url, dbid, dbpw);

	//3.sql문 분석
	String sql = "insert into member values(?,?,?,?)";
	PreparedStatement ps =  conn.prepareStatement(sql);
	
	//3_1 : ? 셋팅
	ps.setString(1, id);
	ps.setString(2, passwd);
	ps.setString(3, name);
	ps.setTimestamp(4, reg_date);		
	
	//4.
	int cnt = ps.executeUpdate();
	if(cnt == 0)
		out.print("레코드 삽입 실패");
	else
		out.print("레코드 삽입 성공");
	
	// 5.
	conn.close();
	ps.close();
	
%>
<!-- JSP가 서블릿으로 변환되어 실행될 때, 
서블릿 컨테이너는 기본적으로 예외 처리를 수행합니다 -->




