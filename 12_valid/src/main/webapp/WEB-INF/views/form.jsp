<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<style type="text/css">
		.error {
			color: red;
		}
	</style>
	
	<% 
		String[] bookstore = {"교보문고","알라딘","yes24","인터파크"};
		String[] kind = {"유료","무료"};
	%>
	
	form.jsp<br>
	
	<form:form commandName="book" action="insert" method="post">
		제목 : <input type="text" name="title" value="${book.title }">
		<form:errors path="title" cssClass="error"></form:errors>
		<br>
		저자 : <input type="text" name="author" value="${book.author }">
		<form:errors path="author" cssClass="error"></form:errors>
		<br>
		가격 : <input type="text" name="price" value="${book.price }">
		<form:errors path="price" cssClass="error"></form:errors>
		<br>
		출판사 : <input type="text" name="publisher" value="${book.publisher }">
		<form:errors path="publisher" cssClass="error"></form:errors>
		<br>
		구입가능서점 : 
		<c:forEach var="store" items="<%=bookstore %>">
			${store}<input type="checkbox" name="bookstore" value="${store}" <c:if test="${fn:contains(book.bookstore,store)}"> checked </c:if>>
		</c:forEach>
		<form:errors path="bookstore" cssClass="error"></form:errors>
		<br>
		배송비 : 
		<c:forEach var="kind" items="<%=kind %>">
			<input type="radio" name="kind" value="${kind}" <c:if test="${book.kind==kind}"> checked </c:if>>${kind}
		</c:forEach>
		<form:errors path="kind" cssClass="error"></form:errors>
		<br>
		<input type="submit" value="전송">
	</form:form>
	
	
	
	
	
	
	