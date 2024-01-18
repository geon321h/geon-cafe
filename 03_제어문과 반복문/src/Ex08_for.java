import java.util.Scanner;

public class Ex08_for {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int i,j;
		
		for(i=1;i<=3;i++) {
			
			for(j=1;j<=2;j++) {
				
				System.out.println(i+","+j);
				
			} // 안쪽 for문
			
		} // 바깥쪽 for문
		System.out.println();
		
		// 전체 구구단 출력하기 //
		
		for(i=2;i<=9;i++) {
			
			System.out.printf("-%d단-\n",i);
			for(j=1;j<=9;j++) {
				
				System.out.printf("%d*%d=%d\n",i,j,i*j);
				
			}
			System.out.println("-------");
			
		}
		System.out.println();
		
		
	}
	
}

/*
// 이중 for문 //
 
 for(초기식[1];조건식[2];증감식[4]) { 
	
	for[3](초기식[1-1];조건식[1-2];증감식[1-4] {
		
		[1-3]실행할문장
		
	}
	
}
	
- 바깥쪽 for문에서 [3]까지 진행되어 안쪽 for문이 진행되면 [1-1] ~ [1-4] 까지 
  for문이 종료될때까지 반복되며 종료시 다시 [4]번으로가 바깥쪽 for문을 진행시켜 
  [1]로 돌아가 바깥쪽 for문이 종료될때까지 위 과정을 반복한다.
*/
