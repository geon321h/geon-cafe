<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	member/result.jsp<br>
	
	id : ${param.id } <br>
	id : <%=request.getParameter("id") %> <br>
	id : ${requestScope.id } <br>
	id : ${id } <br>
	id : <%=request.getAttribute("id") %> <br>
	pw : ${param.pw } <br>
	pw : <%=request.getParameter("pw") %> <br>
	pw : ${requestScope.pw } <br>
	pw : ${pw } <br>
	pw : <%=request.getAttribute("pw") %> <br>
	
	id : ${mb.id } <br>
	pw : ${mb.pw } <br>
	addr : ${mb.addr } <br>
	age : ${mb.age } <br>
	