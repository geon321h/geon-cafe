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
			location.href="insert.prd?pageNumber="+pageNumber;
		}
		function goUpdate(num,pageNumber,whatColumn,keyword){
			//console.log(num);
			//console.log(pageNumber);
			//console.log(whatColumn);
			//console.log(keyword);
			location.href="update.prd?num="+num+"&pageNumber="+pageNumber+"&whatColumn="+whatColumn+"&keyword="+keyword;
		}
	</script>

	<a href="<%=request.getContextPath()+"/main.jsp"%>">시작페이지</a>
	<a href="#">로그아웃</a>

	<h2>상품 리스트 화면(${pageInfo.totalCount})</h2>
	<h2>productList.jsp</h2>
	
	<form action="list.prd" method="get">
		<select name="whatColumn">
			<option value="all" >전체 검색</option>
			<option value="name" <c:if test="${whatColumn=='name'}"> selected </c:if>>상품명</option>
			<option value="contents" <c:if test="${whatColumn=='contents'}"> selected </c:if>>설명</option>
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
			<th>상품번호</th>
			<th>상품명</th>
			<th>상품이미지</th>
			<th>설명</th>
			<th>가격</th>
			<th>삭제</th>
			<th>수정</th>
		</tr>
		<c:forEach var="product" items="${productList}">
			<tr>
				<td>${product.num}</td>
				<td><a href="detailView.prd?num=${product.num}&pageNumber=${pageInfo.pageNumber}&whatColumn=${whatColumn}&keyword=${keyword}" >${product.name}</a></td>
				<td>
					<img style="width: 100px" src="<%=request.getContextPath()%>/resources/uploadImage/${product.image}">
				</td>
				<td>${product.contents}</td>
				<td>${product.price}</td>
				<td><a href="delete.prd?num=${product.num}&pageNumber=${pageInfo.pageNumber}&whatColumn=${whatColumn}&keyword=${keyword}">삭제</a></td>
				<td><input type="button" value="수정" onclick="goUpdate(${product.num},${pageInfo.pageNumber},'${whatColumn}','${keyword}')"></td>
			</tr>
		</c:forEach>
	</table>
	
	<center>
		${pageInfo.pagingHtml}
	</center>
	
	