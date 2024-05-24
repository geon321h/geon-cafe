<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	PersonForm.jsp <br>

    <form action="person" method="post">
        <table border="1">
            <tr>
                <td>이름</td>
                <td>
                    <input type="text" name="name">
                </td>
            </tr>
            <tr>
                <td>나이</td>
                <td>
                    <input type="text" name="age">
                </td>
            </tr>
            <tr>
                <td>성별</td>
                <td>
                    <input type="radio" name="gender" value="남자">남자
                    <input type="radio" name="gender" value="여자">여자
                </td>
            </tr>
            <tr>
                <td>취미</td>
                <td>
                    <input type="checkbox" name="hobby" value="낚시">낚시
                    <input type="checkbox" name="hobby" value="요리">요리
                    <input type="checkbox" name="hobby" value="자전거">자전거
                    <input type="checkbox" name="hobby" value="음악듣기">음악듣기
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="전송">
                    <input type="submit" value="취소">
                </td>
            </tr>
        </table>
	</form>


