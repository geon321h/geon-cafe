<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    productList.jsp
  
    
    <style type="text/css">
    	table {
			border-spacing: 0px;
			border: 1px solid #ddd;
			border-width: 1px 1px 0px 1px;
    	}
		tr:first-child {
			background-color: yellow;
		}
		
		table td ,table th{
			padding: 10px 14px;
			font-family: "나눔스퀘어 네오";			
			text-align: center;
			border: solid #ddd;
			border-width: 0px 0px 1px 0px;
		}
	</style>
    
    <table border="1" align="center">
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>제조사</th>
            <th>가격</th>
            <th>입고일자</th>
            <th>삭제</th>
            <th>수정</th>
        </tr>
		<c:forEach var="lists" items="${lists}">
	        <tr>
	            <td>${lists.id}</td>
	            <td>${lists.name}</td>
	            <td>${lists.company}</td>
	            <td>${lists.price}</td>
	            <td>${lists.regdate}</td>
	            <td><a href="delete.prd?id=${lists.id}">삭제</a></td>
	            <td><a href="updateForm.prd?id=${lists.id}">수정</a></td>
	        </tr>
		</c:forEach>
    </table>
	<br>
	<a href="insertForm.jsp">삽입</a>