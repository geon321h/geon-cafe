package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dao.PDao;
import com.spring.ex.dto.PDto;

public class PUpdateCommand implements PCommand{

	@Override
	public void execute(HttpServletRequest request) {

		PDao dao = PDao.getInstance();
		
		PDto pdto = new PDto();
		int num = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		pdto.setNum(num);
		pdto.setId(id);
		pdto.setName(name);
		pdto.setAge(age);
		
		dao.updatePerson(pdto);
		
	}
	
}
