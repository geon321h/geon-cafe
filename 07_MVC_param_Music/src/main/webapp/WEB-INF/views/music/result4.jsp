<%@page import="com.spring.Bean.MusicBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	result4.jsp<br>
	
	<%
	MusicBean mb = (MusicBean)request.getAttribute("musicBean");
	%>
	
	제목 : ${musicBean.title} <br>
	제목 : <%=mb.getTitle()%> <br>
	
	가수 : ${musicBean.singer} <br>
	가수 : <%=mb.getSinger()%> <br>
	
	가격 : ${musicBean.price} <br>
	가격 : <%=mb.getPrice()%> <br>
	