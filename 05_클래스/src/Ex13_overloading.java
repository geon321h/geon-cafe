
public class Ex13_overloading {

	public static void main(String[] args) {

		Ex13_overloading e = new Ex13_overloading();
	
		int i;
		
		i = e.plus(3,4,5);
		System.out.println("i: " + i);
		
	} // main
	
	int plus(int a, int b, int c) { // 정의
		
		return a+b+c;
		
	}

}
