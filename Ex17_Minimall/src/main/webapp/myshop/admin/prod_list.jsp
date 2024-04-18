<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="my.shop.ProductBean"%>
<%@page import="my.shop.ProductDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@include file="top.jsp" %>
	<style type="text/css">
		#prod_list {
			margin-top: 20px;
		}
		#prod_list table{
			width: 90%;
			border-top: 5px;
			border-bottom: 5px;
			border-left: 0px;
			border-right: 0px;
			border-style: double;
			border-color: navy;
			border-collapse: separate;
			
		}
		
		#prod_list tr{
			height: 40px;
		}
	
		#prod_list tr:first-child {
			background-color: orange;
		}
		
		#prod_list tr:first-child td {
			font-weight: bold;
		}
		
	</style>
	
	<script type="text/javascript">
		function checkDel() {
			if (confirm("정말 삭제하시겠습니까?") == true){    //확인
				return;
			 }else{   //취소
			     return false;
			 }
		}
	</script>
    <td colspan="6" >
	    <!-- myshop/admin/cate_list.jsp 관리자 첫 페이지  -->
	    <form action="" method="post" id="prod_list">
        	<h2>상품 목록<!-- (prod_list.jsp) --></h2>
            <table >
                <tr>
                    <td>번호</td>
                    <td>상품코드</td>
                    <td>상품명</td>
                    <td>이미지</td>
                    <td>가격</td>
                    <td>제조회사</td>
                    <td>수량</td>
                    <td>수정 | 삭제</td>
                </tr>
                	<%
                		ProductDao pdao = ProductDao.getInstance();
                	 	ArrayList<ProductBean> product_lists = pdao.getAllProduct();
                	 	
                    	String saveFolder = "/myshop/images";
                	 	String requestFolder = request.getContextPath()+"/"+saveFolder;
                	    
                	 	if(product_lists.size()>0){
							for(ProductBean pb : product_lists){
		                	    String fullPath = requestFolder+"\\"+pb.getPimage();
								%>
								<tr>
									<td><%=pb.getPnum()%></td>
									<td><%=pb.getPcategory_fk()%></td>
									<td><%=pb.getPname()%></td>
									<td><img src="<%=fullPath%>" width="50" onclick="location.href='prod_view.jsp?pnum=<%=pb.getPnum()%>'"/></td>
									<td  align="right"><%=pb.getPrice()%></td>
									<td><%=pb.getPcompany()%></td>
									<td align="right"><%=pb.getPqty()%></td>
									<td>
										<a href="prod_update.jsp?pnum=<%=pb.getPnum()%>">수정</a> |
										<a href="deleteProdProc.jsp?pnum=<%=pb.getPnum()%>&pimage=<%=pb.getPimage()%>" onclick="return checkDel()">삭제</a>
									</td>
								</tr>
								<%
							}
                	 	}else{
                	 		%>
                	 		<tr>
                	 			<td colspan="4">등록된 상품이 없습니다.</td>
                	 		</tr>
                	 		<%
                	 	}
                	%>
            </table>
        </form>
    </td>
    <%@include file="bottom.jsp" %>