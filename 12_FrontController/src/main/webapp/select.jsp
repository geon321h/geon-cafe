<%@page import="myPkg.MovieDao"%>
<%@page import="myPkg.MovieBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%
	MovieDao mdao = MovieDao.getMovieInstance();
	System.out.println("select.jsp mdao: " + mdao);
%>

<style type="text/css">

	*{
		font-family: "나눔스퀘어 네오" , "@맑은 고딕";
	}

	table{
		margin: auto;		
		margin-top : 50px;
		border-collapse: collapse;
		border-color: #a9a9a9;
	}
	table th {
		background-color: yellow;
	}

	th {
		text-align: center;
		padding: 10px 20px;
	}
	
	td{
		text-align: center;
		padding: 20px 20px;
	}
	
	div {
		margin: 20px 0px;	
		display: flex;
		justify-content: center;
	}
	
	div input {
		width : 60px;
		height : 30px;
		font-weight : bold;
		border: 1px solid #4d4d4d;
		border-radius : 5px;
		background-color : white;
		margin : 0px 5px;	
	}

</style>

	<script type="text/javascript">
		function pageMove(locat){
			location.href=locat;
		}
		
		function deleteAll(obj){ 
			let rcheck = document.getElementsByName("rowcheck"); 
			let check = obj.checked;
			if(check){
				for(let i=0;i<rcheck.length;i++){
					rcheck[i].checked = true;
				}
			}else{
				for(let i=0;i<rcheck.length;i++){
					rcheck[i].checked = false;
				}
			}
		}
		
		function selectDelete(){
			let rcheck = document.getElementsByName("rowcheck"); 
			let flag = false;
			for(let i=0;i<rcheck.length;i++){
				if(rcheck[i].checked){
					flag=true;
					console.log(rcheck[i]);
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

<form name="myform" action="deleteAll.mv" >
	<table border="1">
		<tr>
			<th><input type="checkbox" name="checkAll" id="" onclick="deleteAll(this)"></th>
			<th>번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>나이</th>
			<th>좋아하는 장르</th>
			<th>즐겨보는 시간대</th>
			<th>동반관객수</th>
			<th>개선사항</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
			<c:forEach var="list" items="${lists}">
			<tr>
				<td><input type="checkbox" name="rowcheck" value="${list.num}"></td>
				<td>${list.num}</td>
				<td>${list.id}</td>
				<td>${list.name}</td>
				<td>${list.age}</td>
				<td>${list.genre}</td>
				<td>${list.time}</td>
				<td>${list.partner}</td>
				<td>${list.memo}</td>				
				<td><a href="updateForm.mv?num=${list.num}">수정</a></td>
				<td><a href="delete.mv?num=${list.num}">삭제</a></td>
				</tr>
			</c:forEach>
	</table>
	<div>
		<input type="button" onclick="pageMove('insertForm.jsp')" value="삽입">	
		<input type="button" onclick="selectDelete()" value="삭제">	
	</div>
</form>
			
			
			
			
			