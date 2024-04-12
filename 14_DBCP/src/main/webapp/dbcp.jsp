<%@page import="java.sql.ResultSet"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    dbcp.jsp<br>
    
 <%
 	Connection conn = null;
 	PreparedStatement ps = null;
 	
 	Context initContext = new InitialContext(); // Context는 InitialContext의 부모
 	Context envContext = (Context)initContext.lookup("java:comp/env"); // 해당 폴더에 접근하여 찾기
 	DataSource ds = (DataSource)envContext.lookup("jdbc/OracleDB"); // 다운캐스팅 해당 정보를 가진 것에 접근하여 찾기
 	conn = ds.getConnection();
 	System.out.println("conn : "+conn);
 
 	request.setCharacterEncoding("UTF-8");
 	
 	String username = request.getParameter("username");
 	String email = request.getParameter("email");
 	
 	String sql;
 	
	if(username != null && email != null){
		sql = "insert into tdbcp values(?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1,username);
		ps.setString(2,email);
		ps.executeUpdate();
	}
 	
 %>

	<h2>tdbcp</h2>
	<form name="myform" method="post" action="dbcp.jsp">
		이름 : <input type="text" name="username" id=""><br>
		email : <input type="text" name="email" id=""><br>
		<input type="submit" value="등록">

	</form>
	
	<h2>목록보기</h2>
	
	<%
		sql = "select username,email from tdbcp";
		ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int i = 1;
		while(rs.next()){
			out.println(i+":"+rs.getString(1)+","+rs.getString(2));
			i++;
		}
		
		rs.close();
		ps.close();
		conn.close();
		
	%>
	
	
	
	
	
	
	
 
 	
  