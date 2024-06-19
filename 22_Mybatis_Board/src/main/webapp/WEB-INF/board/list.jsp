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
		
		.subject_text a{
			text-decoration: none;
			color: black;
		}
		
	</style>
	
	<script type="text/javascript">
		function insert() {
			location.href = "insert.bd";
		}
	</script>
	
	<body>
		<a href="<%=request.getContextPath()%>/main.jsp">메인페이지</a>
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
			<c:set var="Bnumber" value="${pageInfo.number}"/>
			<c:forEach var="board" items="${boardList}" varStatus="vs">
				<tr> 
					<td>${Bnumber}</td>
					<c:set var="Bnumber" value="${Bnumber-1}"/>
					<td style="text-align: left;" class="subject_text">
						<c:if test="${board.re_level>0}">
							<c:set var="wid" value="${20*board.re_level}"></c:set>
                            <img src="<%=request.getContextPath()%>/resources/images/level.gif" width="${wid}" height="15">
					        <img src="<%=request.getContextPath()%>/resources/images/re.gif">
						</c:if>
						<a href="detailView.bd?num=${board.num}&pageNumber=${param.pageNumber}&whatColumn=${param.whatColumn}&keyword=${param.keyword}">${board.subject}</a>
						<c:if test="${board.readcount>=10}">
								<img src="<%=request.getContextPath()%>/resources/images/hot.gif">
						</c:if>
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