
public class Ex01_1차원 {

	public static void main(String[] args) {

		int x=10, y=20, z=30;
		
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		System.out.println("------------");
		
		// 배열의 3가지 선언 방식 //
		
		//int[] arr = {10,20,30};
		//int[] arr = new int[] {10,20,30};
		int[] arr = new int[3];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr);
		System.out.println(arr.length); // 0 1 2 3가지 있음
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		System.out.println("------------");
		
		// 배열이 사용할 수 있는 for문 - 확장 for문 //
		
		for( int a : arr) { // 자동으로 첫주소부터 마지막주소까지 접근 
			System.out.println(a);
		}
		
	}

}

/*
  n번지(10)n+4번지(20)n+8번지(30)
   arr[0]  arr[1]    arr[2]
  - 한칸당 4byte이기에 4번지씩 차지함
  - 배열은 0부터 늘어남     
  - arr에는 arr[]의 첫 집의 주소가 들어옴

 	- 확장 for문 -
 for(하나 남을수 있는 변수 : 반복대상) {
 }

*/
