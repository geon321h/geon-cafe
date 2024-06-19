<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<%@include file="../common/common.jsp" %>

	<style type="text/css">
		body {
			background:  #e0ffff;
			font-family:  "나눔스퀘어 네오";
			text-align: center;
		}
		table {
			background-color: #fff;
			margin: 0 auto;
			border-collapse: collapse;
		}
		
		tr th {
			background-color: #AFEEEE;
		}
		
		th, td {
			padding: 15px 20px;
			text-align: left;
		}
		tr:last-child td {
			text-align: center;
		}
		
		td{
			font-size: 14px;
		}
		.err{
			color: red;
			font-size: 14px;
		}
	</style>
	
	<P>board/deleteForm.jsp</P>
	<h2>글삭제</h2>
	
	<form  method="post" action="delete.bd">
		<input type="hidden" name="num" value="${num}">
		<input type="hidden" name="pageNumber" value="${pageNumber}">
		<input type="hidden" name="whatColumn" value="${whatColumn}">
		<input type="hidden" name="keyword" value="${keyword}">
		<table border="1">
			<tr>
				<th>비밀번호를 입력해주세요.</th>
			</tr>
			<tr>
				<td >
					비밀번호:
					<input type="password" name="passwd">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글삭제">
					<input type="button" value="글목록" onclick="location.href='list.bd?pageNumber=${pageNumber}&whatColumn=${whatColumn}&keyword=${keyword}'">					
				</td>
			</tr>
		</table>
	
	</form>
	
	