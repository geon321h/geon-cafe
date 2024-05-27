<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



	<form action="member/input5" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id">
				</td>
			</tr>		
			<tr>
				<td>비번</td>
				<td>
					<input type="text" name="pw">
				</td>
			</tr>		
			<tr>
				<td>주소</td>
				<td>
					<input type="text" name="addr">
				</td>
			</tr>		
			<tr>
				<td>나이</td>
				<td>
					<input type="text" name="age">
				</td>
			</tr>		
			<tr>
				<td colspan="2">
					<input type="submit" value="전송">
				</td>
			</tr>		
		</table>
	</form>