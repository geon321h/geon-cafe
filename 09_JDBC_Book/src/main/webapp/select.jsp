<%@page import="myPkg.BookBeen"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    select.jsp<br>

<jsp:useBean id="bdao" class="myPkg.BookDao"/>

<style type="text/css">

	table{
		margin: auto;		
		border-collapse: collapse;
		border-color: #a9a9a9;
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

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	function pageMove(locat){
		location.href=locat;
	}
	function allDelete(obj){ // this로 준 요소(이름이 allcheck인 체크박스 인풋 자체)

		let rcheck = document.getElementsByName("rowcheck"); // 이름이 rowcheck인 요소를 가져옴
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
	function selectDelete(locat){
		let rcheck = document.getElementsByName("rowcheck"); 
		let flag = false;
		for(let i=0;i<rcheck.length;i++){
			if(rcheck[i].checked){
				flag=true;
				break;
			}
		}
		if(flag){
			// pageMove(locat);
			document.myform.submit();
		}else{
			alert("삭제할 항목을 1개 이상 선택해주세요.");
			return;
		}

	}
</script>

<form name="myform" action="deleteAll.jsp">
	<input type="button" onclick="selectDelete('deleteAll.jsp')" value="삭제">	
	<input type="button" onclick="pageMove('insertForm.jsp')" value="추가">	
	<table border="1">
		<tr>
			<th><input type="checkbox" name="allcheck" id="" onclick="allDelete(this)"></th> <!--this는 클릭한 요소의 정보-->
			<th>번호</th>
			<th>제목</th>
			<th>저자</th>
			<th>출판사</th>
			<th>가격</th>
			<th>입고일</th>
			<th>배달비</th>
			<th>구입가능 서점</th>
			<th>보유수량</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<% 
		 ArrayList<BookBeen> lists = bdao.getAllBook();
			for(BookBeen bb : lists){
			%>
			<tr>
				<td><input type="checkbox" name="rowcheck" value="<%=bb.getBid() %>"></td>
				<td><%=bb.getBid() %></td>
				<td><%=bb.getTitle() %></td>
				<td><%=bb.getAuthor() %></td>
				<td><%=bb.getPublisher() %></td>
				<td ><%=bb.getPrice() %></td>
				<td><%=bb.getReg_date() %></td>
				<td><%=bb.getDelivery_price() %></td>
				<td><%=bb.getBookstore()%></td>
				<td><%=bb.getQuantity() %></td>
				<td><a href="updateForm.jsp?bid=<%=bb.getBid() %>">수정</a></td>
				<td><a href="deleteProc.jsp?bid=<%=bb.getBid() %>">삭제</a></td>
				</tr>
				<%
			}
			%>
	</table>
</form>
			
			
			
			
			