
public class Fruit {

	private static Fruit instance;
	
	public static Fruit getInstance() {
		if(instance == null) {
			instance = new Fruit();
		}
		return instance;
	}
	
	private Fruit() {
		System.out.println("Fruit 생성자");
	}
	
	public void apple() {
		System.out.println("apple");
	}

	public void banana() {
		System.out.println("banana");
	}
	
	public void orange() {
		System.out.println("orange");
	}
	
}
