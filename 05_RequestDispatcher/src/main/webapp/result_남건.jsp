<%@page import="myPkg.petBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


	result_남건.jsp<br>
	
	<!-- 	1. jsp  -->
	<%
	String[] pet_arr = request.getParameterValues("pet");
	%>
	이름 : <%=request.getParameter("name") %> <br>
	주소 : <%=request.getParameter("addr") %> <br>
	좋아하는 동물 : 
    <%
    for(int i =0;i<pet_arr.length;i++){
   		out.print(pet_arr[i]);
   		if(i!=pet_arr.length-1){
   			out.print(",");
   		}
   	}
   	%>
   	<br>
   	
	<!-- 	2. jsp (bean) -->
	<%
	petBean pb = (petBean)request.getAttribute("pb");
	%>
	이름 : <%=pb.getName()%> <br>
	주소 : <%=pb.getAddr()%> <br>
	좋아하는 동물 : 
    <%
    for(int i =0;i<pb.getPet().length;i++){
   		out.print(pb.getPet()[i]);
   		if(i!=pb.getPet().length-1){
   			out.print(",");
   		}
   	}
   	%>
   	<br>
   	
	<!-- 	3. param -->
	이름 : ${param.name } <br>
	주소 : ${param.addr } <br>
	좋아하는 동물 : 
    <c:if test="${paramValues.pet == null}">
	선택 누락
	</c:if>
	<c:if test="${paramValues.pet != null}">
		<c:forEach var="pet" items="${paramValues.pet}" varStatus="vs">
			${pet}
			<c:if test="${!vs.last}">,</c:if>
		</c:forEach>
	</c:if>
	<br>
	
	<!-- 	4. el (bean)세팅 -->
	<c:set var="petB" value="<%=pb%>"></c:set>
	이름 : ${petB.name } <br>
	주소 : ${petB.addr } <br>
	좋아하는 동물 : 
    <c:if test="${petB.pet == null}">
	선택 누락
	</c:if>
	<c:if test="${petB.pet != null}">
		<c:forEach var="pet" items="${petB.pet}" varStatus="vs">
			${pet}
			<c:if test="${!vs.last}">,</c:if>
		</c:forEach>
	</c:if>
	<br>
	
	<!-- 	5. el (bean)세팅_메서드 -->
	이름 : ${petB.name } <br>
	주소 : ${petB.addr } <br>
	좋아하는 동물 : 
    <c:if test="${petB.pet == null}">
	선택 누락
	</c:if>
	<c:if test="${petB.pet != null}">
		<c:forEach var="pet" items="${petB.pet}" varStatus="vs">
			${pet}
			<c:if test="${!vs.last}">,</c:if>
		</c:forEach>
	</c:if>
	<br>
	
	<!-- 	6. 속성 -->
	이름 : ${name } <br>
	주소 : ${addr } <br>
	좋아하는 동물 : 
    <c:if test="${pet == null}">
	선택 누락
	</c:if>
	<c:if test="${pet != null}">
		<c:forEach var="pet" items="${pet}" varStatus="vs">
			${pet}
			<c:if test="${!vs.last}">,</c:if>
		</c:forEach>
	</c:if>
	<br>
	
	<!-- 	7. bean속성 -->
	이름 : ${pb.name } <br>
	주소 : ${pb.addr } <br>
	좋아하는 동물 : 
    <c:if test="${pb.pet == null}">
	선택 누락
	</c:if>
	<c:if test="${pb.pet != null}">
		<c:forEach var="pet" items="${pb.pet}" varStatus="vs">
			${pet}
			<c:if test="${!vs.last}">,</c:if>
		</c:forEach>
	</c:if>
	<br>

