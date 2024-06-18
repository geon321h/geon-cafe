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
	
	shopList.jsp
	<a href="<%=request.getContextPath()+"/logout.jsp"%>">로그아웃</a>

	<h2>주문자정보</h2>
	
	<table border="1">
		<tr>
			<td colspan="3" >
				주문자 정보 : ${member.name}(${member.id})
			</td>
		</tr>
		<tr>
			<th>주문 번호</th>
			<th>주문 일자</th>
			<th>상세 보기</th>
		</tr>
		<c:forEach var="orders" items="${ordersList}">
			<tr>
				<td>${orders.oid}</td>
				<fmt:parseDate value="${orders.orderdate}" var="orderdate" pattern="yyyy-MM-dd HH:mm"/>
				<td>
					<fmt:formatDate value="${orderdate}" pattern="yyyy-MM-dd HH:mm"/>
				</td>
				<td><a href="detailView.mall?oid=${orders.oid}" >상세보기</a></td>
			</tr>
		</c:forEach>
	</table>