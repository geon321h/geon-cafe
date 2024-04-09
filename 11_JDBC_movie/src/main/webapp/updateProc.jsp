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
    	request.setCharacterEncoding("UTF-8");
    
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
	    System.out.println(mb.getName());
    	int cnt = mdao.updateMovie(mb);
    	
    	String msg =null;
    	String url =null;
    	
    	if(cnt > 0){
    		msg = "수정 성공";
    		url = "select.jsp";
    	}else{
    		msg = "수정 실패";
    		url = "updateForm.jsp?num="+mb.getNum();
    	}
    	
    %>
    <Script>
        alert("<%=msg%>");
        location.href="<%=url%>";
    </Script>