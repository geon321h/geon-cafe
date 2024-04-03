<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		String driver = "oracle.jdbc.driver.OracleDriver";// jdbc에서 하던 초기 작업 그대로 진행
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String dbid = "sqlid";
		String dbpw = "sqlpw";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, dbid, dbpw);
		
		String sqlId = "select * from register where id=?";
		PreparedStatement ps = conn.prepareStatement(sqlId);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery(); 
		if(rs.next()){
			String dpw = rs.getString("passwd");
			String name = rs.getString("name");
			String gender = rs.getString("gender");
			String uname = rs.getString("uname");
			String dname = rs.getString("dname");
			
			session.setAttribute("sid", id);	
			session.setAttribute("spasswd", passwd);	
			session.setAttribute("sname", name);	
			session.setAttribute("sgender", gender);	
			session.setAttribute("suname", uname);	
			session.setAttribute("sdname", dname);	
			if(dpw.equals(passwd)){
	%>
				<form method="post" action="updateProc.jsp">
					<table border="1" cellpadding="3" cellspacing="0">
						<tr>
							<th colspan="2">
								회원 정보를 입력해 주세요
							</th>
						</tr>
						<tr>
							<th> 아이디 </th>
							<td><%=id%> <input type="hidden" name="id" value="<%=id%>"></td>
						</tr>
						<tr>
							<th> 비밀번호 </th>
							<td><%=passwd%> <input type="hidden" name="passwd" value="<%=passwd%>"> </td>
						</tr>
						<tr>
							<th> 이름 </th>
							<td> <input type="text" name="name" value="<%=name%>"> </td>
						</tr>
						<tr>
							<th> 성별 </th>
							<td>
								<%
								if(gender.equals("남")){
								%>
								<input type="radio" name="gender" value="남" checked>남
    	   						<input type="radio" name="gender" value="여">여<p> 
								<% 
								}else{
    	   						%>
								<input type="radio" name="gender" value="남">남
    	   						<input type="radio" name="gender" value="여" checked>여<p>
								<%
								}
								%>
    	   					</td>
						</tr>
						<tr>
							<th> email </th>
							<td> 
								<input type="text" name="uname" value="<%=uname%>">@
					  			<select name="dname">
						  			<option value="daum.net">daum.net</option>
						  			<option value="naver.com">naver.com</option>
						  			<option value="nate.com">nate.com</option>
						  			<option value="google.com">google.com</option>
						  			<option value="yahoo.com">yahoo.com</option> 		
					  			</select><p>

							</td>
						</tr>
						<tr>
							<th colspan="2">
								<input type="submit" value="확인">
								<input type="reset" value="취소">
							</th>
						</tr>	
					</table>
				</form>
	<%
			}else{
				out.print("<script>alert('비밀번호가 틀립니다.')</script> <meta http-equiv=\"refresh\" content=\"2; url=updateForm.jsp\">");
			}// 비번 다름
		}else{
			out.print("<script>alert('찾는 아이디가 없습니다.')</script> <meta http-equiv=\"refresh\" content=\"2; url=updateForm.jsp\">");
		}// 찾는 아이디 없음
    %>
    