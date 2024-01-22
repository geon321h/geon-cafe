
public class Ex10_정렬 {

	public static void main(String[] args) {

		int[] arr = {8,3,5,2,9};
		int i, j, k, x, y, temp;
		
		// 변수 값 바꾸기 //
		
		x = 10;
		y = 20;		
		
		System.out.println(x + "," + y);
		
		temp = y;
		y = x;
		x = temp;
		
		System.out.println(x + "," + y);
		
		for(i=0;i<arr.length;i++) {
			
			System.out.print(arr[i] + " ");
			
		}
		System.out.println();

		// 배열 정렬하기 //
		
		for(i=0;i<arr.length-1;i++) {
			
			for(j=i+1;j<arr.length;j++) {
				
				if(arr[i]>arr[j]) {
					
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					
				} 
				
				for(k=0;k<arr.length;k++) {
					
					System.out.print(arr[k] + " ");
					
				}
				System.out.println();
				
			}
			
		}
		
		
	}

}
