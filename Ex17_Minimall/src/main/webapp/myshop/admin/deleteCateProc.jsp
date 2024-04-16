<%@page import="my.shop.CategoryDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    deleteCateProc.jsp<br>
    
   	<%
	   int cnum = Integer.parseInt(request.getParameter("cnum"));
   		CategoryDao cdao = CategoryDao.getInstance();
	   int cnt = cdao.deleteCategory(cnum);
	   
	   String msg =null;
	   	if(cnt > 0){
	   		msg = "삭제 성공";
	   	}else{
	   		msg = "삭제 실패";
	   	}
    %>
         <Script>
            alert("<%=msg%>");
            location.href="cate_list.jsp";
        </Script>