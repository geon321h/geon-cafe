package sample1;

public class Circle {

	private double radius;
	private Point point;
	
	public Circle(double radius,Point point) {
		super();
		this.radius = radius;
		this.point = point;
	}

	public void display() {
		System.out.println("원의 중심 : "+point.getXpos()+","+point.getYpos());
		System.out.println("원의 면적 : "+Math.pow(radius,2));
	}
	
}
