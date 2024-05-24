<%@page import="java.util.ArrayList"%>
<%@page import="myPkg.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	memberList.jsp<br>
	
	
	
	<table border="1" align="center">
        <tr>
            <td>번호</td>
            <td>이름</td>
            <td>비밀번호</td>
            <td>삭제</td>
            <td>수정</td>
        </tr>
		<c:forEach var="lists" items="${lists}">
	        <tr>
	            <td>${lists.id}</td>
	            <td>${lists.name}</td>
	            <td>${lists.password}</td>
	            <td><a href="delete.mem?id=${lists.id}">삭제</a></td>
	            <td><a href="updateForm.mem?id=${lists.id}">수정</a></td>
	        </tr>
		</c:forEach>
    </table>
    

<br>

<table border="1" align="center">
	<tr>
		<td>번호</td>
		<td>이름</td>
		<td>비밀번호</td>
		<td>삭제</td>
		<td>수정</td>
	</tr>
	<%-- <c:set var="list" value="${lists}"/> --%>
  	<c:forEach var="i" begin="0" end="${fn:length(lists)-1}" step="1">
  		<tr align="center">
  			<td>${lists.get(i).getId()}</td>
  			<td>${lists.get(i).name}</td>
  			<td>${lists.get(i).password}</td>
  			<td><a href="delete.mem?id=${lists.get(i).getId()}">삭제</a></td>
  			<td><a href="updateForm.mem?id=${lists.get(i).getId()}">수정</a></td>
  		</tr>
  	</c:forEach>

</table> 

<br>

<table border="1" align="center">
	<tr>
		<td>번호</td>
		<td>이름</td>
		<td>비밀번호</td>
		<td>삭제</td>
		<td>수정</td>
	</tr>
	
	<%
	    ArrayList<MemberBean> mlist = (ArrayList<MemberBean>)request.getAttribute("lists");
	    for (MemberBean member : mlist) {
	%>
	    <tr>
	        <td><%= member.getId() %></td>
	        <td><%= member.getName() %></td>
	        <td><%= member.getPassword() %></td>
	        <td><a href="delete.mem?id=<%= member.getId() %>">삭제</a></td>
	        <td><a href="updateForm.mem?id=<%= member.getId() %>">수정</a></td>
	    </tr>
	<%
	    }
	%>
</table>

<a href="memberForm.jsp">삽입</a>
    