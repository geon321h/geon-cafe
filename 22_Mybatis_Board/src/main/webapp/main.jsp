<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	//response.sendRedirect("list.bd");
    	String viewProduct = request.getContextPath() +"/list.bd";
    	String viewMember = request.getContextPath() +"/list.mb";
    	session.invalidate();
    %>
    
    <a href="<%=viewProduct%>">게시판 목록 보기</a><br><br>
    <a href="<%=viewMember%>">회원 목록 보기</a><br><br>