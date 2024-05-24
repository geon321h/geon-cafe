package myPkg;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("*.mem")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("doGet");
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		System.out.println("doPost");
		doProcess(request,response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			MemberDao mdao = new MemberDao();
			String uri = request.getRequestURI();
			String command = uri.substring(request.getContextPath().length());
			String viewPage=null;
			
			if(command.equals("/insert.mem")){
				System.out.println("insert 요청 들어옴");
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				MemberBean mb = new MemberBean(0,name,password);
				int cnt = mdao.insertData(mb);
				if(cnt>0){
					viewPage = "memberTo.jsp";
				}
			}else if(command.equals("/update.mem")){
				System.out.println("update 요청 들어옴");
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				MemberBean mb = new MemberBean(id,name,password);
				int cnt = mdao.updateData(mb);
				if(cnt>0){
					viewPage = "/select.mem";
				}
				
			}else if(command.equals("/updateForm.mem")){
				System.out.println("updateForm 요청 들어옴");
				int id = Integer.parseInt(request.getParameter("id"));
				MemberBean mb = mdao.getMemberById(id);
				request.setAttribute("mb", mb);
				viewPage = "memberUpdateForm.jsp";
				
			}else if(command.equals("/select.mem")){
				System.out.println("select 요청 들어옴");
				
				ArrayList<MemberBean> lists = mdao.getMemberList();
				
				if(lists !=null){
					viewPage = "memberList.jsp";
					request.setAttribute("lists", lists);
				}
				
			}else if(command.equals("/delete.mem")){
				System.out.println("delete 요청 들어옴");
				int id = Integer.parseInt(request.getParameter("id"));
				mdao.deleteData(id);
				
				viewPage = "/select.mem";
			}
			
			if(viewPage==null){
				System.out.println("요청된페이지가 잘못되었습니다.");
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
				dispatcher.forward(request, response);
			}
		
	}

}





