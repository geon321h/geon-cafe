<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	list.jsp<br>
		
	<style type="text/css">
		table {
			font-family: "나눔스퀘어 네오";
			border-collapse: collapse;
			border-color: #a9a9a9;
		}
		
		td{
			padding: 20px 20px;
			text-align: center;
		}
		tr:first-child td{
			font-weight: bold;
			background-color: teal;
		}
	</style>
	
	<table border="1">
    	<tr>
    		<td>번호</td>
    		<td>아이디</td>
    		<td>비번</td>
    		<td>우승국가</td>
    		<td>16강국가</td>
    		<td>수정</td>
    		<td>삭제</td>
    	</tr>
    	<c:forEach var="list" items="${lists}">
	    	<tr>
	    		<td>${list.num}</td>
	    		<td>${list.id}</td>
	    		<td>${list.pw}</td>
	    		<td>${list.win}</td>
	    		<td>${list.round16}</td>
	    		<td><a href="updateForm?num=${list.num}">수정</a></td>
    			<td><a href="delete?num=${list.num}">삭제</a></td>
	    	</tr>
    	</c:forEach>
    </table>
    
 <a href="insertForm">삽입</a>