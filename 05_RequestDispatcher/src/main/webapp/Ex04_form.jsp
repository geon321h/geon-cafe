<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
	<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	Ex04_form.jsp<br>
	
	<%
	
	String[] hobby = {"달리기	","수영","등산","영화"};
	
	%>
	
	<form name="myform" action="insert" method="post"> 
		아이디: <input type="text" name="id"> <br>
		비밀번호: <input type="password" name="password"> <br>
		이름: <input type="text" name="name" > <br>
		생년월일: 
		<select name="year">
			<c:forEach var="y" begin="0" end="${2024-1950}" step="1">
				<option value="${2024-y}">${2024-y}</option>
			</c:forEach>
		</select>
		년
		<select name="month">
			<c:forEach var="m" begin="0" end="${12-1}" step="1">
				<option value="${12-m}">${12-m}</option>
			</c:forEach>
		</select>
		월
		<select name="day">
			<c:forEach var="d" begin="0" end="${31-1}" step="1">
				<option value="${31-d}">${31-d}</option>
			</c:forEach>
		</select>
		일
		 <br>
		취미:
		<%
		for(String h : hobby){
			%>
			<input type="checkbox" name="hobby"  value="<%=h%>"><%=h%>
			<%
		}
		%>
		<br>
		[성적 입력]<br>
		C언어: <input type="text" name="c" size="10">
		JAVA: <input type="text" name="java" size="10">
		JSP: <input type="text" name="jsp" size="10">
		<br>
		<input type="submit" value="가입하기">
	</form>	