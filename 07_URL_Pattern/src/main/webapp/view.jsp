<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	view.jsp <br>
	
<!-- 	서블릿요청 -->
	
<!-- 	get : a태그,location,form(get) -->
<!-- 	post : form(post) -->
<hr>
-do-<br><br>
<a href="insert.do">insert</a>
<hr>
<a href="http://localhost:8081/07_URL_Pattern/update.do">update</a>
<hr>
<a href="http://localhost:8081<%=request.getContextPath()%>/select.do">select</a>
<hr>
<a href="<%=request.getContextPath()%>/delete.do">delete</a>
<hr>
<br><br>

-mb-<br><br>
<a href="insert.mb">insert</a>
<hr>
<a href="http://localhost:8081/07_URL_Pattern/update.mb">update</a>
<hr>
<a href="http://localhost:8081<%=request.getContextPath()%>/select.mb">select</a>
<hr>
<a href="<%=request.getContextPath()%>/delete.mb">delete</a>
<hr>