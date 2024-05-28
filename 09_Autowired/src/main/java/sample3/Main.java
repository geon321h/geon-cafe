package sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("/sample3/appContext.xml");
		// Person person= context.getBean("myConsumer",Person.class);
		Person person= (Consumer)context.getBean("myConsumer");
		System.out.println(person.personDrive());
		
		
	}

}
