<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!-- main.jsp -->

<link rel="stylesheet" type="text/css" href="style.css"> 
<style type="text/css">
	table{
		width: 400px;
	}
	
	h2{
		margin: 100px 0px 50px 0px;
	}

	tr td:first-child {
		background-color: yellow;
	}

    td:nth-child(2) input {
        width: 100%;
    }


</style>

    <body >
        <form action="loginPro.jsp" method="post">
        	<h2>[로그인 화면]</h2>
            <table border="1">
                <tr>
                    <td>아이디</td>
                    <td>
                        <input type="text" name="id" maxlength="12">
                    </td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td>
                        <input type="password" name="password" maxlength="12">
                    </td>
                </tr>
                <tr >
                    <td colspan="2">
                        <input type="submit"  value="로그인">
                        <input type="button"  value="회원가입" onclick="location.href='myshop/member/register.jsp'">
                        <input type="button"  value="아이디 찾기" onclick="location.href='myshop/member/findid.jsp'">
                        <input type="button"  value="비번 찾기" onclick="location.href='myshop/member/findpwd.jsp'">
                    </td>
                </tr>
            </table>
        </form>
    </body>
    
    