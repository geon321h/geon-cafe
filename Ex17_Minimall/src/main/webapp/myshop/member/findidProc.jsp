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
    
    	MemberDTO member = mdao.findId(mDto);
    
/*     	System.out.println(mDto.getName());
    	System.out.println(mDto.getRrn1());
    	System.out.println(mDto.getRrn2());
    	System.out.println(id); */
		
		String msg =null;
		String url =null;
		
		if(member != null){
			msg = "해당하는 아이디는 \'"+member.getId()+"\' 입니다.";
			url = "../../main.jsp";
		}else{
			msg = "해당하는 아이디가 없습니다.";
			url = "findid.jsp";
		}
		
	%>
	<Script>
	    alert("<%=msg%>");
	    location.href="<%=url%>";
	</Script>