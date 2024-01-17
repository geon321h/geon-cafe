import java.util.Scanner;

public class Ex02_if_else {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num;
		
		System.out.print("숫자 입력: ");
		num = sc.nextInt();
		
		System.out.printf("입력한 숫자: %d\n",num);
		
		// if(num==1 || num==2 || num==3 || num==10) - 비효율적임
		// if(1<= num <=100) - 자바 문법의 맞지않는 방식 
		if(1<=num && num<=10) {
			System.out.println("1~10사이의 수입니다.");
		}else if(11<=num && num<=20){			
			System.out.println("11~20사이의 수입니다.");
		}else if(21<=num && num<=30){			
			System.out.println("21~30사이의 수입니다.");
		}else {
			System.out.println("1~30사이의 수가 아닙니다.");			
		}
			
		if(num%5 == 0) {
			System.out.println("5의 배수입니다.");
			if(num%10 == 0) {
				System.out.println("10의 배수입니다.");				
			}
		}else {			
			System.out.println("5의 배수가 아닙니다.");
		}
		
		if(num%2 == 0) {
			if(num == 0) {
				System.out.println("0입니다.");
			}else {
				System.out.println("짝수입니다.");
			}
		}
		else {
			System.out.println("홀수입니다.");
		}
		
	}

}

/* 
 제어문
 - if~else
*/