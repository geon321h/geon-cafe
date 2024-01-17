import java.util.Scanner;

public class Ex06_입력문 {

	public static void main(String[] args) {
		
		int kor, eng, math;
		// kor = 70;
		// eng = 80;
		// math = 95;
		Scanner sc = new Scanner(System.in);
		System.out.println("국어점수 입력=>");
		kor = sc.nextInt();
		System.out.println("영어점수 입력=>");
		eng = sc.nextInt();
		System.out.println("수학점수 입력=>");
		math = sc.nextInt();
		
		int total =kor+eng+math; // 70+80+95=245
		System.out.println("국어점수:" + kor);
		System.out.println("영어점수:" + eng);
		System.out.println("수학점수:" + math);
		System.out.println("합계:" + total);
		
		int avg = total/3;
		// int/int=>int
		// int(4)/double(8)=>double
		System.out.println("평균:" + avg);
		
		double avg2 = total/3;
		System.out.println("평균2:" + avg2);
		
		double avg3 = total/3.0;
		// int/dooble=double
		System.out.println("평균3:" + avg3);
		System.out.printf("평균4:%.2f\n", avg3);
		
	}

}
