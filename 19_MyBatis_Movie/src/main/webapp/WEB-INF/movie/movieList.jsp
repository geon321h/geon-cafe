<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@include file="../common/common.jsp" %>

    movieList.jsp<br>
    
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
	
	<script type="text/javascript">
		function insert(pageNumber){
			location.href="insert.mv?pageNumber="+pageNumber;
		}
		
		function goUpdate(num,pageNumber) {
			location.href="update.mv?num="+num+"&pageNumber="+pageNumber;
		}
	</script>
	
	<h2>영화 목록 (${pageInfo.totalCount})</h2> 
	
	<form action="list.mv" method="get">
		<select name="whatColumn">
			<option value="all" >전체 검색</option>
			<option value="genre" <c:if test="${whatColumn=='genre'}"> selected </c:if>>장르</option>
			<option value="grade" <c:if test="${whatColumn=='grade'}"> selected </c:if>>관람등급</option>
			<option value="actor" <c:if test="${whatColumn=='actor'}"> selected </c:if>>출연배우</option>
		</select>
		<input type="text" name="keyword" value="<c:if test="${keyword != 'null'}">${keyword}</c:if>">
		<input type="submit"  value="검색">
	</form>
	
	<table border="1">
		<tr>
			<td colspan="9" style="text-align: right;">
				<button onclick="insert(${pageInfo.pageNumber})">추가하기</button>
			</td>
		</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>제작 대륙</th>
			<th>제작 나라</th>
			<th>장르</th>
			<th>관람등급</th>
			<th>출연배우</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="movie" items="${movieList}">
			<tr>
				<td>${movie.num}</td>
				<td><a href="detailView.mv?num=${movie.num}&pageNumber=${pageInfo.pageNumber}&whatColumn=${whatColumn}&keyword=${keyword}" >${movie.title}</a></td>
				<td>${movie.continent}</td>
				<td>${movie.nation}</td>
				<td>${movie.genre}</td>
				<td>${movie.grade}</td>
				<td>${movie.actor}</td>
				<td><input type="button" value="수정" onclick="goUpdate()"></td>
				<td><a href="delete.mv?num=${movie.num}&pageNumber=${pageInfo.pageNumber}&whatColumn=${whatColumn}&keyword=${keyword}">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<center>
		${pageInfo.pagingHtml}
	</center>