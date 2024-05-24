<%@page import="my.shop.CategoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="my.shop.CategoryDao"%>
<%@page import="my.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	 <!-- myshop/display/top.jsp-->
	 
	 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css"> 
	<style type="text/css">
		body {
			text-align: center;
			font-family: "나눔스퀘어 네오" , "@맑은 고딕";
		}
		#container {
			width: 1200px;
		}
		#container #header {
			height: 60px;
			text-align: center;
		}
		#content {
s			text-align: center;
		}
		
		#container span {
			margin:0px 5px;
		}
		
		#menu{
			display: inline-block;
			float: left;
			margin-left: 10px;
		}
		#menu a, #menu span{
			font-size: 20px;
			font-weight: bold;
		}
		
		#user{
			display: flex;
			float: right;
			margin-right: 10px;
		}
		
		#user span {
			margin-top: 5px;
		}
		
		#aside{
			width: 200px;
			background-color: #F0F8FF;
		}
		
		#aside h2{
			margin-top: 30px;
		}
		
		#aside td{
			width: 150px;
			background-color: white;
		}
		
	</style>
	
    <%
        request.setCharacterEncoding("UTF-8");
        
        String id = (String)session.getAttribute("id");
        if(id == null){
        	id = "admin";
        }
	 	
	 	String contextPath = request.getContextPath();
        
    %>
	<table border="1" id="container">
		<tr id="header">
			<td colspan="2">
				<div id="menu">
					<a href="<%=contextPath%>/main.jsp" >HOME</a><span>|</span> 
					<%
						if(id.equals("admin")){
							%>
							<a href="<%=contextPath%>/myshop/admin/main.jsp" >관리자홈</a><span>|</span> 
							<%
						}
					%>
					<a href="<%=contextPath%>/myshop/display/mall.jsp" >쇼핑몰홈</a><span>|</span>
					<a href="<%=contextPath%>/myshop/display/mall_cartList.jsp" >장바구니</a><span>|</span>
					<a href="<%=contextPath%>/myshop/display/board/list.jsp" >게시판</a><span>|</span>
					<a href="<%=contextPath%>/myshop/display/company.jsp" >회사소개</a>
				</div>
				<div id="user">
					<span><%=id%>님</span>
					<a class="Logout" href="<%=contextPath%>/logout.jsp">
						<img alt="" src="<%=contextPath%>/img/logout3.jpg" width="50px" height="25px">
					</a>
				</div>
			</td>
		</tr>
			<tr id="content" valign="top">
				    <td id="aside">
					    <table border="1">
		    				<tr>
		    					<td><a href="<%=contextPath%>/myshop/display/ceo.jsp">ceo 인사말</a></td>
		    				</tr>
		    				<tr>
		    					<td><a href="<%=contextPath%>/myshop/display/history.jsp">회사연혁</a></td>
		    				</tr>
		    				<tr>
		    					<td><a href="<%=contextPath%>/myshop/display/chart.jsp">조직도</a></td>
		    				</tr>
					    </table>
				    </td >
				
	
	