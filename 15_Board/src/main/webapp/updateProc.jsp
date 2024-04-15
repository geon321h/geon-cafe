<%@page import="java.sql.Timestamp"%>
<%@page import="board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    updateForm.jsp(입력(5) + 번호(1) + 페이지번호(1)) => replyProc.jsp
    
    <%
    	request.setCharacterEncoding("UTF-8");
    	BoardDao bdao = BoardDao.getInstance();
    %>
    
    <jsp:useBean id="bb" class="board.BoardBean">
    	<jsp:setProperty name="bb" property="*"/>
    </jsp:useBean>
    
    <%
    	String pageNum = request.getParameter("pageNum");
    	int cnt = bdao.updateArticle(bb);
    	
    	String msg =null;
    	String url =null;
    	
    	if(cnt > 0){
    		msg = "수정 성공";
    		url = "list.jsp?pageNum="+pageNum;
    	}else if(cnt == 0){
    		msg = "비밀번호가 일치하지 않습니다.";
    		url = "updateForm.jsp?pageNum="+pageNum+"&num="+bb.getNum();
    	}else{
    		msg = "수정 실패";
    		url = "updateForm.jsp?pageNum="+pageNum+"&num="+bb.getNum();
    	}
    	
    %>
    <Script>
        alert("<%=msg%>");
        location.href="<%=url%>";
    </Script>