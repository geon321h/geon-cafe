<%@page import="myPkg.MovieDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%-- <jsp:useBean id="mdao" class="myPkg.MovieDao" /> --%>
	<%
		MovieDao mdao = MovieDao.getMovieInstance();
	%>
    <%
    	String userId = request.getParameter("userId");
    	
    	boolean flag = mdao.searchId(userId);
    	String str ="";
    	
    	if(flag){
    		str = "NO";
    	}else{
    		str = "YES";
    	}
    	out.print(str);
    	//System.out.println(str);
    %>