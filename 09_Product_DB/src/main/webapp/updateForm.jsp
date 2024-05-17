<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
	prodForm.jsp
	
	<%
		String[] company_arr = {"농심","해태","오리온","롯데"};
	%>
	
	<h2>상품 정보 입력</h2>
	
	<form action="update.prd" method="post" name="myform">
		<input type="hidden" name="id" value="${pb.id}"><br>
		상품명 : <input type="text" name="name" value="${pb.name}"><br>
		가격 : <input type="text" name="price" value="${pb.price}"><br>
		제조사 : 
		<select name="company">
			<c:forEach var="com" items="<%=company_arr%>">
				<c:if test="${com == pb.company}">
					<option value="${com}" selected="selected">${com}</option>
				</c:if>
				<c:if test="${com != pb.company}">
					<option value="${com}">${com}</option>
				</c:if>
			</c:forEach>
		</select>
		<br>
		입고일자 : <input type="date" name="regdate" value="${pb.regdate}"><br>
		<input type="submit" value="수정">
	</form>
	