<%@page import="my.member.MemberDTO"%>
<%@page import="my.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	main.jsp(id,password) -> loginPro.jsp<br>
	
    <%
        request.setCharacterEncoding("UTF-8");
        MemberDAO mdao = MemberDAO.getInstance();
    %>
    
    <jsp:useBean id="mDto" class="my.member.MemberDTO">
    	<jsp:setProperty name="mDto" property="*"/>
    </jsp:useBean>
    
	<%
    	MemberDTO member = mdao.login(mDto.getId(),mDto.getPassword());
    	
		String msg =null;
		String url =null;
		
		if(member != null){
			if(member.getId().equals("admin")){
				url = "myshop/admin/main.jsp";
			}else{
				url = "myshop/display/mall.jsp";
			}
		}else{
			msg = "아이디 혹은 비밀번호가 틀립니다.";
			url = "main.jsp";
		}
		
    %>
    
   	<Script>
	    alert("<%=msg%>");
	    location.href="<%=url%>";
	</Script>
	
	