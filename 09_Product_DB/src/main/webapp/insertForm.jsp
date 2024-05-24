<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	prodForm.jsp
	
	<%
		application.setAttribute("flag", false);
	%>
	
	<h2>상품 정보 입력</h2>
	
	<form action="insert.prd" method="post" name="myform">
		상품명 : <input type="text" name="name"><br>
		가격 : <input type="text" name="price"><br>
		제조사 : 
		<select name="company">
			<option value="농심">농심</option>
			<option value="해태">해태</option>
			<option value="오리온">오리온</option>
			<option value="롯데">롯데</option>
		</select>
		<br>
		<input type="submit" value="전송">
	</form>
	
	<a href="select.prd">목록보기</a>