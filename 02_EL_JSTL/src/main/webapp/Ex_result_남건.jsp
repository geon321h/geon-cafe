<%@page import="mypkg.bookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<c:if test="${param.kind==null}">배송비 선택안함</c:if>
	<c:if test="${param.count=='선택'}">보유수량 선택안함</c:if>
	<table border="1">
		<tr>
				<td>제목</td>
				<td>
				<c:choose>
					<c:when test="${param.title!=''}">${param.title}</c:when>
					<c:otherwise>제목없음</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td>저자</td>
				<td>
				<c:choose>
					<c:when test="${param.author !='' }">${param.author}</c:when>
					<c:otherwise>저자없음</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td>출판사</td>
				<td>
				<c:choose>
					<c:when test="${param.publisher !=''}">${param.publisher}</c:when>
					<c:otherwise>출판사없음</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>
				<c:choose>
					<c:when test="${param.price !=''}">${param.price}</c:when>
					<c:otherwise>가격없음</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td>입고일</td>
				<td>
				<c:choose>
					<c:when test="${param.buy !=''}">${param.buy}</c:when>
					<c:otherwise>입고일없음</c:otherwise>
				</c:choose>
				 </td>
			</tr>

			<tr>
				<td>배송비</td>
				<td>
				<c:choose>
					<c:when test="${param.kind !=null}">${param.kind}</c:when>
					<c:otherwise>배송비 선택안함</c:otherwise>
				</c:choose>
				</td>
			</tr>
			
			<tr>
				<td>보유수량</td>
				<td>
				<c:choose>
					<c:when test="${param.count !='선택'}">${param.count}</c:when>
					<c:otherwise>보유수량 선택안함</c:otherwise>
				</c:choose>
				</td>
			</tr>
	</table>
	
	
	<c:set var="title" value="${param.title}"></c:set>
	<c:set var="author" value="${param.author}"></c:set>
	<c:set var="publisher" value="${param.publisher}"></c:set>
	<c:set var="price" value="${param.price}"></c:set>
	<c:set var="buy" value="${param.buy}"></c:set>
	<c:set var="kind" value="${param.kind}"></c:set>
	<c:set var="count" value="${param.count}"></c:set>
	
	<c:if test="${kind==null}">배송비 선택안함</c:if>
	<c:if test="${count=='선택'}">보유수량 선택안함</c:if>
	<table border="1">
		<tr>
				<td>제목</td>
				<td>
				<c:choose>
					<c:when test="${title!=''}">${title}</c:when>
					<c:otherwise>제목없음</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td>저자</td>
				<td>
				<c:choose>
					<c:when test="${author !='' }">${author}</c:when>
					<c:otherwise>저자없음</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td>출판사</td>
				<td>
				<c:choose>
					<c:when test="${publisher !=''}">${publisher}</c:when>
					<c:otherwise>출판사없음</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>
				<c:choose>
					<c:when test="${price !=''}">${price}</c:when>
					<c:otherwise>가격없음</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td>입고일</td>
				<td>
				<c:choose>
					<c:when test="${buy !=''}">${buy}</c:when>
					<c:otherwise>입고일없음</c:otherwise>
				</c:choose>
				 </td>
			</tr>

			<tr>
				<td>배송비</td>
				<td>
				<c:choose>
					<c:when test="${kind !=null}">${kind}</c:when>
					<c:otherwise>배송비 선택안함</c:otherwise>
				</c:choose>
				</td>
			</tr>
			
			<tr>
				<td>보유수량</td>
				<td>
				<c:choose>
					<c:when test="${count !='선택'}">${count}</c:when>
					<c:otherwise>보유수량 선택안함</c:otherwise>
				</c:choose>
				</td>
			</tr>
	</table>
	
	<c:set var="bb2" value="<%=new bookBean() %>"></c:set>
		<c:set target="${bb2}" property="title" value="${param.title}"></c:set>
	<c:set target="${bb2}" property="author" value="${param.author}"></c:set>
	<c:set target="${bb2}" property="publisher" value="${param.publisher}"></c:set>
	<c:set target="${bb2}" property="price" value="${param.price}"></c:set>
	<c:set target="${bb2}" property="buy" value="${param.buy}"></c:set>
	<c:set target="${bb2}" property="kind" value="${param.kind}"></c:set>
	<c:set target="${bb2}" property="count" value="${param.count}"></c:set>
	
	<c:if test="${bb2.kind==null}">배송비 선택안함</c:if>
	<c:if test="${bb2.count=='선택'}">보유수량 선택안함</c:if>
	<table border="1">
		<tr>
				<td>제목</td>
				<td>
				<c:choose>
					<c:when test="${bb2.title!=''}">${title}</c:when>
					<c:otherwise>제목없음</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td>저자</td>
				<td>
				<c:choose>
					<c:when test="${bb2.author !='' }">${author}</c:when>
					<c:otherwise>저자없음</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td>출판사</td>
				<td>
				<c:choose>
					<c:when test="${bb2.publisher !=''}">${publisher}</c:when>
					<c:otherwise>출판사없음</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>
				<c:choose>
					<c:when test="${bb2.price !=0}">${price}</c:when>
					<c:otherwise>가격없음</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td>입고일</td>
				<td>
				<c:choose>
					<c:when test="${bb2.buy !=''}">${buy}</c:when>
					<c:otherwise>입고일없음</c:otherwise>
				</c:choose>
				 </td>
			</tr>

			<tr>
				<td>배송비</td>
				<td>
				<c:choose>
					<c:when test="${bb2.kind !=null}">${kind}</c:when>
					<c:otherwise>배송비 선택안함</c:otherwise>
				</c:choose>
				</td>
			</tr>
			
			<tr>
				<td>보유수량</td>
				<td>
				<c:choose>
					<c:when test="${bb2.count !='선택'}">${count}</c:when>
					<c:otherwise>보유수량 선택안함</c:otherwise>
				</c:choose>
				</td>
			</tr>
	</table>
	
	<jsp:useBean id="bb" class="mypkg.bookBean">
		<jsp:setProperty property="*" name="bb"/>
	</jsp:useBean>
	
	
	<c:if test="${bb.kind==null}">배송비 선택안함</c:if>
	<c:if test="${bb.count=='선택'}">보유수량 선택안함</c:if>
	<table border="1">
		<tr>
				<td>제목</td>
				<td>
				<c:choose>
					<c:when test="${bb.getTitle()!=null}">${title}</c:when>
					<c:otherwise>제목없음</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td>저자</td>
				<td>
				<c:choose>
					<c:when test="${bb.author !=null}">${author}</c:when>
					<c:otherwise>저자없음</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td>출판사</td>
				<td>
				<c:choose>
					<c:when test="${bb.publisher !=null}">${publisher}</c:when>
					<c:otherwise>출판사없음</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>
				<c:choose>
					<c:when test="${bb.price !=0}">${price}</c:when>
					<c:otherwise>가격없음</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td>입고일</td>
				<td>
				<c:choose>
					<c:when test="${bb.buy !=null}">${buy}</c:when>
					<c:otherwise>입고일없음</c:otherwise>
				</c:choose>
				 </td>
			</tr>

			<tr>
				<td>배송비</td>
				<td>
				<c:choose>
					<c:when test="${bb.kind !=null}">${kind}</c:when>
					<c:otherwise>배송비 선택안함</c:otherwise>
				</c:choose>
				</td>
			</tr>
			
			<tr>
				<td>보유수량</td>
				<td>
				<c:choose>
					<c:when test="${bb.count !='선택'}">${count}</c:when>
					<c:otherwise>보유수량 선택안함</c:otherwise>
				</c:choose>
				</td>
			</tr>
	</table>
	
	
	
	