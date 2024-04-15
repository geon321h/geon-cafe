<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="javax.servlet.annotation.MultipartConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    Ex01_proc<br>

    <%
    
        request.setCharacterEncoding("UTF-8");
    	String name = request.getParameter("name");
    	String filename = request.getParameter("filename");
    	System.out.println("name: "+name+"  filename: "+filename);

    	String configFolder = "";
    	int maxSize = 1024*1024*5;
    	String saveFolder = "img";
    	String encoding = "UTF-8";
    	
    	// ServletConfig config = new ServletConfig(); 자동 생성
    	//  jsp 페이지가 서블릿으로 변환도어 서블릿 객체(인스턴스)가 생성 될때
    	// 참고해야하는 초기 설정정보를 저장해두는 객체이다.
    	// 서블릿 당 1개가 생성된다.
    	
    	// ServletConfig application = new ServletConfig(); 
    	// 프로젝트 당 1개가 생성된다.
    	
    	String applicationFolder = application.getRealPath("");
    	System.out.println("applicationFolder: "+ applicationFolder);
    	
    	ServletContext sc = config.getServletContext();
    	configFolder = sc.getRealPath("");
    	System.out.println("configFolder: "+ configFolder);
    	// applicationFolder == configFolder 두 방법 모두 같다
    	// 현재 작업중인 폴더까지의 경로
    			
    	configFolder = config.getServletContext().getRealPath("img");
    	System.out.println("configFolder: "+ configFolder);
    	// 현재 작업중인 폴더까지의 경로 + /img
    	
    	String requestFolder = request.getContextPath();
    	System.out.println("requestFolder: "+ requestFolder);
    	// 현재 작업중인 폴더명
    	
    	requestFolder = request.getContextPath()+"/"+saveFolder;
    	System.out.println("requestFolder: "+ requestFolder);
    	// 현재 작업중인 폴더명/img => 보이는 것과 다르게 실제경로는 더길다.
    			
    	MultipartRequest multi; // cos.jar 파일이 있어야 생성가능
    	multi = new MultipartRequest(request,
				configFolder,
				maxSize,
				encoding,
				new DefaultFileRenamePolicy());
    	// new DefaultFileRenamePolicy() 이미 업로드된 이미지를 올릴시 (n) 숫자를 증가시키면서 추가함
    	
    	Enumeration files = multi.getFileNames();
   	 	String file = (String)files.nextElement();
    	System.out.println("file: "+ file);
    	// input:file의 name에 써있는 값을 가져온다.
    	String fname = multi.getFilesystemName(file);
    	System.out.println("fname: "+ fname);
    	// 해당 name에 업로드된 파일명을 가져온다.
    	String orgname = multi.getOriginalFileName(file);
    	System.out.println("orgname: "+ orgname);
    	
    	String fullPath1 = configFolder+"\\"+orgname;
    	String fullPath2 = requestFolder+"\\"+orgname;
    	System.out.println("fullPath1: "+ fullPath1);
    	System.out.println("fullPath2: "+ fullPath2);
    	
    %>
    
    이름 : <%=multi.getParameter("name") %> <br><br>
    <img src="<%=fullPath1%>" width="500" height="200"/> <br><br>
    <img src="<%=fullPath2%>" width="500" height="200"/> <br><br>
    
   	<!-- 업로드 시에는 configFolder 가져올때는 requestFolder --> 
    
    
    
    
    
    
    
    
    