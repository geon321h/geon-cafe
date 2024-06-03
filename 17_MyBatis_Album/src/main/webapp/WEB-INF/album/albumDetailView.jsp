<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../common/common.jsp" %>fmt" %>

	albumDetailView.jsp<br>
	
	<style type="text/css">
		table {
			font-family: "나눔스퀘어 네오";
			border-collapse: collapse;
			margin: 0 auto;
		}
		td,th {
			text-align: center;
			padding: 15px 20px;
		}
	</style>
	
	<h3>상품 상세 화면</h3>
	
	<table border="1">
	  <tr>
	    <td>번호</td>
	    <td>${album.num }</td>
	  </tr>
	  <tr>
	    <td>노래제목</td>
	    <td>${album.title }</td>
	  </tr>
	  <tr>
	    <td>가수명</td>
	    <td>${album.singer }</td>
	  </tr>
	  <tr>
	    <td>가격</td>
	    <td>${album.price }</td>
	  </tr>
	  <tr>
	    <td>발매일</td>
	    <td>
	    <fmt:parseDate value="${album.day}" var="day" pattern="yyyy-MM-dd"/>
	    <fmt:formatDate value="${day}" pattern="yyyy-MM-dd"/>
	    </td>
	  </tr>
	  <tr>
	    <td colspan="2">
	    	<a href="list.ab">앨범 리스트 화면으로 돌아감</a>
		</td>
	  </tr>
	</table>
