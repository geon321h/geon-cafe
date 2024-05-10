<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
	Ex11_fmt.jsp<br>
	
	<c:set var="price" value="12345"></c:set>
	<c:out value="${price}"></c:out>
	
	<fmt:formatNumber var="su1" value="${price}" type="number"></fmt:formatNumber>
	su1 : ${su1 } <br>
	
	<fmt:formatNumber var="su2" value="${price}" pattern="###,000.00"></fmt:formatNumber>
	su2 : ${su2 } <br>
	
	<fmt:formatNumber var="su3" value="123.789789" maxFractionDigits="1"></fmt:formatNumber>
	su3 : ${su3 } <br> <!-- 두번째 자리에서 반올림하여 소수점 첫번째 자리까지 -->
	
	<fmt:parseNumber var="su4"  value="123.789789"  integerOnly="true" ></fmt:parseNumber>
	su4 : ${su4 } <br> 