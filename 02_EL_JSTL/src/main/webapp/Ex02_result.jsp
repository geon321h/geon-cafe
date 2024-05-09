<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<jsp:useBean id="pb" class="mypkg.PersonBean">
		<jsp:setProperty name="pb" property="*"/>
	</jsp:useBean>
	<%
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String age = request.getParameter("age");
	%>
	
	아이디1: <%=id %> <br>
	이름1: <%=name %><br>
	비번1: <%=password %><br>
	나이1: <%=age %><br>
	
	아이디2: <%=pb.getId() %> <br>
	이름2: <%=pb.getName() %><br>
	비번2: <%=pb.getPassword() %><br>
	나이2: <%=pb.getAge() %><br>
	
	아이디3: ${param.id} <br>
	이름3: ${param["name"]}<br>
	비번3: ${param['password']}<br>
	나이3: ${param.age}<br>
	
	아이디4: <jsp:getProperty name="pb" property="id"/><br>
	이름4: <jsp:getProperty name="pb" property="name"/><br>
	비번4: <jsp:getProperty name="pb" property="password"/><br>
	나이4: <jsp:getProperty name="pb" property="age"/><br>
	
	아이디5: ${pb.getId()} <br>
	이름5: ${pb.name}<br>
	비번5: ${pb['password']}<br>
	나이5: ${pb["age"]}<br>

	주소1 : <%=request.getParameter("addr") %><br> <!-- 	null -->
	주소2 : ${param.addr}<br> <!-- 	공백 --> 

	
		