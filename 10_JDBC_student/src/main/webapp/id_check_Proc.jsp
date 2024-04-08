<%@page import="myPkg.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    
    	String userId = request.getParameter("userId");
    	StudentDao sDao = new StudentDao();
    	
    	boolean flag = sDao.searchId(userId);
    	String str ="";
    	
    	if(flag){
    		str = "NO";
    	}else{
    		str = "YES";
    	}
    	out.print(str);
    	System.out.println(str);
    
    %>