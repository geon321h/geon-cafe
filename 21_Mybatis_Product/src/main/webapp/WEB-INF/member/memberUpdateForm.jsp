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
	
	<%
		String[] gender = {"남자","여자"}; 
		String[] hobby = {"취미","마라톤","영화감상","게임","공부"}; 
	%>
	<a href="login.mb">로그인화면</a>
	<h2>회원 수정 화면</h2>
	
	<form:form commandName="member" name="myform" action="update.mb" method="post">
		<input type="hidden" name="pageNumber" value="${param.pageNumber}">
		<input type="hidden" name="whatColumn" value="${param.whatColumn}">
		<input type="hidden" name="keyword" value="${param.keyword}">
		<input type="hidden" name="id" value="${member.id}">
		<table border="1">
			<tr>
				<th>*아이디</th>
				<td >
					<input type="text" value="${member.id}" disabled="disabled">
				</td>
			</tr>
			<tr>
				<th>*이름</th>
				<td >
					<input type="text" name="name" value="${member.name}">
					<form:errors path="name" cssClass="err"></form:errors>
				</td>
			</tr>
			<tr>
				<th>*비번</th>
				<td >
					<input type="text" name="password" value="${member.password}">
					<form:errors path="password" cssClass="err"></form:errors>
				</td>
			</tr>
			<tr>
				<th>*성별</th>
				<td >
					<c:forEach var="gender" items="<%=gender%>">
						<input type="radio" name="gender" value="${gender}" <c:if test="${member.gender == gender}"> checked </c:if>>${gender}
					</c:forEach>
					<form:errors path="gender" cssClass="err"></form:errors>
				</td>
			</tr>
			<tr>
				<th>*취미</th>
				<td >
					<c:forEach var="hobby" items="<%=hobby%>">
						<input type="checkbox" name="hobby" value="${hobby}" <c:if test="${fn:contains(member.hobby,hobby)}"> checked </c:if> >${hobby}
					</c:forEach>
					<form:errors path="hobby" cssClass="err"></form:errors>
				</td>
			</tr>
			<tr>
				<th>*주소 앞부분</th>
				<td >
					<input type="text" name="address1" value="${member.address1}">
					<form:errors path="address1" cssClass="err"></form:errors>
				</td>
			</tr>
			<tr>
				<th>주소 뒷부분</th>
				<td >
					<input type="text" name="address2" value="${member.address2}">
				</td>
			</tr>
			<tr>
				<th>적립포인트</th>
				<td >
					<input type="text" name="mpoint" value="${member.mpoint}">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정하기">
				</td>
			</tr>
		</table>
	</form:form>