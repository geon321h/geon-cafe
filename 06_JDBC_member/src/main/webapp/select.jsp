<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
select.jsp<br>
<%
String driver = "oracle.jdbc.driver.OracleDriver";// jdbc에서 하던 초기 작업 그대로 진행
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
		<th width="100">아이디</th>
		<th width="100">패스워드</th>
		<th width="150">이름</th>
		<th width="250">가입일자</th>
	</tr>
	<%
		//3. sql문 분석
		String sql = "select * from member";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		// 4.sql문 실행
		ResultSet rs = ps.executeQuery(); 
		/*
		ID            PASSWD        NAME        REG_DATE
		-------------------- ----------------- --------------
		kim           1234          김연아        00/03/03
		hong          9876          홍길동        24/03/20
		*/
		while(rs.next()){
			String id = rs.getString("id");
			String passwd = rs.getString("passwd");
			String name = rs.getString("name");
			//String reg_date = rs.getString("reg_date");
			String reg_date = String.valueOf(rs.getDate("reg_date"));
		%>			
			<tr align="center">
				<td><%=id %></td>
				<td><%=passwd %></td>
				<td><%=name %></td>
				<td><%=reg_date %></td>
			</tr>
		<%			
		}//while
		
		//5
		conn.close();
		ps.close();
		rs.close();
	%>
</table>

<!-- JSP => JAVA(servlet)-->


























