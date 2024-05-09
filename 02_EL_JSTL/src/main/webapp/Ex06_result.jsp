<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	Ex06_result.jsp <br>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<!-- 	 -->
	
	<c:set var="kor" value="${param.kor}"></c:set>
	<c:set var="eng" value="${param.eng}"></c:set>
	<c:set var="math" value="${param.math}"></c:set>
	<c:set var="sum" value="${math+kor+eng}"></c:set>
	<c:set var="avg" value="${sum/3}"></c:set>
	
	
	국어 : ${kor} 영어: ${param.eng} 영어: ${math} <br>
	합계 : ${sum} <br>
	평균 :  ${avg} <br>
	
	<c:if test="${avg>90 }">
		A학점
	</c:if>
	<c:if test="${avg>=80 and avg<90}">
		B학점
	</c:if>
	<c:if test="${avg>=70 and avg<80}">
		C학점
	</c:if>
	<c:if test="${avg>=60 and avg<70}">
		D학점
	</c:if>
	<c:if test="${avg<60}">
		F학점
	</c:if>
	 <br>
	 
 	<c:choose>
		<c:when test="${avg>=90 }">A학점</c:when>
		<c:when test="${avg>=80}">B학점</c:when>
		<c:when test="${avg>=70}">C학점</c:when>
		<c:when test="${avg>=60}">D학점</c:when>
		<c:otherwise>F학점</c:otherwise>
	</c:choose>
	
	<c:set var="avg2" value="${avg/10}"></c:set>
	avg2 :  ${avg2} <br>
	
	<fmt:parseNumber var="avg3" value="${avg/10}" integerOnly="true" />
	avg3 :  ${avg3} <br>
	
	 	<c:choose>
		<c:when test="${avg3==10 or avg3==9 }">A학점</c:when>
		<c:when test="${avg3==8}">B학점</c:when>
		<c:when test="${avg3==7}">C학점</c:when>
		<c:when test="${avg3==6}">D학점</c:when>
		<c:otherwise>F학점</c:otherwise>
	</c:choose>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	