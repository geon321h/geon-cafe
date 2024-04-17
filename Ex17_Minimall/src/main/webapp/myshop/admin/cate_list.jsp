<%@page import="java.util.ArrayList"%>
<%@page import="my.shop.CategoryDao"%>
<%@page import="my.shop.CategoryBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@include file="top.jsp" %>
	<style type="text/css">
		#cate_list {
			margin-top: 50px;
		}
		#cate_list table{
			width: 600px;
		}
		#cate_list h2{
			margin: 30px  0px;
		}
		
		#cate_list tr{
			height: 40px;
		}
	
		#cate_list tr:first-child {
			background-color: yellow;
		}
		
		#cate_list tr:first-child td {
			font-weight: bold;
		}
		
	</style>
    <td colspan="6" >
	    <!-- myshop/admin/cate_list.jsp 관리자 첫 페이지  -->
	    <form action="" method="post" id="cate_list">
        	<h2>카테고리 목록(cate_list.jsp)</h2>
            <table border="1">
                <tr>
                    <td>번호</td>
                    <td>카테고리 코드</td>
                    <td>카테고리명</td>
                    <td>삭제</td>
                </tr>
                	<%
                		CategoryDao cdao = CategoryDao.getInstance();
                	 	ArrayList<CategoryBean> category_lists = cdao.getAllCategory();
                	 	if(category_lists.size()>0){
							for(CategoryBean cb : category_lists){
								%>
								<tr>
									<td><%=cb.getCnum()%></td>
									<td><%=cb.getCode()%></td>
									<td><%=cb.getCname()%></td>
									<td><a href="deleteCateProc.jsp?cnum=<%=cb.getCnum()%>">삭제</a></td>
								</tr>
								<%
							}
                	 	}else{
                	 		%>
                	 		<tr>
                	 			<td colspan="4">등록된 카테고리가 없습니다.</td>
                	 		</tr>
                	 		<%
                	 	}
                	%>
            </table>
        </form>
    </td>
    <%@include file="bottom.jsp" %>