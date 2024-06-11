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
	
	<script type="text/javascript">
		function insert(pageNumber){
			location.href="insert.am?pageNumber="+pageNumber;
		}
	</script>
	
	<h2>애완동물 구매 목록 (${pageInfo.totalCount})</h2> 
	
	<form action="list.am" method="get">
		<select name="whatColumn">
			<option value="all" >전체 검색</option>
			<option value="class_animal" <c:if test="${whatColumn=='class_animal'}"> selected </c:if>>동물 분류</option>
			<option value="family_animal" <c:if test="${whatColumn=='family_animal'}"> selected </c:if>>동물 종류</option>
		</select>
		<input type="text" name="keyword" value="<c:if test="${keyword != 'null'}">${keyword}</c:if>">
		<input type="submit"  value="검색">
	</form>
	
	<table border="1">
		<tr>
			<td colspan="8" style="text-align: right;">
				<button onclick="insert(${pageInfo.pageNumber})">추가하기</button>
			</td>
		</tr>
		<tr>
			<th>번호</th>
			<th>구매자 아이디</th>
			<th>동물 분류</th>
			<th>동물 종류</th>
			<th>마릿수</th>
			<th>애완 상품</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="animal" items="${animalList}">
			<tr>
				<td>${animal.num}</td>
				<td><a href="detailView.am?num=${animal.num}&pageNumber=${pageInfo.pageNumber}&whatColumn=${whatColumn}&keyword=${keyword}" >${animal.id}</a></td>
				<td>${animal.class_animal}</td>
				<td>${animal.family_animal}</td>
				<td>${animal.many_animal}</td>
				<td>${animal.prduct_animal}</td>
				<td><a href="update.am?num=${animal.num}&pageNumber=${pageInfo.pageNumber}&whatColumn=${whatColumn}&keyword=${keyword}">수정</td>
				<td><a href="delete.am?num=${animal.num}&pageNumber=${pageInfo.pageNumber}&whatColumn=${whatColumn}&keyword=${keyword}">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<center>
		${pageInfo.pagingHtml}
	</center>
	
	
	