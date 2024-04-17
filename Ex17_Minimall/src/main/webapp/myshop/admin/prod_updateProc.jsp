<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="my.shop.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    prod_updateProc.jsp.jsp<br>
    
   	<%
		ProductDao pdao = ProductDao.getInstance();
	  	
	    String configDir = config.getServletContext().getRealPath("/myshop/images");
	    int maxSize = 1024*1024*5;
	    String encoding = "UTF-8";
	    MultipartRequest mr = new MultipartRequest(request,configDir,maxSize,encoding,new DefaultFileRenamePolicy());
	   	
	    if(mr.getOriginalFileName("pimage2")!=null && mr.getParameter("pimage")!=null){
		 	String fullPath = configDir+"\\"+mr.getParameter("pimage");
    	 	File file = new File(fullPath);
    	 	
			/*  System.out.println(fullPath);
 			System.out.println(file);
 			System.out.println(file.exists()); */
    	 	if(file.exists()){
    	 		if(file.delete()){
    	 			System.out.println("파일삭제 성공");
    	 		}else{
    	 			System.out.println("파일삭제 실패");
    	 		}
    	 	}else{
    	 			System.out.println("파일없음");
    	 	}
	    }
	    
	    int cnt = pdao.updateProduct(mr);
	    
	   	String msg =null;
	   	String url =null;
	   	if(cnt > 0){
	   		msg = "수정 성공";
	   		url = "prod_list.jsp";
	   	}else{
	   		msg = "수정 실패";
	   		url = "prod_update.jsp?pnum="+mr.getParameter("pnum");
	   	}
    %>
         <Script>
            alert("<%=msg%>");
            location.href="<%=url%>";
        </Script>