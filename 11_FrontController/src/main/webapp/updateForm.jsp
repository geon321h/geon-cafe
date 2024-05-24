<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
	<h3>updateForm.jsp</h3><br>
	<form action="update.do" method="post" name="myform">
		<h3>회원수정</h3>
		<input type="hidden" name="num" value="${mb.num }">
		아이디  <input type="text" name="id" value="${mb.id }"><br>
		비번 <input type="password" name="passwd" value="${mb.passwd }"><br>
		이름  <input type="text" name="name" value="${mb.name }"><br>
		<br>
		<input type="submit" value="수정">
	</form>
	