<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@include file="top.jsp" %>
	<style type="text/css">
		#cate_input {
			margin-top: 50px;
		}
		#cate_input table{
			width: 400px;
			margin-top: 30px;
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
	    <!-- myshop/admin/cate_input.jsp  -->
	    <form action="cate_proc.jsp" method="post" id="cate_input">
        	<h2>카테고리 등록(cate_proc.jsp)</h2>
            <table border="1">
                <tr>
                    <td>카테고리 코드</td>
                    <td>
                        <input type="text" name="code" maxlength="20">
                    </td>
                </tr>
                <tr>
                    <td>카테고리 이름</td>
                    <td>
                        <input type="text" name="cname" maxlength="50">
                    </td>
                </tr>
                <tr >
                    <td colspan="2">
                        <input type="submit"  value="등록">
                        <input type="reset"  value="취소">
                    </td>
                </tr>
            </table>
        </form>
    </td>
    <%@include file="bottom.jsp" %>