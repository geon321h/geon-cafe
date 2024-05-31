package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.dao.MartDao;

public class MDeleteAllCommand implements MCommand {

	@Override
	public void execute(Model model) {

		MartDao mdao = MartDao.getInstance();
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("req");
		
		String[] rowcheckArr = request.getParameterValues("rowcheck");
		mdao.deleteAll(rowcheckArr);
		
	}

}
