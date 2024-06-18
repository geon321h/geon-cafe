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
	
	<h2>상품 상세 화면</h2> 
	
	<table border="1">
		<tr>
			<td rowspan="6"><img src="<%=request.getContextPath()%>/resources/uploadImage/${product.image}"></td>
			<th>상품명</th>
			<td>${product.name}</td>
		</tr>
		<tr>
			<th>가격</th>
			<td>${product.price}</td>
		</tr>
		<tr>
			<th>재고수량</th>
			<td>${product.stock}</td>
		</tr>
		<tr>
			<th>설명</th>
			<td>${product.contents}</td>
		</tr>
		<tr>
			<th>주문수량</th>
			<td>
				<form action="add.mall" method="post">
					<input type="hidden" name="num" value="${product.num}">
					<input type="hidden" name="pageNumber" value="${pageNumber}">
					<input type="text" name="orderqty" value="0" style="30px">
					<input type="submit" value="주문">
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="2"><a href="list.prd?pageNumber=${pageNumber}&whatColumn=${whatColumn}&keyword=${keyword}">상품 리스트</a></td>
		</tr>
	</table>
