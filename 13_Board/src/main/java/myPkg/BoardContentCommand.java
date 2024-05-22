package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardBean;
import board.BoardDao;

public class BoardContentCommand implements BoardCommand{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

    	String num = request.getParameter("num");
    	String pageNum = request.getParameter("pageNum");
    	BoardDao bdao = BoardDao.getInstance();
    	BoardBean bb = bdao.getArticle(Integer.parseInt(num));
    	
    	request.setAttribute("bb", bb);
    	request.setAttribute("pageNum", pageNum);
		
	}

}
