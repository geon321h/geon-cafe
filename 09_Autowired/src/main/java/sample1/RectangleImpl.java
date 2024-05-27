package sample1;


public class RectangleImpl implements Rectangle{

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
