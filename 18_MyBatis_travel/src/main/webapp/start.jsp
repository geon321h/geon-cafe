<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		String viewPage = request.getContextPath()+"/list.tv";
		response.sendRedirect(viewPage);
	%>