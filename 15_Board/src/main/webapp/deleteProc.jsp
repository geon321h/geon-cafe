<%@page import="board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	request.setCharacterEncoding("UTF-8");
    	BoardDao bdao = BoardDao.getInstance();
    	int num = Integer.parseInt(request.getParameter("num"));
    	String passwd = request.getParameter("passwd");
    	
    	int pageNum = Integer.parseInt(request.getParameter("pageNum"));
    	
    	int cnt = bdao.deleteArticle(num,passwd);
    	
    	int count = bdao.getArticlesCount();
    	int pageSize = 10;
    	int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
    	
    	if(pageNum>pageCount){
    		pageNum -= 1;	
    	}
    	
    	String msg =null;
    	String url =null;
    	
    	if(cnt > 0){
    		msg = "삭제 성공";
    		url = "list.jsp?pageNum="+pageNum;
    	}else if(cnt == 0){
    		msg = "비밀번호가 일치하지 않습니다.";
    		url = "deleteForm.jsp?num="+num+"&pageNum="+pageNum;
    	}else{
    		msg = "삭제 오류";
    		url = "deleteForm.jsp?num="+num+"&pageNum="+pageNum;
    	}
    	
    %>
    <Script>
        alert("<%=msg%>");
        location.href="<%=url%>";
    </Script>