<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@include file="../common/common.jsp" %>

	<style type="text/css">
		h2{
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
		td {
			text-align: left;		
		}
		tr:last-child td {
			text-align: center;		
		}
		.err{
			color: red;
			font-size: 14px;
		}
	</style> 
	
	
	<h2>상품 수정 화면</h2>
	
	<form:form commandName="product" name="myform" action="update.prd" method="post" enctype="multipart/form-data">
		<input type="hidden" name="pageNumber" value="${param.pageNumber}">
		<input type="hidden" name="whatColumn" value="${param.whatColumn}">
		<input type="hidden" name="keyword" value="${param.keyword}">
		<input type="hidden" name="num" value="${product.num}">
		<table border="1">
			<tr>
				<th>*상품명</th>
				<td >
					<input type="text" name="name" value="${product.name}">
					<form:errors path="name" cssClass="err"></form:errors>
				</td>
			</tr>
			<tr>
				<th>제조회사</th>
				<td >
					<input type="text" name="company" value="${product.company}">
				</td>
			</tr>
			<tr>
				<th>*가격</th>
				<td >
					<input type="text" name="price" value="${product.price}">
					<form:errors path="price" cssClass="err"></form:errors>
				</td>
			</tr>
			<tr>
				<th>재고수량</th>
				<td >
					<input type="text" name="stock" value="${product.stock}">
				</td>
			</tr>
			<tr>
				<th>적립포인트</th>
				<td >
					<input type="text" name="point" value="${product.point}">
				</td>
			</tr>
			<tr>
				<th>*설명</th>
				<td >
					<input type="text" name="contents" value="${product.contents}">
					<form:errors path="contents" cssClass="err"></form:errors>
				</td>
			</tr>
			<tr>
				<th>*상품이미지</th>
				<td >
					<img src="<%=request.getContextPath()%>/resources/uploadImage/${product.image}">
					<input type="file" name="upload" ><br><br>
					<input type="text" name="upload2" value="${product.image}">
					<form:errors path="image" cssClass="err"></form:errors>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정하기">
					<input type="button" value="목록보기" onclick="location.href='list.prd?pageNumber=${pageNumber}'">					
				</td>
			</tr>
		</table>
	</form:form>