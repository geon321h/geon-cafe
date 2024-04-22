<%@page import="my.board.BoardBean"%>
<%@page import="my.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 	content.jsp(num,pageNum) => updateForm.jsp -->
<%@include file="../mall_top.jsp" %>
<link rel="stylesheet" type="text/css" href="style2.css"> 
<style type="text/css">
    #mainContent table {
        width: 700px;
    }

	 #mainContent tr:first-child td{
	    text-align: right;
        font-size: 16px;
    }

    #mainContent tr td:first-child{
	    background-color: #AFEEEE;
    }

    #mainContent tr td:nth-child(2){
        padding: 0;
        text-align: left;
	    background-color: white;
	    width: 500px;
    }
    
    #mainContent tr td:nth-child(2) input{
    	height: 40px;
    	width: 100%;
    }
    
    #mainContent input, textarea{
    	font-family: "나눔스퀘어 네오" , "@맑은 고딕";
    	padding: 5px;
    }
    
    #mainContent tr:last-child td input{
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
     	int num = Integer.parseInt(request.getParameter("num"));
     	String pageNum = request.getParameter("pageNum");
     	
     	BoardDao bdao = BoardDao.getInstance();
     	
     	BoardBean bb = bdao.getArticleByNum(num);
     	
    %>
    
<%@include file="color.jsp" %>
    <td id="mainContent" bgcolor="<%=bodyback_c%>">
        <form action="updateProc.jsp?num=<%=num%>&pageNum=<%=pageNum%>" method="post">
        	<p>글수정</p>
            <table>
                <tr>
                    <td colspan="2">
						<a href="list.jsp?pageNum=<%=pageNum%>">글목록</a>
					</td>
                </tr>
                <tr>
                    <td>작성자</td>
                    <td>
                        <input type="text" name="writer" maxlength="10" value="<%=bb.getWriter()%>">
                    </td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td>
                        <input type="text" name="subject" maxlength="20" value="<%=bb.getSubject()%>">
                    </td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td>
                        <input type="text" name="email" maxlength="10" value="<%=bb.getEmail()%>">
                    </td>
                </tr>
                <tr>
                    <td>내용</td>
                    <td>
                        <textarea name="content" cols="70" rows="10" maxlength="20" ><%=bb.getContent()%></textarea>
                    </td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td>
                        <input type="password" name="passwd" maxlength="12" value="<%=bb.getPasswd()%>">
                    </td>
                </tr>
                <tr >
                    <td colspan="2">
                        <input type="submit"  value="글수정">
                        <input type="reset"  value="초기화">
                        <input type="button"  value="목록보기" onclick="location.href='list.jsp?pageNum=<%=pageNum%>'">
                    </td>
                </tr>
            </table>
        </form>
     </td>
<%@include file="../mall_bottom.jsp" %>  
    