<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="my.shop.mall.OrdersDao"%>
<%@page import="my.shop.mall.OrderBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@include file="top.jsp" %>
	<style type="text/css">
		[name="orderList"] {
			width: 800px;
		}
		
		[name="orderList"] tr:nth-child(2) {
			background-color: #cdcdcd;
		}
	
	</style>
    <%
       	OrdersDao odao = new OrdersDao();
       	ArrayList<OrderBean> lists =null;
       	String name = request.getParameter("name");
       	if(name == null){
       		
       		lists = odao.getAllOrders("");
       		
       	}else{
       		
       		lists = odao.getAllOrders(name);
       		
       	}
    %>
	
    <td colspan="6" >
	    <table border="1" name="orderList" >
	        <tr>
	            <td colspan="5">
	            	<form action="shopping_list.jsp" method="post">
	            	조회할 회원 아이디 입력: 
		            	<input type="text" name="name" size="20">
		            	<input type="submit" value="내역 조회"> 
	            	</form>
	            </td>
	        </tr>
	        <tr>
	            <td>회원명</td>
	            <td>회원 아이디</td>
	            <td>상품명</td>
	            <td>수량</td>
	            <td>금액</td>
	        </tr>

	        <%
			int TotalAmount = 0;	                	    
	    	DecimalFormat df = new DecimalFormat("###,###");
	    	
	        if(lists != null){
				for(OrderBean ob : lists){
					%>
					<tr>
						<td><%=ob.getMname()%></td>
						<td><%=ob.getMid()%></td>
						<td><%=ob.getPname()%></td>
						<td align="right"><%=ob.getQty()%></td>
						<td align="right"> &#8361;<%=df.format(ob.getAmount())%></td>
					<tr>
					<%
					TotalAmount += ob.getAmount();
				}
	  	 	}else{
	  	 		%>
	  	 		<tr>
	  	 			<td colspan="5">구매내역이 없습니다.</td>
	  	 		</tr>
	  	 		<%
	  	 	}
	      	%>
	        <tr>
	            <td colspan="4">
	            	<b>총 금액 </b>
	            </td>
	            <td colspan="1" align="right">
					 &#8361;<%=df.format(TotalAmount)%>
	            </td>
	        </tr>
	    </table>
    </td>
    <%@include file="bottom.jsp" %>