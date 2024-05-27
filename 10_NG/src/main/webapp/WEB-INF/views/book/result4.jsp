<%@page import="com.spring.Bean.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	result4.jsp<br>
	
	<%
	BookBean bb = (BookBean)request.getAttribute("bookBean");
	%>
	
	제목 : ${bookBean.title} <br>
	제목 : <%=bb.getTitle()%> <br>
	
	저자 : ${bookBean.author} <br>
	저자 : <%=bb.getAuthor()%> <br>

	
	가격 : ${bookBean.price} <br>
	가격 : <%=bb.getPrice()%> <br>

	
	출판사 : ${bookBean.publisher} <br>
	출판사 : <%=bb.getPublisher() %> <br>

	
	
	