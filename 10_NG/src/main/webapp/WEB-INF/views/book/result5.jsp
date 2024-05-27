<%@page import="com.spring.Bean.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	result5.jsp<br>
	
	<%
	BookBean bb = (BookBean)request.getAttribute("bk");
	%>
	
	제목 : ${bk.title} <br>
	제목 : <%=bb.getTitle()%> <br>
	
	저자 : ${bk.author} <br>
	저자 : <%=bb.getAuthor()%> <br>

	
	가격 : ${bk.price} <br>
	가격 : <%=bb.getPrice()%> <br>

	
	출판사 : ${bk.publisher} <br>
	출판사 : <%=bb.getPublisher() %> <br>
	
	
	