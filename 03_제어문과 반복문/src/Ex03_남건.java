import java.util.Scanner;

public class Ex03_남건 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String name;
		int kor_score, eng_score, math_score, total;
		double avg;
		char grade;
		
		System.out.print("이름 입력=>");
		name = sc.next();
		System.out.print("국어 점수=>");
		kor_score = sc.nextInt();
		System.out.print("영어 점수=>");
		eng_score = sc.nextInt();		
		System.out.print("수학 점수=>");
		math_score = sc.nextInt();
		
		total = kor_score + eng_score + math_score;
		avg = total/(double)3;
		
		if(avg>=90) {			
			grade = 'A';
		}else if(avg>=80) {
			grade = 'B';
		}else if(avg>=70) {
			grade = 'C';			
		}else if(avg>=60) {
			grade = 'D';			
		}else {
			grade = 'F';						
		}
		
		System.out.println("---------------------------");
		System.out.println("이름\t국어\t영어\t수학");
		System.out.println("---------------------------");
		System.out.printf("%s\t%d\t%d\t%d\n",name,kor_score,eng_score,math_score);
		System.out.println("---------------------------");
		System.out.printf("총점: %d\n",total);
		System.out.printf("총점: %.2f\n",avg);
		System.out.println("---------------------------");
		System.out.printf("학점=%c\n", grade);
		
		
	}

}

/*
이름 입력=>윤아
국어 점수=>77
영어 점수=>88
수학 점수=>98
---------------------------
이름	국어	영어	수학
---------------------------
윤아	77	88	98
---------------------------
총점: 263
평균: 87.67
---------------------------
학점=B
*/

/* 추가풀이
		 
	- type1 -
	
	if(avg>=90) {
		grade = 'A';
	}
	if(avg>=80 && avg <90) {
		grade = 'B';
	}
	if(avg>=70 && avg <80) {
		grade = 'C';
	}
	if(avg>=60 && avg <70) {
		grade = 'D';
	}
	if(avg<60) {
		grade = 'F';
	}
	System.out.printf("학점=%c\n", grade);
	
	- type2 -
	
	switch ((int)avg/10) {
	case 10: // grade = 'A';	break; 굳이 안넣어도 밑으로 가서 작동
	case 9: grade = 'A';
		break;
	case 8: grade = 'B';
		break;
	case 7: grade = 'C';
		break;
	case 6: grade = 'D';
		break;
	default: grade = 'F';
		break;
	}
	System.out.printf("학점=%c\n", grade);
			
 */