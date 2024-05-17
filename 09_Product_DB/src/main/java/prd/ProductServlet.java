package prd;

import java.io.IOException;
import java.io.ObjectInputFilter.Config;
import java.lang.reflect.Member;
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
 * Servlet implementation class ProductServlet
 */
//@WebServlet("*.prd")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletContext application;
    ProductDao pdao = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		application = config.getServletContext();
		
		String driver = config.getInitParameter("driver");
		String url = config.getInitParameter("url");
		String user = config.getInitParameter("user");
		String pw = config.getInitParameter("pw");
		System.out.println("driver: "+driver);
		System.out.println("url: "+url);
		System.out.println("user: "+user);
		System.out.println("pw: "+pw);
		
		pdao = new ProductDao(driver,url,user,pw);
		
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
		
		if(command.equals("/insert.prd")){
			System.out.println("insert 요청");
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			String company = request.getParameter("company");
			ProductBean pb = new ProductBean();
			pb.setName(name);
			pb.setPrice(price);
			pb.setCompany(company);
			
			boolean flag = (boolean)application.getAttribute("flag");
			if(flag){
				System.out.println("productList");
				viewPage = "/select.prd";
			}else {
				System.out.println("insertForm");
				int cnt = pdao.insertProduct(pb);
				if(cnt>0) {
					viewPage = "/select.prd";
				}
				application.setAttribute("flag", true);
			}

		}else if(command.equals("/select.prd")){
			System.out.println("select 요청");
			ArrayList<ProductBean> lists = pdao.getProductList();
				
			if(lists !=null){
				viewPage = "productList.jsp";
				request.setAttribute("lists", lists);
			}
			
		}else if(command.equals("/updateForm.prd")){
			System.out.println("updateForm 요청");
			int id = Integer.parseInt(request.getParameter("id"));
			ProductBean pb = pdao.getProductById(id);
			request.setAttribute("pb", pb);
			viewPage = "updateForm.jsp";
			
		}else if(command.equals("/update.prd")){
			System.out.println("update 요청");
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			String company = request.getParameter("company");
			String regdate = request.getParameter("regdate");
			
			ProductBean pb = new ProductBean();
			pb.setId(id);
			pb.setName(name);
			pb.setPrice(price);
			pb.setCompany(company);
			pb.setRegdate(regdate);
			
			int cnt = pdao.updateProduct(pb);
			if(cnt>0) {
				viewPage = "/select.prd";
			}
			
		}else if(command.equals("/delete.prd")){
			System.out.println("delete 요청");
			int id = Integer.parseInt(request.getParameter("id"));
			pdao.deleteProduct(id);
			viewPage = "/select.prd";
			
		}
		
		if(viewPage==null){
			System.out.println("요청된페이지가 잘못되었습니다.");
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
		
	}

}
