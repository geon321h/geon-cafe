<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    Ex02_form.jsp => Ex02_result.jsp <br>
        <%
    	request.setCharacterEncoding("UTF-8"); // 제일위에 써야 한글처리된다.
    
    	int num1 = Integer.parseInt(request.getParameter("num1"));
    	int num2 = Integer.parseInt(request.getParameter("num2"));
		
    	int count = 0;
    	int mul = 1;
    	while(count < num2){
    		mul *= num1;
    		count++;
    	}
    	
    %>
    
    <%=num1%><sup><%=num2%></sup>=<%=mul%> <br>
    <%=num1%><sup><%=num2%></sup>=<%=Math.pow(num1, num2)%> <br>