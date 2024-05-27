package sample2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myCircleImpl")
public class CircleImpl implements Circle{

	@Autowired	
	@Qualifier("PointX")
	Shape pointx; // new PointX();
	
	int x;
	int y;
	int radius;
	
	public CircleImpl() {
		System.out.println("CircleImpl()");
	}
	
	public void setPointx(Shape px) {
		this.pointx = px;
	}
	
	public Shape getPointx() {
		return pointx;
	}
	
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String make() {

		return pointx.make();
	}
	
}
