package com.spring.ex.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.dao.FDao;
import com.spring.ex.dto.FDto;

public class FListCommand implements FCommand {

	@Override
	public void execute(Model model) {

		FDao dao = FDao.getInstance();
		
		ArrayList<FDto> lists = dao.getFootballAll();
		//request.setAttribute("lists", lists);
		model.addAttribute("lists", lists);
		
	}

}
