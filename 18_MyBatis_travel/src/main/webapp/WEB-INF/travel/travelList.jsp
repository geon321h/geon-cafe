<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@include file="../common/common.jsp" %>
    
    travelList.jsp <br>
    
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
		function insert(){
			location.href="insert.tv";
		}
		
		function goUpdate(num,pageNumber) {
			location.href="update.tv?num="+num+"&pageNumber="+pageNumber;
		}
	</script>
	
	<h2>여행 리스트 화면(전체 레코드갯수:${pageInfo.getTotalCount()})/${pageInfo.totalCount}</h2>
	<p>현재 클릭한 페이지 번호 : ${pageInfo.getPageNumber()}/${pageInfo.pageNumber}</p>
	<form action="list.tv" method="get">
		<select name="whatColumn">
			<option value="all" >전체 검색</option>
			<option value="area" <c:if test="${whatColumn=='area'}"> selected </c:if>>지역</option>
			<option value="style" <c:if test="${whatColumn=='style'}"> selected </c:if>>여행 타입</option>
		</select>
		<input type="text" name="keyword" value="<c:if test="${keyword != 'null' && whatColumn!='all'}">${keyword}</c:if>">
		<input type="submit"  value="검색">
	</form>
	
	<table border="1">
		<tr>
			<td colspan="8" style="text-align: right;">
				<button onclick="insert()">추가하기</button>
			</td>
		</tr>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>장소</th>
			<th>여행 타입</th>
			<th>예상비용</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="travel" items="${travelLists}">
			<tr>
				<td>${travel.num}</td>
				<td>${travel.name}</td>
				<td>${travel. age}</td>
				<td>${travel.area}</td>
				<td>${travel.style}</td>
				<td style="text-align: right;">${travel.price}만원</td>
				<td><input type="button" value="수정" onclick="goUpdate(${travel.num},${pageInfo.pageNumber})"></td>
				<td><a href="delete.tv?num=${travel.num}&pageNumber=${pageInfo.pageNumber}">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<center>
		${pageInfo.pagingHtml}
	</center>
