package myPkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MovieIdCheckCommand implements MovieCommand{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		MovieDao mdao = MovieDao.getMovieInstance();
		String userId = request.getParameter("userId");
		boolean flag = mdao.searchId(userId);
		String str ="";
		if(flag){
			str = "NO";
		}else{
			str = "YES";
		}
		try {
			PrintWriter out = response.getWriter();
			out.print(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}

}
