<%@page import="myPkg.BookBeen"%>
<%@page import="myPkg.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    updateForm.jsp<br>
    
    <%
	    request.setCharacterEncoding("UTF-8");
    
	   int bid = Integer.parseInt(request.getParameter("bid"));
	   
	   BookDao bDao = new BookDao();
	   BookBeen bb = bDao.getBookBybid(bid);
	   
	   String[] delivery_price = {"유료","무료"};
	   String[] bookstore = {"kyobo","aladin","yes24","interpark"};
    %>

    <script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
	
		$(function(){
			let use = "";
			let isCheck = true;
			$('#titleCheck').click(function(){
				isCheck = true;
				$.ajax({
                    url : "title_check_Proc.jsp", // 요청 URL
                    data : ({
						usertitle : $('input[name="title"]').val() // ; 하지 않기 usertitle에 title value넣어서 보내기 
					}),
					success : function(data) {
						if($('input[name="title"]').val()=="<%=bb.getTitle()%>"){
							$('#titleMessage').html("등록 가능합니다.").css('color','green');
							use = 'possible';
						}else if($('input[name="title"]').val()==""){
							$('#titleMessage').html("입력이 누락됐습니다.").css('color','red');
							use = 'missing';
							// $('#titleMessage').show();
						}else if($.trim(data) == "NO"){
							$('#titleMessage').html("이미 등록된 도서입니다.").css('color','red');
							use = 'impossible';
						}else{
							$('#titleMessage').html("등록 가능합니다.").css('color','green');
							use = 'possible';
						}
					}
                });
				
			})
			$('input[name="title"]').keydown(function(){
				// $('#titleMessage').css('display','none');
				isCheck = false;
				$('#titleMessage').empty();
			})

			$('#sub').click(function(){
				if(!isCheck){
					alert("중복체크를 해주세요.");
					return false;
				}else if(use == 'missing'){
					alert("제목 누락되었습니다.");
					$('input[name="title"]').focus();
					return false;
				}else if(use == "impossible"){
					alert("이미 등록된 도서입니다.");
					$('input[name="title"]').focus();
					return false;
				}
			})
		});
	</script>

 <h1>도서 정보 입력</h1>
	<form name="myform" action="updateProc.jsp?bid=<%=bid %>" method="post">
		<table border=1>
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="title" value="<%=bb.getTitle()%>">
					<input type="button" id="titleCheck" value="중복체크">
					<span id="titleMessage"></span>
				</td>
			</tr>
			<tr>
				<td>저자</td>
				<td><input type="text" name="author" value="<%=bb.getAuthor()%>">
			</tr>
			<tr>
				<td>출판사</td>
				<td><input type="text" name="publisher" value="<%=bb.getPublisher()%>">
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="price" value="<%=bb.getPrice()%>">
			</tr>
			<tr>
				<td>입고일</td>
				<td><input type="date" name="reg_date" value="<%=bb.getReg_date()%>">
			</tr>

			<tr>
				<td>배송비</td>
				<td>
					<%
						for(String d : delivery_price){
					%>
						<%=d%><input type="radio" name="delivery_price" value="<%=d%>" <%if(bb.getDelivery_price().equals(d)){%> checked  <%} %>>	
					<%
						}
					%>
				</td>
			</tr>
			<tr>
				<td>구입가능 서점</td>
				<td>
					<%
					for(int i = 0 ; i < bookstore.length; i++){
					%>
						<%=bookstore[i]%><input type="checkBox" name="bookstore" value="<%=bookstore[i]%>" <%if(bb.getBookstore().contains(bookstore[i])){ %> checked <%} %>>
					<%
					}
				%>
				</td>
			</tr>
			<tr>
				<td>보유수량</td>
				<td><select name="quantity" id="quantity">
						<option value="선택">선택
						<%
						for(int i=1;i<=5;i++){
						%>
							<option value="<%=i%>" <%if(bb.getQuantity() == i){ %> selected <% } %> ><%=i%></option>
						<%
						}
						%>
				</select></td>
			</tr>

		</table>
		<br> <input type="submit" value="전송" id="sub"> 
		<input type="reset"	value="취소">
	</form>
    