<%@page import="java.sql.Timestamp"%>
<%@page import="my.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	writeForm.jsp(입력(5) + 페이지번호(1)) => writeProc.jsp

    <%
    	request.setCharacterEncoding("UTF-8");
    	BoardDao bdao = BoardDao.getInstance();
    %>
    
    <jsp:useBean id="bb" class="my.board.BoardBean">
    	<jsp:setProperty name="bb" property="*"/>
    </jsp:useBean>
    
    <%
   		// 입력(5) + 날짜(1) + 아이피(1) + 자동(1) =>8개
		bb.setReg_date(new Timestamp(System.currentTimeMillis())); // long타입
    	bb.setIp(request.getRemoteAddr()); // 아이피주소 받아오기 String
    	String pageNum = request.getParameter("pageNum");
    	int cnt = bdao.insertArticle(bb);
    	
    	String msg =null;
    	String url =null;
    	
    	if(cnt != -1){
    		msg = "추가 성공";
    		url = "list.jsp?pageNum="+pageNum;
    	}else{
    		msg = "추가 실패";
    		url = "writeForm.jsp?pageNum="+pageNum;
    	}
    	
    %>
    <Script>
        alert("<%=msg%>");
        location.href="<%=url%>";
    </Script>