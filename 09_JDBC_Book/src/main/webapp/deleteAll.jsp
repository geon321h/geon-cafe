<%@page import="myPkg.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	    request.setCharacterEncoding("UTF-8");
    	String[] rowcheckArr = request.getParameterValues("rowcheck");
    	
    	for(String rowcheckStr : rowcheckArr){
    		int rowcheck = Integer.parseInt(rowcheckStr);
    		System.out.println(rowcheck);
    	}
    	
    	BookDao bDao = new BookDao();
    	int cnt = bDao.deleteCheckData(rowcheckArr);
    	
    	String msg =null;
    	String url =null;
    	
    	if(cnt > 0){
    		msg = "삭제 성공";
    		url = "select.jsp";
    	}else{
    		msg = "삭제 실패";
    		url = "select.jsp";
    	}
    	
    %>
        <Script>
        alert("<%=msg%>");
        location.href="<%=url%>";
    </Script>