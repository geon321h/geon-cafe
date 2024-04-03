<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
    	// String id = "kim"; // 지역변수
	%>
	
    <%!
    	String id = "kim"; // 전역변수
    	String name = "김연아";
    	public String getId(){
    		return id;
    	}
    %>
    
    <% String str = getId(); %>
    
    <%= str %>
    
    <% 
    	String name = "손흥민";
    	String comment = "주석문 연습";
    %><br>
    name : <%= name %><br>
    <p>
    	commet1:<%=comment %><br>
    	<!-- commet2:<%=comment %><br>--> <!-- html 주석 -->
    	<%-- commet3:<%=comment %><br> --%> <%-- jsp 주석 --%>
    