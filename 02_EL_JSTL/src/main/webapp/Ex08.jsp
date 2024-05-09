<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	Ex08.jsp<br>
	
	<%
		
		String[] movieList = {"혹성탈출","범죄도시","쿵푸팬더","파묘"};
		pageContext.setAttribute("mList", movieList);
// 		request.setAttribute("mList", movieList);
// 		session.setAttribute("mList", movieList);
// 		application.setAttribute("mList", movieList);
		
	%>
	
	<table border="1">
		<tr>
			<th>제목</th>
		</tr>
		<%
		for(String movie : movieList){
			%>
			<tr>
				<td><%=movie %></td>
			</tr>
			<%
		}
		%>		
	</table>
	
	<hr>
	<c:set var="movieList" value="<%=movieList%>"></c:set>
	<table border="1">
		<tr>
			<th>index</th>
			<th>count</th>
			<th>title</th>
		</tr>
		<c:forEach var="movie" items="${movieList}" varStatus="status" >
		<!-- status는 특수한 기능을 위해 사용할 수 있고 사용하지 않아도 된다. -->
			<tr>
				<td>${status.index}</td>
				<td>${status.count}</td>
				<td>${movie}</td>
			</tr>
		</c:forEach>				
	</table>