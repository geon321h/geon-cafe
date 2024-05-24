package myPkg;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardBean;
import board.BoardDao;

public class BoardReplyCommand implements BoardCommand{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
    	String pageNum = request.getParameter("pageNum");
    	
		BoardDao bdao = BoardDao.getInstance();
		BoardBean bb = new BoardBean();
		bb.setWriter(request.getParameter("writer"));
		bb.setEmail(request.getParameter("email"));
		bb.setSubject(request.getParameter("subject"));
		bb.setContent(request.getParameter("content"));
		bb.setPasswd(request.getParameter("passwd"));
		bb.setRef(Integer.parseInt(request.getParameter("ref")));
		bb.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		bb.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		bb.setReg_date(new Timestamp(System.currentTimeMillis()));
    	bb.setIp(request.getRemoteAddr());
    	int cnt = bdao.replyArticle(bb);
		
    	String url =null;
    	
    	if(cnt != -1){
    		url = "list.bd?pageNum="+pageNum;
    	}else{
    		url = "replyForm.jsp?ref="+bb.getRef()+"&re_step="+bb.getRe_step()+"&re_level="+bb.getRe_level()+"&pageNum="+pageNum;
    	}
    	request.setAttribute("url", url);
    	
	}

}
