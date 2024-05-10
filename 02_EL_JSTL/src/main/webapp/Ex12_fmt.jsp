<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   	
   	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
	Ex12_fmt.jsp<br>
	<%
	Date now = Calendar.getInstance().getTime();
 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
	%>
	<c:set var="now" value="<%=new Date()%>"></c:set>
	<c:out value="${now}"></c:out>
	
	<fmt:formatDate value="${now}" type="both" pattern="yyyy:MM:dd:HH:mm:ss"/>
	<c:out value="${now}"></c:out>
