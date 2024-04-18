<%@page import="my.shop.ProductBean"%>
<%@page import="my.shop.ProductDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="my.shop.CategoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@include file="top.jsp" %>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/script.js"></script>
	<style type="text/css">
		#prod_input {
			margin: 50px 0px;
		}
		#prod_input table{
			width: 800px;
			border-top: 5px;
			border-bottom: 5px;
			border-left: 0px;
			border-right: 0px;
			border-style: double;
			border-color: navy;
			border-collapse: separate;
   			border-spacing: 5px 5px;			
		}
		
		#prod_input h2{
			margin: 30px  0px;
		}
		
		#prod_input tr{
			height: 50px;
		}
	
		#prod_input tr td:first-child {
			background-color: orange;
			font-weight: bold;
			width: 100px;
		}
		
	    #prod_input td:nth-child(2) {
			text-align: left;
	    }
	    
	    #prod_input tr:last-child td {
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
  	 	String[] pspec = {"NORMAL","NEW","HOT"};
  	 	
  	%>
	
    <td colspan="6" >
	    <!-- myshop/admin/prod_input.jsp 관리자 첫 페이지  -->
	    <form action="prod_updateProc.jsp" method="post" id="prod_input" enctype="multipart/form-data" >
        	<h2>상품 수정</h2>
            <table >
                <tr>
                    <td>카테고리</td>
                    <td>
                        <input type="text" maxlength="50" disabled value="<%=pb.getPcategory_fk() %>">
                    </td>
                </tr>
                <tr>
                    <td>상품번호</td>
                    <td>
                        <input type="hidden" name="pnum" maxlength="50" placeholder="상품번호"  value="<%=pb.getPnum() %>"><%=pb.getPnum() %>
                    </td>
                </tr>
                <tr>
                    <td>상품명</td>
                    <td>
                        <input type="text" name="pname" maxlength="50" placeholder="상품명" value="<%=pb.getPname() %>">
                    </td>
                </tr>
                <tr>
                    <td>제조회사</td>
                    <td>
                        <input type="text" name="pcompany" maxlength="50" placeholder="제조회사" value="<%=pb.getPcompany() %>">
                    </td>
                </tr>
                <tr>
                    <td>상품이미지</td>
                    <td>
                    	<img src="<%=fullPath%>" width="200"/>
                        <input type="file" maxlength="30" name="pimage2" onchange="" >
                        <input type="text" maxlength="50" name="pimage" placeholder="이미지"  value="<%=pb.getPimage() %>">
                    </td>
                </tr>
                <tr>
                    <td>상품 수량</td>
                    <td>
                        <input type="text" name="pqty" maxlength="10" placeholder="0" value="<%=pb.getPqty() %>">
                    </td>
                </tr>
                <tr>
                    <td>상품 가격</td>
                    <td>
                        <input type="text" name="price" maxlength="50" placeholder="0" value="<%=pb.getPrice() %>">
                    </td>
                </tr>
                <tr>
                    <td>상품 스펙</td>
                    <td>
                   		<select name="pspec" >
             		       <% 
                        		for(String str : pspec){
                        			%>
                        				<option value="<%=str %>" <%if(str.equals(pb.getPspec())){%>selected<%}%>><%=str %></option>
                        			<%
	                        	}
                        	%>
                   		</select>
                    </td>
                </tr>
                <tr>
                    <td>상품 소개</td>
                    <td>
                        <textarea rows="6" cols="60" name="pcontents" placeholder="상품에 대한 소개를 해주세요."><%=pb.getPcontents() %></textarea>
                    </td>
                </tr>
                <tr>
                    <td>상품 포인트</td>
                    <td>
                        <input type="text" name="point" maxlength="50" placeholder="0" value="<%=pb.getPoint() %>">
                    </td>
                </tr>
                <tr >
                    <td colspan="2">
						<input type="submit"  value="수정">
                        <input type="reset"  value="취소">
                    </td>
                </tr>
            </table>
        </form>
    </td>
    <%@include file="bottom.jsp" %>