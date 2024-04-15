<%@page import="java.text.SimpleDateFormat"%>
<%@page import="board.BoardDao"%>
<%@page import="board.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="style.css"> 
<style type="text/css">
    table {
        width: 500px;
    }
    table td{
	    background-color: white;
    }
    .listTitle {
        background-color: #AFEEEE;
    }
    tr:last-child td {
        text-align: right;
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

<%@include file="color.jsp" %>

    <%
    	String num = request.getParameter("num");
    	String pageNum = request.getParameter("pageNum");
    	// System.out.println(num);
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	BoardDao bdao = BoardDao.getInstance();
    	BoardBean bb = bdao.getArticle(Integer.parseInt(num));
    	
    %>
    

    <body bgcolor="<%=bodyback_c%>">
        <form action="">
            <p>글내용 보기</p>
            <table>
                <tr>
                    <td class="listTitle" width="125">글번호</td>
                    <td width="125"><%=bb.getNum() %></td>
                    <td class="listTitle" width="125">조회수</td>
                    <td width="125"><%=bb.getReadcount() %></td>
                </tr>
                                <tr>
                    <td class="listTitle" width="125">작성자</td>
                    <td width="125"><%=bb.getWriter() %></td>
                    <td class="listTitle" width="125">작성일</td>
                    <td width="125"><%=sdf.format(bb.getReadcount())%></td>
                </tr>
                <tr>
                    <td class="listTitle" width="125">글제목</td>
                    <td colspan="3" width="125"><%=bb.getSubject() %></td>
                </tr>
                <tr>
                    <td class="listTitle" width="125">글내용</td>
                    <td colspan="3" width="375"><%=bb.getContent() %></td>
                </tr>
                <tr>
                	<td colspan="4" class="listTitle">
	                    <input type="button" name="updateBtn" value="글수정" onclick="location.href='updateForm.jsp?num=<%=bb.getNum()%>&pageNum=<%=pageNum%>'">
	                    <input type="button" name="deleteBtn" value="글삭제" onclick="location.href='deleteForm.jsp?num=<%=bb.getNum()%>&pageNum=<%=pageNum%>'">
	                    <input type="button" name="reBtn" value="답글쓰기" onclick="location.href='replyForm.jsp?ref=<%=bb.getRef()%>&re_step=<%=bb.getRe_step()%>&re_level=<%=bb.getRe_level()%>&pageNum=<%=pageNum%>'">
	                    <input type="button" name="listBtn" value="글목록" onclick="location.href='list.jsp?pageNum=<%=pageNum%>'">
                	</td>
                </tr>
            </table>
        </form>
    </body>
    
    