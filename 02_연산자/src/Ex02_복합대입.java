
public class Ex02_복합대입 {

	public static void main(String[] args) {

		int a=10,b=20,c=30,d=40,e=50;
		
		// a= a + 3 대입 연산자
		a+=3; // 복합대입 연산자
		System.out.println("a=" + a);
		
		b-=5;
		System.out.println("b=" + b);
		
		c*=2;
		System.out.println("c=" + c);
		
		d/=7;
		System.out.println("d=" + d);
		
		e%=8;
		System.out.println("e=" + e);
		
		String fruit = "apple";
		System.out.println("fruit: " + fruit);
		
		//fruit = fruit + "banana";
		fruit += "banana";
		System.out.println("fruit: " + fruit);
		
		
	}

}
