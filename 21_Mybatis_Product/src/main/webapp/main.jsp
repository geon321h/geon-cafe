<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    main.jsp<br>
    
    <%
    	String viewProduct = request.getContextPath() +"/list.prd";
    	String viewOrder = request.getContextPath() +"/list.mall";
    	String viewMember = request.getContextPath() +"/list.mb";
    %>
    
    <a href="<%=viewProduct%>">상품 목록 보기</a><br><br>
    <a href="<%=viewOrder%>">나의 주문 내역</a><br><br>
    <a href="<%=viewMember%>">회원 목록 보기</a><br><br>
    
    <!-- <a href="logout.jsp">로그아웃</a> -->