<%@page import="myPkg.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    updateForm.jsp => updateProc.jsp <br>
    
    <%
	    request.setCharacterEncoding("UTF-8");
    %>
    
    <jsp:useBean id="bb" class="myPkg.BookBeen">
    	<jsp:setProperty name="bb" property="*"/>
    </jsp:useBean>
    <%
    	String[] bookstoreArr = request.getParameterValues("bookstore");
	    String bookstore = "";
		for(String str : bookstoreArr){
			bookstore += str+" ";
		}
		bookstore.trim();
		bb.setBookstore(bookstore);
		
    	BookDao bDao = new BookDao();
    
    	int cnt = bDao.updateBook(bb);
    	
    	String msg =null;
    	String url =null;
    	
    	if(cnt > 0){
    		msg = "수정 성공";
    		url = "select.jsp";
    	}else{
    		msg = "수정 실패";
    		url = "updateForm.jsp?bid="+bb.getBid();
    	}
    	
    %>
    <Script>
        alert("<%=msg%>");
        location.href="<%=url%>";
    </Script>