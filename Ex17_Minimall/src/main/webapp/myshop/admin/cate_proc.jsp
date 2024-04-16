<%@page import="my.shop.CategoryDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    cate_proc.jsp<br>
    
     <%
        request.setCharacterEncoding("UTF-8");
     	CategoryDao cdao = CategoryDao.getInstance();
    %>
    
     <jsp:useBean id="cb" class="my.shop.CategoryBean">
    	<jsp:setProperty name="cb" property="*"/>
    </jsp:useBean>
    
    <%
    
	    int cnt = cdao.insertCategory(cb);
		
		String msg =null;
		String url = "";
		
		if(cnt != -1){
			msg = "추가 성공";
			url = "cate_list.jsp";
		}else{
			msg = "추가 실패";
			url = "cate_input.jsp";
		}
    
    %>
    
   	<Script>
	    alert("<%=msg%>");
	    location.href="<%=url%>";
	</Script>