
public class Ex04_관계논리 {

	public static void main(String[] args) {

		int a = 10;
		int b = 10;
		boolean c = a <= b;
		
		System.out.println("a<b : " + c );
		System.out.println("a<b : " + (a <= b) );
		
		// c = a == b; //true
		c = a != b; // false
		System.out.println("c : " + c);
		
		// c = a>1 && b<1; //false
		c = a>1 || b<1; // true
		System.out.println("c : " + c);
		
		System.out.println(!(5>3)); // true => false

	}

}

/*
&& and 연산자
T && T : T
T && F : F
F && T : F
F && F : F

|| or 연산자
T || T : T
T || F : T
F || T : T
F || F : F

!true => false
!false => true
*/