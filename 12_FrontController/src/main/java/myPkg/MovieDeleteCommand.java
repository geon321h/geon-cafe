package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MovieDeleteCommand implements MovieCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		MovieDao mdao = MovieDao.getMovieInstance();
		int num =Integer.parseInt(request.getParameter("num"));
		
		int cnt = mdao.deleteMovie(num);
		
		if(cnt>0){
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실패");
		}
		
	}
	
}
