<%@page import="svy.SurveyBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
 
	<%
		String[] satisfaction = {"매우만족","만족","보통","불만족","매우 불만족"};
		String[] part = {"JAVA","Spring","XML","JDBC","Servlet","JSP"};
		String[] howto = {"우편","이메일"};
		SurveyBean sb = (SurveyBean)request.getAttribute("sb");
	%>
 
	과정 만족도 설문<br>아래 항목을 입력해 주세요.
	
	<form action="update.svy" method="post" name="myform">
		<h3>개인정보 :</h3>
		<input type="hidden" name="no" value="${sb.no}">
		이름  <input type="text" name="name" style="margin-left:48px" value="${sb.name}"><br>
		소속 회사  <input type="text" name="company" style="margin-left: 11px" value="${sb.company}"><br>
		이메일주소  <input type="text" name="email" value="${sb.email}"><br>
		<br>
		<h3>본 교육 과정을 수강하고 과정에 만족도를 선택헤 주세요.</h3>
		<c:forEach var="satisfaction" items="<%=satisfaction%>">
			<c:if test="${satisfaction == sb.satisfaction}">
				<input type="radio" name="satisfaction" value="${satisfaction}" checked>${satisfaction}
			</c:if>
			<c:if test="${satisfaction != sb.satisfaction}">
				<input type="radio" name="satisfaction" value="${satisfaction}" >${satisfaction}
			</c:if>
		</c:forEach>
		<h3>관심있는 분야는 무엇입니까?</h3>
		<c:forEach var="part" items="<%=part%>" varStatus="vs">
			<c:set value="" var="check"></c:set>
			<c:forEach var="partSB" items="${sb.part}">
				<c:if test="${part == partSB}">
					<c:set value="checked" var="check"></c:set>
				</c:if>
			</c:forEach>
			<input type="checkbox" name="part" value="${part}" ${check} >${part}
			<c:if test="${vs.count==3}"><br></c:if>
		</c:forEach>
		<br><br>
		정보 발송 방법 : 
		<select name="howto">
			<c:forEach var="howto" items="<%=howto%>">
				<c:if test="${howto == sb.howto}">
					<option value="${howto}" selected>${howto}</option>
				</c:if>
				<c:if test="${howto != sb.howto}">
					<option value="${howto}">${howto}</option>
				</c:if>
			</c:forEach>
		</select>
		<br><br>
		<c:if test="${sb.agree == 1}">
			<input type="checkbox" name="agree" checked> 정보 발송에 동의 합니다.
		</c:if>
		<c:if test="${sb.agree == 0}">
			<input type="checkbox" name="agree"> 정보 발송에 동의 합니다.
		</c:if>
		<br><br>
		<input type="submit" value="전송">
	</form>
