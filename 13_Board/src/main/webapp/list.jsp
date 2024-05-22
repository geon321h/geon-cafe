<%@page import="java.text.SimpleDateFormat"%>
<%@page import="board.BoardBean"%>
<%@page import="board.BoardDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
    <link rel="stylesheet" type="text/css" href="style.css"> 
   
	<%@include file="color.jsp" %>
    <body bgcolor="<%=bodyback_c%>">
        <form action="">
            <p>글목록(전체 글:${count})</p>
            <table>
            	<caption>
            		<a href="writeForm.jsp?pageNum=${pageNum}">글쓰기</a>
            	</caption>
        	    <c:if test="${count == null}">
     		        <tr>
	                    <td>
	                        	<%
								response.sendRedirect("list.bd");
								%>
	                    </td>
	                </tr>
            	</c:if>
            	<c:if test="${count ==0}">
     		        <tr>
	                    <td>
	                        게시판에 저장된 글이 없습니다.
	                    </td>
	                </tr>
            	</c:if>
				<c:if test="${count > 0}">
                <tr>
                    <td>
                        번호
                    </td>
                    <td>
                        제목
                    </td>
                    <td>
                        작성자
                    </td>
                    <td>
                        작성일
                    </td>
                    <td>
                        조회수
                    </td>
                    <td>
                        ip
                    </td>
                </tr>
                <tr>
    
                </tr>
				<c:set var="pnum" value="${number}"></c:set>
				<c:forEach var="bb" items="${lists}">
					<fmt:formatDate value="${bb.getReg_date()}" pattern="yyyy-MM-dd HH:mm" var="reg_date"/>
					<tr bgcolor="white">
						<td>${pnum}</td>
						<c:set var="pnum" value="${pnum-1}"></c:set>
						<td class="leftText">
							<c:if test="${bb.getRe_level()>0}">
								<c:set var="wid" value="${20*bb.getRe_level()}"></c:set>
	                            <img src="images/level.gif" width="${wid}" height="15">
						        <img src="images/re.gif">
							</c:if>
							<a href="content.bd?num=${bb.num}&pageNum=${pageNum}">${bb.subject}</a>
							<c:if test="${bb.getReadcount()>=10}">
								<img src="images/hot.gif">
							</c:if>
						</td>
						<td>${bb.writer}</td>
						<td>${reg_date}</td>
						<td>${bb.readcount}</td>
						<td>${bb.ip}</td>
					</tr>
				</c:forEach>
				</c:if>
            </table>
            <c:if test="${count>0}">
            	<c:if test="${startPage>pageBlock}">
            		<a href="list.bd?pageNum=${startPage-pageBlock}">[이전]</a>
            	</c:if>
				<c:forEach begin="${startPage}" end="${endPage}" var="i">
					<a href="list.bd?pageNum=${i}">[${i}]</a>
				</c:forEach>
            	<c:if test="${endPage<pageCount}">
            		<a href="list.bd?pageNum=${startPage+pageBlock}">[다음]</a>
            	</c:if>
            </c:if>
           
        </form>
    </body>

    