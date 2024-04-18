<%@page import="my.shop.ProductDao"%>
<%@page import="my.shop.ProductBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="my.shop.CategoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- prod_list.jsp(pnum) -> prod_view.jsp -->
	<%@include file="top.jsp" %>
	<style type="text/css">
		#prod_view {
			margin: 50px 0px;
		}
		#prod_view table{
			width: 800px;
			border-top: 5px;
			border-bottom: 5px;
			border-left: 0px;
			border-right: 0px;
			border-style: double;
			border-color: navy;
			border-collapse: separate;
		}
		
		#prod_view tr{
			height: 50px;
		}
	
		#prod_view tr td:nth-child(2n-1) {
			background-color: orange;
			font-weight: bold;
		}
		
	    #prod_view td:nth-child(2n) {
			text-align: left;
			font-weight: 900;
			color: navy;
	    }
	    
   	   #prod_view #imgarea {
			text-align: center;
	    }
	    
	    #prod_view tr:last-child td {
	 		background-color: eaeaea;
		}
	    
	</style>
	
	<%
		int pnum = Integer.parseInt(request.getParameter("pnum"));	
		ProductDao pdao = ProductDao.getInstance();
		ProductBean pb = pdao.getProductByPnum(pnum);
		
    	String saveFolder = "/myshop/images";
	 	String requestFolder = request.getContextPath()+"/"+saveFolder;
	 	String fullPath = requestFolder+"\\"+pb.getPimage();
	 	
  	%>
	
    <td colspan="6" >
	    <!-- myshop/admin/prod_input.jsp 관리자 첫 페이지  -->
	    <div  id="prod_view">
        	<h2>상품상세보기</h2>
            <table border="1">
                <tr>
                    <td>카테고리</td>
                    <td>
                    	<sapn><%=pb.getPcategory_fk() %></sapn>
                    </td>
					<td>상품번호</td>
                    <td>
                    	<sapn><%=pb.getPnum() %></sapn>
                    </td>
                </tr>
                <tr>
                    <td>상품명</td>
                    <td>
                        <sapn><%=pb.getPname() %></sapn>
                    </td>
                    <td>제조회사</td>
                    <td>
                        <sapn><%=pb.getPcompany() %></sapn>
                    </td>                    
                </tr>
                <tr>
                    <td>상품이미지</td>
                    <td colspan="3" id="imgarea">
                    	<img src="<%=fullPath%>" width="200"/>
                    </td>
                </tr>
                <tr>
                    <td>상품 수량</td>
                    <td>
                    	<sapn><%=pb.getPqty() %></sapn>
                    </td>
                    <td>상품 가격</td>
                    <td>
                    	<sapn><%=pb.getPrice() %></sapn>
                    </td>
                </tr>
                <tr>
                    <td>상품 스펙</td>
                    <td>
                    	<sapn><%=pb.getPspec() %></sapn>
                    </td>
                    <td>상품 포인트</td>
                    <td>
                    	<sapn><%=pb.getPoint() %></sapn>
                    </td>
                </tr>
                <tr>
                    <td>상품 소개</td>
                    <td height="100" colspan="3" valign="top">
                    	<sapn><%=pb.getPcontents() %></sapn>
                    </td>
                </tr>                
                <tr >
                    <td colspan="4" >
						<input type="button"  value="돌아가기" onclick="location.href='prod_list.jsp'">
                    </td>
                </tr>
            </table>
        </div>
    </td>
    <%@include file="bottom.jsp" %>