import java.util.Scanner;

public class Ex04_switch_case {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
			
		System.out.print("숫자입력:");
		int num = sc.nextInt();
		
		switch (num+2) {
		case 1:System.out.println("1입니다");
			break; // break 만날시 switch~case문을 빠져나옴
		case 2:System.out.println("2입니다");
			break;
		case 3:System.out.println("3입니다");
			break; 
		default :System.out.println("1~3아님"); // 마지막은 break 굳이 필요없음
		}
		System.out.println("switch~case 공부중..");
		
		if(num==1) {
			System.out.println("1입니다");
		}else if (num==2) {
			System.out.println("2입니다");			
		}else if (num==3) {
			System.out.println("3입니다");						
		}else {
			System.out.println("1~3아님");
		}
		
	}

}
