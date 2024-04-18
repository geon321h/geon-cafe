<%@page import="java.io.File"%>
<%@page import="my.shop.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    deleteProdProc.jsp<br>
    
   	<%
	   	int pnum = Integer.parseInt(request.getParameter("pnum"));
	   	String pimage = request.getParameter("pimage");
		ProductDao pdao = ProductDao.getInstance();
		
	  	int cnt = pdao.deleteProduct(pnum);
	  	
	  	String configDir = config.getServletContext().getRealPath("/myshop/images");
	 	String fullPath = configDir+"\\"+pimage;
	  	
	 	File file = new File(fullPath);
	 	if(file.exists()){
	 		if(file.delete()){
	 			System.out.println(configDir);
	 			System.out.println("파일삭제 성공");
	 		}else{
	 			System.out.println("파일삭제 실패");
	 		}
	 	}else{
	 			System.out.println("파일없음");
	 	}
	   	
	   	String msg =null;
	   	if(cnt > 0){
	   		msg = "삭제 성공";
	   	}else{
	   		msg = "삭제 실패";
	   	}
    %>
         <Script>
            alert("<%=msg%>");
            location.href="prod_list.jsp";
        </Script>