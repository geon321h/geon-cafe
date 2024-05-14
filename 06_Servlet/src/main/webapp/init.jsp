<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	init.jsp <br>
	
	company1 : <%=request.getParameter("company")%><br>
	company2 : ${param.company}<br>
	company3 : <%=application.getInitParameter("company")%><br>
	singer : <%=application.getInitParameter("singer")%><br>
	manager : <%=application.getInitParameter("manager")%><br>
	
	company4 : ${initParam.company}<br>
	singer2 : ${initParam.singer}<br>
	manager2 : ${initParam.manager}<br>
	
	<a href="second.do">second</a>	
