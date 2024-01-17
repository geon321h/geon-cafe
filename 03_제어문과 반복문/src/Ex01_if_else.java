import java.util.Scanner;

public class Ex01_if_else {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// int a=10 , b=7;
		int a,b;
		
		System.out.println("a를 입력하세요.");
		a = sc.nextInt();
		System.out.println("b를 입력하세요.");
		b = sc.nextInt();		
		
		if(a>b) { // a>b 
			// 조건이 참일때 실행하는 문장
			System.out.println("a가 더 크다");
			System.out.println("하하하");
			// 2줄이상이면 {} 반드시
		}else if (a<b) { // a<b
			System.out.println("b가 더 크다");	
			System.out.println("호호호");
		}else {	// a==b
			// 조건이 거짓일때 실행하는 문장
			System.out.println("a와 b가 같다.");				
			System.out.println("헤헤헤");
		}
		System.out.println("if~else 공부중..");
		
		
	}

}

/*
if(조건) {
	// 조건이 참일때 실행하는 문장
}else if(조건){
	// 추가적인 조건이 참일때 실행하는 문장
}else {
	// 모든 조건이 거짓일때 실행하는 문장
}

-Ex-

if(점수>= 90) { // 90이상
	
}else if(점수>=80){ // 80 ~89
	
}else if (점수>=70) { // 70~79
	
}else { // 70미만
	
}
*/
