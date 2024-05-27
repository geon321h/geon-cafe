package sample2;

import org.springframework.stereotype.Component;

@Component("PointY")
public class PointY implements Shape{


	@Override
	public String make() {
		return "Y를 만들다";
	}
	
	@Override
	public String delete() {
		return "Y를 지우다";
	}


	
}
