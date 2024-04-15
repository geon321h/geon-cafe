<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	content.jsp(pageNum) => writeForm.jsp

<link rel="stylesheet" type="text/css" href="style.css"> 
<style type="text/css">
    table {
        width: 700px;
    }

	 tr:first-child td{
	    text-align: right;
        font-size: 16px;
    }

    tr td:first-child{
	    background-color: #AFEEEE;
    }

    tr td:nth-child(2){
        padding: 0;
        text-align: left;
	    background-color: white;
	    width: 500px;
    }
    
    tr td:nth-child(2) input{
    	height: 40px;
    	width: 100%;
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

     <%
     	String pageNum = request.getParameter("pageNum");
    %>
    
<%@include file="color.jsp" %>
    <body bgcolor="<%=bodyback_c%>">
        <form action="writeProc.jsp?pageNum=<%=pageNum%>" method="post">
        	<p>글쓰기</p>
            <table>
                <tr>
                    <td colspan="2">
						<a href="list.jsp?pageNum=<%=pageNum%>">글목록</a>
					</td>
                </tr>
                <tr>
                    <td>이름</td>
                    <td>
                        <input type="text" name="writer" maxlength="10">
                    </td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td>
                        <input type="text" name="subject" maxlength="20">
                    </td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td>
                        <input type="text" name="email" maxlength="10">
                    </td>
                </tr>
                <tr>
                    <td>내용</td>
                    <td>
                        <textarea name="content" cols="70" rows="10" maxlength="20"></textarea>
                    </td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td>
                        <input type="password" name="passwd" maxlength="12">
                    </td>
                </tr>
                <tr >
                    <td colspan="2">
                        <input type="submit"  value="글쓰기">
                        <input type="reset"  value="다시작성">
                        <input type="button"  value="목록보기" onclick="location.href='list.jsp?pageNum=<%=pageNum%>'">
                    </td>
                </tr>
            </table>
        </form>
    </body>
    
    