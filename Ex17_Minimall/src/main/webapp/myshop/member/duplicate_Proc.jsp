<%@page import="my.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	String id = request.getParameter("id");
	    MemberDAO mdao = MemberDAO.getInstance();
	    
    	boolean flag = mdao.duplicateCheckId(id);
    	
    	String str ="";
    	if(flag){
    		str = "NO";
    	}else{
    		str = "YES";
    	}
    	out.print(str);
    	//System.out.println(str);
    %>