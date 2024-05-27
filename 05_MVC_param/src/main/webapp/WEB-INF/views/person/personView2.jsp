<%@page import="com.spring.bean.PersonBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	personView2.jsp <br>
	<%
		PersonBean pb= (PersonBean)request.getAttribute("personBean"); 
	%>
	id1 : ${personBean.id}<br>
	id2 : <%=pb.getId() %><br>
	
	pw1 : ${personBean.pw}<br>
	pw2 : <%=pb.getPw() %><br>
	
	name1 : ${personBean.name}<br>
	name2 : <%=pb.getName() %><br>
	
	addr1 : ${personBean.addr}<br>
	addr2 : <%=pb.getAddr() %><br>
