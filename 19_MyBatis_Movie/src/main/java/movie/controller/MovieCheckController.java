package movie.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import movie.model.MovieDao;

@Controller
public class MovieCheckController {

	private final String command = "/title_check_proc.mv";
	
	@Autowired
	MovieDao movieDao; 
	
	@RequestMapping(value = command, method=RequestMethod.POST)
	@ResponseBody
	private String check(@RequestParam("title") String title) {
		int count = movieDao.searchTitle(title);
		System.out.println(count);
		
		if(count == 0) {
			return "YES";
		}else {
			return "NO";
		}
		
	}
	
	
}
