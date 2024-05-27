<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	result1.jsp<br>
	
	제목 : ${param.title} <br>
	제목 : <%=request.getParameter("title") %> <br>
	
	가수 : ${param.singer} <br>
	가수 : <%=request.getParameter("singer") %> <br>
	
	가격 : ${param.price} <br>
	가격 : <%=request.getParameter("price") %> <br>
	