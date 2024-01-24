
public class Ex07_배열넘기기 {

	public static void main(String[] args) {

		// Ex07_배열넘기기 e = new Ex07_배열넘기기(); - 인스턴스 방식
		// e.func(); - 인스턴스 방식
		// Ex07_배열넘기기.func(); - static 방식
		
		int x, y, z;
		x=10;
		y=20;
		z=30;
		int[] arr = {10,20,30};
		
		func(x,y,z);
		func(arr[0],arr[1],arr[2]);
		
		func2(arr); // 주소를 넘겨줌
		System.out.println(arr[1]);
		System.out.println(arr[0] + "," + arr[1] + "," + arr[2]);
		
	}
	
	static void func(int a, int b, int c) {

		System.out.println("func():");
		System.out.println(a + "," + b + "," + c);
		
	}

	static void func2(int[] x) {
		
		System.out.println("func2():");
		System.out.println(x[0] + "," + x[1] + "," + x[2]);
		x[1]=200; // 값이 아니라 주소를 보냈기에 변경이 된다.
		return;
		
	}

}





