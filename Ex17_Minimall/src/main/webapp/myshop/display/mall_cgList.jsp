<%@page import="my.shop.ProductBean"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="my.shop.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!-- mall_top.jsp(code,cgname) => mall_cgList.jsp<br> -->
 	<%@include file="mall_top.jsp" %>   
    <%
        request.setCharacterEncoding("UTF-8");
        String code = request.getParameter("code");
        String cname = request.getParameter("cname");
        
        if(code == null){
        	code = "animal";
        	cname = "동물";
        }
		
    %>
    
    <style type="text/css">
	
		#mainContent h2 {
			margin-top: 30px;
			margin-bottom: 50px;
			font-size: 30px;
			font-weight: 900;
					
		}
		
		#mainContent table{
			margin-bottom: 50px;
			border-spacing: 30px;
			 border-collapse: separate;
		}
		
		.title{
		 	margin: 0 auto;
		 	margin-bottom: 20px;
			color: #DC143C;
			font-size: 24px;
			font-weight: 900;
			border-width:5px 0px 5px 0px;
			border-color: #8FBC8B	;
			border-style: double;
			padding: 20px 0px;
			width: 80%;
		}
		
		.Message{
			font-size: 18px;
			padding: 20px 0px;
			color: navy;
			font-weight: bold;
		}
		
		.content{
			width: 230px;
			height: 260px;
			padding: 10px 0px;
			border: 1px solid black;
		}
		.content img{
			margin-bottom: 20px;
			width: 100px;
			max-height:100px;
		}
		.content span {
			color: navy;
			font-size: 16px;
		}
		
	</style>
   	
   	<%
   		ProductDao pDao = ProductDao.getInstance();
   		DecimalFormat df = new DecimalFormat();
		String requestFolder = request.getContextPath()+"/myshop/images";
   	%>

    <td id="mainContent">
		<%
		ArrayList<ProductBean> lists = pDao.getProductByCode(code);
		%>
		<h2>Welcome to my mall!</h2>
		<div class="title"><%=cname%></div>
		<table border="0">
			<tr>
			<%
				if(lists.size()>0){
					int count = 0;
					for(int j=0;j<lists.size();j++){
						count++;
		        	 	String fullPath = requestFolder+"\\"+lists.get(j).getPimage();
						%>
							<td class="content" >
								<a href="mall_prodView.jsp?pnum=<%=lists.get(j).getPnum()%>">
									<img src="<%=fullPath%>"><br>
								</a>
								<span><%=lists.get(j).getPname()%></span><br>
								<span><font color="#DC143C"><%=df.format(lists.get(j).getPrice())%></font>원</span><br>
								<span>[<%=lists.get(j).getPoint()%>]point</span>
							</td>
						<%
						if(count%3==0){
							%>
								</tr>
								<tr>
							<%
						}
					}
				}else{
					%>
						<td colspan="3" class="Message">
							<%=cname%> 상품이 없습니다.
						</td> 
					<%								
				}
			%>
			</tr>
		</table>
    </td>
    
    <%@include file="mall_bottom.jsp" %>
    
    