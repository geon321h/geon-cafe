package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dao.PDao;

public class PInsertCommand implements PCommand{

	@Override
	public void execute(HttpServletRequest request) {

		PDao dao = PDao.getInstance();
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		dao.insert(id,name,age);
		
	}
	
}
