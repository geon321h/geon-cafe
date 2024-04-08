<%@page import="java.util.ArrayList"%>
<%@page import="myPkg.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<jsp:useBean id="sdao" class="myPkg.StudentDao"/>

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

<form name="myform" action="deleteAll.jsp" >
	<table border="1">
		<tr>
			<th><input type="checkbox" name="checkAll" id="" onclick="deleteAll(this)"></th>
			<th>번호</th>
			<th>아이디</th>
			<th>비번</th>
			<th>이름</th>
			<th>생년월일</th>
			<th>취미</th>
			<th>c언어</th>
			<th>JAVA</th>
			<th>JSP</th>
			<th>합계</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<% 
		 ArrayList<StudentBean> lists = sdao.getAllStudents();
			for(StudentBean sb : lists){
			%>
			<tr>
				<td><input type="checkbox" name="rowcheck" value="<%=sb.getNum()%>"></td>
				<td><%=sb.getNum()%></td>
				<td><%=sb.getId()%></td>
				<td><%=sb.getPasswd()%></td>
				<td><%=sb.getName()%></td>
				<td><%=sb.getYear()%>-<%=sb.getMonth()%>-<%=sb.getDay()%></td>
				<td><%=sb.getHobby()%></td>
				<td><%=sb.getC()%></td>
				<td><%=sb.getJava()%></td>
				<td><%=sb.getJsp()%></td>
				<td><%=sb.getSum()%></td>
				
				<td><a href="updateForm.jsp?num=<%=sb.getNum()%>">수정</a></td>
				<td><a href="deleteProc.jsp?num=<%=sb.getNum()%>">삭제</a></td>
				</tr>
				<%
			}
			%>
	</table>
	<div>
		<input type="button" onclick="pageMove('insertForm.jsp')" value="삽입">	
		<input type="button" onclick="selectDelete()" value="삭제">	
	</div>
</form>
			
			
			
			
			