import java.util.Scanner;

public class Ex04_1차원 {

	public static void main(String[] args) {

		// int[] score = {79,88,91,33,100,55,95};

		Scanner sc = new Scanner(System.in);
		
		int a, i, sum;
		//int[] arr = new int[5];

		// System.out.println("숫자입력:");
		// a= sc.nextInt();
		// System.out.println("a:" + a );	

		// 배열의 길이와 변수 입력받아 합계 출력하기 //
		
		System.out.print("배열의 길이 입력:");
		int len = sc.nextInt();
		int[] arr = new int[len];
		
		for(i=0;i<arr.length;i++) {
		
			System.out.print("숫자입력:");
			arr[i] = sc.nextInt();
		
		}

		for(i=0;i<arr.length;i++) {
			
			System.out.print(arr[i] + " ");
			
		}
		System.out.println();
		
		sum=0;
		for(i=0;i<arr.length;i++) {
			
			sum += arr[i];
			
		}
		System.out.println("합계:" + sum);
		System.out.println("--------------");

		
		
	}

}
