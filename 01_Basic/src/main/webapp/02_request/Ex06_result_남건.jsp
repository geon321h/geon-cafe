<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    Ex06_result_남건.jsp<br>

        <%
            
        	request.setCharacterEncoding("UTF-8");
        
            String id = request.getParameter("id");
            String pw = request.getParameter("pw");
            String[] product = request.getParameterValues("product");
            String time = request.getParameter("time");
            String approve = request.getParameter("approve");
            String agree = request.getParameter("agree");
            
        %>
        
        <table border="1">
            <tr>
                <th>아이디</th>
                <td><%=id %></td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><%=pw %></td>
            </tr>
            <tr>
                <th>구매상품</th>
                <td>
                <%
                    for(String p : product){
                        out.print(p+" ");
                    }
                %>
            </td>
            </tr>
            <tr>
                <th>배송시간</th>
                <td><%=time %></td>
            </tr>
            <tr>
                <th>결제방법</th>
                <td><%=approve %></td>
            </tr>
            <tr>
                <th>결제동의</th>
                <td>
                <%
                    if(agree==null){
                        out.print("동의 안함");
                    }else{
                        out.print("동의");
                    }
                %>
                </td>
            </tr>
        </table>
        
        <hr>
        
        
         <table border="1">
            <%
                Enumeration<String> names = request.getParameterNames();
            
                while (names.hasMoreElements()) {
                String eval = "";
                    String em = names.nextElement();
                    String[] values = request.getParameterValues(em);
                    for (String v : values) {
                    	if (em.equals("agree")) {
		                    out.print("<tr><th>agree</th>");
		                    out.print("<td>동의</td></tr>");
		                    break;
                    	}
                   	eval += v + " ";
                    }
                    out.print("<tr><th>"+em +"</th>");
                    out.print("<td>"+eval +"</td></tr>");
                    if (em.equals("approve")) {
                    	if(!names.hasMoreElements()){
                    		em = "agree";
                        	eval = "동의 안함";
	                        out.print("<tr><th>"+em +"</th>");
	                        out.print("<td>"+eval +"</td></tr>");
                    	}
                    }
                }
                %>
        </table>
        
        
        