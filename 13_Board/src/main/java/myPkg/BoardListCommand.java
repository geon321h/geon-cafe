package myPkg;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardBean;
import board.BoardDao;

public class BoardListCommand implements BoardCommand{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String pageNum = request.getParameter("pageNum");
		BoardDao bdao = BoardDao.getInstance();
		if(pageNum == null){
			pageNum= "1";
		}
		
		
		int pageSize = 10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1)*pageSize +1;
		int endRow = currentPage*pageSize;
		int count = 0;
		int number = 0;
	    count =  bdao.getArticlesCount();
	    number =count - (currentPage-1)*pageSize;
	    
	    ArrayList< BoardBean> lists = bdao.getArticles(startRow,endRow);
		
    	if(count>0){
    		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
    		int pageBlock = 10; // 보이는 페이지 총 갯수 설정
    		
    		int startPage = ((currentPage-1) / pageBlock*pageBlock) + 1;
    		int endPage = startPage + pageBlock -1;
    		
    		if(endPage>pageCount){
    			endPage = pageCount;	
    		}
    		request.setAttribute("pageBlock", pageBlock);
    		request.setAttribute("startPage", startPage);
    		request.setAttribute("endPage", endPage);
    	}
    	
    	request.setAttribute("lists", lists);
    	request.setAttribute("count", count);
    	request.setAttribute("number", number);
    	request.setAttribute("pageNum", pageNum);
		
	}

}
