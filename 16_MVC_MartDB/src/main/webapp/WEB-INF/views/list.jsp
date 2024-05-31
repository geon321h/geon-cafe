<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	list.jsp <br><br><hr><br>
	
	<style type="text/css">
		*{
			text-align: center;
		}
		
		table {
			font-family: "나눔스퀘어 네오";
			border-collapse: collapse;
			border-color: #a9a9a9;
			margin: 0 auto;
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
	
	<script type="text/javascript">

		function checkAll(obj){ 
	
			var rcheck = document.getElementsByName("rowcheck"); 
			var check = obj.checked;
			if(check){
				for(var i=0;i<rcheck.length;i++){
					rcheck[i].checked = true;
				}
			}else{
				for(let i=0;i<rcheck.length;i++){
					rcheck[i].checked = false;
				}
			}
		}
	
		function selectDelete(){
			var rcheck = document.getElementsByName("rowcheck"); 
			var flag = false;
			for(var i=0;i<rcheck.length;i++){
				if(rcheck[i].checked){
					flag=true;
					break;
				}
			}
			if(flag){
				document.myform.submit();
			}else{
				alert("삭제할 항목을 1개 이상 선택해주세요.");
				return;
			}

		}
	
	</script>
	<form name="myform" action="deleteAll">
	<table border="1">
    	<tr>
    		<td><input type="checkbox" name="allcheck" onclick="checkAll(this)"></td>
    		<td>번호</td>
    		<td>아이디</td>
    		<td>비번</td>
    		<td>상품</td>
    		<td>시간대</td>
    		<td>결제</td>
    		<td>동의</td>
    		<td>수정</td>
    		<td>삭제</td>
    	</tr>
    	<c:forEach var="list" items="${lists}">
	    	<tr>
	    		<td><input type="checkbox" name="rowcheck" value="${list.num}"></td>
	    		<td>${list.num}</td>
	    		<td>${list.id}</td>
	    		<td>${list.pw}</td>
	    		<td>${list.product}</td>
	    		<td>${list.time}</td>
	    		<td>${list.approve}</td>
	    		<td>${list.agree}</td>
	    		<td><a href="updateForm?num=${list.num}">수정</a></td>
    			<td><a href="delete?num=${list.num}">삭제</a></td>
	    	</tr>
    	</c:forEach>
    </table>
    </form>
    <input type="button" onclick="selectDelete()" value="삭제">
 <br><a href="form">삽입</a>