<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

    <table border="1">
    	<tr>
    		<td>번호</td>
    		<td>아이디</td>
    		<td>이름</td>
    		<td>나이</td>
    		<td>수정</td>
    		<td>삭제</td>
    	</tr>
    	<c:forEach var="list" items="${lists}">
	    	<tr>
	    		<td>${list.num}</td>
	    		<td>${list.id}</td>
	    		<td>${list.name}</td>
	    		<td>${list.age}</td>
	    		<td><a href="updateForm?num=${list.num}">수정</a></td>
    			<td><a href="delete?num=${list.num}">삭제</a></td>
	    	</tr>
    	</c:forEach>
    </table>
    
    <table border="1">
    	<tr>
    		<td>번호</td>
    		<td>아이디</td>
    		<td>이름</td>
    		<td>나이</td>
    		<td>수정</td>
    		<td>삭제</td>
    	</tr>
    	<c:forEach var="i" begin="" end="${fn:length(lists)-1}" step="1">
	    	<tr>
	    		<td>${lists[i].num}</td>
	    		<td>${lists[i].id}</td>
	    		<td>${lists[i].name}</td>
	    		<td>${lists[i].age}</td>
	    		<td><a href="updateForm?num=${lists[i].num}">수정</a></td>
    			<td><a href="delete?num=${lists[i].num}">삭제</a></td>
	    	</tr>
    	</c:forEach>
    </table>
    
 <a href="insertForm">삽입</a>