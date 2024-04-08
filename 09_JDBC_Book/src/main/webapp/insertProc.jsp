<%@page import="myPkg.BookDao"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    insertProc.jsp<br>

    <!-- form에서 넘어온 값을 받아서 한 묶음으로 묶기 -->
    
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
    
    	int cnt = bDao.insertBook(bb);
    	
    	String msg =null;
    	String url =null;
    	
    	if(cnt != -1){
    		msg = "추가 성공";
    		url = "select.jsp";
    	}else{
    		msg = "추가 실패";
    		url = "insertForm.jsp";
    	}
    	
    %>
    <Script>
        alert("<%=msg%>");
        location.href="<%=url%>";
    </Script>
        
            
            
            