<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	test2result.jsp<br>
	
	id : ${param.id} <br>
	id : <%=request.getParameter("id") %> <br>
	id : ${requestScope.id} <br>
	id : ${id} <br>
	id : <%=request.getAttribute("id") %> <br>