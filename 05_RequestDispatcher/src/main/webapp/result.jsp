<%@page import="myPkg.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	result.jsp <br>
	
	<%
	
	request.setCharacterEncoding("UTF-8");
	String name=request.getParameter("name");
	String age=request.getParameter("age");
	Integer age2 = (Integer)request.getAttribute("age");
	String addr = (String)request.getAttribute("addr");
	Person per = (Person)request.getAttribute("per");
	
	%>
	
	이름:<%=name%><br>
	나이:<%=age%><br>
	나이2:<%=age2%><br>
	주소:<%=addr%><br>
	
	per:<%=per%><br>
	per:<%=per.toString()%><br>
	이름:<%=per.getName()%><br>
	나이:<%=per.getAge()%><br>
	주소:<%=per.getWeight()%><br>
	
	