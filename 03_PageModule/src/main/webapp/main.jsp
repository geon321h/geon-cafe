<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	시작하는 페이지 main.jsp
	
	<jsp:forward page="template.jsp">
	
		<jsp:param value="content.jsp" name="viewPage"/>
		
	</jsp:forward>
	
	<!-- 거쳐가는 페이지 -->