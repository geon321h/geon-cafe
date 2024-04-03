<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
result.jsp<br>

<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	// HttpServletRequest request = new HttpServletRequest();
	String bb = (String)session.getAttribute("aa");
	
	String passwd = request.getParameter("passwd");
	String sports = request.getParameter("sports");
	String game = request.getParameter("game");
	
	session.invalidate();
	
%>
id: <%= id %> <br>
id2: <%= bb %> <br>

passwd: <%= passwd %> <br>
sports: <%= sports %> <br>
game: <%= game %> <br>
<br><br>




