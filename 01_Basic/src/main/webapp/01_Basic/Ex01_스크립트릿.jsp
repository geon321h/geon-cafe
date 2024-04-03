<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>      
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	/* 
	body{
	
	} */
</style>
<script type="text/javascript">

</script>
</head>
<body>
	 Hello
	<script type="text/javascript">
		/* document.write("hi"); */
	</script>  
	
	<% 
	String name = "홍길동";
	System.out.println(name); 
	%>	 
	 JSP 주석 
	<br>
	<b>저의 이름은</b>
	<b><%=name %>입니다.</b>
	
</body>
</html> 

 