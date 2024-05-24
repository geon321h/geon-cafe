package sample5;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloMain {

	public static void main(String[] args) {

		// ÀÚ¹Ù 
		CalcBeanImpl calc = new CalcBeanImpl(5);
		calc.setSu1(10);
		calc.calculate();
		
		MessageBeanImpl msg = new MessageBeanImpl("À±¾Æ");
		msg.setGreeting("Hello");
		msg.sayHello();
		
		// xml
		Resource resource = new ClassPathResource("applicationContext3.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		CalcBean calc2 = (CalcBean)factory.getBean("calc");
		calc2.calculate();
		MessageBean msg2 = (MessageBean)factory.getBean("msg");
		msg2.sayHello();

	}

}
