package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDao;

public class BoardDeleteCommand implements BoardCommand{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		BoardDao bdao = BoardDao.getInstance();
		int num = Integer.parseInt(request.getParameter("num"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		String passwd = request.getParameter("passwd");
		
    	int cnt = bdao.deleteArticle(num,passwd);
    	
    	int count = bdao.getArticlesCount();
    	int pageSize = 10;
    	int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
    	
    	if(pageNum>pageCount){
    		pageNum -= 1;	
    	}
    	
    	String msg =null;
    	String url =null;
    	
    	if(cnt > 0){
    		url = "list.bd?pageNum="+pageNum;
    	}else if(cnt == 0){
    		msg = "비밀번호가 일치하지 않습니다.";
    		url = "deleteForm.jsp?num="+num+"&pageNum="+pageNum;
    	}else{
    		url = "deleteForm.jsp?num="+num+"&pageNum="+pageNum;
    	}
    	
    	request.setAttribute("msg", msg);
    	request.setAttribute("url", url);
		
	}

}
