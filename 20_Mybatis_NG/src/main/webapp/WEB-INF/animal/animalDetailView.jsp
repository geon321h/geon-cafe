<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@include file="../common/common.jsp" %>

	<style type="text/css">
		form,h2,p {
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
	</style>    
	
	<h2>애완동물 구매기록 화면</h2> 
	
	<table border="1">
		<tr>
			<th>번호</th>
			<td>${animal.num}</td>
		</tr>
		<tr>
			<th>구매자 아이디</th>
			<td>${animal.id}</td>
		</tr>
		<tr>
			<th>동물</th>
			<td>${animal.family_animal}</td>
		</tr>
		<tr>
			<th>마릿수</th>
			<td>${animal.many_animal}</td>
		</tr>
		<tr>
			<th>추가물품</th>
			<td>${animal.prduct_animal}</td>
		</tr>
		<tr>
			<td colspan="2"><a href="list.am?pageNumber=${pageNumber}&whatColumn=${whatColumn}&keyword=${keyword}">구매 목록</a></td>
		</tr>
	</table>
