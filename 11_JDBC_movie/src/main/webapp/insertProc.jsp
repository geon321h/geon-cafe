<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 	<%
    	request.setCharacterEncoding("UTF-8");
    %>
    <jsp:useBean id="mdao" class="myPkg.MovieDao"/>
    <jsp:useBean id="mb" class="myPkg.MovieBean">
    	<jsp:setProperty name="mb" property="*"/>
    </jsp:useBean>
    <%
    	String[] genreArr = request.getParameterValues("genre");
	    String genre = "";
	    if(genreArr == null){
	    	genre = "좋아하는 장르없음";	
	    }else{
			for(String str : genreArr){
				genre += str+" ";
			}
	    }
	    genre.trim();
	    mb.setGenre(genre);
	    
	    // System.out.println(mb.getMemo());
		
    	int cnt = mdao.insertMovie(mb);
    	
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
        
            
            
            