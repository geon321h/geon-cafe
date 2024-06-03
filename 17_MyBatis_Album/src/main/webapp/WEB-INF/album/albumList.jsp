<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../common/common.jsp" %>

	album\albumList.jsp <br>

	<style type="text/css">
		form {
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
	
	<script type="text/javascript">
		function insert(){
			location.href="insert.ab";
		}
		
		function goUpdate(num) {
			location.href="update.ab?num="+num;
		}
	</script>
	
	<form action="list.ab" method="get">
		<select name="whatColumn">
			<option value="all" >전체 검색</option>
			<option value="title" <c:if test="${whatColumn=='title'}"> selected </c:if>>노래 제목</option>
			<option value="singer" <c:if test="${whatColumn=='singer'}"> selected </c:if>>가수명</option>
		</select>
		<input type="text" name="keyword" value="<c:if test="${keyword != 'null' && whatColumn!='all'}">${keyword}</c:if>">
		<input type="submit"  value="검색">
	</form>
	
	
	<table border="1">
		<tr>
			<td colspan="7" align="right">
				<input type="button" value="추가하기" onclick="insert()">
			</td>
		</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>가수</th>
			<th>가격</th>
			<th>날짜</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="album" items="${albumList}">
			<tr>
				<td>${album.num}</td>
				<td><a href="detail.ab?num=${album.num}">${album.title}</a></td>
				<td>${album.singer}</td>
				<td>${album.price}</td>
				<td>
				<fmt:parseDate value="${album.day}" var="day" pattern="yyyy-MM-dd"/>
	   			<fmt:formatDate value="${day}" pattern="yyyy-MM-dd"/>
	   			</td>
				<td><input type="button" value="수정" onclick="goUpdate(${album.num})"></td>
				<td><a href="delete.ab?num=${album.num}">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<br>
	<center>
		${pageInfo.pagingHtml}
	</center>
	