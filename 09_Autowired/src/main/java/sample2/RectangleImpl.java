package sample2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myRectangleImpl")
public class RectangleImpl implements Rectangle{

	@Autowired	
	@Qualifier("PointY")
	Shape pointy;
	
	int x;
	int y;
	
	public RectangleImpl() {
		System.out.println("RectangleImpl()");
	}
	
	public void setPointy(Shape py) {
		this.pointy = py;
	}
	
	public Shape getPointy() {
		return pointy;
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

		return pointy.make();
	}
	
}
