<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

	surveyList.jsp
	
	<style type="text/css">
    	table {
			border-spacing: 0px;
			border: 1px solid #ddd;
			border-width: 1px 1px 0px 1px;
    	}
		tr:first-child {
			background-color: yellow;
		}
		
		table td ,table th{
			padding: 10px 14px;
			font-family: "나눔스퀘어 네오";			
			text-align: center;
			border: solid #ddd;
			border-width: 0px 0px 1px 0px;
		}
	</style>
    
    <table border="1" align="center">
        <tr>
            <th>번호</th>
            <th>이름</th>
            <th>소속 회사</th>
            <th>이메일 주소</th>
            <th>과정 만족도</th>
            <th>관심 분야</th>
            <th>정보 발송 방법</th>
            <th>정보 발송 동의</th>
            <th>삭제</th>
            <th>수정</th>
        </tr>
		<c:forEach var="lists" items="${lists}">
	        <tr>
	            <td>${lists.no}</td>
	            <td>${lists.name}</td>
	            <td>${lists.company}</td>
	            <td>${lists.email}</td>
	            <td>${lists.satisfaction}</td>
	            <td>
		            <c:forEach var="part" items="${lists.part}" varStatus="vs">
		            	${part}<c:if test="${!vs.last}">,</c:if>
		            </c:forEach>
	            </td>
	            <td>${lists.howto}</td>
	            <td>
	            	<c:if test="${lists.agree==1}">동의함</c:if>
	            	<c:if test="${lists.agree==0}">동의안함</c:if>
	            </td>
	            <td><a href="delete.svy?no=${lists.no}">삭제</a></td>
	            <td><a href="updateForm.svy?no=${lists.no}">수정</a></td>
	        </tr>
		</c:forEach>
    </table>
	<br>
	
	
	
	
	
	
	<a href="insertForm.jsp">삽입</a>