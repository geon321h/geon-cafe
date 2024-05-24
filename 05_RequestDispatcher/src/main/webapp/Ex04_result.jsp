<%@page import="myPkg.RegisterBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
	
	Ex04_result.jsp<br><br>
	
	<!-- 	1. jsp  -->
	-1. jsp- <br>
	<%
	String[] hobby_arr = request.getParameterValues("hobby");
	%>
	아이디 : <%=request.getParameter("id") %> <br>
	비밀번호 : <%=request.getParameter("password") %> <br>
	이름 : <%=request.getParameter("name") %> <br>
	생년월일 : 
	<%=request.getParameter("year") %>-<%=request.getParameter("month") %>-<%=request.getParameter("day") %> 
	<br>
	취미 : 
    <%
    if(hobby_arr.length>0){
	    for(int i =0;i<hobby_arr.length;i++){
	   		out.print(hobby_arr[i]);
	   		if(i!=hobby_arr.length-1){
	   			out.print(",");
	   		}
	   	}
    }else{
    	out.print("선택사항 없음");
    }
   	%>
   	<br>
   	<%
   	int c = Integer.parseInt(request.getParameter("c"));
   	int java = Integer.parseInt(request.getParameter("java"));
   	int jsp = Integer.parseInt(request.getParameter("jsp"));
   	int total = c+java+jsp;
   	%>
   	c언어 : <%=request.getParameter("c") %> <br>
   	java : <%=request.getParameter("java") %> <br>
   	jsp : <%=request.getParameter("jsp") %> <br>
   	총합 : <%=total%> <br>
   	<hr>
   	
	<!-- 	2. param  -->
	-2. param- <br>
	아이디 : ${param.id } <br>
	비밀번호 : ${param.password } <br>
	이름 : ${param.name } <br>
	생년월일 : 
	${param.year }-${param.month }-${param.day } 
	<br>
	취미 : 
    <c:if test="${paramValues.hobby == null}">
	선택사항 없음
	</c:if>
	<c:if test="${paramValues.hobby != null}">
		<c:forEach var="h" items="${paramValues.hobby}" varStatus="vs">
			${h}<c:if test="${!vs.last}">,</c:if>
		</c:forEach>
	</c:if>
   	<br>
   	c언어 : ${param.c } <br>
   	java : ${param.java } <br>
   	jsp : ${param.jsp } <br>
   	총합 : ${param.c+param.java+param.jsp}
   	<hr>
   	
	<!-- 	3. 속성  -->
	-3. 속성- <br>
	아이디 : ${id } <br>
	비밀번호 : ${password } <br>
	이름 : ${name } <br>
	생년월일 : 
	${year }-${month }-${day } 
	<br>
	취미 : 
    <c:if test="${hobby == null}">
	선택사항 없음
	</c:if>
	<c:if test="${hobby != null}">
		<c:forEach var="h" items="${hobby}" varStatus="vs">
			${h}<c:if test="${!vs.last}">,</c:if>
		</c:forEach>
	</c:if>
   	<br>
   	c언어 : ${c } <br>
   	java : ${java } <br>
   	jsp : ${jsp } <br>
   	총합 : ${total } <br>
   	<hr>
   	
	<!-- 	4. 각각속성  -->
	-4. 각각속성- <br>
	아이디 : ${requestScope.id } <br>
	비밀번호 : ${requestScope.password } <br>
	이름 : ${requestScope.name } <br>
	생년월일 : 
	${requestScope.year }-${requestScope.month }-${requestScope.day } 
	<br>
	취미 : 
    <c:if test="${requestScope.hobby == null}">
	선택사항 없음
	</c:if>
	<c:if test="${requestScope.hobby != null}">
		<c:forEach var="h" items="${requestScope.hobby}" varStatus="vs">
			${h}<c:if test="${!vs.last}">,</c:if>
		</c:forEach>
	</c:if>
   	<br>
   	c언어 : ${requestScope.c } <br>
   	java : ${requestScope.java } <br>
   	jsp : ${requestScope.jsp } <br>
   	총합 : ${requestScope.total } <br>
   	<hr>
   	
   	<!-- 	5. jsp각각속성  -->
   	-5. jsp각각속성- <br>
	<%
	String[] hobby_arr2 = (String[])request.getAttribute("hobby");
	%>
	아이디 : <%=request.getAttribute("id") %> <br>
	비밀번호 : <%=request.getAttribute("password") %> <br>
	이름 : <%=request.getAttribute("name") %> <br>
	생년월일 : 
	<%=request.getAttribute("year") %>-<%=request.getAttribute("month") %>-<%=request.getAttribute("day") %> 
	<br>
	취미 : 
    <%
    if(hobby_arr2.length>0){
	    for(int i =0;i<hobby_arr2.length;i++){
	   		out.print(hobby_arr2[i]);
	   		if(i!=hobby_arr2.length-1){
	   			out.print(",");
	   		}
	   	}
    }else{
    	out.print("선택사항 없음");
    }
   	%>
   	<br>
   	c언어 : <%=request.getAttribute("c") %> <br>
   	java : <%=request.getAttribute("java") %> <br>
   	jsp : <%=request.getAttribute("jsp") %> <br>
   	총합 : <%=request.getAttribute("total") %> <br>
   	<hr>
   	
   	<!-- 	6. jsp bean  -->
   	-6. jsp bean- <br>
	<%
	RegisterBean rb = (RegisterBean)request.getAttribute("rb");
	%>
	아이디 : <%=rb.getId() %> <br>
	비밀번호 : <%=rb.getPassword() %> <br>
	이름 : <%=rb.getName() %> <br>
	생년월일 : 
	<%=rb.getYear() %>-<%=rb.getMonth() %>-<%=rb.getDay() %> 
	<br>
	취미 : 
    <%
    if(rb.getHobby().length>0){
	    for(int i =0;i<rb.getHobby().length;i++){
	   		out.print(rb.getHobby()[i]);
	   		if(i!=rb.getHobby().length-1){
	   			out.print(",");
	   		}
	   	}
    }else{
    	out.print("선택사항 없음");
    }
   	%>
   	<br>
   	c언어 : <%=rb.getC() %> <br>
   	java : <%=rb.getJava()%> <br>
   	jsp : <%=rb.getJsp() %> <br>
   	총합 : <%=rb.getTotal()%> <br>
   	<hr>
   	
   	<!-- 	7. 속성 bean  -->
   	-7. 속성 bean- <br>
	아이디 : ${rb.getId() } <br>
	비밀번호 : ${rb.getPassword() } <br>
	이름 : ${rb.getName() } <br>
	생년월일 : 
	${rb.year }-${rb.month }-${rb.day } 
	<br>
	취미 : 
    <c:if test="${rb.hobby == null}">
	선택사항 없음
	</c:if>
	<c:if test="${rb.hobby != null}">
		<c:forEach var="h" items="${rb.hobby}" varStatus="vs">
			${h}<c:if test="${!vs.last}">,</c:if>
		</c:forEach>
	</c:if>
   	<br>
   	c언어 : ${rb.c } <br>
   	java : ${rb.java } <br>
   	jsp : ${rb.jsp } <br>
   	총합 : ${rb.total } <br>
   	<hr>
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	