<%@page import="my.shop.mall.CartBean"%>
<%@page import="my.shop.ProductBean"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	mall_order.jsp(결제하기) ->mall_calculate.jsp

    <jsp:useBean id="mallCart" class="my.shop.mall.CartBean" scope="session"/>
    <jsp:useBean id="order" class="my.shop.mall.OrdersDao" scope="session"/>
    
    <%
    
    	int memno = (Integer)session.getAttribute("no");
    	
    	Vector<ProductBean> clist = mallCart.getClist();
    	int cnt = order.insertOrders(memno,clist);
    	mallCart.removeAllProduct();
    	
    	String msg="";
    	if(cnt>0){
    		msg="결제 성공";
    	}else{
    		msg="결제 실패";
    	}
    	
    %>
    
     <script type="text/javascript">
		alert('<%=msg%>');
		location.href="mall_cartList.jsp";
	</script>