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
	<a href="<%=request.getContextPath()+"/main.jsp"%>">시작페이지</a>
	<h2>주문 상세 내역</h2> 
	
	<table border="1">
		<tr>
			<td colspan="2"> 고객명: ${member.name}</td>
			<td colspan="3"> 송장 번호(주문번호): ${param.oid}</td>
		</tr>
		<tr>
			<td colspan="5"> 배송지 : ${member.address1}</td>
		</tr>
		<tr>
			<th>순번</th>
			<th>상품명(상품번호)</th>
			<th>수량</th>
			<th>단가</th>
			<th>금액</th>
		</tr>
		<c:forEach var="orders" items="${ordersList}" varStatus="vs">
			<tr>
				<td>${vs.count}</td>
				<td>${orders.name}(${orders.pnum})</td>
				<td>${orders.qty}</td>
				<td>${orders.price}</td>
				<td>${orders.price*orders.qty}</td>
			</tr>
		</c:forEach>

	</table>
