<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	album\albumList.jsp <br>

	<style type="text/css">
		table {
			font-family: "나눔스퀘어 네오";
			border-collapse: collapse;
			margin: 0 auto;
		}
		td {
			text-align: center;
			padding: 15px 20px;
		}
	</style>
	
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>가수</td>
			<td>가격</td>
			<td>날짜</td>
		</tr>
		<c:forEach var="album" items="${albumList}">
			<tr>
				<td>${album.num}</td>
				<td>${album.title}</td>
				<td>${album.singer}</td>
				<td>${album.price}</td>
				<td>${album.day}</td>
			</tr>
		</c:forEach>
	</table>