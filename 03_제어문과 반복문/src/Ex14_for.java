
public class Ex14_for {

	public static void main(String[] args) {

		// 1~100까지 합계 구하기 //

		int i, j, sum;
		
		sum=0;
		
		for(i=1;i<=100;i++) {
			
			sum += i;
			
		}
		System.out.println("1~100까지 합계: " + sum);
		System.out.println();
		
		// 1~n까지 합계 구하기 //
				
		// case1
		for(i=10;i<=100;i+=10) {
			
			sum=0;
			for(j=1;j<=i;j++) {
				sum += j;
			}
			System.out.println("1~"+i+"=" + sum);			
			
		}
		System.out.println();

		// case2
		sum=0;
		for(i=1;i<=100;i++) {
			
			sum += i;
			if(i%10 == 0) {
				System.out.println("1~"+i+"=" + sum);							
			}
			
		}
		System.out.println();
		
		// n ~ n+9 까지 출력하기 //
		
		sum=0;
		for(i=1;i<=100;i++) {
			
			sum += i;
			if(i%10 == 1) { // 대신 i-9도 가능
				System.out.print(i+"~");
			} else if(i%10 == 0) {
				System.out.println(i+"=" + sum);	
				sum = 0;
			}
			
		}
		System.out.println();
		
	}

}
