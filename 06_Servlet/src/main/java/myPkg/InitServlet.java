package myPkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class initServlet
 */
//@WebServlet("/init.do")
public class InitServlet extends HttpServlet {
	private String company =null;
	private String singer =null;
	private String manager =null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitServlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    
    //    ServletConfig config = new ServletConfig();
	public void init(ServletConfig config) throws ServletException {
		
		ServletContext sc = config.getServletContext();
		company = sc.getInitParameter("company");
		singer = sc.getInitParameter("singer");
		manager = sc.getInitParameter("manager");
		//System.out.println("company: "+company);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("company: "+company+"<br>");
		out.print("singer: "+singer+"<br>");
		out.print("manager: "+manager+"<br>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
	}

}
