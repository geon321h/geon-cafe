<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
	
		String su1 = request.getParameter("su1");
		String su2 = request.getParameter("su2");
		Integer sum = (Integer)request.getAttribute("sum");
		Integer cha = (Integer)request.getAttribute("cha");
		Integer mul = (Integer)request.getAttribute("mul");
		double div = (double)request.getAttribute("div");
	
	%>
	
	수1 : <%=su1 %>
	수2 : <%=su2 %>
	합 :  <%=sum %>
	차 :  <%=cha %>
	곱 :  <%=mul %>
	나누기 :  <%=div %>
