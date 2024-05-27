<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	result2.jsp<br>
	
	제목 : ${param.title} <br>
	제목 : <%=request.getParameter("title") %> <br>
	제목 : ${requestScope.title} <br>
	제목 : ${title} <br>
	제목 : <%=request.getAttribute("title") %> <br>
	
	저자 : ${param.author} <br>
	저자 : <%=request.getParameter("author") %> <br>
	저자 : ${requestScope.author} <br>
	저자 : ${author} <br>
	저자 : <%=request.getAttribute("author") %> <br>
	
	가격 : ${param.price} <br>
	가격 : <%=request.getParameter("price") %> <br>
	가격 : ${requestScope.price} <br>
	가격 : ${price} <br>
	가격 : <%=request.getAttribute("price") %> <br>
	
	출판사 : ${param.publisher} <br>
	출판사 : <%=request.getParameter("publisher") %> <br>
	출판사 : ${requestScope.publisher} <br>
	출판사 : ${publisher} <br>
	출판사 : <%=request.getAttribute("publisher") %> <br>
	
	
	