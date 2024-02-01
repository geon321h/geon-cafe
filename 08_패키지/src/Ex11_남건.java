import java.util.Scanner;

public class Ex11_남건 {

	public static void main(String[] args) {

		// 1~45 정수 난수 6개 발생 //
		// 맞은 개수 구하기
		// 1~4등까지 출력

		Scanner sc = new Scanner(System.in);

		int i, j, count=0;
		String s = "숫자"; // 기본출력문
		int[] lotto = new int[6];
		int[] my = new int[6];

		// 로또 프로그램 //
		
		for(i=0;i<lotto.length;i++) { // 당첨번호 추첨

			lotto[i] = (int)(Math.random()*45)+1;

			for(j=0;j<i;j++) {

				if(lotto[i] == lotto[j]) {
					i--;
				}
			}

		}

		for(i=0;i<my.length;i++) { // 로또번호 직접 작성
			
			System.out.print(s + (i+1) + ":");
			my[i] = sc.nextInt();
			s = "숫자"; // 출력문 초기화 
			
			if(my[i]<1 || my[i]>45) { // 1~45 값인지 검사
				
				System.out.println("1~45까지의 수를 입력하세요.");
				i--;
				continue;
				
			}
			
			for(j=0;j<i;j++) { // 중복값 검사
				
				if(my[i] == my[j]) {
					s = "중복됨숫자"; // 중복시 출력문
					i--;
				}
			
			}
			
		}
		
		for(i=0;i<my.length;i++) { // 로또 번호 겹치는 개수 계산
			
			for(j=0;j<i+1;j++) {
				
				if(my[i] == lotto[j]) {
					count++;
				}
			
			}
			
		}
		
		// 번호 출력 // 

		System.out.println("컴이 추첨한 로또 번호");
		for(i=0;i<lotto.length;i++) {

			System.out.print(lotto[i] + " ");

		}
		System.out.println();
		System.out.println();

		System.out.println("내가 선택한 로또 번호" );
		for(i=0;i<my.length;i++) {

			System.out.print(my[i] + " ");

		}
		System.out.println();
		System.out.println();
		
		// 결과에 따른 등수 측정  //
		
		System.out.println("맞은 갯수:" + count);
		
		switch (count) {
		
		case 6: System.out.println("축하합니다~ 1등입니다!");
				break;
		case 5: System.out.println("축! 2등입니다!");
				break;
		case 4: System.out.println("축! 3등입니다!");
				break;
		case 3: System.out.println("4등입니다!");
				break;
		default:System.out.println("꽝!!");

		}


	}

}
