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
		
		tr:first-child td  {
			text-align: right;
			background-color: #AFEEEE;
		}
		
		tr th {
			background-color: #AFEEEE;
		}
		
		th, td {
			padding: 15px 20px;
			text-align: center;
		}
		
		td{
			font-size: 14px;
		}
	</style>
	
	<script type="text/javascript">
		function insert() {
			location.href = "insert.bd";
		}
	</script>
	
	<body>
		<p>board/list.jsp</p>
		<h2>게시판 목록보기</h2>
		
		<form action="list.bd" method="get">
			<select name="whatColumn">
				<option value="all" >전체 검색</option>
				<option value="writer" <c:if test="${whatColumn=='writer'}"> selected </c:if>>작성자</option>
				<option value="subject" <c:if test="${whatColumn=='subject'}"> selected </c:if>>제목</option>
			</select>
			<input type="text" name="keyword" value="<c:if test="${keyword != 'null'}">${keyword}</c:if>">
			<input type="submit"  value="검색">
		</form>
		
		<table border="1">
			<tr>
				<td colspan="6">
					<button onclick="insert()">추가하기</button>
				</td>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>ip</th>
			</tr>
<%-- 			<c:set var="pnum" value="${number}"></c:set> --%>
			<c:forEach var="board" items="${boardList}" varStatus="vs">
				<tr> 
					<td>${pageInfo}</td>
<%-- 					<c:set var="pnum" value="${pnum-1}"></c:set> --%>
					<td>
						<a href="">${board.subject}</a>
					</td>
					<td>${board.writer}</td>
					<fmt:parseDate  value="${board.reg_date}" var="date" pattern="yyyy-MM-dd"/>
					<td><fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/></td>
					<td>${board.readcount}</td>
					<td>${board.ip}</td>
				</tr>
			</c:forEach> 
		</table>		
		<br><br>
		${pageInfo.pagingHtml}
	</body>