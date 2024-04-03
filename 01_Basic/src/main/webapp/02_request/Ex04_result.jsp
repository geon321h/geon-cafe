<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		Ex04_result.jsp<br>
       <%
    	request.setCharacterEncoding("UTF-8"); // 맨 위
    
    	String name = request.getParameter("name");
    	String pw = request.getParameter("pw");
    	String[] farr = request.getParameterValues("fruit"); // 여러개 받기
    	// 받을 값이 없을시 주소를 받지 못하기에 null값이 들어간다.
    	
    	
    	
    	%>
    	
    	이름: <%=name %><br>
    	비번: <%=pw %><br>
    	과일: 
    	<%
    	if(farr == null){
    		out.print("선택한 과일이 없습니다.<br>");
    	}else{
    		out.print("선택한 과일이 있습니다.<br>");
    		for(String v : farr){
    			out.print(v+" ");
    		}
    	}
    	%>
    	<br>