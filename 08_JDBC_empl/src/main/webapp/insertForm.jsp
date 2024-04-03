<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    insertForm.jsp<br>

    <h2>회원 가입</h2>

    <form action="insertProc.jsp" method="post">

        이름 : <input type="text" name="name" id=""><br>
        부서번호 : <select name="dept" id="">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                  </select><br>
        급여 : <input type="text" name="salary" id=""><br>
        <input type="submit" value="보내기">
    </form>
    
    