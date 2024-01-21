
public class Ex05_2차원 {

	public static void main(String[] args) {

		//int[] arr1 = {10,20,30}
		//int[] arr2 = new int[]{10,20,30};
		//int[] arr3 = new int[3];
		//arr[0]=10;
		//arr[1]=20;
		//arr[2]=30;
		
		int i, j;
		
		int[][] arr1 = {{1,2},{3,4},{5,6}};
		int[][] arr2 = new int[][] {{1,2},{3,4},{5,6}};
		int[][] arr3 = new int[3][2];
		arr3[0][0]=1;
		arr3[0][1]=2;
		arr3[1][0]=3;
		arr3[1][1]=4;
		arr3[2][0]=5;
		arr3[2][1]=6;
		
		System.out.println(arr1[0][0]); // 0행(층)0열
		System.out.println(arr1[2][1]); // 2행1열
		
		System.out.println(arr1.length); //
		System.out.println(arr1[0].length); //
		System.out.println(arr1[1].length); //
		System.out.println(arr1[2].length); //
		
		for(i=0;i<arr1.length;i++)	 {
			for(j=0;j<arr1[i].length;j++) {
				
				System.out.print(arr1[i][j] + " ");
				
			}
			System.out.println();
		}
		
		
	}

}

/*
   n번지(10)   n+4번지(20)
   arr[0][0]  arr[0][1]    
   n2번지(10)  n2+4번지(20)
   arr[1][0]  arr[1][1]    
   n3번지(10)  n3+4번지(20)
   arr[2][0]  arr[2][1]    

   m번지(n번지) m+4번지(2n번지) m+8번지(n번지) // 주소가 들어가는 곳은 무조건 4byte

- 한 열의 방2개를 관리하는 n,2n,3n도 배열이 된다. 이를 관리하는 대표 관리자가 arr이다.
*/