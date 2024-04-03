<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
form.jsp => via.jsp<br>

<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	// HttpServletRequest request = new HttpServletRequest();
	
	String passwd = request.getParameter("passwd");
	
	session.setAttribute("aa", id); // aa:kim
	//HttpSession session = new HttpSession(); 
	
	
%>

id: <%= id %> <br>
passwd: <%= passwd %> <br>

<br><br>


<h1>Session 내장객체 예제</h1><br>
<form action="result.jsp" method="post">
	<%-- 아이디 <input type="text" name="id"  value="<%=id %>"> <br>
	비밀번호 <input type="text" name="passwd" value="<%=passwd %>"> <br><br> --%>
	
	☆가장 좋아하는 스포츠를 선택하세요.☆<br>
	 <input type="radio" name="sports" value="태권도">태권도
	 <input type="radio" name="sports" value="유도">유도
	 <input type="radio" name="sports" value="프로레슬링">프로레슬링
	 <input type="radio" name="sports" value="이종격투기">이종격투기<br><br>
	 
	☆가장 좋아하는 게임을 선택하세요.☆<br>
	<select name="game">
	   <option value="카드라이더">카드라이더</option>
	   <option value="버블버블">버블버블</option>
	   <option value="메이플">메이플</option>
	</select><br><br>
	<input type="submit" value="전송">
</form>