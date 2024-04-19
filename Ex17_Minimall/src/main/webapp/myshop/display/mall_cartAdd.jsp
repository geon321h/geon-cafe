<%@page import="my.shop.ProductBean"%>
<%@page import="my.shop.ProductDao"%>
<%@page import="my.shop.mall.CartBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	mall_prodView.jsp(pnum,oqty) -> mall_cartAdd.jsp 

    <jsp:useBean id="mallCart" class="my.shop.mall.CartBean" scope="session"/>
    <%
    	
    	int pnum = Integer.parseInt(request.getParameter("pnum"));
    	int oqty = Integer.parseInt(request.getParameter("oqty"));
    	
    	System.out.println("pnum: "+pnum);
    	System.out.println("oqty: "+oqty);
    	
    	ProductDao pDao = ProductDao.getInstance();
		ProductBean pb = pDao.getProductByPnum(pnum);
    	
    	String msg="";
    	if(pb.getPqty()<oqty){
    		%>
		     <script type="text/javascript">
				alert('주문 수량 초과');
				history.back();
			</script>
    		<%
    	}else{
	    	mallCart.addProduct(pnum,oqty);
	    	%>
	    	     <script type="text/javascript">
					location.href="mall_cartList.jsp";
				</script>
	    	<%
    	}
    	
    %>	
    

    