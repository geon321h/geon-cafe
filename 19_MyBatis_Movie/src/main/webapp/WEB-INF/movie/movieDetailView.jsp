<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@include file="../common/common.jsp" %>

    movieDetailView.jsp<br>
    
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
	
	<h2>영화 상세 화면</h2> 
	
	<table border="1">
		<tr>
			<th>번호</th>
			<td>${movie.num}</td>
		</tr>
		<tr>
			<th>영화제목</th>
			<td>${movie.title}</td>
		</tr>
		<tr>
			<th>제작국가</th>
			<td>${movie.nation}</td>
		</tr>
		<tr>
			<th>장르</th>
			<td>${movie.genre}</td>
		</tr>
		<tr>
			<th>관람등급</th>
			<td>${movie.grade}</td>
		</tr>
		<tr>
			<th>배우</th>
			<td>${movie.actor}</td>
		</tr>
		<tr>
			<td colspan="2"><a href="list.mv?pageNumber=${pageNumber}&whatColumn=${whatColumn}&keyword=${keyword}">영화 리스트 화면으로 돌아감</a></td>
		</tr>
	</table>
