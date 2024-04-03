<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript">

		function check(){

			if($('INPUT[name="id"]').val()==""){
				alert('아이디를 입력해주세요.');
				$('input[name="id"]').prev('span').css('color','red');
				$('input[name="id"]').focus();
				return false;
			}
			$('input[name="id"]').prev('span').css('color','black');
			
			if($('input[name="pw"]').val()==""){
				alert('비밀번호를 입력해주세요.');
				$('input[name="pw"]').prev('span').css('color','red');
				$('input[name="pw"]').focus();
				return false;
			}
			$('input[name="pw"]').prev('span').css('color','black');
			
			if(!$('input[name="product"]').is(":checked")){
				$('input[name="product"]').prev('span').css('color','red');
				alert('구매 상품을 선택해주세요.');
				return false;
			}
			$('input[name="product"]').prev('span').css('color','black');
			
			if($('select[name="time"]').val()=="선택"){
				$('select[name="time"]').prev('span').css('color','red');
				alert('배송시간을 선택해주세요.');
				return false;
			}
			$('select[name="time"]').prev('span').css('color','black');
			
			if(!$('input[name="approve"]').is(":checked")){
				$('input[name="approve"]').prev('span').css('color','red');
				alert('결제방법을 선택해주세요.');
				return false;
			}
			$('input[name="approve"]').prev('span').css('color','black');
		}
	</script>

Ex06_form_내이름.jsp<br>

<h2> 상품 구매 내역 </h2>
<FORM name="myform" METHOD="post" ACTION="Ex06_result_남건.jsp">

 <span>아이디 :</span> <INPUT TYPE="text" NAME="id"><br>
 <span>비번 :</span> <INPUT TYPE="text" NAME="pw"><br>
  <p> 
  
 
<span>구매상품:</span>
	<input type="checkbox" name="product" value="식품">식품
	<input type="checkbox" name="product" value="의류">의류
	<input type="checkbox" name="product" value="도서">도서
	<input type="checkbox" name="product" value="가구">가구
<p>

<span>배송시간 :</span> 
 	<SELECT NAME="time">
 		<OPTION VALUE="선택">선택</OPTION>
		<OPTION  VALUE="9시~11시">9시~11시</OPTION>
		<OPTION VALUE="11시~1시">11시~1시</OPTION>
		<OPTION VALUE="1시~5시">1시~5시</OPTION>
		<OPTION VALUE="5시~9시">5시~9시</OPTION>
	</SELECT>
<p>

<span>결제방법:</span>
카드 <INPUT TYPE="radio" NAME="approve" VALUE="카드">
핸드폰 <INPUT TYPE="radio" NAME="approve" VALUE="핸드폰">
<p>
<span>결제 동의합니다. </span>  <INPUT TYPE="checkbox" NAME="agree" id="agree"> 
<p>

<INPUT TYPE="submit" value="보내기" onclick="return check()">
</FORM>



