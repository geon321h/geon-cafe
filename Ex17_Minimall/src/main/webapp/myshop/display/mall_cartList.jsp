<%@page import="java.text.DecimalFormat"%>
<%@page import="my.shop.ProductBean"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- mall_prodView.jsp(pnum,oqty) -> mall_cartAdd.jsp -> mall_cartList.jsp -->
    
	<%@include file="mall_top.jsp" %>
	
	<style type="text/css">
		#cartList {
			width: 80%;
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
			height: 60px;
			background: #8FBC8B;
		}
	</style>
	
    <jsp:useBean id="mallCart" class="my.shop.mall.CartBean" scope="session"/>
    <%
    	
      	String saveFolder = "/myshop/images";
  	 	String requestFolder = request.getContextPath()+"/"+saveFolder;
    	Vector<ProductBean> clist = mallCart.getClist();
    	DecimalFormat df = new DecimalFormat("###,###");
    
    %>	
	<td id="mainContent">
	    <table border="1" id="cartList" >
	        <tr>
	            <td colspan="6">장바구니 보기</td>
	        </tr>
	        <tr>
	            <td>번호</td>
	            <td>상품명</td>
	            <td>수량</td>
	            <td>단가</td>
	            <td>금액</td>
	            <td>삭제</td>
	        </tr>
	        <%
			int cartTotalPrice = 0;	                	    
			int cartTotalPoint = 0;
	        if(clist.size()>0){
				for(ProductBean pb : clist){
	              	    String fullPath = requestFolder+"\\"+pb.getPimage();
					%>
					<tr>
						<td><%=pb.getPnum()%></td>
						<td>
	                        <img src="<%=fullPath%>" width="50"/><br>
	                        <%=pb.getPname()%>
	                    </td>
						<td>
							<form action="mall_cartEdit.jsp" name="f" method="post">
		                        <input type="hidden" name="pnum" value="<%=pb.getPnum()%>" >
		                        <input type="text" name="oqty" value="<%=pb.getPqty()%>" size="2">개
		                        <input type="submit" value="수정">
		                     </form>
	                    </td>
						<td  align="right">
							<%=df.format(pb.getPrice())%>원<br>
							[<%=df.format(pb.getPoint())%>]point
						</td>
						<td  align="right">
	                        <%=df.format(pb.getPrice()*pb.getPqty())%>원<br>
	                        [<%=df.format(pb.getPoint()*pb.getPqty())%>]point
	                    </td>
						<td>
							<a href="mall_cartDel.jsp?pnum=<%=pb.getPnum()%>">삭제</a>
						</td>
					</tr>
					<%
					cartTotalPrice += pb.getPrice()*pb.getPqty();
					cartTotalPoint += pb.getPoint()*pb.getPqty();
				}
	  	 	}else{
	  	 		%>
	  	 		<tr>
	  	 			<td colspan="6">등록된 상품이 없습니다.</td>
	  	 		</tr>
	  	 		<%
	  	 	}
	      	%>
	        <tr>
	            <td colspan="4" align="left">
	            	<b>장바구니 총액 : </b>
					<font color="red">
		        			<%=df.format(cartTotalPrice) %> 원<br>
	        		</font>
	        		<b>총 적립 포인트 : </b>
					<font color="green">
		        			[<%=df.format(cartTotalPoint) %>] point
		        		</font>
	            </td>
	            <td colspan="2">
	                <a href="mall_order.jsp">[주문하기]</a>
	                <a href="">[게속쇼핑]</a>
	            </td>
	        </tr>
	
	    </table>
     </td>
    <%@include file="mall_bottom.jsp" %>
    