package myPkg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MovieServlet
 */
//@WebServlet("/MovieServlet")
public class MovieFrontController extends HttpServlet {
	private ServletContext application;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		application = config.getServletContext();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		doAction(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		doAction(request,response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String command = uri.substring(request.getContextPath().length());
		String viewPage = null;
		
		if(command.equals("/insert.mv")) {
		
			MovieInsertCommand movieInsert = new MovieInsertCommand();
			boolean flag = (boolean)application.getAttribute("flag");
			if(flag){
				viewPage = "/select.mv";
			}else {
				movieInsert.execute(request, response);
				viewPage = "/select.mv";
				application.setAttribute("flag", true);
			}
			
		}else if(command.equals("/select.mv")){
			MovieListCommand MovieList =  new MovieListCommand();
			MovieList.execute(request, response);
			viewPage = "/select.jsp";
		}else if(command.equals("/id_check.mv")){
			MovieIdCheckCommand idCheck =  new MovieIdCheckCommand();
			idCheck.execute(request, response);
			return;
		}else if(command.equals("/delete.mv")){
			MovieDeleteCommand movieDelete =  new MovieDeleteCommand();
			movieDelete.execute(request, response);
			
			viewPage = "/select.mv";
		}else if(command.equals("/deleteAll.mv")){
			MovieDeleteAllCommand movieDeleteAll =  new MovieDeleteAllCommand();
			movieDeleteAll.execute(request, response);
			
			viewPage = "/select.mv";
		}else if(command.equals("/updateForm.mv")){
			MovieUpdateFormCommand movieUpdateForm =  new MovieUpdateFormCommand();
			movieUpdateForm.execute(request, response);
			
			viewPage = "/updateForm.jsp";
		}else if(command.equals("/update.mv")){
			MovieUpdateCommand movieUpdate =  new MovieUpdateCommand();
			movieUpdate.execute(request, response);
			
			viewPage = "/select.mv";
		}
		
		
		if(viewPage==null){
			System.out.println("요청된페이지가 잘못되었습니다.");
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
		
	}

}









