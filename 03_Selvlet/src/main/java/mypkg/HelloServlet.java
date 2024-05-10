package mypkg;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloSelvlet
 */
//@~ : annotation
@WebServlet("/Hello") // URL mapping
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloServlet() { // 생성자 , 처음 객체 생성시에 호출
        System.out.println("HelloServlet() 생성자");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException { // 처음 객체 생성시에 호출되어 초기작업을 함
		System.out.println("init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() { // 파일의 "수정",서버종료등에 호출 되어 마무리 작업을 함
		System.out.println("destroy");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/* 자동으로 생성된다. 
	 * HttpServletRequest request = new HttpServletRequest(); HttpServletResponse
	 * response = new HttpServletResponse();
	 */	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doGet(request, response);
	}

}
