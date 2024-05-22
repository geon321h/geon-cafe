package myPkg;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardBean;
import board.BoardDao;

public class BoardWriteCommand implements BoardCommand{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		BoardDao bdao = BoardDao.getInstance();
		BoardBean bb = new BoardBean();
		bb.setWriter(request.getParameter("writer"));
		bb.setEmail(request.getParameter("email"));
		bb.setSubject(request.getParameter("subject"));
		bb.setContent(request.getParameter("content"));
		bb.setPasswd(request.getParameter("passwd"));
		bb.setReg_date(new Timestamp(System.currentTimeMillis())); 
    	bb.setIp(request.getRemoteAddr());

    	
    	int cnt = bdao.insertArticle(bb);
    	if(cnt > 0){
    		System.out.println("추가 성공");
    	}else{
    		System.out.println("추가 실패");
    	}
    	
		
	}

}
