<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    int cnt=0;
    while(true){
    	int num = (int)(Math.random()*10)+1;
    	cnt++;
    	out.print(cnt+" 번째 = "+num+"<br>");
    	if(num == 7){
    		break;
    	}
    }
    
    %>