package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MovieUpdateFormCommand implements MovieCommand{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		MovieDao mdao = MovieDao.getMovieInstance();
		int num =Integer.parseInt(request.getParameter("num"));
		
		MovieBean mb = mdao.getMovieByNum(num);
		request.setAttribute("mb", mb);
		
	}

}
