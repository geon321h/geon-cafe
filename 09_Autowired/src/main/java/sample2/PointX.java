package sample2;

import org.springframework.stereotype.Component;

@Component("PointX") // PointX PointX = new PointX(); Ŭ���� �̸��� ���Ƶ� �ȴ�.
public class PointX implements Shape{

	@Override
	public String make() {
		return "X�� �����";
	}
	
	@Override
	public String delete() {
		return "X�� �����";
	}

	
}
