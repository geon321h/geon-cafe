<%@page import="my.shop.CategoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="my.shop.CategoryDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@include file="top.jsp" %>
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
		}
		
	    #prod_input td:nth-child(2) {
			text-align: left;
	    }
	    
	    #prod_input tr:last-child td {
	 		background-color: eaeaea;
		}
	    
	</style>
	
	<%
  		CategoryDao cdao = CategoryDao.getInstance();
  	 	ArrayList<CategoryBean> category_lists = cdao.getAllCategory();
  	 	
  	 	String[] pspec = {"NORMAL","NEW","HOT"};
  	%>
	
    <td colspan="6" >
	    <!-- myshop/admin/prod_input.jsp 관리자 첫 페이지  -->
	    <form action="" method="post" id="prod_input" enctype="multipart/form-data">
        	<h2>상품 등록</h2>
            <table >
                <tr>
                    <td>카테고리</td>
                    <td>
                        <select name="pcategory_fk">
                        	<% 
                        		for(CategoryBean cb : category_lists){
                        			%>
                        				<option value="<%=cb.getCname()%>"><%=cb.getCname()%></option>
                        			<%
	                        	}
                        	%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>상품명</td>
                    <td>
                        <input type="text" name="pname" maxlength="50" placeholder="상품명">
                    </td>
                </tr>
                <tr>
                    <td>상품코드</td>
                    <td>
                        <input type="text" name="pname" maxlength="50" placeholder="상품코드">
                    </td>
                </tr>
                <tr>
                    <td>제조회사</td>
                    <td>
                        <input type="text" name="pcompany" maxlength="50" placeholder="제조회사">
                    </td>
                </tr>
                <tr>
                    <td>상품이미지</td>
                    <td>
                        <input type="file" name="pimage" maxlength="30">
                    </td>
                </tr>
                <tr>
                    <td>상품 수량</td>
                    <td>
                        <input type="text" name="pqty" maxlength="10" placeholder="0">
                    </td>
                </tr>
                <tr>
                    <td>상품 가격</td>
                    <td>
                        <input type="text" name="price" maxlength="50" placeholder="0">
                    </td>
                </tr>
                <tr>
                    <td>상품 스펙</td>
                    <td>
                   		<select name="pspec">
             		       <% 
                        		for(String str : pspec){
                        			%>
                        				<option value="<%=str %>">::<%=str %>::</option>
                        			<%
	                        	}
                        	%>
                   		</select>
                    </td>
                </tr>
                <tr>
                    <td>상품 소개</td>
                    <td>
                        <textarea rows="6" cols="60" name="pcontents" placeholder="상품에 대한 소개를 해주세요."></textarea>
                    </td>
                </tr>
                <tr>
                    <td>상품 포인트</td>
                    <td>
                        <input type="text" name="point" maxlength="50" placeholder="0">
                    </td>
                </tr>
                <tr >
                    <td colspan="2">
						<input type="submit"  value="등록">
                        <input type="reset"  value="취소">
                    </td>
                </tr>
            </table>
        </form>
    </td>
    <%@include file="bottom.jsp" %>