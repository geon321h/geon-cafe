import java.util.Scanner;

public class Ex09_2차원입력 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// int[][] arr = new int[2][3];
		
		//행과 열의 갯수를 입력받고 변수도 입력받기 //
		
		int i,j,row,col;
		
		System.out.print("행의 갯수 입력:");
		row = sc.nextInt();
		System.out.print("열의 갯수 입력:");
		col = sc.nextInt();
		 
		int[][] arr = new int[col][row];
		
		for(i=0;i<arr.length;i++) {
			for(j=0;j<arr[i].length;j++) {
				
				System.out.print(i + "행 " + j + "열의 변수를 입력하세요.");
				arr[i][j] = sc.nextInt();
				
			}
			
		}
		
		for(i=0;i<arr.length;i++) {
			for(j=0;j<arr[i].length;j++) {
				
				System.out.println("arr["+ i + "][" + j + "]의 값:" + arr[i][j]);
				
			}
			
		}
		
		// 1차원 배열 출력하기 //

		int[] num = {10,20,30};
		
		for(i=0;i<num.length;i++) {
			
			System.out.print(num[i] + " ");
		
		}
		System.out.println();
		
		for(int a : num) { // 확장 for문을 이용한 출력
			System.out.print(a + " ");
		}
			System.out.println();
		
	}

}
