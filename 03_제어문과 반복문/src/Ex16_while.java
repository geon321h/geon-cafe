import java.util.Scanner;

public class Ex16_while {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int i, sum;
		i=1;
		sum=0;
		
		// while로 1~10까지 합계 출력 //
		
		while(i<=10) {
			
			sum +=i;
			i++;
			
		}
		System.out.println("1~10:" + sum);
		System.out.println("-----------");
		
		// 음수 입력시까지 수입력 받기 //
		
		int num;
		
		while(true) {

			System.out.print("수입력: ");
			num = sc.nextInt();
			
			if(num<0) {
				break;
			}
			
		}
		System.out.println("while문 밖");
		System.out.println("-----------");
		
	}

}
