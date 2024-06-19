package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class LoginCotroller {

	private final String command="/login.mb";
	private final String goPage="login";
	private final String goToPage="redirect:list.mb";
	
	@Autowired
	MemberDao memberDao; 
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	private String login() {
		//System.out.println("loginPage");
		return goPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	private String login(HttpServletResponse response,
			HttpSession session,
			@ModelAttribute("member") MemberBean member) {
		
		MemberBean mb = memberDao.getMember(member.getEmail());
		
		String page = goPage;
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if(mb==null){
				out.println("<script>alert('해당하는 아이디가 없습니다.');</script>");
				out.flush();
			}else {
				if(mb.getPassword().equals(member.getPassword())) {
					//System.out.println("destination:"+session.getAttribute("destination"));
					if(session.getAttribute("destination")!=null) {
						session.setAttribute("userInfo", mb);
						page = (String)session.getAttribute("destination");
					}else {
						page = goToPage;
					}
				}else {
					out.println("<script>alert('비밀번호가 일치하지 않습니다.');</script>");
					out.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return page;
	}
	
}
