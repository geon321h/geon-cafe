
public class Ex15_while {

	public static void main(String[] args) {

		// 1~5까지 출력 //
		
		int i;
		
		for (i=1;i<=5;i++) {
			System.out.println(i);
		}
		System.out.println("-------------");
		
		i=1; // 초기식
		for ( ; ; ) {
			if(i>5) { // 조건식
				break;
			}
			System.out.println(i);
			i++; // 증감식
		}
		System.out.println("-------------");
		
		i=1;
		while(i<=5) {
			System.out.println(i);
			i++;
		}
		System.out.println("while문 밖:"+i);
		System.out.println("-------------");
		
		i=1;
		do {
			System.out.println(i);
			i++;			
		} while(i<=5);
		System.out.println("while문 밖:"+i);
		System.out.println("-------------");
		
	}

}

/*
 - while문 구성 -
 초기식;
 while (조건식) { // 조건식이 참이면 {}안에 들어간다. 먼저 조건 비교
 	 반복할문장;
 	 증감식;
 }
 
 - do while문 구성 -
 초기식;
 do{
 	반복할문장;
 	증감식;
 }while(조건식) // 조건식이 참이면 {}안에 들어간다. 나중에 조건 비교
*/
