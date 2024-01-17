public class Ex03_문자형 {
	
	public static void main(String[] args) {
		
		char ch1,ch2; // 문자 한글자 넣겠다고 선언
		ch1 = 'A'; // ''만 가능
		ch2 = 'B';
		System.out.println("ch1= " + ch1);
		System.out.println("ch2= " + ch2);
		System.out.println(1+2);
		System.out.println(ch1 + 1); // 'A'(char:2byte) + 1 = 66
		System.out.println((char)66);
		System.out.println((char)(ch1 + 1)); // A + 1
		
		int x;
		x = 'A';
		System.out.println("x=" + x);
		
		char y;
		y = 66;
		System.out.println("y=" + y);
		
	}

}

/*
 A: 65
 b: 66
 
 a: 97
 b: 98
 
 '0': 48
 '1': 49
*/
