
public class Ex03_1차원 {

	public static void main(String[] args) {
		
		int[] score = {79,88,91,33,100,55,95}; // 배열명에는 첫방의 주소(참조값)가 들어온다.
		
		// 배열의 합계 구하기 //
		int sum = 0;
		sum = score[0] + score[1] + score[2] + score[3] + score[4] + score[5] + score[6];
		System.out.println("sum : " + sum);
		
		sum = 0;
		sum = sum + score[0]; // 0+79=>79
		sum = sum + score[1]; // 79+88=>167
		sum = sum + score[2]; // 167+91=>258
		sum = sum + score[3]; // 258+33=>291
		sum = sum + score[4]; // 291+100=>391
		sum = sum + score[5]; // 391+55=>446
		sum = sum + score[6]; // 446+95=>541
		System.out.println("sum : " + sum);
		
		int i;
		sum = 0;
		for(i=0;i<score.length;i++) {
			sum = sum + score[i];
		}
		
		// 정수 7개의 배열만들고 합계와 평균 소수점아래 2자리까지 출력 //

		System.out.println("sum : " + sum);
		System.out.println(sum/score.length);
		System.out.printf("평균:%.2f\n", (double)sum/score.length);
		System.out.println("--------------");
		
		// 배열을 사용하면 변수와는 달리 간단한 반복문으로 구할수있는 상황이 있다.
		
		// max 와 min 찾기 //
		
		int max, min;
		// int[] score = {79,88,91,33,100,55,95};
		
		max = score[0]; // 79
		min = score[0]; // 79
		
		for(i=1;i<score.length;i++) {
			
			if(max < score[i]) {
				max = score[i];
			}
			
			if(min > score[i]) {
				min = score[i];
			}

		}
		System.out.println("max : " + max);
		System.out.println("min : " + min);
		System.out.println("--------------");

	
	}

}

