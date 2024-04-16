<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/script.js"></script>
    <link rel="stylesheet" type="text/css" href="../../style.css"> 
	<style type="text/css">
		h2{
			margin: 50px 0px 30px 0px;
		}
	
		tr td:first-child {
			background-color: yellow;
		}
		
		tr td:nth-child(1){
			padding: 15px 10px;
		}
		
		tr td:nth-child(2){
			padding: 5px;
		}
		
		tr td:nth-child(2) input{
			height: 35px;
		}
		
		tr:last-child td {
			padding: 5px 10px;
			background-color: orange;
        }
	</style>

    <body >
        <form action="findpwdProc.jsp" method="post">
        	<h2>[비번 찾기]</h2>
            <table border="1">
                 <tr>
                    <td>아이디</td>
                    <td>
                        <input type="text" name="id" maxlength="12" size="20">
                    </td>
                </tr>
                <tr>
                    <td>이름</td>
                    <td>
                        <input type="text" name="name" maxlength="30" size="20">
                    </td>
                </tr>
                <tr>
                    <td>주민 등록 번호</td>
                    <td>
                        <input type="text" name="rrn1" maxlength="6" size="6" onkeyup="rrnAuto()">
                        <span>-</span>
                        <input type="text" name="rrn2" maxlength="7" size="7">
                    </td>
                </tr>
                <tr >
                    <td colspan="2">
                        <input type="submit"  value="아이디 찾기">
                    </td>
                </tr>
            </table>
        </form>
    </body>