<%@page import="myPkg.MovieDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<jsp:useBean id="mdao" class="myPkg.MovieDao"/>
	<%
	   int num = Integer.parseInt(request.getParameter("num"));
	   
	   int cnt = mdao.deleteMovie(num);
	   
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