<%@page import="myPkg.StudentBean"%>
<%@page import="myPkg.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
	    request.setCharacterEncoding("UTF-8");
		int num = Integer.parseInt(request.getParameter("num"));
		
		StudentDao sDao = new StudentDao();
		StudentBean sb = sDao.getStudentByNum(num);
	
		String[] hobby = {"달리기","수영","등산","영화"};
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
			border: 1px solid #00008B;
			color: #00008B;
			border-radius : 5px;
			background-color : white;
		}
		
		#sub {
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
	
	</style>

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
		$(function(){
			let use = "";
			let isCheck = false;
			let isBlack = false;
			$('#idCheck').click(function(){
				isBlack = false;
				isCheck = true;
				$.ajax({
                    url : "id_check_Proc.jsp",
                    data : ({
                    	userId : $('input[name="id"]').val()
					}),
					success : function(data) {
						
						if($('input[name="id"]').val()==""){
							$('#idMessage').html("아이디를 입력해주세요.").css('color','red');
							isBlack = true;
						}else if("<%=sb.getId()%>" == $('input[name="id"]').val()){
							$('#idMessage').html("등록 가능한 아이디입니다.").css('color','green');
							use = 'possible';
						}else if($.trim(data) == "NO"){
							$('#idMessage').html("이미 등록된 아이디입니다.").css('color','red');
							use = 'impossible';
						}else{
							$('#idMessage').html("등록 가능한 아이디입니다.").css('color','green');
							use = 'possible';
						}
					}
                });
			})
			$('input[name="id"]').keydown(function(){
				isCheck = false;
				$('#idMessage').empty();
			})

			$('#sub').click(function(){
				if(!isCheck){
					alert("아이디 중복체크를 해주세요.");
					return false;
				}else if(isBlack){
					alert("아이디를 입력해주세요.");
					$('input[name="id"]').focus();
					return false;
				}else if(use == "impossible"){
					alert("이미 등록된 아이디입니다.");
					$('input[name="id"]').focus();
					return false;
				}
			})
		});
	</script>

	<form name="myform" action="updateProc.jsp?num=<%=num%>" method="post">
		<h2>회원수정updateForm.jsp</h2>
		<table border=1>
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id" size="15" value="<%=sb.getId()%>">
					<input type="button" id="idCheck" value="중복체크"><br>
					<span id="idMessage"></span>
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="passwd" size="15" value="<%=sb.getPasswd()%>">
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" size="15" value="<%=sb.getName()%>">
			</tr>
			<tr>
				<td>생년월일</td>
				<td>
					<select name="year" id="year">
					<%
						for(int i=1930;i<=2024;i++){
						%>
							<option value="<%=i%>" <%if(i==sb.getYear()){%>selected<%} %>><%=i%></option>
						<%
						}
					%>
					</select>
					년
					<select name="month" id="month">
					<%
						for(int i=1;i<=12;i++){
						%>
							<option value="<%=i%>" <%if(i==sb.getMonth()){%>selected<%} %>><%=i%></option>
						<%
						}
					%>
					</select>
					월
					<select name="day" id="day">
					<%
						for(int i=1;i<=31;i++){
						%>
							<option value="<%=i%>" <%if(i==sb.getDay()){%>selected<%} %>><%=i%></option>
						<%
						}
					%>
					</select>
					일
				</td>
			</tr>
			<tr>
				<td>취미</td>
				<td> 
					 <%
					for(int i = 0 ; i < hobby.length; i++){
					%>
						<input type="checkBox" name="hobby" value="<%=hobby[i]%>" <%if(sb.getHobby().contains(hobby[i])){%>checked<%} %> ><%=hobby[i]%>
					<%
					}
					%>
				</td>
			</tr>
			<tr>
				<td>점수입력</td>
				<td>
					<span>C언어 : </span><input type="text" name="c" size="15" value="<%=sb.getC()%>">
					<br>
					<span>JAVA : </span><input type="text" name="java" size="15" value="<%=sb.getJava()%>">
					<br>
					<span>JSP : </span><input type="text" name="jsp" size="15" value="<%=sb.getJsp()%>">
				</td>
			</tr>

		</table>
		<br> 
		<input type="submit" value="수정하기" id="sub"> 
	</form>
    