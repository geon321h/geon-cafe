import java.util.Scanner;

public class Ex01_산술 {

	public static void main(String[] args) {
	
		int num1,num2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자1입력 =>");
		num1 = sc.nextInt();
		System.out.println("숫자2입력 =>");
		num2 = sc.nextInt();

		System.out.println("숫자1:" + num1);
		System.out.println("숫자2:" + num2);
		System.out.println(num1 + "+" + num2 + "=" + (num1+num2));
		System.out.println(num1 + "-" + num2 + "=" + (num1-num2));
		System.out.println(num1 + "*" + num2 + "=" + (num1*num2));
		System.out.println(num1 + "/" + num2 + "=" + (num1/(double)num2));
		System.out.printf("%d/%d=%.3f\n", num1 , num2 ,num1/(double)num2); // int(4)/double(8)=>double
		System.out.println(num1 + "%" + num2 + "=" + (num1%num2));
		System.out.printf("%d%%%d=%d\n", num1 , num2 ,num1%num2);
		
	}

}
