

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondController
 */
//@WebServlet("*.mb")
public class SecondController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("SC doGet");
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		System.out.println("SC doGet");
		doProcess(request,response);
		
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		
		String uri = request.getRequestURI();
		String command = uri.substring(request.getContextPath().length());
		
		if(command.equals("/insert.mb")){
			System.out.println("insert요청 들어옴");
		}else if(command.equals("/update.mb")){
			System.out.println("update요청 들어옴");
		}else if(command.equals("/delete.mb")) {
			System.out.println("delete요청 들어옴");
		}else if(command.equals("/select.mb")){
			System.out.println("select요청 들어옴");
		}
		
	}

}
