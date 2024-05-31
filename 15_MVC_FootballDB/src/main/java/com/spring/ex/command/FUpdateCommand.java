package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.dao.FDao;
import com.spring.ex.dto.FDto;

public class FUpdateCommand implements FCommand {

	@Override
	public void execute(Model model) {

		FDao dao = FDao.getInstance();
		Map<String, Object> map= model.asMap();
		FDto fdto = (FDto)map.get("fdto");
//		HttpServletRequest request = (HttpServletRequest)map.get("req");
//		int num = Integer.parseInt(request.getParameter("num"));
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		String win = request.getParameter("win");
//		String[] round16_arr = request.getParameterValues("round16");
//		String round16 = "";
//		if(round16_arr != null){
//			for(String r : round16_arr) {
//				round16 += r + " ";
//			}
//		}else {
//			round16 += "선택한 나라 없음";
//		}
//		FDto fdto = new FDto(num, id, pw, win, round16);
		
		dao.updateFB(fdto);
		
	}

}
