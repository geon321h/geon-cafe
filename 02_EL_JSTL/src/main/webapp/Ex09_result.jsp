<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

   	 <%
	 	request.setCharacterEncoding("UTF-8");
	 %>
	 
	 이름2: ${param.name}<br>
	 과일1: ${param.fruit}<br>
	 과일2: ${paramValues.fruit}<br>
	 
	 <c:set var="len" value="${fn:length(paramValues.fruit)}"/>
	 
	 len: ${len}<br>
	 <c:if test="${len==0}">
	 	선택한 과일이 없습니다.
	 </c:if>
	 <c:if test="${len>0}">
	  	<c:forEach var="i" begin="0" end="${len-1}" step="1" varStatus="s">
	 		${paramValues.fruit[i]}
	 		<c:if test="${!s.last}">,</c:if>
	 		<br>
	 	</c:forEach>
	 	
  		<c:forEach var="f" items="${paramValues.fruit}" varStatus="s">
	 		${f}
	 		<c:if test="${not s.last}">,</c:if>
	 		<br>
	 	</c:forEach>
	 </c:if>  