<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		String viewLeft = request.getParameter("viewLeft");
		String viewPage = request.getParameter("viewPage");
	%>

	[Template 페이지]<br>

    <table border="1" style="text-align: center;">
        <tr>
           <td colspan="2">
           		<jsp:include page="top.jsp"/>
           </td> 
        </tr>
        <tr>
            <td>
           		<jsp:include page="<%=viewLeft %>"/>
            </td>
            <td>
           		<jsp:include page="<%=viewPage %>"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
           		<input type="submit" value="확인">
           		<input type="reset" value="취소">
            </td> 
        </tr>
    </table>
	
	
     
