import java.util.Scanner;

public class Ex11_남건 {

	public static void main(String[] args) {

		// 학생수와 점수 입력받고 분석 및 출력하기 //
		
		// 1번 학생수만큼의 배열생성
		// 2번 각 학생 점수 입력 받기
		// 3번 점수 리스트 출력
		// 4번 최고점수, 최하점수, 합계, 평균, 정렬한 결과
		// 2~4번 학생수 점수 선입력 문구
		
		Scanner sc = new Scanner(System.in);
		
		int num, std, i, j, max, min, sum, avg, temp;
		boolean pass = false; // 학생수만 설정하고 점수를 입력하지 않은 경우를 판단
		int[] scores = new int[0];
		
		while(true) {
			
			System.out.println("======================================");
			System.out.println("1.학생수|2.점수입력|3.점수리스트|4.분석|5.종료");
			System.out.println("======================================");			
			System.out.print("선택>");
			num = sc.nextInt();
			
			switch(num) {
				case 1: System.out.print("학생수>");
						std = sc.nextInt();
						scores = new int[std];
						pass = false; // 학생수를 재입력할시 다시 점수를 입력받기위해 초기화
						break;
				case 2:	if(scores.length != 0) { // 학생수를 입력했는지만 판단
					
							for(i=0;i<scores.length;i++) {
								System.out.print("scores[" + i + "]>");
								scores[i] = sc.nextInt();
							}
							pass = true; // 모든 학생의 점수를 입력하면 이후 기능 사용가능
							
						}else {
							System.out.println("1.학생수부터 진행하세요.");
						}
						break;
				case 3:	if(pass==true) { // 
							
							for(i=0;i<scores.length;i++) {
								System.out.println("scores[" + i + "]>" + scores[i]);
							}
							
						}else {
							System.out.println("1.학생수,2.점수입력부터 진행하세요.");
						}
						break;
				case 4:	if(pass==true) {
							max = scores[0];
							min = scores[0];
							sum = scores[0];
							for(i=1;i<scores.length;i++) {
								
								if(max<scores[i]) {
									max = scores[i];
								}else if(min>scores[i]) {
									min = scores[i];
								}
								sum += scores[i];
								 
							}
							avg = sum/scores.length;
							
							for(i=0;i<scores.length-1;i++) {
								
								for(j=i+1;j<scores.length;j++) {
									if(scores[i]>scores[j]) {
										temp = scores[i];
										scores[i] = scores[j];
										scores[j] = temp;
									}
									
								}
								
							}
							
							System.out.println("최고점수:" + max);
							System.out.println("최하점수:" + min);
							System.out.println("합계:" + sum);
							System.out.println("평균:" + avg);
							System.out.println();
							System.out.println("정렬한 결과");
							for(i=0;i<scores.length;i++) {
								
								System.out.print(scores[i] + " ");								
							
							}
							System.out.println();
							
						}else {
							System.out.println("1.학생수,2.점수입력부터 진행하세요.");
						}
						break;
				case 5:	System.out.println("프로그램을 종료합니다.");
						System.exit(0);

				default : System.out.println("1~5만 가능합니다.");	
			}
			
		}
		
	}

}
