<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String driver = "oracle.jdbc.driver.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:orcl";
String dbid = "sqlid";
String dbpw = "sqlpw";

//1
Class.forName(driver); 

//2
Connection conn = DriverManager.getConnection(url, dbid, dbpw);

%>

<h2> member 테이블의 레코드 조회</h2>
<table width="600" border="1">
	<tr>
		<th width="150">아이디</th>
		<th width="150">패스워드</th>
		<th width="150">이름</th>
		<th width="150">성별</th>
		<th width="150">email</th>
	</tr>
	<%
		String sql = "select * from register";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery(); 
		while(rs.next()){
			String id = rs.getString("id");
			String passwd = rs.getString("passwd");
			String name = rs.getString("name");
			String gender = rs.getString("gender");
			String uname = rs.getString("uname");
			String dname = rs.getString("dname");
		%>			
			<tr align="center">
				<td><%=id %></td>
				<td><%=passwd %></td>
				<td><%=name %></td>
				<td><%=gender %></td>
				<td><%=uname+"@"+dname %></td>
			</tr>
		<%			
		}//while
		
		//5
		if(conn != null){
			conn.close();
		}
		if(ps != null){
			ps.close();
		}
		if(rs != null){
			rs.close();
		}
	%>
</table>




























