<%@page import="myPkg.EmplDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
	    request.setCharacterEncoding("UTF-8");
    
	   int eid = Integer.parseInt(request.getParameter("eid"));
	   
	   EmplDao eDao = new EmplDao();
	   int cnt = eDao.deleteEmpl(eid);
	   
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