<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    control.jsp
    
    <%
    
    	request.setCharacterEncoding("UTF-8");
    
    	String product = request.getParameter("product");
    
    %>
	
	<jsp:forward page="template.jsp">
	
		<jsp:param value='<%=product+"Left.jsp" %>' name="viewLeft"/>
		<jsp:param value='<%=product+".jsp" %>' name="viewPage"/>
		
	</jsp:forward>
	
	<!-- 거쳐가는 페이지 -->