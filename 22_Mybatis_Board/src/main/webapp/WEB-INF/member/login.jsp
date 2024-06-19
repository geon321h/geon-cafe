<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@include file="../common/common.jsp" %>
		
	
	
	<style type="text/css">
		p,h2{
			text-align: center;
		}
		table {
			font-family: "나눔스퀘어 네오";
			border-collapse: collapse;
			margin: 0 auto;
		}
		td,th {
			text-align: center;
			padding: 15px 20px;
		}
		td {
			text-align: left;		
		}
		tr:last-child td {
			text-align: center;		
		}
		.err{
			color: red;
			font-size: 14px;
		}
	</style> 
	
	<script type="text/javascript">
		function register(){
			location.href="insert.mb";
		}
		function memberList(){
			location.href="list.mb";
		}
	</script>
	<p>member/login.jsp</p>
	<h2>로그인 화면</h2>
	
	<form action="login.mb" method="post" >
		<table border="1">
			<tr>
				<th>이메일</th>
				<td >
					<input type="text" name="email" value="${member.email }">
				</td>
			</tr>
			<tr>
				<th>비번</th>
				<td >
					<input type="password" name="password" value="${member.password }">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인">
					<input type="button" value="회원가입" onclick="register()">					
					<input type="button" value="회원 목록보기" onclick="memberList()">					
				</td>
			</tr>
		</table>
	</form>
	