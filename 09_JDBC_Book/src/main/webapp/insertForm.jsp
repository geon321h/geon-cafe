<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    insertForm.jsp<br>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
		$(function(){
			let use = "";
			let isCheck = false;
			$('#titleCheck').click(function(){
				isCheck = true;
				$.ajax({
                    url : "title_check_Proc.jsp", // 요청 URL
                    data : ({
						usertitle : $('input[name="title"]').val() // ; 하지 않기 usertitle에 title value넣어서 보내기 
					}),
					success : function(data) {
						if($('input[name="title"]').val()==""){
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
	<form name="myform" action="insertProc.jsp" method="post">
		<table border=1>
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="title">
					<input type="button" id="titleCheck" value="중복체크">
					<span id="titleMessage"></span>
				</td>
			</tr>
			<tr>
				<td>저자</td>
				<td><input type="text" name="author">
			</tr>
			<tr>
				<td>출판사</td>
				<td><input type="text" name="publisher">
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="price">
			</tr>
			<tr>
				<td>입고일</td>
				<td><input type="date" name="reg_date">
			</tr>

			<tr>
				<td>배송비</td>
				<td>유료 <input type="radio" name="delivery_price" value="유료"> 
					무료 <input type="radio" name="delivery_price" value="무료">
				</td>
			</tr>
			<tr>
				<td>구입가능 서점</td>
				<td>교보문고 <input type="checkbox" name="bookstore" value="kyobo">
					알라딘 <input type="checkbox" name="bookstore" value="aladin">
					yes24 <input type="checkbox" name="bookstore" value="yes24">
					인터파크 <input type="checkbox" name="bookstore" value="interpark">
			</tr>
			<tr>
				<td>보유수량</td>
				<td><select name="quantity" id="quantity">
						<option value="선택">선택
						<option value="1">1
						<option value="2">2
						<option value="3">3
						<option value="4">4
						<option value="5">5
				</select></td>
			</tr>

		</table>
		<br> <input type="submit" value="전송" id="sub"> 
		<input type="reset"	value="취소">
	</form>
    