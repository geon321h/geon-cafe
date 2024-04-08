<%@page import="myPkg.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    updateForm.jsp => updateProc.jsp <br>
    
    <%
	    request.setCharacterEncoding("UTF-8");
    %>
    
    <jsp:useBean id="sb" class="myPkg.StudentBean">
    	<jsp:setProperty name="sb" property="*"/>
    </jsp:useBean>
    <%
	    String[] hobbyArr = request.getParameterValues("hobby");
	    String hobby = "";
	    if(hobbyArr == null){ //체크박스 선택x
	    	hobby = "선택사항없음";	
	    }else{
			for(String str : hobbyArr){
				hobby += str+" ";
			}
	    }
		hobby.trim();
		sb.setHobby(hobby);
		sb.setSum(sb.getJava()+sb.getJsp()+sb.getC());
		
		StudentDao sDao = new StudentDao();
    	int cnt = sDao.updateStudent(sb);
    	
    	String msg =null;
    	String url =null;
    	
    	if(cnt > 0){
    		msg = "수정 성공";
    		url = "select.jsp";
    	}else{
    		msg = "수정 실패";
    		url = "updateForm.jsp?num="+sb.getNum();
    	}
    	
    %>
    <Script>
        alert("<%=msg%>");
        location.href="<%=url%>";
    </Script>