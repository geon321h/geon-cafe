<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 해당 주소에서 태그를 가져와 "c"라는 이름으로 사용할 수 있다. (namespace:태그) -->
<!-- out, set,  -->

	<%
	int dan = Integer.parseInt(request.getParameter("dan"));
	%>

	<h1>구구단 <%=dan%>단</h1>
	<%
	for(int i=2;i<=9;i++){
		out.print(dan+"*"+i+" = "+(dan*i)+"<br>");
	}

	%> 
	
	<c:out value="Hello"></c:out>
	
	<%
		String s1 = "Hello";
	%>
	
	s1 : <%=s1%><br>
	<c:set var="s2" value="Hello"></c:set>
	s2 : ${s2}
	
	<c:set var="dan2" value="${param.dan}"></c:set>
	단1 : ${param.dan}<br>
	단2 : ${dan2}<br>
	
	<c:forEach var="i" begin="1" end="9" step="1">
		 ${dan2}*${i} = ${dan2*i}<br>
	</c:forEach>