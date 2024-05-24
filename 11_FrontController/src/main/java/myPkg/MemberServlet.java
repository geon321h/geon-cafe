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
 * Servlet implementation class MemberServlet
 */
//@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private ServletContext application;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
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
		
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String command = uri.substring(request.getContextPath().length());
		String viewPage = null;
		
		if(command.equals("/insert.do")) {
			System.out.println("insert요청");
			MInsertCommand mInsert = new MInsertCommand();
			
			boolean flag = (boolean)application.getAttribute("flag");
			if(flag){
				viewPage = "/list.do";
			}else {
				mInsert.execute(request, response);
				viewPage = "/list.do";
				application.setAttribute("flag", true);
			}
		}else if(command.equals("/list.do")) {
			
			MListCommand mList = new MListCommand();
			
			mList.execute(request, response);
			viewPage = "/list.jsp";
		}else if(command.equals("/delete.do")) {
			System.out.println("delete요청");
			MdeleteCommand mdelete = new MdeleteCommand();
			mdelete.execute(request, response);
			
			viewPage ="list.do";
		}else if(command.equals("/updateForm.do")) {
			MUpdateFormCommand mUpdateForm = new MUpdateFormCommand();
			mUpdateForm.execute(request, response);
			
			viewPage ="updateForm.jsp";
		}else if(command.equals("/update.do")) {
			mUpdateCommand mUpdate = new mUpdateCommand();
			mUpdate.execute(request, response);
			
			viewPage ="list.do";
		}
		
		if(viewPage==null){
			System.out.println("요청된페이지가 잘못되었습니다.");
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
		
	}

}






