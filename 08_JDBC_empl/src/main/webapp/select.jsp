<%@page import="myPkg.EmplBeen"%>
<%@page import="java.util.ArrayList"%>
<%@page import="myPkg.EmplDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    select.jsp<br>
<%--     
    <%
    	EmplDao ed = new EmplDao();
    %>
--%>

<!-- 1단계 -->
<jsp:useBean id="edao" class="myPkg.EmplDao"/>

<table border="1">
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>부서번호</th>
		<th>급여</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
<% 
	ArrayList<EmplBeen> lists = edao.getAllEmpl();
	for(EmplBeen eb : lists){
%>
	<tr>
		<td><%=eb.getEid() %></td>
		<td><%=eb.getName() %></td>
		<td><%=eb.getDept() %></td>
		<td><%=eb.getSalary() %></td>
		<td><a href="updateForm.jsp?eid=<%=eb.getEid() %>">수정</a></td>
		<td><a href="deleteProc.jsp?eid=<%=eb.getEid() %>">삭제</a></td>
	</tr>
<%
	}
%>
</table>

<hr>
<a href="insertForm.jsp">삽입</a>

