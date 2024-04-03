<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
Ex01_form.jsp => Ex01_result1.jsp <br>

<%
	request.setCharacterEncoding("UTF-8");
	String msg = request.getParameter("msg");
	System.out.println("Ex01_result1.jsp msg : " + msg);
%>

msg : <%= msg %>

<%
	response.sendRedirect("Ex01_result2.jsp?msg="+msg);   
// 	http://localhost:8080/01_Basic/03_response/Ex01_result1.jsp?msg=hello -->
	/* HttpServletResponse response = new HttpServletResponse() */ 
%>

<!-- 
response.sendRedirect
request객체를 공유하지 않는다. 
주소가 최종 목적지의 주소로 나온다.
-->

















