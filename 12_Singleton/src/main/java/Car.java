
public class Car {

	private static Car instance;
	
	public static Car getInstance() {
		if(instance == null) {
			instance = new Car();
		}
		return instance;
	}
	
	private Car() {
		System.out.println("Car생성자");
	}
	
	public void morning() {
		System.out.println("모닝");
	}
	
	public void genesis() {
		System.out.println("제네시스");
	}
	
	public void sonata() {
		System.out.println("소나타");
	}
	
}
