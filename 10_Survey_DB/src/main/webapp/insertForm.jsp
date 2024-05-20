<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
 
	<%
		application.setAttribute("flag", false);
		String[] satisfaction = {"매우만족","만족","보통","불만족","매우 불만족"};
		String[] part = {"JAVA","Spring","XML","JDBC","Servlet","JSP"};
		String[] howto = {"우편","이메일"};
	%>
 
	과정 만족도 설문<br>아래 항목을 입력해 주세요.
	
	<form action="insert.svy" method="post" name="myform">
		<h3>개인정보 :</h3>
		이름  <input type="text" name="name" style="margin-left:48px"><br>
		소속 회사  <input type="text" name="company" style="margin-left: 11px"><br>
		이메일주소  <input type="text" name="email"><br>
		<br>
		<h3>본 교육 과정을 수강하고 과정에 만족도를 선택헤 주세요.</h3>
		<c:forEach var="satisfaction" items="<%=satisfaction%>">
				<input type="radio" name="satisfaction" value="${satisfaction}">${satisfaction}
		</c:forEach>
		<h3>관심있는 분야는 무엇입니까?</h3>
		<c:forEach var="part" items="<%=part%>" varStatus="vs">
				<input type="checkbox" name="part" value="${part}">${part}
				<c:if test="${vs.count==3}"><br></c:if>
		</c:forEach>
		<br><br>
		정보 발송 방법 : 
		<select name="howto">
			<c:forEach var="howto" items="<%=howto%>">
				<option value="${howto}">${howto}</option>
			</c:forEach>
		</select>
		<br><br>
		<input type="checkbox" name="agree"> 정보 발송에 동의 합니다.
		<br><br>
		<input type="submit" value="전송">
	</form>
	
	<a href="select.svy">목록보기</a>