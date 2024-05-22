package myPkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardBean;
import board.BoardDao;

public class BoardUpdateCommand implements BoardCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		BoardDao bdao = BoardDao.getInstance();
		BoardBean bb = new BoardBean();
		bb.setNum(num);
		bb.setWriter(request.getParameter("writer"));
		bb.setEmail(request.getParameter("email"));
		bb.setSubject(request.getParameter("subject"));
		bb.setContent(request.getParameter("content"));
		bb.setPasswd(request.getParameter("passwd"));
		
     	int cnt = bdao.updateArticle(bb);
     	
    	String msg =null;
    	String url =null;
    	
    	if(cnt > 0){
    		url = "list.bd?pageNum="+pageNum;
    	}else if(cnt == 0){
    		msg = "비밀번호가 일치하지 않습니다.";
    		url = "updateForm.bd?pageNum="+pageNum+"&num="+bb.getNum();
    	}else{
    		url = "updateForm.bd?pageNum="+pageNum+"&num="+bb.getNum();
    	}
    	
    	request.setAttribute("msg", msg);
    	request.setAttribute("url", url);
    	PrintWriter out;
		try {
			out = response.getWriter();
			out.print("	<script  type=\"text/javascript\">\r\n"
					+ "		alert('비밀번호가 일치하지 않습니다.');\r\n"
					+ "	</script>");
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
