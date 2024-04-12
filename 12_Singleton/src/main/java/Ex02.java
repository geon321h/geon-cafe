
public class Ex02 {

	public static void main(String[] args) {
		
//		Fruit f1 = new Fruit();
		
		Fruit f1 = Fruit.getInstance();
		f1.apple();
		
		Fruit f2 = Fruit.getInstance();
		f2.banana();
		
		 System.out.println("f1: " + f1); 
		 System.out.println("f2: " + f2);
		
	}
	
}
