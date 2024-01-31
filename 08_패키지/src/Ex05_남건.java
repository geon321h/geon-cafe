import java.util.Scanner;

class Person {

	String id;
	String pw;
	String name;

	public Person(String id, String pw, String name) {

		this.id = id;
		this.pw = pw;
		this.name = name;

	}

}

public class Ex05_남건 {

	public static void main(String[] args) {

		// 연속 로그인 진행 //

		Scanner sc = new Scanner(System.in);

		String inputId, inputPw, retry;
		boolean login = false; // 로그인 성공 여부를 판단, 기본값은 비 로그인 상태

		Person[] p_arr = {
				new Person("kim", "1234", "김연아"),
				new Person("son", "7777", "손흥민"), 
				new Person("park", "9876", "박지성")
		};


		do {

			System.out.print("아이디 입력:");
			inputId = sc.next();

			System.out.print("비밀번호 입력:");
			inputPw = sc.next();

			for(int i=0;i<p_arr.length;i++) { // 회원정보와 일치하는지 확인

				if(p_arr[i].id.equals(inputId) && p_arr[i].pw.equals(inputPw)) {

					System.out.println("반갑습니다. " + p_arr[i].name + "님" );
					login = true; // 일치하는 회원정보가 있으면 로그인

				}

			}

			if(login == false) { // 아이디 혹은 비밀번호가 틀려 로그인이 안된 상태

				System.out.println("아이디 혹은 비밀번호가 일치하지않습니다. ");
				System.out.println();

			}else { // 로그인이 된 상태

				do { // 계속할지 올바른 선택을 했는지 판별

					System.out.print("계속?(y|n)");
					retry = sc.next();

					if(retry.equals("y")||retry.equals("n")|| retry.equals("예")|| retry.equals("아니요")) {

						break;

					}else {

						System.out.println("y(예) 혹은 n(아니요)를 입력해주세요");
					}

				}while(true);


				login = false; // 로그아웃되서 초기화
				if(retry.equals("n") || retry.equals("아니요")) { // 계속하지않으면 종료
					break;
				}
				System.out.println();

			}


		}while(true);

	}

}
