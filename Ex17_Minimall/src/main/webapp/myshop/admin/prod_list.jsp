<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@include file="top.jsp" %>
	<style type="text/css">
		#cate_input table{
			width: 400px;
		}
		#cate_input h2{
			margin: 30px  0px;
		}
		
		#cate_input tr{
			height: 50px;
		}
	
		#cate_input tr td:first-child {
			background-color: yellow;
		}
	    #cate_input td:nth-child(2) input {
	        width: 100%;
	    }
	</style>
    <td colspan="6" >
	    <!-- myshop/admin/prod_list.jsp 관리자 첫 페이지  -->
	    <form action="" method="post" id="cate_input">
        	<h2>카테고리 등록</h2>
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
    </td>
    <%@include file="bottom.jsp" %>