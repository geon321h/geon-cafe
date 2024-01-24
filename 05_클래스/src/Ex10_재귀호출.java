
public class Ex10_재귀호출 {

	public static void main(String[] args) {

		
		System.out.println("4! : " + fact(4));
		System.out.println("4! : " + fact2(4));
		
	}

	// 재귀호출을 이용한 !계산 //
	
	static int fact(int n) {
		
		if(n==1) {
			return 1;
		}else {
			return n*fact(n-1);
		}
		
	}
	
	// 반복문을 이용한 !계산 //
	
	static int fact2(int n) {
		
		int result = 1;
		for(int i=n;i>0;i--) {
			result *= i;
		}
		return result; 
	}
	
}
