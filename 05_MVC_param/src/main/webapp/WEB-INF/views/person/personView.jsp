<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	personView.jsp <br>
	
	id1 : ${param.id}<br>
	id2 : <%=request.getParameter("id") %><br>
	id3 : ${id2}<br>
	id4 : ${requestScope.id2}<br>
	id5 : <%=request.getAttribute("id2") %><br>
	
	pw1 : ${param.pw}<br>
	pw2 : <%=request.getParameter("pw") %><br>
	pw3 : ${pw2}<br>
	pw4 : ${requestScope.pw2}<br>
	pw5 : <%=request.getAttribute("pw2") %><br>
	
	name1 : ${param.name}<br>
	name2 : <%=request.getParameter("name") %><br>
	name3 : ${name2}<br>
	name4 : ${requestScope.name2}<br>
	name5 : <%=request.getAttribute("name2") %><br>
	
	addr1 : ${param.addr}<br>
	addr2 : <%=request.getParameter("addr") %><br>
	addr3 : ${addr2}<br>
	addr4 : ${requestScope.addr2}<br>
	addr5 : <%=request.getAttribute("addr2") %><br>
	
