package member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberLoginController {

	private final String command = "login.mb";
	private final String getPage = "loginForm";
	
	@Autowired
	MemberDao memberDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	private String loginForm() {
			
			return getPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	private ModelAndView login(
			@ModelAttribute("member") MemberBean member,
			HttpSession session,
			HttpServletResponse response) {
		    
		ModelAndView mav = new ModelAndView();
		
		MemberBean mb = memberDao.getMember(member.getId());  
		System.out.println("mb:" + mb);

		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if(mb == null){ // �ش� ���̵� �������� �ʴ´�.
				out.println("<script>");
				out.println("alert('�ش� ���̵�� �������� �ʽ��ϴ�.');");
				out.println("</script>");
				out.flush();
				//mav.setViewName(getPage);
				return new ModelAndView( getPage ) ;
				
			}else{ // �ش� ���̵� �����Ѵ�.
				if(mb.getPassword().equals(member.getPassword())) { // ��� ��ġ
					
					session.setAttribute("loginInfo", mb); // loginInfo:�α����� ����� ����
					System.out.println("��� ��ġ");
					System.out.println("destination:"+(String)session.getAttribute("destination"));
					return new ModelAndView((String)session.getAttribute("destination")) ;
					
				}else { // ��� ����ġ
					System.out.println("��� ����ġ");
					out.println("<script>");
					out.println("alert('��� ����ġ�Դϴ�.');");
					out.println("</script>");
					out.flush();
					return new ModelAndView( getPage ) ;
				}
			}

		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return mav;
		
		
	}
	
}
