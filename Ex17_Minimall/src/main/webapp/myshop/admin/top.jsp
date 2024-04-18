<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	 <!-- myshop/admin/top.jsp-->
	 
	 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css"> 
	<style type="text/css">
		body {
			text-align: center;
			font-family: "나눔스퀘어 네오" , "@맑은 고딕";
		}
		table {
			width: 1200px;
		}
		tr:first-child {
			height: 40px;
			text-align: center;
		}
		#content {
			height: 360px;
			text-align: center;
		}
		
		#header h2{
			margin: 30px 0px;
			font-size: 28px;
			font-weight: 900;
		}
		
		#header{
			margin-bottom: 30px;
		}
		
		#header a{
			font-size: 16px;
			margin: 0px 16px;
		}
		
	</style>
	<%
		session.setAttribute("id", "admin");
	%>

			<div id="header">
				<h2>쇼핑몰(관리자용)</h2>
				<a href="main.jsp">쇼핑몰홈</a>|
				<a href="<%=request.getContextPath()%>/main.jsp">메인 화면</a>|
				<a href="">로그아웃</a>
			</div>
			<table border="1">
				<tr>
					<td><a href="cate_input.jsp" >카테고리 등록</a></td>
					<td><a href="cate_list.jsp" >카테고리 목록</a></td>
					<td><a href="prod_input.jsp" >상품 등록</a></td>
					<td><a href="prod_list.jsp" >상품 목록</a></td>
					<td><a href="shopping_list.jsp" >쇼핑 내역</a></td>
					<td><a href="<%=request.getContextPath()%>/myshop/display/mall.jsp" >사용자 홈</a></td>
				</tr>
				<tr id="content" valign="top">
				
	
	