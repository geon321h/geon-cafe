<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    	<style type="text/css"> 

        img {
            width: 300px;
            height: 200px;
        }

    </style>

    red.jsp<br>
    
    <%
    
    	String name = request.getParameter("name");
    	String color = request.getParameter("color");
    
    %>
    
    <%=name %>님이 좋아하는 색은 <%=color %>입니다.<br>
    <img src="../images/<%=color%>.jpg" >