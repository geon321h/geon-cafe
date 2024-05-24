<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<c:set var="food" value="${param.food}"></c:set>
	선택한 음식 ${food} <br>
	
	<c:if test="${food == '치킨' }">
		치킨
	</c:if>
	<c:if test="${food == '피자' }">
		피자
	</c:if>
	<c:if test="${food == '햄버거' }">
		햄버거
	</c:if>
	<c:if test="${food != '햄버거' or food == '피자' or food == '치킨'}">
		그밖의 음식
	</c:if>
	
	<c:choose>
		<c:when test="${food == '치킨' }">치킨</c:when>
		<c:when test="${food == '피자' }">피자</c:when>
		<c:otherwise>그밖의 음식</c:otherwise>
	</c:choose>
	
	
