<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<%@include file="../common/common.jsp" %>

	<style type="text/css">
		body {
			background:  #e0ffff;
			font-family:  "나눔스퀘어 네오";
			text-align: center;
		}
		table {
			background-color: #fff;
			margin: 0 auto;
			border-collapse: collapse;
		}
		
		tr th {
			background-color: #AFEEEE;
		}
		
		th, td {
			padding: 15px 20px;
			text-align: left;
		}
		tr:last-child td {
			text-align: center;
		}
		
		td{
			font-size: 14px;
		}
		.err{
			color: red;
			font-size: 14px;
		}
	</style>
	
	<P>board/replyForm.jsp</P>
	<h2>답글쓰기</h2>
	${ref}/${re_step}/${re_level}
	<form:form commandName="board" method="post" action="reply.bd">
		<input type="hidden" name="ref" value="${ref}">
		<input type="hidden" name="re_step" value="${re_step}">
		<input type="hidden" name="re_level" value="${re_level}">
		<input type="hidden" name="pageNumber" value="${pageNumber}">
		<input type="hidden" name="whatColumn" value="${whatColumn}">
		<input type="hidden" name="keyword" value="${keyword}">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td >
					<input type="hidden" name="writer" value="${userInfo.name}">
					${userInfo.name}
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td >
					<input type="text" name="subject" value="[답글]${board.subject }">
					<form:errors  cssClass="err" path="subject"></form:errors>
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td >
					<input type="hidden" name="email" value="${userInfo.email }">
					${userInfo.email }
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td >
					<textarea rows="6" cols="25" name="content">${board.content }</textarea>
					<form:errors cssClass="err" path="content"></form:errors>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td >
					<input type="password" name="passwd" value="${board.passwd }">
					<form:errors cssClass="err" path="passwd"></form:errors>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="답글쓰기">
					<input type="reset" value="다시 작성하기">
					<input type="button" value="목록보기" onclick="location.href='list.bd?pageNumber=${pageNumber}&whatColumn=${whatColumn}&keyword=${keyword}'">					
				</td>
			</tr>
		</table>
	
	</form:form>
	
	