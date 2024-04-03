<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    Ex01_contain.jsp<br>
    <%
    	
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
    
    %>
    
    cid: <%=id %><br>
    cpasswd: <%=passwd %><br>