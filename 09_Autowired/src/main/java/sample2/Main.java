package sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample1.Circle;

public class Main {

	public static void main(String[] args) {

//		Shape px = new PointX(); 
//		PointY py = new PointY(); 
//		
//		CircleImpl circle = new CircleImpl();
//		circle.setPointx(px);
//		System.out.println(circle.make());
//		
//		System.out.println("--------------------");
//		
//		RectangleImpl rec = new RectangleImpl();
//		rec.setPointy(py);
//		System.out.println(rec.make());
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/sample2/appContext.xml");
		Circle circle =(Circle)context.getBean("myCircleImpl");
		circle.make();
		
		
	}

}
