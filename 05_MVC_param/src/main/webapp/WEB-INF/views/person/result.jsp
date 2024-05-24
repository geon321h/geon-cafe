<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	person/result.jsp <br>
	
	name1 : ${name}<br>
	name2 : ${param.name}<br>
	name3 : <%=request.getParameter("name") %><br>
	
	name2-1 : ${name2}<br>
	name2-2 : ${requestScope.name2}<br>
	name2-3 : <%=request.getAttribute("name2") %><br>
	
	age1 : ${age}<br>
	age2 : ${param.age}<br>
	
	
	