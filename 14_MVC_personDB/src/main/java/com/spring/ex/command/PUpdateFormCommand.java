package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dao.PDao;
import com.spring.ex.dto.PDto;

public class PUpdateFormCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request) {

		int num= Integer.parseInt(request.getParameter("num"));

		PDao pdao = PDao.getInstance();
		PDto pdto = pdao.getPersonByNum(num);

		request.setAttribute("pdto", pdto);
		
	}
	
}
