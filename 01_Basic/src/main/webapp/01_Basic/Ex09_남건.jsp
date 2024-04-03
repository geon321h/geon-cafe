<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<table border="1">
    <%
    	for(int i=0;i<9;i++){
		    out.print("<tr>");
    		for(int j=2;j<=9;j++){
	    		if(i==0){
	    			out.print("<th  style=\"background-color:purple\">"+j+"단</th>");
	    		}else{
	    			out.print("<td>"+j+"*"+i+"="+(i*j)+" </td>");
	    		}
    		}
		    out.print("</tr>");
    	}
    %>
   	</table>