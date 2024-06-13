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
	
	<script type="text/javascript">
		function register(){
			location.href="register.mb";
		}
		function goUpdate(id,pageNumber,whatColumn,keyword){
			location.href="update.mb?id="+id+"&pageNumber="+pageNumber+"&whatColumn="+whatColumn+"&keyword="+keyword;
		}
	</script>

	<a href="<%=request.getContextPath()+"/main.jsp"%>">시작페이지</a>

	<h2>회원 리스트 화면(${pageInfo.totalCount})</h2>
	
	<form action="list.mb" method="get">
		<select name="whatColumn">
			<option value="all" >전체 검색</option>
			<option value="gender" <c:if test="${whatColumn=='gender'}"> selected </c:if>>성별</option>
			<option value="hobby" <c:if test="${whatColumn=='hobby'}"> selected </c:if>>취미</option>
		</select>
		<input type="text" name="keyword" value="<c:if test="${keyword != 'null'}">${keyword}</c:if>">
		<input type="submit"  value="검색">
	</form>
	
	<table border="1">
		<tr>
			<td colspan="9" style="text-align: right;">
				<button onclick="register()">회원가입하기</button>
			</td>
		</tr>
		<tr>
			<th>ID</th>
			<th>이름</th>
			<th>비번</th>
			<th>성별</th>
			<th>취미</th>
			<th>주소</th>
			<th>포인트</th>
			<th>삭제</th>
			<th>수정</th>
		</tr>
		<c:forEach var="member" items="${memberList}">
			<tr>
				<td>${member.id}</td>
				<td><a href="detailView.mb?num=${member.id}&pageNumber=${pageInfo.pageNumber}&whatColumn=${whatColumn}&keyword=${keyword}" >${member.name}</a></td>
				<td>${member.password}</td>
				<td>${member.gender}</td>
				<td>${member.hobby}</td>
				<td>${member.address1} ${member.address2}</td>
				<td>${member.mpoint}</td>
				<td><a href="delete.mb?num=${member.id}&pageNumber=${pageInfo.pageNumber}&whatColumn=${whatColumn}&keyword=${keyword}">삭제</a></td>
				<td><input type="button" value="수정" onclick="goUpdate(${member.id},${pageInfo.pageNumber},'${whatColumn}','${keyword}')"></td>
			</tr>
		</c:forEach>
	</table>
	
	<center>
		${pageInfo.pagingHtml}
	</center>