<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	Ex02_form.jsp <br>
	
	<form action="Ex02_result.jsp" method="post">
		<table border="1">
			<tr>
				<td>
					아이디
				</td>
				<td>
					<input type="text" name="id" id="">
				</td>
			</tr>
			<tr>
				<td>
					이름
				</td>
				<td>
					<input type="text" name="name" id="">
				</td>
			</tr>
			<tr>
				<td>
					비밀번호
				</td>
				<td>
					<input type="password" name="password" id="">
				</td>
			</tr>
			<tr>
				<td>나이</td>
				<td>
					<input type="text" name="age" id="">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="전송">
				</td>
			</tr>
		</table>
	</form>