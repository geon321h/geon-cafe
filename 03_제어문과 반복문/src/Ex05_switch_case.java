import java.util.Scanner;

public class Ex05_switch_case {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("과일명 입력:");
		String fruit = sc.next();
		System.out.println("과일명:" + fruit);
		
		switch (fruit) { // 실수는 들어가면 안됨
		case "apple": System.out.println("사과");
			break;
		case "grape": System.out.println("포도");
			break;
		case "peach": System.out.println("복숭아");
			break;
		default: System.out.println("그 밖의 과일");
			break;
		}
		
	}

}
