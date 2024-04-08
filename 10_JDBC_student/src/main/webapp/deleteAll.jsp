<%@page import="myPkg.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	System.out.println(request.getParameter("rowcheck"));
    	String[] rowcheckArr = request.getParameterValues("rowcheck");
    	
    	for(String rowcheckStr : rowcheckArr){
    		System.out.println(rowcheckStr);
    	} 
    	
    	StudentDao sDao = new StudentDao();
    	int cnt = sDao.deleteAllStudent(rowcheckArr);
    	
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