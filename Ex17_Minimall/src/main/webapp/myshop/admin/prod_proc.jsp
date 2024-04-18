<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="my.shop.ProductDao"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    prod_input.jsp -> prod_proc.jsp<br>
    <%-- <jsp:useBean id="pb" class="my.shop.ProductBean"/> --%>
    <%
    	ProductDao pdao = ProductDao.getInstance();
    
    	String configFolder = "";
    	String saveFolder = "/myshop/images";
	    int maxSize = 1024*1024*5;
	    String encoding = "UTF-8";
	    
	    configFolder = config.getServletContext().getRealPath("/myshop/images");
	    String requestFolder = request.getContextPath()+"/"+saveFolder;
	    
	    MultipartRequest multi;
	    multi = new MultipartRequest(request,configFolder,maxSize,encoding,new DefaultFileRenamePolicy());
	    
		/* Enumeration files = multi.getFileNames();
	    String file = (String)files.nextElement(); */
	    String fname = multi.getFilesystemName("pimage");
	    String orgname = multi.getOriginalFileName("pimage");
	    String fullPath = requestFolder+"\\"+orgname;
	    
	    System.out.println(configFolder);
	    System.out.println(requestFolder);
	    System.out.println(fullPath);
	    

	    
		/* pb.setPname(multi.getParameter("pname"));
	    pb.setPcompany(multi.getParameter("pcompany"));
	    pb.setPcategory_fk(multi.getParameter("pcategory_fk"));
	    pb.setPimage(fname);
	    pb.setPqty(Integer.parseInt(multi.getParameter("pqty")));
	    pb.setPrice(Integer.parseInt(multi.getParameter("price")));
	    pb.setPspec(multi.getParameter("pspec"));
	    pb.setPcontents(multi.getParameter("pcontents"));
	    pb.setPoint(Integer.parseInt(multi.getParameter("point")));
	    pb.setPinputdate(pinputdate); */
			    
    
	    int cnt = pdao.insertProduct(multi);
		
		String msg =null;
		String url = "";
		
		if(cnt != -1){
			msg = "추가 성공";
			url = "prod_list.jsp";
		}else{
			msg = "추가 실패";
			url = "prod_input.jsp";
		}
    
    %>
    
   	<Script>
	    alert("<%=msg%>");
	    location.href="<%=url%>";
	</Script>
    
    상품명 : <%=multi.getParameter("pname") %> <br>
    제조 회사 : <%=multi.getParameter("pcompany") %> <br>
    상품 스펙 : <%=multi.getParameter("pspec") %> <br>
    상품이미지  <br>
    <img src="<%=fullPath%>" width="100"/> <br>
    
    
    
