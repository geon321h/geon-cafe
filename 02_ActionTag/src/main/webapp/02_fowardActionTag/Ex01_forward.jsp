<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 	Ex01_forward.jsp<br>
 		<%
    	
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("passwd");
    
    %>
    
    id: <%=id %><br>
    passwd: <%=pw %><br>