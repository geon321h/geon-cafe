package svy;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SurveyServlet
 */
@WebServlet("*.svy")
public class SurveyServlet extends HttpServlet {
	private ServletContext application;
	SurveyDao sdao = null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SurveyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

		application = config.getServletContext();
//		String driver = config.getInitParameter("driver");
//		String url = config.getInitParameter("url");
//		String user = config.getInitParameter("user");
//		String pw = config.getInitParameter("pw");
		String driver ="oracle.jdbc.driver.OracleDriver";
		String url ="jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "sqlid";
		String pw = "sqlpw";
		
		sdao = new SurveyDao(driver,url,user,pw);
	
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
		String viewPage=null;
		
		if(command.equals("/insert.svy")){
			System.out.println("insert 요청");
			String name = request.getParameter("name");
			String company = request.getParameter("company");
			String email = request.getParameter("email");
			String satisfaction = request.getParameter("satisfaction");
			String[] part = request.getParameterValues("part");
			String howto = request.getParameter("howto");
			int agree = 0;
			System.out.println(request.getParameter("agree"));
			if(request.getParameter("agree") !=null){
				agree = 1;
			}
			SurveyBean sb = new SurveyBean();
			sb.setName(name);
			sb.setCompany(company);
			sb.setEmail(email);
			sb.setSatisfaction(satisfaction);
			sb.setPart(part);
			sb.setHowto(howto);
			sb.setAgree(agree);
			
			boolean flag = (boolean)application.getAttribute("flag");
			if(flag){
				viewPage = "/select.svy";
			}else {
				int cnt = sdao.insertSurvey(sb);
				if(cnt>0) {
					viewPage = "/select.svy";
					application.setAttribute("flag", true);
				}
			}

		}else if(command.equals("/select.svy")){
			System.out.println("select 요청");
			ArrayList<SurveyBean> lists = sdao.getSurveyList();
				
			if(lists !=null){
				request.setAttribute("lists", lists);
			}
			viewPage = "surveyList.jsp";
			
		}else if(command.equals("/updateForm.svy")){
			System.out.println("updateForm 요청");
			int no = Integer.parseInt(request.getParameter("no"));
			SurveyBean sb = sdao.getSurveyByNo(no);
			request.setAttribute("sb", sb);
			
			viewPage = "updateForm.jsp";
		}else if(command.equals("/update.svy")){
			System.out.println("update 요청");
			int no = Integer.parseInt(request.getParameter("no"));
			String name = request.getParameter("name");
			String company = request.getParameter("company");
			String email = request.getParameter("email");
			String satisfaction = request.getParameter("satisfaction");
			String[] part = request.getParameterValues("part");
			String howto = request.getParameter("howto");
			int agree = 0;
			if(request.getParameter("agree") !=null){
				agree = 1;
			}
			
			SurveyBean sb = new SurveyBean();
			sb.setNo(no);
			sb.setName(name);
			sb.setCompany(company);
			sb.setEmail(email);
			sb.setSatisfaction(satisfaction);
			sb.setPart(part);
			sb.setHowto(howto);
			sb.setAgree(agree);
			
			int cnt = sdao.updateSurvey(sb);
			
			if(cnt>0) {
				viewPage = "/select.svy";
			}else {
				viewPage = "/updateForm.svy?no="+no;
			}
			
			
		}else if(command.equals("/delete.svy")){
			System.out.println("delete 요청");
			
			int no = Integer.parseInt(request.getParameter("no"));
			sdao.deleteSurvey(no);
			viewPage = "select.svy";
		}
		
		if(viewPage==null){
			System.out.println("요청된페이지가 잘못되었습니다.");
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
		
	}

}
