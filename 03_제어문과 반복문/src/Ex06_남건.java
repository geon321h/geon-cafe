import java.util.Scanner;

public class Ex06_남건 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num1, num2;
		char op;
		
		System.out.print("연산자 입력 : ");
		op = sc.next().charAt(0);
		System.out.print("숫자1: ");
		num1 = sc.nextInt();
		System.out.print("숫자2: ");
		num2 = sc.nextInt();
		
		
		switch (op) {
		case '+':System.out.printf("%d%c%d=%d\n",num1, op, num2, num1+num2 );
			break;
		case '-':System.out.printf("%d%c%d=%d\n",num1, op, num2, num1-num2 );
			break;
		case '*':System.out.printf("%d%c%d=%d\n",num1, op, num2, num1*num2 );
			break;
		case '/':System.out.printf("%d%c%d=%.2f\n",num1, op, num2, num1/(double)num2);
			break;
		case '%':System.out.printf("%d%c%d=%d\n",num1, op, num2, num1%num2 );
			break;
		default:System.out.println("올바른 연산자가 아닙니다.");
			break;
		}
	}
}

/*
 연산자 입력 
 숫자2개 
 계산
 */