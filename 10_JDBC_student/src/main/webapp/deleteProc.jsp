<%@page import="myPkg.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
	    request.setCharacterEncoding("UTF-8");
    
	   int num = Integer.parseInt(request.getParameter("num"));
	   
	   StudentDao sDao = new StudentDao();
	   int cnt = sDao.deleteStudent(num);
	   
	   String msg =null;
	   	String url =null;
	   	
	   	if(cnt > 0){
	   		msg = "삭제 성공";
	   	}else{
	   		msg = "삭제 실패";
	   	}
    %>
         <Script>
            alert("<%=msg%>");
            location.href="select.jsp";
        </Script>