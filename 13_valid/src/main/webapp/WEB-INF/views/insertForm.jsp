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
		String[] product = {"식품","의류","도서","가구"};
		String[] time = {"0~4","4~8","8~12","12~16","16~20","20~24"};
		String[] approve = {"카드","핸드폰"};
	%>
	
	insertForm.jsp<br>
	<h3>마트 상품 구매 내역</h3>
	<form:form commandName="pro" action="insert" method="post">
		아이디 : <input type="text" name="id" value="${pro.id }">
		<form:errors path="id" cssClass="error"></form:errors>
		<br>
		비번 : <input type="text" name="pw" value="${pro.pw }">
		<form:errors path="pw" cssClass="error"></form:errors>
		<br>
		구매상품 : 
		<c:forEach var="product" items="<%=product %>">
			${product}<input type="checkbox" name="product" value="${product}" <c:if test="${fn:contains(pro.product,product)}"> checked </c:if>>
		</c:forEach>
		<form:errors path="product" cssClass="error"></form:errors>
		<br>
		배송시간 : 
		<select name="time">
			<option value="">선택</option>
		<c:forEach var="time" items="<%=time %>">
			<option value="${time}" <c:if test="${pro.time==time}"> selected </c:if>>${time}</option>
		</c:forEach>
		</select>
		<form:errors path="time" cssClass="error"></form:errors>
		<br>
		결제방법 : 
		<c:forEach var="approve" items="<%=approve%>">
			<input type="radio" name="approve" value="${approve}" <c:if test="${pro.approve==approve}"> checked </c:if>>${approve}
		</c:forEach>
		<form:errors path="approve" cssClass="error"></form:errors>
		<br>
		결제 동의합니다. <input type="checkbox" name="agree" value="동의" <c:if test="${pro.agree != null}"> checked </c:if>>
		<form:errors path="agree" cssClass="error"></form:errors>
		<br> 
		<input type="submit" value="보내기">
	</form:form>
	
	
	
	
	
	
	