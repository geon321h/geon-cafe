<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    Ex04_result.jsp<br>
       <%
    	request.setCharacterEncoding("UTF-8"); // 맨 위
    
    	Enumeration<String> names = request.getParameterNames(); // Enumeration

    	while(names.hasMoreElements()){
    		String em = names.nextElement();
    		out.println(em+": ");
    		
    		String[] values = request.getParameterValues(em);
    		for(String v : values){
    			
    			out.println(v+" ");
    			
    		}
    		out.println("<br>");
    		
    	}
    	
    	
    	%>