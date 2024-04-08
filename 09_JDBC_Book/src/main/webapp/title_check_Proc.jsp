<%@page import="myPkg.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    
    	String usertitle = request.getParameter("usertitle");
    	BookDao bDao = new BookDao();
    	
    	boolean flag = bDao.searchTitle(usertitle);
    	String str ="";
    	
    	if(flag){
    		str = "NO";
    	}else{
    		str = "YES";
    	}
    	out.print(str);
    
    %>