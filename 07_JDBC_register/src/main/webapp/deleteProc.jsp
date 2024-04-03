<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
deleteProc.jsp<br>

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
		if(dpw.equals(passwd)){
			String sql = "delete from register where id=? and passwd=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, passwd);
			
			int cnt = -1;
			cnt = ps.executeUpdate(); 
			if(cnt==0 || cnt ==-1){
				out.print("삭제 실패");
			}
			else{
				out.print("삭제 성공");
			}
			conn.close();
			ps.close();
			
			response.sendRedirect("select.jsp");
			
		}else{
			out.print("<script>alert('비밀번호가 틀립니다.')</script> <meta http-equiv=\"refresh\" content=\"2; url=deleteForm.jsp\">");
		}// 비번 다름
	}else{
		out.print("<script>alert('찾는 아이디가 없습니다.')</script> <meta http-equiv=\"refresh\" content=\"2; url=deleteForm.jsp\">");
	}// 찾는 아이디 없음
	%>
	<br>
		
		
		
		
		
		
		
	
	
	
	
