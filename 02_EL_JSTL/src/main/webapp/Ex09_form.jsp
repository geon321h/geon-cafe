<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		Ex09_form.jsp <br>
	
	<form action="Ex09_result.jsp" method="post">
		이름: <input type="text" name="name"><br>
		<input type="checkbox" name="fruit" value="포도">포도<br>
		<input type="checkbox" name="fruit" value="딸기">딸기<br>
		<input type="checkbox" name="fruit" value="수박">수박<br>
		<input type="checkbox" name="fruit" value="복숭아">복숭아<br>
		<input type="submit" value="전송">
	</form>