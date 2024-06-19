<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@include file="../common/common.jsp" %>

		
	<style type="text/css">
		p,h2{
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
		String[] hobby = {"운동","요리","게임","독서","영화"}; 
		String[] job = {"무직","학생","직장인","사업가"}; 
	%>
	
	<P>member/updateForm.jsp</P>
	<h2>회원 정보 수정</h2>
	
	<form:form commandName="member" method="post" action="update.mb">
		<input type="hidden" name="pageNumber" value="${param.pageNumber}">
		<input type="hidden" name="whatColumn" value="${param.whatColumn }">
		<input type="hidden" name="keyword" value="${param.keyword }">
		<input type="hidden" name="num" value="${param.num }">
		<table border="1">
			<tr>
				<th>이메일</th>
				<td >
					<input type="hidden" name="email" value="${member.email }">
					<input type="text"value="${member.email }" disabled="disabled">
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td >
					<input type="text" name="name" value="${member.name }">
					<form:errors cssClass="err" path="name"></form:errors>
				</td>
			</tr>
			<tr>
				<th>비번</th>
				<td >
					<input type="text" name="password" value="${member.password }">
					<form:errors cssClass="err" path="password"></form:errors>
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td >
					<c:forEach var="gender" items="<%=gender %>">
						<input type="radio" name="gender" <c:if test="${gender == member.gender}"> checked </c:if>  value="${gender}">${gender}
					</c:forEach>
					<form:errors cssClass="err" path="gender"></form:errors>
				</td>
			</tr>
			<tr>
				<th>취미</th>
				<td >
					<c:forEach var="hobby" items="<%=hobby %>">
						<input type="checkbox" name="hobby" <c:if test="${fn:contains(member.hobby,hobby)}"> checked </c:if>  value="${hobby}">${hobby}
					</c:forEach>
					<form:errors cssClass="err" path="hobby"></form:errors>
				</td>
			</tr>
			<tr>
				<th>직업</th>
				<td >
				<select name="job">
					<c:forEach var="job" items="<%=job %>">
						<option value="${job}" <c:if test="${job == member.job}"> selected </c:if> >${job}					
					</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정하기">
					<input type="button" value="회원 목록보기" onclick="location.href='list.mb?pageNumber=${param.pageNumber}&whatColumn=${param.whatColumn}&keyword=${param.keyword}'">					
				</td>
			</tr>
		</table>
	
	</form:form>
	
	
	
	
	
	