<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	String[] str = {"JSP","정말","재미","있다."};
    %>

    <table border="1" width="300">
        <tr>
            <th>배열의 첨자</th>
            <th>배열의 내용</th>
        </tr>
    <%
    	for(int i=0;i<str.length;i++){	
    %>
    <tr>
    	<td><%=i  %></td>
    	<td><%=str[i]  %></td>
    </tr>
    <%
    	}
    %>
   	</table>
   	<hr>
   	
    <table border="1" width="300">
        <tr>
            <th>배열의 첨자</th>
            <th>배열의 내용</th>
        </tr>
    <%
    	for(int i=0;i<str.length;i++){	
		    out.print("<tr>"+
		    	"<td>"+i+" </td>"+
		    	"<td>"+str[i]+"</td>"+
		    "</tr>");
    	}
    %>
   	</table>
    