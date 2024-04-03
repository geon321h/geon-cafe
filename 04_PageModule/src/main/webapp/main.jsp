<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   	<h3>[Template 페이지 - 메인페이지]</h3>
    	
	<form action="control.jsp" method="post">
	    <table border="1" style="text-align: center;">
	        <tr>
	           <th colspan="2" style="text-align: center;">
	           		제품을 선택해주세요
	           </th> 
	        </tr>
	        <tr>
	           		<th>제품</th>
	            <td>
					<input type="radio" name="product" value="tv">텔레비젼<br>
					<input type="radio" name="product" value="dc">디지털카메라<br>
					<input type="radio" name="product" value="mp">MP3플레이어
	            </td>
	        </tr>
	        <tr>
	            <td colspan="2" >
	           		<input type="submit" value="확인">
	           		<input type="reset" value="취소">
	            </td> 
	        </tr>
	    </table>
	</form>