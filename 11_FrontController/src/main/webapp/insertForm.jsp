<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 	
 	<%
 	application.setAttribute("flag", false);
 	%>
	<h3>insertForm.jsp</h3><br>
	<form action="insert.do" method="post" name="myform">
		<h3>회원가입</h3>
		아이디  <input type="text" name="id" ><br>
		비번 <input type="password" name="passwd" ><br>
		이름  <input type="text" name="name" ><br>
		<br>
		<input type="submit" value="전송">
	</form>
	
	<a href="list.do">목록보기</a>