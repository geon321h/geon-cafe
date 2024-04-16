<%@page import="my.member.MemberDTO"%>
<%@page import="my.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
        request.setCharacterEncoding("UTF-8");
        MemberDAO mdao = MemberDAO.getInstance();
    %>
    
    <jsp:useBean id="mDto" class="my.member.MemberDTO">
    	<jsp:setProperty name="mDto" property="*"/>
    </jsp:useBean>
    
    <%
    
    	MemberDTO member = mdao.findPwd(mDto);
    
		String msg =null;
		String url =null;
		
		if(member != null){
			msg = "해당 계정의 비밀번호는 \'"+member.getPassword()+"\' 입니다.";
			url = "../../main.jsp";
		}else{
			msg = "해당 계정이 없습니다.";
			url = "findpwd.jsp";
		}
		
	%>
	<Script>
	    alert("<%=msg%>");
	    location.href="<%=url%>";
	</Script>