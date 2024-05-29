package sample3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myConsumer")
public class Consumer implements Person{

	private String name;
	private int age;
	
	@Autowired
	@Qualifier("myGrandeur")
	private Car car;
	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int getAge() {
		return age;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public String personDrive() {
		return car.drive();
	}
	
}
