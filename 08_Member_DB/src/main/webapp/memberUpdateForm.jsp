<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    memberUpdateForm.jsp<br>

    <form action="update.mem" method="post" name="myform">
       	<input type="hidden" name="id" value="${mb.id}">
        <table border="1" align="center" width="60%">
            <tr>
                <td width="30%">이름</td>
                <td width="70%">
                    <input type="text" name="name" value="${mb.name}">
                </td>
            </tr>
            <tr>
                <td width="30%">비밀번호</td>
                <td width="70%">
                    <input type="password" name="password" value="${mb.password}">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="전송">
                </td>
            </tr>
        </table>
    </form>
    
    