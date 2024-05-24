<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    input.jsp <br>
    
    id1: ${id} <br>
    id2: ${requestScope.id }<br>
    id3: <%=request.getAttribute("id") %><br>
    name1: ${name} <br>
	name2: ${requestScope.name }<br>
    name3: <%=request.getAttribute("name") %><br>