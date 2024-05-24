<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<c:set var="s" value="가나/다라*마바/사/아"></c:set>
	s : ${s}<br>
	<c:forTokens var="one" items="${s}" delims="/*" varStatus="st">
		<c:out value="${st.index}"/>
		<c:out value="${one}"/>
	</c:forTokens>