package member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberLoginController {

	private final String command = "loginForm.mb";
	private final String getPage = "loginForm";
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	private String loginForm() {
			
			return getPage;
	}
	
}
