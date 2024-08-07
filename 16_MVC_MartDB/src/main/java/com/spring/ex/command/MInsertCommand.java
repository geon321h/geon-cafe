package com.spring.ex.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.spring.ex.dao.MartDao;
import com.spring.ex.dto.MartBean;

public class MInsertCommand implements MCommand {

	@Override
	public void execute(Model model) {

		MartDao mdao = MartDao.getInstance();
		Map<String, Object> map= model.asMap();
		
		MartBean mb = (MartBean)map.get("mart");
		
		mdao.insert(mb);
		
	}

}
