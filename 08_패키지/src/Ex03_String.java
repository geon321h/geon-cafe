import java.util.Scanner;

public class Ex03_String {

	public static void main(String[] args) {

		String s1 = "AA";
		String s2 = new String("BB");
		
		System.out.println(s1);
		System.out.println(s2);
		
		String str1 = "Have a nice day"; // String str1 = new String("Have a nice day"); 
		String str2 = "HAve a nice day"; // String str2 = new String("Have a nice day");
		String str3 ="hahaha";
		
		int len = str1.length();
		System.out.println("len:" + len);
		
		boolean result1 = str1.equals(str2);
		System.out.println("result1:" + result1);
		
		boolean result2 = str1.equalsIgnoreCase(str2);
		System.out.println("result2:" + result2);
		
		int result3 = str1.compareTo(str2); // 문자열이 같으면 0이나온다.
		System.out.println("result3:" + result3);
		
		if (result3 == 0 ) {
			
			System.out.println("두 문자열 같음");
			
		}else {
			
			System.out.println("두 문자열 같지않음");

		}
		
		int result4 = str1.compareToIgnoreCase(str2);
		System.out.println("result4:" + result4);
		
		System.out.println(str1 == str2);
		
		String result5 = str1.concat(str3);
		System.out.println("result5:" + result5);

		char result6 = str1.charAt(str1.length()-1);
		System.out.println("result6:" + result6);
		
		int result7 = str1.indexOf("nice");
		System.out.println("result7:" + result7);
		
		int result8 = str1.indexOf('a');
		System.out.println("result8:" + result8);

		int result9 = str1.lastIndexOf('a');
		System.out.println("result9:" + result9);

		String result10 = str1.substring(2,8); // 2 ~ < 8 8은 포함안됨
		System.out.println("result10:" + result10);
		
		String result11 = str1.substring(2); // 2 ~
		System.out.println("result11:" + result11);
		
		String result12 = str1.replace('a','x');
		System.out.println("result12:" + result12);

		String result13 = str1.toUpperCase();
		System.out.println("result13:" + result13);
		
		String result14 = str1.toLowerCase();
		System.out.println("result14:" + result14);
		
		boolean result15 = str1.contains("nice");
		System.out.println("result15:" + result15);
		
		String str4 = "  ab cde  ";
		System.out.println(str4.length());
		System.out.println(str4);
		str4 = str4.trim(); // 공백을 제거하는 메서드x
		System.out.println(str4.length());
		System.out.println(str4);
		System.out.println(str4.toString());
		
		System.out.println("-------------------------------");
		
		String fullName = "Hello.java"; // a.txt hi.ppt
		
		String fileName;
		String ext;
		
		int point = fullName.indexOf(".");
		fileName = fullName.substring(0,point);
		ext = fullName.substring(point+1);
		
		System.out.println("파일명:" + fileName);
		System.out.println("확장자:" + ext);

		String str5 = "Hell@oWo@rld";
		String[] result16 = str5.split("@"); // \\.,$ 등등 표기방법
		
		System.out.println(result16.length);
		
		for(String a : result16) {
			
			System.out.println(a);
			
		}
		
		System.out.println("-------------------------------");
		
		String id = "kim";
		String pw = "1234";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디 입력:");
		String inputId = sc.next();
		
		System.out.print("비밀번호 입력:");
		String inputPw = sc.next();

		if(id.equals(inputId) && pw.equals(inputPw)) { // == 쓰면 주소비교가 되어 equals를 사용해야함
			
			System.out.println("로그인 가능합니다.");
			
		}else {
			
			System.out.println("로그인 불가능합니다.");
			
		}
		
		
		
	}

}










