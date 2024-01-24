import java.util.Scanner;

public class Ex11_남건 {

	public static void main(String[] args) {

		// 정수 2개 입력 ex) 2,3 : 2^3 <= 2*2^2 <= 2*2^1 <= 2*2^0
		// 재귀호출로 a의 b승 구하기
		// 반복문으로 a의 b승 구하기
		
		Scanner sc = new Scanner(System.in);
		
		int a,b;
		
		System.out.println("정수를 2개 입력하세요:");
		a = sc.nextInt();
		b = sc.nextInt();
		
		System.out.println(a + "의" + b + "승은: " + square(a,b));
		System.out.println(a + "의" + b + "승은: " + square2(a,b));
		
		
		
	}
	
	// 재귀호출로 a의 b승 구하기 //

	static int square(int a, int b) {
		
		if(b==0) {
			return 1;
		}else {
			return a*square(a, b-1);
		}
		
	}
	
	// 반복문으로 a의 b승 구하기 //
	
	static int square2(int a, int b) {
		
		int i, result=1;
		
		for(i=b;b>0;b--) {
			result *= a;
		}
		return result;
		
	}

}






