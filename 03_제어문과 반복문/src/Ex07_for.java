import java.util.Scanner;

public class Ex07_for {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int dan, i, sum;
		
		for(i=1;i<=5;i++) {
			// 2줄이상이면 {} 반드시
			System.out.println("자바" + i);
			System.out.println("하하하");
			System.out.println("호호호");
		}
		
		System.out.println("for문 밖" + i);
		System.out.println();
		
		for (i=0;i<5;i++) {
			System.out.println("재미있는 자바공부" + i );
		}
		System.out.println("for문 밖" + i + "\n");
		
		for (i=57;i>=49;i=i-2) {
			System.out.println("재미있는 자바공부" + i );
		}
		System.out.println("for문 밖" + i + "\n");
		
		// 합계 구해서 출력 //
		
		sum = 1+2+3+4+5+6+7+8+9+10;
		System.out.println("sum: " + sum);
		
		sum = 0;
		sum += 1;
		sum += 2;
		sum += 3;
		sum += 4; // 10=6+4
		sum += 5;
		sum += 6;
		sum += 7;
		sum += 8;
		sum += 9;
		sum += 10; // 55=45+10
		System.out.println("sum: " + sum);
		
		sum = 0;
		for (i=1;i<=10;i++) {
			sum += i;
		}
		System.out.println("sum: " + sum);
		
		sum = 0;
		for (i=1;i<=100;i++) {
			if(0==i%5) {
				sum += i;				
			}
		}

		/*
		for (i=0;i<=100;i=i+5) {
				sum += i;				
		}
		*/
		
		System.out.println("sum: " + sum +"\n");
		
		// 3단 출력하기 //
		
		/*
		System.out.println("3*3=3");
		System.out.println("3*6=6");
		System.out.println("3*9=27");
		*/
		
		for(i=1;i<=9;i++) {
			System.out.printf("3*%d=%d\n",i,3*i);
		}
		System.out.println();
		
		/*
		for(i=1;i<=9;i++) ; {
			System.out.printf("3*%d=%d\n",i,3*i);
		}
		- for문은 i 값을 증가시키는 것만 반복했고 i=10이 되자 밖에 있는 출력문이 출력되었다
		*/
		
		// 구구단 입력받아 출력하기 //
		
		System.out.print("단 입력:");
		dan = sc.nextInt();
		
		for(i=1;i<=9;i++) {
			System.out.printf("%d*%d=%d\n",dan,i,dan*i);
		}
		System.out.println();
		
		// 대문자 A ~ Z 까지 출력하기 //
		
		for(i=65;i<=90;i++) {
			System.out.print((char)i + " ");
		}
		System.out.println();
		
		for(char ch='A';ch<='Z';ch++) {
			System.out.print(ch + " ");
		}
		System.out.println("\n");
		
		// 1에서 100까지 5와 7의 공배수 출력 //
		
		for(i=1;i<=100;i++) {
			if(i%5==0 && i%7==0) {
				System.out.println(i);				
			}
		}
		System.out.println();
		
		// 100아래 x와 y의 배수와 공배수 //
		
		int x , y;

		System.out.printf("숫자 x 입력:");
		x = sc.nextInt();
		System.out.printf("숫자 y 입력:");
		y = sc.nextInt();
		
		System.out.println("x의 배수");
		for(i=1;i<=100;i++) {
			
			if (i%x == 0) {
				System.out.println(i);
			}
			
		}

		System.out.println("y의 배수");
		for(i=1;i<=100;i++) {
			
			if (i%y == 0) {
				System.out.println(i);
			}
			
		}
		
		System.out.println("x 와 y의 공배수");
		for(i=1;i<=100;i++) {
			
			if (i%y == 0 && i%x == 0) {
				System.out.println(i);
			}
			
		}
				
	}
	
}

/*
// 반복문 for 형식 //
 
 for(초기식[1];조건식[2];증감식[4]) 
	[3]
	반복할문장1
	반복할문장2

 - 조건이 성립하여 t일때 실행하고 성립하지않아 f일때 실행하지않고 멈춘다
 - []는 작동 순서
*/
