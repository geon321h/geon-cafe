<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    Ex02_via.jsp<br>
    
    <%
    	request.setCharacterEncoding("UTF-8");
    
    	String name = request.getParameter("name");
    	String color = request.getParameter("color");
    
    %>
    
    이름: <%=name %><br>
    선택한 색: <%=color %><br>
    
    <%-- <jsp:forward page='<%=color+".jsp "%>'/> --%>
    <jsp:forward page='<%=color+".jsp "%>'>
    	<jsp:param value="<%=name%>" name="name"/>
    	<jsp:param value="<%=color%>" name="color"/>
    </jsp:forward>
    
    
<%--     <%
    
    	switch(color){
    	
    		case "yellow"	:
    			%><jsp:forward page="yellow.jsp"/><%
    			break;
    		case "green"	:
    			 %><jsp:forward page="green.jsp"/><%
    			break;
    		case "blue"	:
    			%><jsp:forward page="blue.jsp"/><%
    			break;
    		case "red"	:
    			%><jsp:forward page="red.jsp"/><%
    			break;
			default: System.out.print("잘못된 색상 선택");
				break;
    	
    	}
    
    %> --%>
    