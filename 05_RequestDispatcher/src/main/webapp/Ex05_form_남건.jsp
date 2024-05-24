<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    Ex05_form_남건.jsp => FormServlet => Ex05_result_남건.jsp 출력
    
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
			function check() {
				//console.log($("input[name='name']").val());
				
				if($("input[name='name']").val()==""){
					alert("이름을 입력해주세요.");
					$("input[name='name']").focus();
					return false;
				}
				if($("input[name='age']").val()==""){
					alert("나이를 입력해주세요.");
					$("input[name='age']").focus();
					return false;
				}else if(isNaN($("input[name='age']").val())){
					alert("나이는 숫자로 입력해주세요.");
					$("input[name='age']").focus();
					return false;
				}
				
			}
	</script>	 
	 
	<form name="frm" method="get" action="FormServlet">
		이름 : <input type="text" name="name"><br><br>
		나이 : <input type="text" name="age"><br><br>
		성별 : <input type="radio" name="gender" value="남자" checked>남자 
			  <input type="radio" name="gender" value="여자" checked>여자<br><br>
			  
		
		좋아하는 커피 : <input type="checkbox" name="coffee" value="아메리카노" checked>아메리카노
		<input type="checkbox" name="coffee" value="카페라떼">카페라떼
		<input type="checkbox" name="coffee" value="카푸치노">카푸치노
		<input type="checkbox" name="coffee" value="캬라멜 마끼아또">캬라멜 마끼아또
		<br><br>
		<span style="float:left; margin-right:20px">
		직업 :  
			<select name="job">
				<option value="">선택하세요</option>
				<option value="학생">학생</option>
				<option value="언론인">언론인</option>
				<option value="공무원">공무원</option>
				<option value="군인">군인</option>
				<option value="서비스업">서비스업</option>				
			</select>
		</span> 
		
		<label style="float:left;margin-right:10px">여행하고 싶은 나라 : </label>
			<select name="travel" size="3" multiple="multiple"> 
				<option value="영국">영국</option>
				<option value="일본">일본</option>
				<option value="호주">호주</option>
				<option value="그리스">그리스</option>
				<option value="필리핀">필리핀</option>				
			</select><br><br>
		<input type="submit" value="전송" onclick="return check()"><br><br>
		
	</form>