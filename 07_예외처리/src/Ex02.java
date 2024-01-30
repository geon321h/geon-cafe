import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		boolean result;
		
		System.out.print("숫자1:");
		int num1 = sc.nextInt();
		System.out.print("숫자2:");
		int num2 = sc.nextInt();
		
		result = divider(num1,num2);
		
		if (result == true) {
		
			System.out.println("나누기 성공");
		
		}else {
			
			System.out.println("나누기 실패");

		}
		// System.out.println("나누기 결과:" + result);
		
	}

	public static boolean divider(int i, int x) {
		
		try {
			
			int result = i/x; // 3/0 new ArithmeticException
			return true;
			
		} catch (ArithmeticException e) {

			System.out.println(e);
			System.out.println(e.toString());
			System.out.println(e.getMessage());
			return false;
			
		}finally {
			
			System.out.println("finally 영역");
			
		}
		
	}
}

