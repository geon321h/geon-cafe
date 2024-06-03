<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp" %>
	
	albumUpdateForm.jsp<br>
	
	<style type="text/css">
		.err {
			color: red;
		}
	</style>
	
		<h3>앨범 수정 화면</h3>
	
	<form:form commandName="album" action="update.ab" method="post">
	 	<input type="hidden" name="num" value="${album.num }">
		노래제목 <input type="text" name="title" value="${album.title }">
		<form:errors path="title" cssClass="err"></form:errors>
		<br>
		가수명 <input type="text" name="singer" value="${album.singer }">
		<form:errors path="singer" cssClass="err"></form:errors>
		<br>
		가격 <input type="text" name="price" value="${album.price }">
		<form:errors path="price" cssClass="err"></form:errors>
		<br>
		<fmt:parseDate value="${album.day}" var="day" pattern="yyyy-MM-dd"/>
		발매일 <input type="text" name="day" value="<fmt:formatDate value="${day}" pattern="yyyy-MM-dd"/>">
		<br>
		<input type="submit" value="수정하기">
	</form:form>