
public class Ex01_출력문 {

	public static void main(String[] args) { //main 메서드
		
		System.out.println(10);
		System.out.println(); // 엔터
		System.out.println(20);

		System.out.println('가');
		System.out.println("가");
		// System.out.println('가나다'); ''안에는 반드시 한글자만 가능
		System.out.println("가나다");
		System.out.println(' '); // 한칸 출력
		System.out.println("");

		System.out.println(10+20);
		System.out.println("10+20="+ 10+20); // "" 안에 있는 것은 연산안되고 그대로 나옴 , 문자열 뒤 +: 연달아~
		System.out.println("10+20="+ (10+20)); // ()안에 있는 것부터
		System.out.println("3+5=8");
		System.out.println("3+5=" + (3+5));
		System.out.println("안녕하세요\t저의\t\t이름은 '남건'입니다.\n\n반갑습니다.");
		System.out.println("안녕하세요\t저의\t\t이름은 \"남건\"입니다.\n\n반갑습니다.");
		
		System.out.println("--------------------------------");
		
		int a = 123;
		System.out.println("a="+ a + "입니다.");
		System.out.printf("a=%d입니다.\n",a);
		System.out.printf("a=%10d입니다.\n",a); // d 앞의 숫자만큼 자리를 여유두고 출력함
	
		char b = 'B';
		System.out.println("b="+ b + "입니다.");
		System.out.printf("b=%3c입니다.\n",b);
		// System.out.printf("b=%d입니다\n",b);
		System.out.printf("b=%5d입니다.\n",(int)b); // 숫자로 변환해서 출력하고 싶으면 앞에 자료형을 변경
		
		float c= 72.346f;
		System.out.println("c="+ c + "입니다.");
		System.out.printf("c=%f입니다.\n",c);
		System.out.printf("c=%7.2f입니다.\n",c); // f 앞은 전체자릿수.소수아래자릿수 끊기는곳에 반올림되서 출력
		System.out.printf("c=%.2f입니다.\n",c); // .소수아래자릿수
		
		String s;
		s = "아이유";
		System.out.println("s="+ s + "입니다.");
		System.out.printf("s=%5s입니다.\n",s);		
		
		System.out.println(s + "의 나이는 " + a + "살 입니다.");
		System.out.printf("%s의 나이는 %d살 입니다.\n",s,a);
		//System.out.println("서식문자",변수);
		
		
		/*
		 서식문자
		 정수 : %d
		 문자 : %c
		 실수 : %f
		 문자열 : %s
		*/
		
	}
	
}

// 클래스 이름만 변경하면 안된다.
// 파일명을 변경하면 class 이름도 자동으로 변경된다.

// or /* */ 주석처리
// 문자는 따옴표로 둘러싸야 한다.

/*
 단축키
 복사: ctrl + c
 잘라내기: ctrl + x
 붙여넣기: ctrl + v
 복붙: ctrl + alt + 방향키
 라인이동(잘라내기+붙여넣기): alt + 방향키
 실행: ctrl + F11
 삭제: ctrl + d
 여러줄삭제: 블럭잡고 ctrl + d
 되돌리기: ctrl + z
 /:슬래시
 \:역슬래시
 ::콜론
 ;:세미콜론
 */
