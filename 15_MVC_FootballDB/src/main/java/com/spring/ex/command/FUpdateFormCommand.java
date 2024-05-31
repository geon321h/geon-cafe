package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.dao.FDao;
import com.spring.ex.dto.FDto;

public class FUpdateFormCommand implements FCommand {

	@Override
	public void execute(Model model) {

		FDao dao = FDao.getInstance();
		Map<String, Object> map= model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("req");
		int num = Integer.parseInt(request.getParameter("num"));
		
		FDto fdto = dao.getFootball(num);
		request.setAttribute("fdto", fdto);
		
	}

}
