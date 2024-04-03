<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
Ex03_result.jsp<br>
   <%
    	request.setCharacterEncoding("UTF-8"); // 맨 위
    
    	String name = request.getParameter("name");
    	String age = request.getParameter("age");
    	String gender = request.getParameter("gender");
    	String hobby = request.getParameter("hobby");
    	String color = request.getParameter("color");
    	String abc = request.getParameter("abc");
    	
    	if(abc == null){
			out.print("abc라는 name이 없음<br>");
		}else{
			out.print("abc라는 name이 있음<br>");
		}
    	
    	if(gender.equals("man")) {  
    		gender="남자";
    	}else{
    		gender="여자";
    	}
    	String colorImg; 
    	  if(color.equals("blue")){
    		   colorImg = "../images/blue.jpg";
    	   }else if(color.equals("red")){
    		   colorImg = "../images/red.jpg";
    	   }else if(color.equals("yellow")){
    		   colorImg = "../images/yellow.jpg";
    	   }else {
    		   colorImg = "../images/green.jpg"; 
    	   }
    	%>
    	
    	이름: <%=name %><br>
    	나이: <%=age %><br>
    	성별: <%=gender %><br>
    	취미: <%=hobby %><br>
    	선택한 색: <%=color %><br>
    	
    	1: <img src="../images/<%=color+".jpg"%>"> <br>
    	2: <img src="../images/<%=color%>.jpg"> <br> 
    	3: <img src="<%=colorImg %>"> <br>
    	4: 
    	<%
    		out.print("<img src='../images/" + color + ".jpg'>");
    	%>
    	
    	
