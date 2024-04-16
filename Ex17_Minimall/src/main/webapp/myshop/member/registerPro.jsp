<%@page import="my.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!-- myshop/member/registerPro.jsp -->
    
    <%
        request.setCharacterEncoding("UTF-8");
        MemberDAO mdao = MemberDAO.getInstance();
    %>
    
    <jsp:useBean id="mDto" class="my.member.MemberDTO">
    	<jsp:setProperty name="mDto" property="*"/>
    </jsp:useBean>
    
    <%
    
	    int cnt = mdao.insertMember(mDto);
		
		String msg =null;
		String url =null;
		
		if(cnt != -1){
			msg = "추가 성공";
			url = "../../main.jsp";
		}else{
			msg = "추가 실패";
			url = "register.jsp";
		}
		
	%>
	<Script>
	    alert("<%=msg%>");
	    location.href="<%=url%>";
	</Script>