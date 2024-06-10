<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@include file="../common/common.jsp" %>

	movieInsertForm.jsp<br>
	
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
			$('#title_check').click(function() {
				isBlack = false;
				isCheck = true;
				$.ajax({
					url : "title_check_proc.mv",
					type : "post",
					data :  ({
                    	"title" : $('input[name="title"]').val()
					}),
					success : function(data) {
						if($('input[name="title"]').val()==""){
							$('#titleMessage').html("title 입력누락").css('color','red');
							isBlack = true;
						}else if($.trim(data) == "YES"){
							$('#titleMessage').html("사용가능합니다.").css('color','blue');
							use = 'possible';
						}else{
							$('#titleMessage').html("이미 등록한 제목입니다.").css('color','red');
							use = 'impossible';
						}
					}
				});	
			});
			
			$('#btnSubmit').click(function() {
				if(use == 'impossible'){
					alert("이미 등록한 제목입니다.");
					return false;
				}else if(!isCheck){
					alert("중복체크를 해주세요.");
					return false;
				}
			});
			
			$('input[name="title"]').keydown(function() {
				use="";
				isCheck = false;
				$('#titleMessage').empty();
			});
			
		});
		
		var nation_arr = [
            ['한국','중국','일본','베트남'],
            ['영국','프랑스','독일'],
            ['미국','캐나다'],
            ['이집트','가나','케냐'],
            ['뉴질랜드','오스트레일리아']
        ];
		
		window.onload=function(){
			document.myform.nation.options[0] = new Option('나라 선택하세요');
			//console.log(document.myform.nation.options[0].value);
			document.myform.nation.options[0].value = "";
			//console.log(document.myform.nation.options[0].value);
			
            var c_index = document.myform.continent.selectedIndex - 1;
            if(c_index != -1){
                for( c in nation_arr[c_index] ){
                	document.myform.nation.options[parseInt(c)+1] = new Option(nation_arr[c_index][c]);
                	if('${movie.nation}' == document.myform.nation.options[c].value){ 
                		//console.log(document.myform.nation.options[c]);
                		document.myform.nation.options[c].selected = true; 
                	}
                }
            }
		}
		
		function continentChange(){
            var n_index = document.myform.nation.selectedIndex;
            
            // 변경시 선택하세요 구문 제외 초기화
            for( n in nation_arr[n_index+1] ){
                document.myform.nation.options[1] = null;
            }
            
            // 대륙 변경에 따른 나라 나열
            var c_index = document.myform.continent.selectedIndex - 1;
            if(c_index != -1){
                for( c in nation_arr[c_index] ){
                    document.myform.nation.options[parseInt(c)+1] = new Option(nation_arr[c_index][c]);
                }
            }
        }
	</script>
	
	<%
		String[] genre = {"액션","스릴러","코미디","판타지","애니메이션"}; 
		String[] grade = {"19","15","12","7"};
		String[] continent = {"대륙 선택하세요","아시아","유럽","아메리카","아프리카","오세아니아"};
	%>
	
	<h2>영화 정보 등록 화면</h2>
	
	<form:form commandName="movie" name="myform" action="insert.mv" method="post" >
		<input type="hidden" name="pageNumber" value="${pageNumber}">
		<table border="1">
			<tr>
				<th>영화 제목</th>
				<td colspan="3">
					<input type="text" name="title" value="${movie.title}">
					<input type="button" value="중복체크" id="title_check">
					<span id="titleMessage"></span>
					<form:errors path="title" cssClass="err"></form:errors>
				</td>
			</tr>
			<tr>
				<th>대륙</th>
				<td>
					<select name="continent" onchange="continentChange()">
						<c:forEach var="continent" items="<%=continent%>" varStatus="vs">
							<c:if test="${vs.first}">
								<option value="">${continent}
							</c:if>
							<c:if test="${!vs.first}">
								<option value="${continent}" <c:if test="${movie.continent == continent}"> selected </c:if> >${continent}
							</c:if>
						</c:forEach>
					</select>
					<form:errors path="continent" cssClass="err"></form:errors>
				</td>
				<th>나라</th>
				<td>
					<select name="nation">
					</select>
					<form:errors path="nation" cssClass="err"></form:errors>
				</td>
			</tr>
			<tr>
				<th>장르</th>
				<td colspan="3">
					<c:forEach var="genre" items="<%=genre%>">
						<input type="checkbox" name="genre" value="${genre}" <c:if test="${fn:contains(movie.genre,genre)}"> checked </c:if> >${genre}
					</c:forEach>
					<form:errors path="genre" cssClass="err"></form:errors>
				</td>
			</tr>
			<tr>
				<th>관람 등급</th>
				<td colspan="3">
					<c:forEach var="grade" items="<%=grade%>">
						<input type="radio" name="grade" value="${grade}" <c:if test="${movie.grade == grade}"> checked </c:if>>${grade}
					</c:forEach>
					<form:errors path="grade" cssClass="err"></form:errors>
				</td>
			</tr>
			<tr>
				<th>출연 배우</th>
				<td colspan="3">
					<input type="text" name="actor" value="${movie.actor}">
					<form:errors path="actor" cssClass="err"></form:errors>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="submit" value="추가하기" id="btnSubmit">
					<input type="button" value="목록보기" onclick="location.href='list.mv?pageNumber=${pageNumber}'">					
				</td>
			</tr>
		</table>
	</form:form>