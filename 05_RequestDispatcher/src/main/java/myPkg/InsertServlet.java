package myPkg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String[] hobby = request.getParameterValues("hobby");
		int c = Integer.parseInt(request.getParameter("c"));
		int java = Integer.parseInt(request.getParameter("java"));
		int jsp = Integer.parseInt(request.getParameter("jsp"));
		int total = c+java+jsp;
		
		RegisterBean rb = new RegisterBean();
		rb.setId(id);
		rb.setPassword(password);
		rb.setName(name);
		rb.setYear(year);
		rb.setMonth(month);
		rb.setDay(day);
		rb.setHobby(hobby);
		rb.setC(c);
		rb.setJava(java);
		rb.setJsp(jsp);
		rb.setTotal(total);
		request.setAttribute("rb", rb);
		
		request.setAttribute("id", id);
		request.setAttribute("password",password);
		request.setAttribute("name", name);
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("day", day);
		request.setAttribute("hobby", hobby);
		request.setAttribute("c", c);
		request.setAttribute("java", java);
		request.setAttribute("jsp", jsp);
		request.setAttribute("total", total);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Ex04_result.jsp");
		dispatcher.forward(request, response);
		
	}

}

