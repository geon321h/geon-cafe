<%@page import="myPkg.EmplBeen"%>
<%@page import="myPkg.EmplDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    updateProc.jsp<br>
    
    <%
	   request.setCharacterEncoding("UTF-8");
    
/* 	   int eid = Integer.parseInt(request.getParameter("eid"));
	   String name = request.getParameter("name");
	   int dept = Integer.parseInt(request.getParameter("dept"));
	   int salary =  Integer.parseInt(request.getParameter("salary"));
	   
	   EmplBeen eb = new EmplBeen();
	   
	   eb.setEid(eid);
	   eb.setName(name);
	   eb.setDept(dept);
	   eb.setSalary(salary) ; */
	   
	   Object seid = session.getAttribute("seid");
	   System.out.print(seid);
	   
    %>
    
    <jsp:useBean id="eb" class="myPkg.EmplBeen">
    	<jsp:setProperty name="eb" property="*"/>
    </jsp:useBean>
    
    <%
    	EmplDao eDao = new EmplDao();
    	System.out.print(eb);
    	int cnt = eDao.updateEmpl(eb);
    	
    	String msg =null;
    	String url =null;
    	if(cnt >0){
    		msg = "수정 성공";
    		url = "select.jsp";
    	}else{
    		msg = "수정 실패";
    		url = "updateForm.jsp?eid="+eb.getEid();
    	}
    	
    %>
    
         <Script>
            alert("<%=msg%>");
            location.href="<%=url%>";
        </Script>