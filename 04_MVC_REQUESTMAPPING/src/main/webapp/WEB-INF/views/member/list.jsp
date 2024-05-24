<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	 list.jsp <br>
	 
    name1: ${name} <br>
	name2: ${requestScope.name }<br>
    name3: <%=request.getAttribute("name") %><br>
    
    age1: ${age} <br>
    age2: ${requestScope.age }<br>
    age3: <%=request.getAttribute("age") %><br>
    
    