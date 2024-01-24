
public class Ex13_overloading {

	public static void main(String[] args) {

		Ex13_overloading e = new Ex13_overloading();
	
		int i, j;
		double k;
		
		i = e.plus(3,4,5);
		System.out.println("i: " + i);
		
		j = e.plus(10,20);
		System.out.println("j: " + j);

		k = e.plus(0.1,0.2);
		System.out.println("k: " + k);

	} // main
	
	int plus(int a, int b, int c) { // 정의
		
		return a+b+c;
		
	}

	int plus(int x, int y) { // 메서드 overloading / 오버라이딩 차이
		
		return x+y;
	
	}
	
	double plus(double x, double y) {
		
		return x+y;
		
	}
	
}
