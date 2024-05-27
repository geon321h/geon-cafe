<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	result3.jsp<br>
	
제목 : ${param.title} <br>
	제목 : <%=request.getParameter("title") %> <br>
	제목 : ${requestScope.title} <br>
	제목 : ${title} <br>
	제목 : <%=request.getAttribute("title") %> <br>
	
	가수 : ${param.singer} <br>
	가수 : <%=request.getParameter("singer") %> <br>
	가수 : ${requestScope.singer} <br>
	가수 : ${singer} <br>
	가수 : <%=request.getAttribute("singer") %> <br>
	
	가격 : ${param.price} <br>
	가격 : <%=request.getParameter("price") %> <br>
	가격 : ${requestScope.price} <br>
	가격 : ${price} <br>
	가격 : <%=request.getAttribute("price") %> <br>
	