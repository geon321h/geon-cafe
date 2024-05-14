<%@page import="myPkg.memberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
	
	Ex05_result_남건.jsp<br><br>
	
	<!-- 	1. jsp  -->
	-1. jsp- <br>
	<%
	String[] coffee_arr = request.getParameterValues("coffee");
	String[] travel_arr = request.getParameterValues("travel");
	%>
	이름 : <%=request.getParameter("name") %> <br>
	나이 : <%=request.getParameter("age") %> <br>
	성별 : <%=request.getParameter("gender") %> <br>
	<%
		if(request.getParameter("job").equals("")){
			%>
			선택한 직업 없음 
			<%
		}else{
			%>
			직업 : <%=request.getParameter("job") %> 
			<%
		}
	%>
	<br>
    <%
    if(coffee_arr !=null){
    	out.print("좋아하는 커피 : ");
	    for(int i =0;i<coffee_arr.length;i++){
	   		out.print(coffee_arr[i]+" ");
	   	}
    }else{
    	out.print("선택한 커피 없음");
    }
   	%>
   	<br>
    <%
    if(travel_arr !=null){
    	out.print("여행하고 싶은 나라 : ");
	    for(int i =0;i<travel_arr.length;i++){
	   		out.print(travel_arr[i]+" ");
	   	}
    }else{
    	out.print("선택한 나라 없음");
    }
   	%>
   	<hr>
   	
   	<!-- 	2. param  -->
	-2. param- <br>
	이름 : ${param.name } <br>
	나이 : ${param.age } <br>
	성별 : ${param.gender } <br>
    <c:if test="${param.job == ''}">
		선택한 직업 없음 
	</c:if>
	<c:if test="${param.job != ''}">
		직업 : ${param.job }
	</c:if>
 	<br>
    <c:if test="${paramValues.coffee == null}">
		선택한 커피 없음
	</c:if>
	<c:if test="${paramValues.coffee != null}">
		좋아하는 커피 : 
		<c:forEach var="cof" items="${paramValues.coffee}" >
			${cof}
		</c:forEach>
	</c:if>
   	<br>
    <c:if test="${paramValues.travel == null}">
		선택한 나라 없음
	</c:if>
	<c:if test="${paramValues.travel != null}">
		여행하고 싶은 나라 :
		<c:forEach var="tra" items="${paramValues.travel}" >
			${tra}
		</c:forEach>
	</c:if>
   	<hr>
   	
   	<!-- 	3. 속성  -->
	-3. 속성- <br>
	이름 : ${name } <br>
	나이 : ${age } <br>
	성별 : ${gender } <br>
    <c:if test="${job == ''}">
		선택한 직업 없음 
	</c:if>
	<c:if test="${job != ''}">
		직업 : ${param.job }
	</c:if>
 	<br>
    <c:if test="${coffee == null}">
		선택한 커피 없음
	</c:if>
	<c:if test="${coffee != null}">
		좋아하는 커피 : 
		<c:forEach var="cof" items="${coffee}" >
			${cof}
		</c:forEach>
	</c:if>
   	<br>
    <c:if test="${travel == null}">
		선택한 나라 없음
	</c:if>
	<c:if test="${travel != null}">
		여행하고 싶은 나라 :
		<c:forEach var="tra" items="${travel}" >
			${tra}
		</c:forEach>
	</c:if>
   	<hr>
   	
   	<!-- 	4. 각각속성  -->
	-4. 각각속성- <br>
	이름 : ${requestScope.name } <br>
	나이 : ${requestScope.age } <br>
	성별 : ${requestScope.gender } <br>
    <c:if test="${requestScope.job == ''}">
		선택한 직업 없음 
	</c:if>
	<c:if test="${requestScope.job != ''}">
		직업 : ${requestScope.job }
	</c:if>
 	<br>
    <c:if test="${requestScope.coffee == null}">
		선택한 커피 없음
	</c:if>
	<c:if test="${requestScope.coffee != null}">
		좋아하는 커피 : 
		<c:forEach var="cof" items="${requestScope.coffee}" >
			${cof}
		</c:forEach>
	</c:if>
   	<br>
    <c:if test="${requestScope.travel == null}">
		선택한 나라 없음
	</c:if>
	<c:if test="${requestScope.travel != null}">
		여행하고 싶은 나라 :
		<c:forEach var="tra" items="${requestScope.travel}" >
			${tra}
		</c:forEach>
	</c:if>
   	<hr>
   	
   	<!-- 	5. jsp bean  -->
	-5. jsp bean- <br>
	<%
	memberBean mb = (memberBean)request.getAttribute("mb");
	%>
	이름 : <%=mb.getName()%> <br>
	나이 : <%=mb.getAge()%> <br>
	성별 : <%=mb.getGender() %> <br>
	<%
		if(mb.getJob().equals("")){
			%>
			선택한 직업 없음 
			<%
		}else{
			%>
			직업 : <%=mb.getJob() %> 
			<%
		}
	%>
	<br>
    <%
    if(mb.getCoffee() !=null){
    	out.print("좋아하는 커피 : ");
	    for(int i =0;i<mb.getCoffee().length;i++){
	   		out.print(mb.getCoffee()[i]+" ");
	   	}
    }else{
    	out.print("선택한 커피 없음");
    }
   	%>
   	<br>
    <%
    if(mb.getTravel() !=null){
    	out.print("여행하고 싶은 나라 : ");
	    for(int i =0;i<mb.getTravel().length;i++){
	   		out.print(mb.getTravel()[i]+" ");
	   	}
    }else{
    	out.print("선택한 나라 없음");
    }
   	%>
   	<hr>
   	
   	<!-- 	6. 속성 bean  -->
	-6. 속성 bean- <br>
	이름 : ${mb.getName()} <br>
	나이 : ${mb.getAge()} <br>
	성별 : ${mb.getGender()} <br>
    <c:if test="${mb.job == ''}">
		선택한 직업 없음 
	</c:if>
	<c:if test="${mb.job != ''}">
		직업 : ${param.job }
	</c:if>
 	<br>
    <c:if test="${mb.coffee == null}">
		선택한 커피 없음
	</c:if>
	<c:if test="${mb.coffee != null}">
		좋아하는 커피 : 
		<c:forEach var="cof" items="${mb.coffee}" >
			${cof}
		</c:forEach>
	</c:if>
   	<br>
    <c:if test="${mb.travel == null}">
		선택한 나라 없음
	</c:if>
	<c:if test="${mb.travel != null}">
		여행하고 싶은 나라 :
		<c:forEach var="tra" items="${mb.travel}" >
			${tra}
		</c:forEach>
	</c:if>
   	<hr>
   	
   	