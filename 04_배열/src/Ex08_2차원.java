
public class Ex08_2차원 {

	public static void main(String[] args) {

		// 2차원 가변배열 생성, 출력, 각행의 합계와 전체합계 출력하기 //
		
		int[][] score = {
							{1,2,3},
							{4,5},
							{6,7,8,9},
							{10,11,12},
							{13,14,15,16,17}
						}; // 가변배열 - 행마다 열의 개수가 다른 배열
		
		System.out.println(score.length);
		
		int i,j,total;
		int[] sum = new int[5];
		
		for(i=0;i<score.length;i++) {
			
			System.out.println(score[i].length);
			
		}
		
		for(int[] a : score) {
			
			for(int b : a) {
				
				System.out.print(b + " ");
				
			}
			System.out.println();
		}
		
		for(i=0;i<score.length;i++) {
			
			System.out.print("{");
			for(j=0;j<score[i].length;j++) {
				
				System.out.print(score[i][j]);
				sum[i] = sum[i] + score[i][j];
				
				if(j<score[i].length-1) {
					System.out.print(",");
				}
				
			}
			System.out.print("}");
			
			if(i<score.length-1) {
				System.out.print(",");
			}
			System.out.println();			
			
		}
		
		total = 0;  
		for(i=0;i<sum.length;i++) {
		
			total += sum[i];
			System.out.println( i + "행의 합계:"  + sum[i]);
			
		}
		System.out.println("전체 행의 합계:" + total);		
		
	}

}
