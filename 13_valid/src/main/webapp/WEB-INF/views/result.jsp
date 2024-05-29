<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	result.jsp<br>
	
    아이디 : ${param.id}<br>
    비번 : ${param.pw}<br>
    구매상품 : 
   	<c:forEach var="p" items="${paramValues.product }" varStatus="vs">
   		${p}<c:if test="${!vs.last}">,</c:if>
	</c:forEach>
	<br>
    배송시간 : ${param.time}<br>
    결제방법 : ${param.approve}<br>
	결제 동의 여부 : ${param.agree}<br>
	
	<hr>
	
	<%
	String[] productArr = request.getParameterValues("product"); 
	String product = "";
	for(int i=0;i<productArr.length;i++){
		product += productArr[i];
		if(i!=productArr.length-1){
			product +=",";
		}
	}
	%>
	
    아이디 : <%=request.getParameter("id")%><br>
    비번 : <%=request.getParameter("pw")%><br>
    구매상품 : <%=product%><br>
    배송시간 : <%=request.getParameter("time")%><br>
    결제방법 :<%=request.getParameter("approve")%><br>
	결제 동의 여부 : <%=request.getParameter("agree")%><br>
	
	<hr>
	
    아이디 : ${pro.id}<br>
    비번 : ${pro.pw}<br>
    구매상품 : ${pro.product}<br>
    배송시간 : ${pro.time}<br>
    결제방법 : ${pro.approve}<br>
	결제 동의 여부 : ${pro.agree}<br> 