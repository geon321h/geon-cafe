package sample3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class CircleMain {
	
	public static void main(String[] args) {
		
//		double radius = 10.0;
//		PointImpl point = new PointImpl();
//		
//		point.setXpos(3.0);
//		point.setYpos(4.0);
//		
//		CircleImpl circle = new  CircleImpl(radius, point);
//		circle.display();
		
		Resource resource = new ClassPathResource("applicationContext.xml");
		
		BeanFactory factory = new XmlBeanFactory(resource);
		 Circle circle = (Circle)factory.getBean("circle");
		 circle.display();
		 System.out.println("--------------------------");
		 Point point = (Point)factory.getBean("point");
		 System.out.println("xpos: "+point.getXpos());
		 System.out.println("ypos: "+point.getYpos());
		 
	}

}
