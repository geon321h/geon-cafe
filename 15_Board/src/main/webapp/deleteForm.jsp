<%@page import="board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="style.css"> 
<style type="text/css">
    table {
        width: 500px;
    }

    tr:first-child td,tr:nth-child(3) td{
	    background-color: #AFEEEE;
        font-size: 16px;
    }
    
    tr:nth-child(2) td input{
    	height: 30px;
    	width: 100px;
    }
    
    input, textarea{
    	font-family: "나눔스퀘어 네오" , "@맑은 고딕";
    	padding: 5px;
    }
    
    tr:last-child td input{
    	width:60px;
    	height:30px;
    	background-color: white;
    	border:1px solid white;  
    	border-radius: 5px;
        font-family: "나눔스퀘어 네오" , "@맑은 고딕";
        margin-left: 10px;
    }
</style>

<script type="text/javascript">
	function check() {
   		if(delForm.passwd.value == ""){
   			alert("비밀번호를 입력하세요.");
   			delForm.passwd.focus();
   			return false;
   		}
	}
</script>

     <%
    	String num = request.getParameter("num");
     	String pageNum = request.getParameter("pageNum");
     	//System.out.println(num);
    %>

<%@include file="color.jsp" %>
<body bgcolor="<%=bodyback_c%>">
    <form action="deleteProc.jsp?num=<%=num%>&pageNum=<%=pageNum%>" method="post" name="delForm">
        <p>글삭제</p>
        <table>
            <tr>
                <td >
                    비밀번호를 입력해 주세요.
                </td>
            </tr>
            <tr>
                <td>
                    비밀번호 : <input type="password" name="passwd" maxlength="12">
                </td>
            </tr>
            <tr >
                <td >
                    <input type="submit"  value="글삭제" onClick="return check()">
                    <input type="button"  value="글목록" onClick="location.href='list.jsp?pageNum=<%=pageNum%>'">
                </td>
            </tr>
        </table>
    </form>
</body>
