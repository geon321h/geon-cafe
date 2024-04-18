<%@page import="my.shop.ProductBean"%>
<%@page import="my.shop.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- mall_top.jsp,mall_cgList.jsp(pname) => mall_prodView.jsp<br> -->
	<%@include file="mall_top.jsp" %>

	<style type="text/css">
		#viewTable{
			width: 90%;
			border-width:5px 0px 5px 0px;
			border-style: double;
			border-color: navy;
			margin-top: 50px;
		}
		
		#viewTable td {
			padding: 0px;
			border: 1px solid navy;
			border-width:1px 0px 1px 0px;
		}
		
		.title{
			width: 100%;
			height: 50px;
			color: #8FBC8B;
			font-size: 24px;
			font-weight: 900;
			background-color: #cdcdcd;
		}
		
		#viewTable tr:nth-child(2) td:first-child img{
			width: 300px;
			margin: 10px;
		}
		
		#viewTable tr:nth-child(2) td:last-child img{
			width: 70px;
			height: 30px;
		}
		
		
		#prodContent{
			height: 300px;
			text-align: left;
		}
		
		#viewTable tr:nth-child(2) td:last-child{
			text-align: left;
		}
		
		#viewTable tr:nth-child(2)  form{
			font-size: 16px;
			font-weight: bold;
			text-align: left;
			color: navy;
			padding: 30px;
		}
		
		#viewTable tr:nth-child(2) table td{
			border: 0px;
		}
		
		#prodContent p{
			font-size: 22px;
			font-weight: bold;
			margin: 10px;
			color: navy;		
		}
		
		#prodContent span {
			font-size: 16px;
			margin: 15px;		
		}
		
	</style>    

     <%
       request.setCharacterEncoding("UTF-8");
       int pnum = 1;
       if(request.getParameter("pnum") != null){
        pnum = Integer.parseInt(request.getParameter("pnum"));
       }
       
  		ProductDao pDao = ProductDao.getInstance();
  		ProductBean pb = pDao.getProductByPnum(pnum);
  		String requestFolder = request.getContextPath()+"/myshop/images";
  		String fullPath = requestFolder+"\\"+pb.getPimage();
   	%>
   	<td id="mainContent">
	  <table id="viewTable">
	  	<tr>
	       <td class="title" colspan="2">
	       		[<%=pb.getPname()%>] 상품정보
	       </td>
	     </tr>
	   	<tr>
	       <td width="50%">
	       		<img src="<%=fullPath%>"><br>
	       </td>
	       <td width="50%" >
	       		<form name="f" method="post">
		       		상품번호:<%=pb.getPnum()%><br>
		       		상품이름:<%=pb.getPname()%><br>
		       		상품가격:<%=pb.getPrice()%><br>
		       		상품포인트:<%=pb.getPoint()%><br>
		       		상품갯수:<input type="text" name="oqty" value="1"  size="5"/>개<br>
		       		<table width=50%>
						<tr>
							<td align="center">
								<a href="">
									<img src="<%=request.getContextPath()%>/img/cartbtn.gif">
								</a>
							</td>
							<td align="center">
								<a href="">
									<img src="<%=request.getContextPath()%>/img/orderbtn.gif" >
								</a>
							</td>
						</tr>
					</table>
	       		</form>
	       </td>
	     </tr>
	   	<tr>
	       <td colspan="2" id="prodContent" valign="top">
	       		<p>상품 상세 설명</p>
	       		<span><%=pb.getPcontents()%></span>
	       </td>
	     </tr>
    </table>
    </td>
    <%@include file="mall_bottom.jsp" %>