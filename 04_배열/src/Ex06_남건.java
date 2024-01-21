
public class Ex06_남건 {

	
	public static void main(String[] args) {
		
		// 방10개짜리, 정수가 들어가는 배열을 생성 //
		// 1.배열에 3의 배수 넣기
		// 2.방 모두 채우면 반복 빠져나가기
		// 3.배열 출력하기 3 6 9 ~

		int i=1, j=0;
		
		int[] arr = new int[10];
		
		while(true) {
			if(i%3==0) {
				arr[j]=i;
				System.out.print(arr[j] + " ");
				j++;
			}
			if(j==arr.length) {
				break;
			}
			i++;
		}
		
		
	}
	
}
