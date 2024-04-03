<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		String viewPage = request.getParameter("viewPage");
	%>

	[Template 페이지]<br>

    <table border="1" style="width: 500px; height: 300px;">
        <tr>
           <td colspan="2">
           		<jsp:include page="top.jsp"/>
           </td> 
        </tr>
        <tr>
            <td>
           		<jsp:include page="left.jsp"/>
            </td>
            <td>
           		<jsp:include page="<%=viewPage %>"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
           		<jsp:include page="bottom.jsp"/>
            </td> 
        </tr>
    </table>
	
	
     
