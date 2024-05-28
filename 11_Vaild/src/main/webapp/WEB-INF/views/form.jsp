<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	form.jsp<br>
	
	<form:form commandName="per" action="insert" method="post">
		이름 : <input type="text" name="name" value="${per.name }">
		<form:errors path="name"></form:errors>
		<br>
		비밀번호 : <input type="text" name="pw" value="${per.pw }">
		<form:errors path="pw"></form:errors>
		<br>
		<input type="submit" value="전송">
	</form:form>