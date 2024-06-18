<%@page import="member.model.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
	<%
		//String loginId = ((MemberBean)session.getAttribute("loginInfo")).getId();
	%>
<%-- 	접속자 아이디1 : <%=loginId %> --%>
<%-- 	접속자 아이디2 : ${loginInfo.id} --%>
	접속자 아이디 : ${sessionScope.loginInfo.id}<br>