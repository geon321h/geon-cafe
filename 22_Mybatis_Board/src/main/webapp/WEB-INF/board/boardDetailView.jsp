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
	
	<P>board/boardDetailView.jsp</P>
	<h2>글내용보기</h2>
	
	
		<table border="1">
			<tr>
				<th>글번호</th>
				<td >
					${board.num}
				</td>
				<th>조회수</th>
				<td >
					${board.readcount}
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td >
					${board.writer}
				</td>
				<th>작성일</th>
				<td >
					<fmt:parseDate  value="${board.reg_date}" var="date" pattern="yyyy-MM-dd"/>
					<fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
				</td>
			</tr>
			<tr>
				<th>글제목</th>
				<td colspan="3">
					${board.subject}
				</td>
			</tr>
			<tr>
				<th>글내용</th>
				<td colspan="3">
					${board.content}
				</td>
			</tr>
			<tr>
				<td colspan="4">
 					<input type="button" value="글수정" onclick="location.href='update.bd?num=${board.num}&pageNumber=${pageNumber}&whatColumn=${whatColumn}&keyword=${keyword}'">
					<input type="button" value="글삭제" onclick="location.href='delete.bd?num=${board.num}&pageNumber=${pageNumber}&whatColumn=${whatColumn}&keyword=${keyword}'">
					<input type="button" value="답글쓰기" onclick="location.href='reply.bd?ref=${board.ref}&re_step=${board.re_step}&re_level=${board.re_level}&pageNumber=${pageNumber}&whatColumn=${whatColumn}&keyword=${keyword}'">
					<input type="button" value="목록보기" onclick="location.href='list.bd?pageNumber=${pageNumber}&whatColumn=${whatColumn}&keyword=${keyword}'">
				</td>
			</tr>
		</table>
	
	
	