<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@include file="../common/common.jsp" %>

	travelUpdateForm.jsp <br>
    
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
	
	<%
		String[] area = {"유럽","동남아","일본","중국"};
		String[] style = {"패키지","크루즈","자유여행","골프여행"};
		String[] price = {"선택하세요","10~50","50~100","100~200","200~300"};
	%>
	
	<form:form commandName="travel" action="update.tv" method="post" >
		<input type="hidden" name="pageNumber" value="${pageNumber}">
		<input type="hidden" name="num" value="${travel.num}">
		<table border="1">
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name" value="${travel.name}">
					<form:errors path="name" cssClass="err"></form:errors>
				</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>
					<input type="number" name="age" value='<c:if test="${travel.age==null}">0</c:if><c:if test="${travel.age!=null}">${travel.age}</c:if>'>
					<form:errors path="age" cssClass="err"></form:errors>
				</td>
			</tr>
			<tr>
				<th>장소</th>
				<td>
					<c:forEach var="area" items="<%=area%>">
						<input type="checkbox" name="area" value="${area}" <c:if test="${fn:contains(travel.area,area)}"> checked </c:if> >${area}
					</c:forEach>
					<form:errors path="area" cssClass="err"></form:errors>
				</td>
			</tr>
			<tr>
				<th>여행 타입</th>
				<td>
					<c:forEach var="style" items="<%=style%>">
						<input type="radio" name="style" value="${style}" <c:if test="${travel.style == style}"> checked </c:if>>${style}
					</c:forEach>
					<form:errors path="style" cssClass="err"></form:errors>
				</td>
			</tr>
			<tr>
				<th>예상비용</th>
				<td>
					<select name="price">
						<c:forEach var="price" items="<%=price%>" varStatus="vs">
							<c:if test="${vs.first}">
								<option value="">${price}
							</c:if>
							<c:if test="${!vs.first}">
								<option value="${price}" <c:if test="${travel.price == price}"> selected </c:if> >${price}
							</c:if>
						</c:forEach>
					</select>
					<form:errors path="price" cssClass="err"></form:errors>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정하기">
					<input type="button" value="목록보기" onclick="location.href='list.tv'">					
				</td>
			</tr>
		</table>
	</form:form>	
	
	
	
	