<%@page import="java.text.SimpleDateFormat"%>
<%@page import="my.board.BoardBean"%>
<%@page import="my.board.BoardDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- list.jsp<br> -->
	<%@include file="../mall_top.jsp" %>
   
   	<style>
	   	#mainContent table tr:first-child{
			background-color: #AFEEEE;
		}
	   	#mainContent caption {
			background-color: #AFEEEE;
			border: 1px solid black;
			margin-bottom: 10px;
		}
		#mainContent table, tr, td{
				border:1px solid black;
				cellpadding:0;
				cellspacing:0;
				border-collapse:collapse;
				margin-top: 3px;
			}
			
			*{
				font-family: "나눔스퀘어 네오" , "@맑은 고딕";
			}
			
			#mainContent form {
				text-align: center;
				margin: auto;
			}
			
			#mainContent p{
				font-size: 18px;
				margin-top: 30px;
			}
			
			#mainContent table{
				margin: auto;
			}
			
			
			#mainContent td{
				font-family: "나눔스퀘어 네오" , "@맑은 고딕";
				text-align: center;
				padding: 10px 20px;
			}
			
			
			#mainContent caption a {
				padding: 10px 20px;
				float: right;
			}
			
			#mainContent .leftText {
				text-align: left;
			}
			
			#mainContent A:link {text-decoration:none;color:#696969}
			#mainContent A:hover{text-decoration:yes;color:#66CCFF}
			#mainContent A:visited {text-decoration:none;color:#330066}
	</style>
	<%@include file="color.jsp" %>

	<%
	int pageSize = 10;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	String pageNum = request.getParameter("pageNum");
	
	if(pageNum == null){
		pageNum= "1";
	}
	
	int currentPage = Integer.parseInt(pageNum);
	int startRow = (currentPage - 1)*pageSize +1;
	int endRow = currentPage*pageSize;
	int count = 0;
	int number = 0;
	
    BoardDao bdao = BoardDao.getInstance();
    count =  bdao.getArticlesCount();
    number =count - (currentPage-1)*pageSize;
    
	ArrayList< BoardBean> lists = bdao.getArticles(startRow,endRow);
	%>
	<td id="mainContent" bgcolor="<%=bodyback_c%>">
        <form action="">
            <p>글목록(전체 글:<%=count %>)</p>
            <table>
            	<caption>
            		<a href="writeForm.jsp?pageNum=<%=pageNum%>">글쓰기</a>
            	</caption>
            	<%
            		if(count == 0){
            	%>
	            	<tr>
	                    <td>
	                        게시판에 저장된 글이 없습니다.
	                    </td>
	                </tr>
            	<%		
            		}else{
       			%>
                <tr>
                    <td>
                        번호
                    </td>
                    <td>
                        제목
                    </td>
                    <td>
                        작성자
                    </td>
                    <td>
                        작성일
                    </td>
                    <td>
                        조회수
                    </td>
                    <td>
                        ip
                    </td>
                </tr>
                <tr>
    
                </tr>
	             <% 
				for( BoardBean bb : lists){
				%>
				<tr bgcolor="white">
					<td><%=number--%></td>
					<td class="leftText">
						<%
							int wid = 0;
							//System.out.println(bb.getRe_level());
							if(bb.getRe_level()>0){
								wid = 20*bb.getRe_level();
								%>
                                <img src="images/level.gif" width="<%=wid %>" height="15">
						        <img src="images/re.gif">
								<%
							}
						%>	
						<a href="content.jsp?num=<%=bb.getNum()%>&pageNum=<%=pageNum%>"><%=bb.getSubject()%></a>
						<%
							if(bb.getReadcount()>=10){
								%>
									<img src="images/hot.gif">
								<%
							}
						%>	
					</td>
					<td><%=bb.getWriter()%></td>
					<td><%=sdf.format(bb.getReg_date())%></td>
					<td><%=bb.getReadcount()%></td>
					<td><%=bb.getIp()%></td>
				</tr>
				<%
				}
				%>
               	<%		
            		}
            	%>
            </table>
            <%
            	// 페이지 설정
            	if(count>0){
            		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
            		int pageBlock = 10; // 보이는 페이지 총 갯수 설정
            		
            		int startPage = ((currentPage-1) / pageBlock*pageBlock) + 1;
            		int endPage = startPage + pageBlock -1;
            		
            		if(endPage>pageCount){
            			endPage = pageCount;	
            		}
            		if(startPage>pageBlock){
            			%>
            				<a href="list.jsp?pageNum=<%=startPage-pageBlock%>">[이전]</a>
            			<%
            		}
            		
	            	for(int i=startPage;i<=endPage;i++){
            			%>
        					<a href="list.jsp?pageNum=<%=i%>">[<%=i%>]</a>
        				<%	
	            	}
            		if(endPage<pageCount){
            			%>
	        				<a href="list.jsp?pageNum=<%=startPage+pageBlock%>">[다음]</a>
	        			<%
            		}
	            		
            	}
            
            %>
        </form>
    </td>
    <%@include file="../mall_bottom.jsp" %>
    

    