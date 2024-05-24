package sample4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SubjectMain {

	public static void main(String[] args) {
		
//		SubjectImpl subject = new SubjectImpl(70,80,90);
//		subject.display();
		
		Resource resource = new ClassPathResource("applicationContext2.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		Subject subject = (Subject)factory.getBean("subject");
		subject.display();
		
	}
	
}
