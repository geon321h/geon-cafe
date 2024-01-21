
public class Ex02_1차원 {

	public static void main(String[] args) {

		// 3가지 방법으로 배열을 생성하고 2가지이상 반복문 사용하기 //
		
		double[] arr1 = {1.1,2.2,3.3,4.4,5.5};
		double[] arr2 = new double[] {1.1,2.2,3.3f,44,5.5};
		// 8byte보다 작은 데이터값은 들어갈수있다.
		double[] arr3 = new double[5];
		arr3[0] = 1.1;
		arr3[1] = 2.2;
		arr3[2] = 3.3;
		arr3[3] = 4.4;
		arr3[4] = 5.5;
		int i;
		
		System.out.println("일반 for문");
		for(i=0;i<arr1.length;i++) {
			
			System.out.println("arr1["+i+"]="+arr1[i]);
			
		}
		System.out.println("-------------");
		
		System.out.println("확장 for문");
		for(double a : arr1) {
			i = (int)a-1;
			System.out.println("arr1["+i+"]="+a);
			
		}
		System.out.println("-------------");
		
		System.out.println("while문");
		i=0;
		while(i<arr2.length){ 
			
			System.out.println("arr2["+i+"]="+arr2[i]);
			i++;
			
		}
		System.out.println("-------------");
		
		System.out.println("do while문");
		i=0;
		do {
			
			if(i==arr3.length) {
				break;
			}
			
			System.out.println("arr3["+i+"]="+arr3[i]);			
			i++;
			
		}while(true);
		System.out.println("-------------");
		
		// 다른 데이터타입의 배열 생성 //
		
		char[] ch = {'a','p','p','l','A'};
		String[] s = {"banana","orange","melon"};
		
		String[] s2 = {"aplle"};
		System.out.println("s2:" + s2);
		System.out.println("ch:" + ch);
		System.out.println(ch);
		
		// ch배열은 앞의 문자열이 없이 출력하면 안에 있는 값이 모두 나옴
		
	}

}

/*
- 배열의 정의 - 
같은 타입의 데이터를 여러개를 한묶음으로 묶은것
연속된 메모리 공간을 갖고있다
배열명에는 첫방의 주소(참조값)가 들어온다.
*/

