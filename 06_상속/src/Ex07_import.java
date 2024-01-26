import java.util.Date;
import java.util.Scanner;

import com.javastudy.Car;

public class Ex07_import {

	public static void main(String[] args) {

		Car c = new Car("모닝",24);
		System.out.println(c); // 참조변수는 주소
		c.display();
		
		Scanner sc = new Scanner(System.in);
	
		Date d = new Date();
		System.out.println(d); // date클래스의 참조변수는 날짜가 나온다.
		// String s = new String("재미있는 자바공부");
		String s = "재미있는 자바공부";
		System.out.println(s);
		
	}

}

// final class : 상속받을수 없는 마지막 클래스이다.
// final 메서드 : final이 붙은 메서드는 자식이 오버라이딩 할 수 없다.
// final 변수 : 값을 한 번 설정하면 그 값을 다시 설정할 수 없다.

// 접근 제어자 //
// public : 같은 패키지 클래스 (일반o, 자식o) 다른 패키지 클래스 (일반o, 자식o)
// protected : 같은 패키지 클래스 (일반o, 자식o) 다른 패키지 클래스 (일반x, 자식o)
// default(접근제어자 없을시) : 같은 패키지 클래스 (일반o, 자식o) 다른 패키지 클래스 (일반x, 자식x)
// private : 같은 패키지 클래스 (일반x, 자식x) 다른 패키지 클래스 (일반x, 자식x)

// java.lang 패키지에 있는 클래스는 import 없이 사용가능하다.