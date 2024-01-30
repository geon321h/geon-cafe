import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {

		double a = Math.random(); // 0.0 <= a < 1.0
		
		System.out.println("a:" + a);
		
		// 1~10 사이의 정수 난수 발생 //
		
		int b = (int)(Math.random()*10) + 1 ; // 1 <= a < 11
		// (Math.random()*n+1-i) +i
		
		System.out.println("b:" + b);

		// 17~42 사이의 정수 난수 발생 //
		
		int c = (int)(Math.random()*26) + 17;
		
		System.out.println("c:" + c);
		
		// 1~100 사이의 정수 난수 발생 //
		
		int answer = (int)(Math.random()*100) + 1;
		
		System.out.println("answer: ? ");
		
		int input = 0, count = 0;
		
		Scanner sc  = new Scanner(System.in);

		do {
			
			count++;
			System.out.print("1~100사이의 정수값 입력:");

			try {
				
				input = sc.nextInt();

			} catch (InputMismatchException e) {

				System.out.println("유효하지 않은 값 입니다. 다시 시도해주세요.");
				continue; // 조건식으로 간다.
				
			}
			
			
			if(answer > input) {
				
				System.out.println("더 큰수를 입력하세요");
				
			}else if(answer <input) {
				
				System.out.println("더 작은수를 입력하세요");

			}else {
				
				System.out.println("맞췄습니다.");
				System.out.println("시도한 횟수는 " + count + "입니다.");
				break;
				
			}
			
		}while(true);
		
	}

}
