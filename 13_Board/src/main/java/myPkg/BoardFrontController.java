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
 * Servlet implementation class BoardFrontController
 */
@WebServlet("*.bd")
public class BoardFrontController extends HttpServlet {
	private ServletContext application;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFrontController() {
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
		
		if(command.equals("/write.bd")) {
			BoardWriteCommand boardWrite = new BoardWriteCommand();
			boolean flag = (boolean)application.getAttribute("flag");
			String pageNum = request.getParameter("pageNum");
			
			if(flag) {
				viewPage = "list.bd?pageNum="+pageNum;
			}else {
				boardWrite.execute(request, response);
				viewPage = "list.bd?pageNum="+pageNum;
				application.setAttribute("flag", true);
			}
			
		}else if(command.equals("/list.bd")){
			BoardListCommand boardList = new BoardListCommand();
			boardList.execute(request, response);
			viewPage = "list.jsp";
		}else if(command.equals("/content.bd")){
			BoardContentCommand boardContent = new BoardContentCommand();
			boardContent.execute(request, response);
			
			viewPage = "content.jsp";
		}else if(command.equals("/delete.bd")){
			BoardDeleteCommand boardDelete = new BoardDeleteCommand();
			boardDelete.execute(request, response);
			String url = (String)request.getAttribute("url");
			
			viewPage = url;
		}else if(command.equals("/updateForm.bd")){
			BoardUpdateFormCommand boardUpdateForm = new BoardUpdateFormCommand();
			boardUpdateForm.execute(request, response);
			
			viewPage = "updateForm.jsp";
		}else if(command.equals("/update.bd")){
			BoardUpdateCommand boardUpdate = new BoardUpdateCommand();
			boardUpdate.execute(request, response);
			String url = (String)request.getAttribute("url");
			
			viewPage = url;
		}else if(command.equals("/reply.bd")){
			BoardReplyCommand boardReply = new BoardReplyCommand();
			boolean flag = (boolean)application.getAttribute("flag");
			if(flag) {
				String pageNum = request.getParameter("pageNum");
				viewPage = "list.bd?pageNum="+pageNum;
			}else {
				boardReply.execute(request, response);
				String url = (String)request.getAttribute("url");
				application.setAttribute("flag", true);
				viewPage = url;
			}
			
		}
		
		if(viewPage==null){
			System.out.println("요청된페이지가 잘못되었습니다.");
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}

}









