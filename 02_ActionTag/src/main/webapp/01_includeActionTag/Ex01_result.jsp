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
    
    <hr>
    
    <!-- include 액션 태그 -->
    <jsp:include page="Ex01_contain.jsp">
    	
    </jsp:include>
    <%-- <jsp:include page="Ex01_contain.jsp"/>
	괄호 안에 넣을게 없으면 닫는태그가 아닌 여는태그에서 마무리해야한다 --%>
    <%-- <%@ include file="include page="Ex01_contain.jsp""%> --%>
    
    <hr>
    Ex01_result.jsp 나머지 부분입니다.<br>
    
    