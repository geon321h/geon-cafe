<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    	<!-- myshop/member/register.jsp -->
    	
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/script.js"></script>
    <link rel="stylesheet" type="text/css" href="../../style.css"> 
	<style type="text/css">
		td:nth-child(2) {
			text-align: left;
		}
		
		tr td:first-child {
			background-color: yellow;
		}
	
		.title{
			background-color: orange !important; 
			font-size: 18px;
			text-align: center;
		}
		

	</style>

    <body >
        <form action="registerPro.jsp" method="post">
            <table border="1" >
                <tr>
                    <td colspan="2" class="title">기본 정보</td>
                </tr>
                <tr>
                    <td>* 회원 아이디</td>
                    <td>
                        <input type="text" name="id" maxlength="12">
                        <input type="button"  value="중복체크" onclick="duplicate()">
                        <span id="idMessage"></span>
                    </td>
                </tr>
                <tr>
                    <td>* 비밀 번호</td>
                    <td>
                        <input type="password" name="password" maxlength="8" onblur="pwcheck()">
                        <span>영문 소문자/숫자 조합 3~8자</span>
                    </td>
                </tr>
                <tr>
                    <td>* 비밀 번호 확인</td>
                    <td>
                        <input type="password" name="repassword" maxlength="12" onkeyup="repasswordCheck()">
                        <span id="pwMessage"></span>
                    </td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td>
                        <input type="text" name="email" maxlength="20">
                    </td>
                </tr> 
				 <tr>
                    <td colspan="2" class="title">개인 신상 정보</td>
                </tr>
                <tr>
                    <td>한글 이름</td>
                    <td>
                        <input type="text" name="name" maxlength="30">
                        <span>성과 이름을 붙여주세요 (예)홍길동</span>
                    </td>
                </tr>
                <tr>
                    <td>주민 등록 번호</td>
                    <td>
                        <input type="text" name="rrn1" maxlength="6" size="6">
                        <span>-</span>
                        <input type="text" name="rrn2" maxlength="7" size="7">
                    </td>
                </tr>
                <tr>
                    <td>휴대 전화 번호</td>
                    <td>
                    	<select name="hp1">
                    		<option value="010">010</option>
                    		<option value="011">010</option>
                    	</select>
                    	<span>-</span>
                        <input type="text" name="hp2" maxlength="4" size="4">
                        <span>-</span>
                        <input type="text" name="hp3" maxlength="4" size="4">
                        <span>예) 011-000-0000</span>
                    </td>
                </tr>
                <tr>
                    <td>가입일자</td>
                    <td>
                        <input type="text" name="joindate" maxlength="20" size="10">
                        <span>예) 2000/05/22</span>
                    </td>
                </tr>                                
                <tr >
                    <td colspan="2" class="title">
                        <input type="submit" id="checkSub" value="가입 하기" onclick="return writeSave()">
                        <input type="button"  value="취소" onclick="location.href='../../main.jsp'">
                    </td>
                </tr>
            </table>
        </form>
    </body>