<%@page import="myPkg.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

personResult.jsp<br>

이름 : <%=request.getParameter("name") %> <br>
<%
	Person per = (Person)request.getAttribute("per");
%>
   이름2 : <%=per.getName()%> <br>
    나이 : <%=per.getAge()%> <br>
    성별 : <%=per.getGender()%> <br>
    취미 : <%for(String element : per.getHobby()){%>
    		<%=element %>
    	<%}%>
<br>    	 
이름3 : ${param.name } <br>
나이3 : ${param.age } <br>
성별3 : ${param.gender } <br>
취미3 :
<c:if test="${paramValues.hobby == null}">
	선택 누락
</c:if>
<c:if test="${paramValues.hobby ne null}">
	<c:forEach var="i" items="${paramValues.hobby}" varStatus="h">
		${i}<c:if test="${not h.last}">,</c:if>
	</c:forEach>
</c:if>
<br>
취미4 :
<c:if test="${!empty paramValues.hobby }">
	<c:forEach var="i" begin="0" end="${fn:length(paramValues.hobby)-1 }" step="1">
		${paramValues.hobby[i] }
	</c:forEach>
</c:if>
<br>
<%-- <%
pageContext.setAttribute("per", per);
%> --%>
이름5 : ${per.name } <br>
나이5 : ${per.age }<br>
성별5 : ${per.gender }<br>
취미5 : 
<c:if test="${per.hobby ne null }">
	<c:forEach var="hobby2" items="${per.hobby }">
		${hobby2 }
	</c:forEach>
</c:if>
<c:if test="${per.hobby eq null }">
	선택사항없음
</c:if><br>
<hr>

이름6 : 
<%
	String name = (String)request.getAttribute("name");
%>
<%=name %><br>

이름7 : ${requestScope.name }<br>
이름8 : ${name }<br>
이름9 : ${requestScope.pb.name }<br>
이름10 : ${pb.name }<br>
이름11 : ${pb.getName()}<br>
















    	