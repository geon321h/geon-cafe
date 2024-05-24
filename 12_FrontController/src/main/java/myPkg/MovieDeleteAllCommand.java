package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MovieDeleteAllCommand implements MovieCommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		MovieDao mdao = MovieDao.getMovieInstance();
		String[] rowcheckArr = request.getParameterValues("rowcheck");
		int cnt = mdao.deleteAllMovie(rowcheckArr);
		
		if(cnt>0){
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실패");
		}
		
	}

}
