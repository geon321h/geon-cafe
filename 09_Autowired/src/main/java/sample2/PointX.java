package sample2;

import org.springframework.stereotype.Component;

@Component("PointX") // PointX PointX = new PointX(); 클래스 이름과 같아도 된다.
public class PointX implements Shape{

	@Override
	public String make() {
		return "X를 만들다";
	}
	
	@Override
	public String delete() {
		return "X를 지우다";
	}

	
}
