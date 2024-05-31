<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	updateForm.jsp<br>
	
	<%
	String[] win = {"한국","미국","독일","스페인"};
	String[] round16 = {"한국","멕시코","독일","브라질","스위스","잉글랜드"};
	%>

	<style type="text/css">
		table {
			font-family: "나눔스퀘어 네오";
			border-collapse: collapse;
			border-color: #a9a9a9;
		}
		
		td{
			padding: 20px 20px;
		}
		
		td:first-child{
			font-weight: bold;
		}
		
		.err{
			color: red;
			font-size: 12px;
		}
	</style>

	<form:form commandName="fdto" action="update" method="post">
		<input type="hidden" name="num" value="${fdto.num}">
		<table border="1" style="width: 800px">
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id" size="40" value="${fdto.id}">
					<form:errors path="id" cssClass="err"></form:errors>
					
				</td>
			</tr>		
			<tr>
				<td>비번</td>
				<td>
					<input type="text" name="pw" size="40" value="${fdto.pw}">
					<form:errors path="pw" cssClass="err"></form:errors>
				</td>
			</tr>		
			<tr>
				<td>우승예상국가</td>
				<td>
					<c:forEach var="win" items="<%=win %>">
						<input type="radio" name="win" value="${win}" <c:if test="${fdto.win == win}"> checked </c:if>>${win}
					</c:forEach>
					<form:errors path="win" cssClass="err"></form:errors>
				</td>
			</tr>		
			<tr>
				<td>16강예상국가</td>
				<td>
					<c:forEach var="round" items="<%=round16 %>">
						<input type="checkbox" name="round16" value="${round}"  <c:if test="${fn:contains(fdto.round16,round)}"> checked </c:if>>${round}
					</c:forEach>
					<form:errors path="round16" cssClass="err"></form:errors>
				</td>
			</tr>		
			<tr>
				<td colspan="2">
					<input type="submit" value="수정"> &nbsp;&nbsp;
					<a href="list">목록보기</a>
				</td>
			</tr>		
		</table>
	</form:form>
	
	
	
	
	