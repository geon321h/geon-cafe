<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    Ex01_form.jsp => Ex01_result.jsp <br>
    <%
    	request.setCharacterEncoding("UTF-8"); // 제일위에 써야 한글처리된다.
    
    	String s = request.getParameter("name");
    	String a = request.getParameter("age");
    %>
    
    이름 : <%=s%> <br>
    나이 : <%=s%> <br>