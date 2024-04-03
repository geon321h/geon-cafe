<%@page import="myPkg.EmplDao"%>
<%@page import="myPkg.EmplBeen"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    insertProc.jsp<br>

    <!-- form에서 넘어온 값을 받아서 한 묶음으로 묶기 -->
    
    <%
	    request.setCharacterEncoding("UTF-8");
    
/*    String name = request.getParameter("name");
	   int dept = Integer.parseInt(request.getParameter("dept"));
	   int salary =  Integer.parseInt(request.getParameter("salary"));
	   
	   EmplBeen eb = new EmplBeen();
	   
	   eb.setName(name);
	   eb.setDept(dept);
	   eb.setSalary(salary) */;
	   
    %>
    
    <jsp:useBean id="eb" class="myPkg.EmplBeen">
    	<jsp:setProperty name="eb" property="*"/>
    </jsp:useBean>
    
    <%
    	EmplDao eDao = new EmplDao();
    
    	int cnt = eDao.insertEmpl(eb);
    	
    	String msg =null;
    	String url =null;
    	
    	if(cnt != -1){
    		msg = "삽입 성공";
    		url = "select.jsp";
    	}else{
    		msg = "삽입 실패";
    		url = "insertForm.jsp";
    	}
    	
    %>
        <Script>
            alert("<%=msg%>");
            location.href="<%=url%>";
        </Script>
        
            
            
            