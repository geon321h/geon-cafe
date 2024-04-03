<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 	Ex01_result.jsp<br>
	<%
    	
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("passwd");
    
    %>
    
    id: <%=id %><br>
    passwd: <%=pw %><br>
    
    <!-- forward 액션태그 -->
    <%-- <jsp:forward page="Ex01_forward.jsp"/> --%>
    <jsp:forward page="Ex01_forward.jsp">
    	<jsp:param value="20" name="age"/>
    </jsp:forward>
    
    
    <!-- response.sendRedirect(); 
    		는 원하는 값을 보내고 최종 목적지의 주소로 열리지만
    		forward는 최종주소가 다르다. 
    		또한 forward를 사용한 페이지의 출력을 하지않고 나아가고 리퀘스트 객체는 공유한다.-->
    
