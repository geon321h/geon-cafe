<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    memberForm.jsp<br>

    <script type="text/javascript">
        function insertData(){
            document.myform.action="insert.mem";
            document.myform.submit();
        }
    </script>


    <form action="" method="post" name="myform">
        <table border="1" align="center" width="60%">
            <tr>
                <td width="30%">이름</td>
                <td width="70%">
                    <input type="text" name="name">
                </td>
            </tr>
            <tr>
                <td width="30%">비밀번호</td>
                <td width="70%">
                    <input type="password" name="password">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <a href="#" onclick="insertData()">회원가입</a>
                </td>
            </tr>
        </table>
    </form>
    
    