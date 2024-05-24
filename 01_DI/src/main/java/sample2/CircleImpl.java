package sample2;

import sample1.Point;

public class CircleImpl implements Circle{

	private double radius;
	private PointImpl point;
	
	public CircleImpl(double radius,PointImpl point) {
		super();
		this.radius = radius;
		this.point = point;
	}

	public void display() {
		System.out.println("원의 중심 : "+point.getXpos()+","+point.getYpos());
		System.out.println("원의 면적 : "+Math.pow(radius,2));
	}
	
	
}
