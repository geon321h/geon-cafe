<%@page import="my.shop.ProductDao"%>
<%@page import="my.shop.ProductBean"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<!-- mall_cartList.jsp(pnum,oqty) ->mall_order.jsp -->
	
	<%@include file="mall_top.jsp" %>
	
	<style type="text/css">
		#cartList {
			width: 80%;
			border-width: 5px 0px 5px 0px;
			border-color: navy;
			border-style: double;
		}
		
		#cartList tr:first-child td{
			background-color: orange;
			height: 80px;
			font-size: 20px;
			font-weight: bold;
		}
		#cartList tr:nth-child(2) td{
			height: 40px;
			font-size: 16px;
			font-weight: bold;
			background: #8FBC8B;
		}
		#cartList tr:last-child td{
			height: 40px;
			background: #8FBC8B;
		}
		
		#mainContent form input {
			margin: 20px 0px;
			width:80px;
			height:40px;
			background-color: white;
			border:1px solid black;  
			border-radius: 5px;
			font-family: "나눔스퀘어 네오" , "@맑은 고딕";
		}
		
	</style>
	
    <jsp:useBean id="mallCart" class="my.shop.mall.CartBean" scope="session"/>
    <%
    	
    	String pnum = request.getParameter("pnum");
		String oqty = request.getParameter("oqty");
		if(pnum!=null && oqty!=null){
			ProductDao pDao = ProductDao.getInstance();
			ProductBean pb = pDao.getProductByPnum(Integer.parseInt(pnum));
	    	
	    	String msg="";
	    	if(pb.getPqty()<Integer.parseInt(oqty)){
	    		%>
			     <script type="text/javascript">
					alert('주문 수량 초과');
					history.back();
				</script>
	    		<%
	    	}else{
		    	mallCart.addProduct(Integer.parseInt(pnum),Integer.parseInt(oqty));
	    	}
		}
    
      	String saveFolder = "/myshop/images";
  	 	String requestFolder = request.getContextPath()+"/"+saveFolder;
    	Vector<ProductBean> clist = mallCart.getClist();
    	DecimalFormat df = new DecimalFormat("###,###");
    
    %>	
	<td id="mainContent">
	    <table border="1" id="cartList" >
	        <tr>
	            <td colspan="3">결제 내역서 보기</td>
	        </tr>
	        <tr>
	            <td>상품명</td>
	            <td>수량</td>
	            <td>금액</td>
	        </tr>
	        <%
			int cartTotalPrice = 0;	                	    
	        if(clist.size()>0){
				for(ProductBean pb : clist){
	              	    String fullPath = requestFolder+"\\"+pb.getPimage();
					%>
					<tr>
						<td>
	                        <%=pb.getPname()%>
	                    </td>
						<td align="right">
							<%=pb.getPqty()%>개
	                    </td>
						<td  align="right">
							<%=df.format(pb.getPrice())%>원
						</td>
					</tr>
					<%
					cartTotalPrice += pb.getPrice()*pb.getPqty();
				}
	  	 	}else{
	  	 		%>
	  	 		<tr>
	  	 			<td colspan="3">결제할 상품이 없습니다.</td>
	  	 		</tr>
	  	 		<%
	  	 	}
	      	%>
	        <tr>
	            <td colspan="3" >
	            	<b>결제하실 총액은: </b>
					<font color="red">
		        			<%=df.format(cartTotalPrice) %> 원<br>
	        		</font>
	            </td>
	        </tr>
	    </table>
           <input type="button" value="결제하기" onclick="location.href='mall_calculate.jsp'">
     </td>
    <%@include file="mall_bottom.jsp" %>
	