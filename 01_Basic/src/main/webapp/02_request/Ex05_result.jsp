<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	 Ex05_result.jsp<br>
        <%
    	request.setCharacterEncoding("UTF-8"); // 맨 위
    	
    	String name = request.getParameter("name");
    	String addr = request.getParameter("addr");
    	String season = request.getParameter("season");
    	String[] animalArr = request.getParameterValues("animal");
    	String fruit = request.getParameter("fruit");
    
    	%>
    	
    	이름: <%=name %><br>
    	주소: <%=addr %><br>
    	좋아하는 계절: <%=season %><br>
    	좋아하는 동물:
    	<%

    	for(String a : animalArr){
    		out.print(a+" ");
    	}
    	
    	%>
    	<br>
    	좋아하는 과일: <%=fruit %><br>
    	
    	<hr>
    	
    	<%
    	
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