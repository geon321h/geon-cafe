<%@page import="com.spring.Bean.MusicBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	result5.jsp<br>
	
	<%
	MusicBean mb = (MusicBean)request.getAttribute("msc");
	%>
	
	제목 : ${msc.title} <br>
	제목 : <%=mb.getTitle()%> <br>
	
	가수 : ${msc.singer} <br>
	가수 : <%=mb.getSinger()%> <br>
	
	가격 : ${msc.price} <br>
	가격 : <%=mb.getPrice()%> <br>
	