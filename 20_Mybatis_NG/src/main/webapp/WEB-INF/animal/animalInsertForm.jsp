<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@include file="../common/common.jsp" %>

	<style type="text/css">
		h2{
			text-align: center;
		}
		table {
			font-family: "나눔스퀘어 네오";
			border-collapse: collapse;
			margin: 0 auto;
		}
		td,th {
			text-align: center;
			padding: 15px 20px;
		}
		td {
			text-align: left;		
		}
		tr:last-child td {
			text-align: center;		
		}
		.err{
			color: red;
			font-size: 14px;
		}
	</style> 
	
	<script type="text/javascript" src="resources/js/jquery.js"></script>
	<script type="text/javascript">
		var use;
		var isCheck = false;
		var isBlack = false;
		$(document).ready(function(){
			$('#id_check').click(function() {
				isBlack = false;
				isCheck = true;
				$.ajax({
					url : "id_check.am",
					type : "post",
					data :  ({
                    	"id" : $('input[name="id"]').val()
					}),
					success : function(data) {
						if($('input[name="id"]').val()==""){
							$('#idMessage').html("아이디를 입력해주세요.").css('color','red');
							isBlack = true;
						}else if($.trim(data) == "YES"){
							$('#idMessage').html("사용가능한 아이디입니다").css('color','blue');
							use = 'possible';
						}else{
							$('#idMessage').html("이미 등록된 아이디입니다.").css('color','red');
							use = 'impossible';
						}
					}
				});	
			});
			
			$('#btnSubmit').click(function() {
				if(use == 'impossible'){
					alert("이미 등록된 아이디입니다.");
					return false;
				}else if(!isCheck){
					alert("중복체크를 해주세요.");
					return false;
				}
			});
			
			$('input[name="id"]').keydown(function() {
				use="";
				isCheck = false;
				$('#idMessage').empty();
			});
			
		});
		
		var family_arr = [
            ['개','고양이','너구리','토끼'],
            ['금붕어','잉어'],
            ['개구리','도롱뇽'],
            ['거북이','도마뱀','뱀'],
            ['앵무새','병아리',"매추라기"]
        ];
		
		window.onload=function(){
			document.myform.family_animal.options[0] = new Option('동물 선택');
			//console.log(document.myform.nation.options[0].value);
			document.myform.family_animal.options[0].value = "";
			//console.log(document.myform.nation.options[0].value);
			
            var c_index = document.myform.class_animal.selectedIndex - 1;
            if(c_index != -1){
                for( c in family_arr[c_index] ){
                	document.myform.family_animal.options[parseInt(c)+1] = new Option(family_arr[c_index][c]);
                	if('${animal.family_animal}' == document.myform.family_animal.options[c].value){ 
                		//console.log(document.myform.nation.options[c]);
                		document.myform.family_animal.options[c].selected = true; 
                	}
                }
            }
		}
		
		function class_animalChange(){
            var f_index = document.myform.family_animal.selectedIndex;
            
            for( f in family_arr[f_index+1] ){
                document.myform.family_animal.options[1] = null;
            }
            
            var c_index = document.myform.class_animal.selectedIndex - 1;
            if(c_index != -1){
                for( c in family_arr[c_index] ){
                    document.myform.family_animal.options[parseInt(c)+1] = new Option(family_arr[c_index][c]);
                }
            }
        }
	</script>
	
	<%
		String[] class_animal = {"동물 분류 선택","포유류","어류","양서류","파충류","조류"}; 
		String[] many_animal = {"1","2","3","4","5"};
		String[] prduct_animal = {"통조림","원반","개껌","츄르","어항","목줄"};
	%>
	
	<h2>애완 동물 구매 신청 화면</h2>
	
	<form:form commandName="animal" name="myform" action="insert.am" method="post" >
		<input type="hidden" name="pageNumber" value="${pageNumber}">
		<table border="1">
			<tr>
				<th>구매자 아이디</th>
				<td colspan="3">
					<input type="text" name="id" value="${animal.id}">
					<input type="button" value="중복체크" id="id_check">
					<span id="idMessage"></span>
					<form:errors path="id" cssClass="err"></form:errors>
				</td>
			</tr>
			<tr>
				<th>동물 분류</th>
				<td>
					<select name="class_animal" onchange="class_animalChange()">
						<c:forEach var="class_animal" items="<%=class_animal%>" varStatus="vs">
							<c:if test="${vs.first}">
								<option value="">${class_animal}
							</c:if>
							<c:if test="${!vs.first}">
								<option value="${class_animal}" <c:if test="${animal.class_animal == class_animal}"> selected </c:if> >${class_animal}
							</c:if>
						</c:forEach>
					</select>
					<form:errors path="class_animal" cssClass="err"></form:errors>
				</td>
				<th>동물 종류</th>
				<td>
					<select name="family_animal">
					</select>
					<form:errors path="family_animal" cssClass="err"></form:errors>
				</td>
			</tr>
			<tr>
				<th>마릿수</th>
				<td colspan="3">
					<c:forEach var="many_animal" items="<%=many_animal%>">
						<input type="radio" name="many_animal" value="${many_animal}" <c:if test="${animal.many_animal == many_animal}"> checked </c:if>>${many_animal}
					</c:forEach>
					<form:errors path="many_animal" cssClass="err"></form:errors>
				</td>
			</tr>
			<tr>
				<th>애완용품 추가</th>
				<td colspan="3">
					<c:forEach var="prduct_animal" items="<%=prduct_animal%>">
						<input type="checkbox" name="prduct_animal" value="${prduct_animal}" <c:if test="${fn:contains(animal.prduct_animal,prduct_animal)}"> checked </c:if> >${prduct_animal}
					</c:forEach>
					<form:errors path="prduct_animal" cssClass="err"></form:errors>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="submit" value="추가하기" id="btnSubmit">
					<input type="button" value="목록보기" onclick="location.href='list.am?pageNumber=${pageNumber}'">					
				</td>
			</tr>
		</table>
	</form:form>