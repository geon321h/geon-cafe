<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    Ex01_form<br>
    
    <form action="Ex01_proc.jsp" method="post" enctype="multipart/form-data">

        이름 : <input type="text" name="name" id=""><br>
        파일 : <input type="file" name="filename" id=""><br>

        <input type="submit" value="전송">

    </form>
    
    
    <!-- 파일 전송 
    method="post"
    enctype="multipart/form-data"
    jar 파일 cos.jar -->
    
