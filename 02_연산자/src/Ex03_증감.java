
public class Ex03_증감 {

	public static void main(String[] args) {

		int a=5, b=5, aa, bb;
		
		// a = a+1;
		// a += 1;
		//a++;
		++a;
		System.out.println("a=" + a);
		
		aa = ++a;
		// aa = a++
		System.out.println("a="  + a + " aa=" + aa);
		
		// 변수 앞++ : 먼저 1증가 
		// 변수 뒤++ : 나중에 1증가

		// b = b-1;
		// b -= 1;
		// b--;
		--b;
		
		bb = --b;
		System.out.println("b=" + b + " bb="+ bb);
		// 변수 앞-- : 먼저 1감소 
		// 변수 뒤-- : 나중에 1감소
		
		int i = 10;
		System.out.println(i);
		System.out.println(i++);
		System.out.println(++i);
		System.out.println(++i);
		System.out.println(i++);
		System.out.println(i);
		
		
	}

}
