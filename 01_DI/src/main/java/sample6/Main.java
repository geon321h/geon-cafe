package sample6;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import sample5.MessageBean;

public class Main {

	public static void main(String[] args) {

		// Person ������ ����
		// Student set ����
		// MyInfo set ����
		
		//�ڹ�
		Person per = new PersonImpl("������",30,150.5,"�뷡");
		Student stu = new StudentImpl();
		stu.setEng(70);
		stu.setKor(80);
		stu.setPer(per);
		MyInfo my = new MyInfo();
		my.setPer(per);
		my.setStu(stu);
		my.personPrint();
		my.studentInfo();
		
		
		//xml
//		Resource resource = new ClassPathResource("applicationContext4.xml");
//		BeanFactory factory = new XmlBeanFactory(resource);
		
//		 ApplicationContext factory = new FileSystemXmlApplicationContext("applicationContext4.xml");
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext4.xml");
		
		MyInfo my2 = (MyInfo)factory.getBean("my");
		my2.personPrint();
		my2.studentInfo();


	}

}
