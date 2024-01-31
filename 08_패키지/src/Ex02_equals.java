class Fruit {
	
	private String name;
	private int price;
	
	public Fruit(String name, int price) {
	
		super();
		this.name = name;
		this.price = price;
	
	}
	
	public String toString() {
		
		return name + "/" + price;
		
	}
	
	// equals 재정의 가격 비교 //
	
	public boolean equals(Object obj) {
		
		if(obj instanceof Fruit) {
			Fruit f = (Fruit)obj; 
			return  f.price== this.price;
		}else {
			
			return false;
		}
		
	}
	
}

public class Ex02_equals {

	public static void main(String[] args) {

		Fruit f1 = new Fruit("사과",1000);
		Fruit f2 = new Fruit("포도",1000);
		
		System.out.println(f1.toString());
		System.out.println(f2.toString());
		
		boolean result = f1.equals(f2);
		System.out.println(result);
		
		if(result == true) {
			
			System.out.println("가격이 같다");

		}else {
			
			System.out.println("가격이 같지않다");
			
		}
		
	}

}
