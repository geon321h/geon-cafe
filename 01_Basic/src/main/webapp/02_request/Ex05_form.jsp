<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

        <form method="GET" action="Ex05_result.jsp">
        폼에 데이터를 입력한 후 '전송' 버튼을 클릭하세요.
        <br>
        이름: <input type="text" name="name">
        <br>
        주소: <input type="text" name="addr">
        <br>
        좋아하는 계절: 
        봄<input type="radio" name="season"value="봄">
        여름<input type="radio" name="season"value="여름">
        가을<input type="radio" name="season"value="가을">
        겨울<input type="radio" name="season"value="겨울">
        <br>
        <br>좋아하는 동물: 
        <input type="checkbox" name="animal"value="강아지">강아지
        <input type="checkbox" name="animal"value="토끼">토끼
        <input type="checkbox" name="animal"value="돼지">돼지
        <br><br>
         좋아하는 과일: <select name="fruit" >
 			<option value="apple">사과
 			<option value="banana">바나나
 			<option value="grape">포도
 			<option value="orange">오렌지
 		</select>
 		<br>
        <input type="submit" value="전송">
    </form>