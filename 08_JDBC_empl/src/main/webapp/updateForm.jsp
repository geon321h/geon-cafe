<%@page import="myPkg.EmplBeen"%>
<%@page import="myPkg.EmplDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    updateForm.jsp<br>
    
    <%
	    request.setCharacterEncoding("UTF-8");
    
	   int eid = Integer.parseInt(request.getParameter("eid"));
	   
	   EmplDao eDao = new EmplDao();
	   EmplBeen eb = eDao.getEmplByEid(eid);
	   
	   session.setAttribute("seid", eid);
    %>

    <h2>회원 가입</h2>

    <form action="updateProc.jsp?eid=<%=eid%>" method="post">

        이름 : <input type="text" name="name" value="<%=eb.getName()%>"><br>
        부서번호 : <select name="dept" id="dept">
	                    <option value="1">1</option>
	                    <option value="2">2</option>
	                    <option value="3">3</option>
                  </select><br>
        급여 : <input type="text" name="salary" id="" value="<%=eb.getSalary()%>"><br>
        <input type="submit" value="보내기">
    </form>

    <script type="text/javascript">
    	let num = <%=eb.getDept()%>-1;
        document.getElementById('dept').options[num].selected = true;
    </script>
    
    