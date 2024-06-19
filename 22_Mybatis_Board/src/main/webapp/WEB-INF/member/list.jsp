<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@include file="../common/common.jsp" %>

	<style type="text/css">
		body {
			font-family:  "나눔스퀘어 네오";
			text-align: center;
		}
		table {
			margin: 0 auto;
			border-collapse: collapse;
		}
		
		tr:first-child td  {
			text-align: right;
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
			location.href = "insert.mb";
		}
		function goUpdate(num,pageNumber,whatColumn,keyword){
			location.href="update.mb?num="+num+"&pageNumber="+pageNumber+"&whatColumn="+whatColumn+"&keyword="+keyword;
		}
	</script>
	
	<body>
		<a href="<%=request.getContextPath()%>/main.jsp">메인페이지</a>
		<p>member/list.jsp</p>
		<h2>회원 목록 보기</h2>
		
		<form action="list.mb" method="get">
			<select name="whatColumn">
				<option value="all" >전체 검색</option>
				<option value="name" <c:if test="${whatColumn=='name'}"> selected </c:if>>이름</option>
				<option value="gender" <c:if test="${whatColumn=='gender'}"> selected </c:if>>성별</option>
			</select>
			<input type="text" name="keyword" value="<c:if test="${keyword != 'null'}">${keyword}</c:if>">
			<input type="submit"  value="검색">
		</form>
		
		<table border="1">
			<tr>
				<td colspan="9">
					<button onclick="insert()">추가하기</button>
				</td>
			</tr>
			<tr>
				<th>번호</th>
				<th>이메일</th>
				<th>이름</th>
				<th>비밀번호</th>
				<th>성별</th>
				<th>취미</th>
				<th>직업</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
			<c:forEach var="member" items="${memberList}">
				<tr>
					<td>${member.num}</td>
					<td>${member.email}</td>
					<td>${member.name}</td>
					<td>${member.password}</td>
					<td>${member.gender}</td>
					<td>${member.hobby}</td>
					<td>${member.job}</td>
					<td><a href="delete.mb?num=${member.num}&pageNumber=${pageInfo.pageNumber}&whatColumn=${whatColumn}&keyword=${keyword}">삭제</a></td>
					<td><input type="button" value="수정" onclick="goUpdate('${member.num}',${pageInfo.pageNumber},'${whatColumn}','${keyword}')"></td>
				</tr>
			</c:forEach> 
		</table>		
		<br><br>
		${pageInfo.pagingHtml}
	</body>