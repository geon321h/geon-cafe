<%@page import="myPkg.EmplBeen"%>
<%@page import="java.util.ArrayList"%>
<%@page import="myPkg.EmplDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--     
    <%
    	EmplDao ed = new EmplDao();
    %>
--%>

<!-- 1단계 -->
<jsp:useBean id="edao" class="myPkg.EmplDao"/>

<style type="text/css">
	table{
		margin: auto;		
		border : 3px solid blue;
	}
	table th {
		background-color: yellow;
	}

	th, td {
		text-align: center;
		padding: 5px 20px;
	}
	td:nth-child(6) {
		text-align: right;
		padding: 5px 5px;
	}

</style>

<script type="text/javascript">
	function pageMove(locat){
		location.href=locat;
	}
	
	function allDelete(obj){

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

<form name="myform" action="deleteAll.jsp">
	<input type="button" onclick="selectDelete()" value="삭제">	
	<input type="button" onclick="pageMove('insertForm.jsp')" value="추가">	
	<table border="1">
		<tr>
			<th><input type="checkbox" name="allcheck" id="" onclick="allDelete(this)"></th>
			<th>아이디</th>
			<th>이름</th>
			<th>부서번호</th>
			<th>급여</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
	<% 
		ArrayList<EmplBeen> lists = edao.getAllEmpl();
		for(EmplBeen eb : lists){
	%>
		<tr>
			<td><input type="checkbox" name="rowcheck" value="<%=eb.getEid() %>"></td>
			<td><%=eb.getEid() %></td>
			<td><%=eb.getName() %></td>
			<td><%=eb.getDept() %></td>
			<td><%=eb.getSalary() %></td>
			<td><a href="updateForm.jsp?eid=<%=eb.getEid() %>">수정</a></td>
			<td><a href="deleteProc.jsp?eid=<%=eb.getEid() %>">삭제</a></td>
		</tr>
	<%
		}
	%>
	</table>
</form>

