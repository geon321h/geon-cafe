package sample2;

import org.springframework.stereotype.Component;

@Component("PointY")
public class PointY implements Shape{


	@Override
	public String make() {
		return "Y�� �����";
	}
	
	@Override
	public String delete() {
		return "Y�� �����";
	}


	
}
