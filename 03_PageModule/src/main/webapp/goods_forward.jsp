<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	goods_forward.jsp
	
	<jsp:forward page="template.jsp">
	
		<jsp:param value="goods.jsp" name="viewPage"/>
		
	</jsp:forward>
	
	<!-- 거쳐가는 페이지 -->