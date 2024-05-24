<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 	
 	<%
 	application.setAttribute("flag", false);
 	%>


	<%
		String[] genre = {"다큐","드라마","액션","판타지"};
	
		String[] time = new String[12];
		for(int i=0;i<time.length;i++){
			
			int a = 2*i;
			int b = 2*i+2;
			String timestr = "";
			if(a<10){
				timestr += "0"+a+"~";
			}else{
				timestr += a+"~";
			}
			
			if(b<10){
				timestr += "0"+b;
			}else{
				timestr += b;
			}
			
			time[i] = timestr;
			//System.out.println(time[i]);
			
		}
	%>

	<style type="text/css">

		*{
			font-family: "나눔스퀘어 네오" , "@맑은 고딕";
		}

		form {
			margin: 30px 0px;	
			text-align: center;
		}

		h2 {
			font-weight: 900;
			padding: 20px;
		}

		table{
			margin: auto;		
			border-collapse: collapse;
			border-color: #a9a9a9;
		}
		
		td{
			text-align: center;
			padding: 25px 30px;
		}
		
		td:first-child{
			font-weight: bold;
		}
		
		tr td:last-child{
			text-align: left;
			padding: 25px 20px;
		}
		
		tr:last-child td:last-child span{
			display: inline-block;
			text-align: center;
			width: 60px;
		}
		
		tr:last-child td:last-child input {
			margin: 5px 5px;
		}
		
		#idCheck{
			margin-left: 10px;
			width : 70px;
			height : 25px;
			font-weight : bold;
			border: 1px solid #4B0082;
			color: #4B0082;
			border-radius : 5px;
			background-color : white;
		}
		
		#insertSub {
			width : 80px;
			height : 40px;
			font-weight : bold;
			border: 1px solid #4d4d4d;
			border-radius : 5px;
			background-color : white;
			margin-top : 5px;	
		}
		#listBtn {
			width : 80px;
			height : 40px;
			font-weight : bold;
			border: 1px solid #4d4d4d;
			border-radius : 5px;
			background-color : white;
			margin-top : 5px;	
		}
		
		#idMessage {
			display: block;
			margin-top: 5px;
			font-size: 14px;
		}
		
		textarea {
			width: 100%;
			padding: 10px;
		}

		#textByte {
			text-align: right;
			font-size: 12px;
		}
	
	</style>

	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
		$(function(){
			let possible = false;
			let isCheck = false;
			let isBlack = false;
			
			// 중복 체크 버튼 - 중복 유효 검사 //
			$('#idCheck').click(function(){
				isBlack = false;
				isCheck = true;
				possible = false;
				$.ajax({
                    url : "id_check.mv",
                    data : ({
                    	userId : $('input[name="id"]').val()
					}),
					success : function(data) {
						if($('input[name="id"]').val()==""){
							$('#idMessage').html("아이디를 입력해주세요.").css('color','red');
							isBlack = true;
						}else if($.trim(data) == "NO"){
							$('#idMessage').html("이미 등록된 아이디입니다.").css('color','red');
						}else{
							$('#idMessage').html("등록 가능한 아이디입니다.").css('color','green');
							possible = true;
						}
					}
                });
			})
			
			// 아이디 입력시 - 중복체크 및 메세지 초기화 //
			$('input[name="id"]').keydown(function(){
				isCheck = false;
				$('#idMessage').empty();
			})

			// 가입하기 버튼 - 유효성 재검사 후 출력안내 // 
			$('#insertSub').click(function(){
				if(!isCheck){
					alert("아이디 중복체크를 해주세요.");
					return false;
				}else if(isBlack){
					alert("아이디를 입력해주세요.");
					$('input[name="id"]').focus();
					return false;
				}else if(!possible){
					alert("이미 등록된 아이디입니다.");
					$('input[name="id"]').focus();
					return false;
				}
			})

			// 개선사항 영역 바이트수 체크 //
			let memo_before = "";
			let byte_before = 0;
			$('textarea[name="memo"]').keydown(function(){
				const memo = $('textarea[name="memo"]').val();
				let byte = 0;
				for (let i=0; i<memo.length; i++) {
					byte += (memo.charCodeAt(i) > 128) ? 3 : 1;
				}
				if(byte<=50){
					memo_before = $('textarea[name="memo"]').val();
					byte_before = byte;
				}

			})
			$('textarea[name="memo"]').keyup(function(){
				const memo = $('textarea[name="memo"]').val();
				let byte = 0;
				for (let i=0; i<memo.length; i++) {
					byte += (memo.charCodeAt(i) > 128) ? 3 : 1;
				}
				if(byte>50){
					$('textarea[name="memo"]').val(memo_before);
					$('#textByte').text(byte_before+"/50byte");
				}else{
					$('#textByte').text(byte+"/50byte");
				}
			})
		});
	</script>

	<form name="myform" action="insert.mv" method="post">
		<h2>영화 선호도 조사</h2>
		<table border=1>
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id" size="15">
					<input type="button" id="idCheck" value="중복체크"><br>
					<span id="idMessage"></span>
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" size="15">
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="text" name="age" size="15">
			</tr>
			<tr>
				<td>좋아하는 장르</td>
				<td> 
					<c:forEach var="genre" items="<%=genre %>">
						<input type="checkbox" name="genre" value="${genre }" >${genre }
					</c:forEach>					
				</td>
			</tr>
			<tr>
				<td>즐겨보는 시간대</td>
				<td>
					<select name="time" >
						<c:forEach var="time" items="<%=time %>">
							<option value="${time }" >${time }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>동반관객수</td>
				<td> 
					<c:forEach begin="1" end="5" var="i">
						<input type="radio" name="partner" value="${i }" >${i }
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td>개선사항</td>
				<td>
					<textarea name="memo" rows="6" placeholder="value는 여기에 넣기"></textarea>
					<p id="textByte">0/50byte</p>
				</td>
			</tr>

		</table>
		<br> 
		<input type="submit" value="가입하기" id="insertSub">
		<input type="button" value="목록보기" id="listBtn"  onclick="location.href='select.mv'"> 
	</form>
    