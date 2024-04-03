<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

     <h3>Ex03_form.jsp </h3>
    <form method="GET" action="Ex03_result.jsp">
        이름: <input type="text" name="name"><br>
        나이: <input type="text" name="age"><br>
        성별: <input type="radio" name="gender"value="man">남자<input type="radio" name="gender"value="woman">여자<br>
        취미: <select name="hobby" >
        			<option value="JSP공부">JSP공부
        			<option value="게임">게임
        			<option value="등산">등산
        			<option value="웹툰보기">웹툰보기
        		</select><br><br>
        색 선택: <select name="color">
        			<option value="blue">파랑색
        			<option value="red">빨간색
        			<option value="green">초록색
        			<option value="yellow">기타
        		</select><br><br>
        <input type="submit" value="보내기">
    </form>