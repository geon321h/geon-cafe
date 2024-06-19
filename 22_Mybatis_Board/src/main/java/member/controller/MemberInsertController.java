package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberInsertController {

	private final String command="/insert.mb";
	private final String goPage="insertForm";
	private final String goToPage="redirect:list.mb";
	
	@Autowired
	MemberDao memberDao;
	
	@RequestMapping(value =  command,method = RequestMethod.GET)
	public String insert() {
		
		return goPage;
	}
	
	@RequestMapping(value =  command,method = RequestMethod.POST)
	public String insert(
			@ModelAttribute("member") @Valid MemberBean member,
			BindingResult result,
			HttpServletResponse response) {
		
		if(result.hasErrors()) {
			return goPage;
		}
		
		int cnt = -1;
		cnt = memberDao.insertMember(member);
		
		if(cnt>0) {
			return goToPage;
		}else if(cnt==-5) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("<script>alert('중복되는 이메일입니다.');</script>");
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return goPage;
		}else {
			return goPage;
		}
		
	}
	
}
