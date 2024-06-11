package animal.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import animal.model.AnimalDao;

@Controller
public class AnimalCheckController {

	private final String command = "/id_check.am";
	
	@Autowired
	AnimalDao animalDao;
	
	@RequestMapping(value = command, method=RequestMethod.POST)
	@ResponseBody
	private String check(@RequestParam("id") String id) {
		int count = animalDao.searchId(id);
		
		if(count == 0) {
			return "YES";
		}else {
			return "NO";
		}
		
	}
	
	
}
