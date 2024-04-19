<%@page import="my.shop.ProductBean"%>
<%@page import="my.shop.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    mall_cartList.jsp(pnum,oqty) -> mall_cartEdit.jsp
    
    <jsp:useBean id="mallCart" class="my.shop.mall.CartBean" scope="session"/>
    <%
    	
    	int pnum = Integer.parseInt(request.getParameter("pnum"));
    	int oqty = Integer.parseInt(request.getParameter("oqty"));
    	
    	ProductDao pDao = ProductDao.getInstance();
		ProductBean pb = pDao.getProductByPnum(pnum);
    	
		String msg="";
    	if(pb.getPqty()<oqty){
    		msg="주문 수량 초과";
    	}else{
    		msg="주문수량이 수정되었습니다.";
	    	mallCart.setEdit(pnum,oqty);
    	}
    	
    	//response.sendRedirect("mall_cartList.jsp");
    	
    %>	 
    
    <script type="text/javascript">
		alert('<%=msg%>');
		location.href="mall_cartList.jsp";
		//history.back();
	</script>