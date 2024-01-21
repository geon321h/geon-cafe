
public class Ex07_남건 {

	public static void main(String[] args) {

		// 피보나치 수열 //
		// 1.방10개짜리, 정수가 들어가는 배열을 생성
		// 2.방 모두 채우면 반복 빠져나가기
		// 3.배열 출력하기 1 2 3 5 8 13 21 34
		
		int i=0, j=2, sum=0;
		int[] num = new int[10];
		num[0]=1;
		num[1]=2;
		
		
		while(true) {

			if(j<num.length) {
								
				sum = num[i] + num[i+1]; 
				num[i+2]= sum;
				j++;
				
			}else if(i==num.length) {
				break;
			}
			
			System.out.print(num[i] + " ");
			i++;
		}
		
		
	}

}
