<%@page import="java.sql.Timestamp"%>
<%@page import="board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    replyForm.jsp(입력(5) + 부모(3) + 페이지번호(1)) => replyProc.jsp<br>
    
    <%
    	request.setCharacterEncoding("UTF-8");
    	BoardDao bdao = BoardDao.getInstance();
    	String pageNum = request.getParameter("pageNum");
    %>
    
    <jsp:useBean id="bb" class="board.BoardBean">
    	<jsp:setProperty name="bb" property="*"/>
    </jsp:useBean>
    
    <%
   		// 입력(5) + 날짜(1) + 아이피(1) + 자동(1) =>8개
		bb.setReg_date(new Timestamp(System.currentTimeMillis()));
    	bb.setIp(request.getRemoteAddr());
    	int cnt = bdao.replyArticle(bb);
    	
    	String msg =null;
    	String url =null;
    	
    	if(cnt != -1){
    		msg = "답글추가 성공";
    		url = "list.jsp?pageNum="+pageNum;
    	}else{
    		msg = "답글추가 실패";
    		url = "replyForm.jsp?ref="+bb.getRef()+"&re_step="+bb.getRe_step()+"&re_level="+bb.getRe_level()+"&pageNum="+pageNum;
    	}
    	
    %>
    <Script>
        alert("<%=msg%>");
        location.href="<%=url%>";
    </Script>