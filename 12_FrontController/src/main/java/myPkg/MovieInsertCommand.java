package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MovieInsertCommand implements MovieCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		MovieDao mdao = MovieDao.getMovieInstance();
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age =Integer.parseInt(request.getParameter("age"));
		String[] genre_arr = request.getParameterValues("genre");
		String genre = ""; 
		if(genre_arr == null){
			genre = "선택한 장르 없음";
		}else {
			for(String g : genre_arr) {
				genre += g+" ";
			}
		}
		String time = request.getParameter("time");
		int partner =Integer.parseInt(request.getParameter("partner"));
		String memo = request.getParameter("memo");
		
		MovieBean mb = new MovieBean(id, name, age, genre, time, partner, memo);
		
		int cnt = mdao.insertMovie(mb);
		
		if(cnt>0){
			System.out.println("추가성공");
		}else {
			System.out.println("추가실패");
		}
		
	}
	
}
