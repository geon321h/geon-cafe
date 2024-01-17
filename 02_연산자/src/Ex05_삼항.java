
public class Ex05_삼항 {

	public static void main(String[] args) {

	// 조건문 ? X : Y
	// 조건이 참이면 X을, 거짓이면 Y를
	
	int a = 11, b =20;
	
	int result = a>b ? a : b;
	System.out.println("result:" + result);
		
	//String result2 = a%2 == 0 ? "짝수" : "홀수"; // 짝수 감별
	String result2 = a%2 == 0 ? "짝수" : "홀수"; // 홀수 감별
	System.out.println("result2:" + result2);
	
	
	}

}

/*
이항연산자
 + , - , * , / ,  % , == , != , && , || , < , > , <= , >=
 
단항연산자
 ! , ++ , -- , -(숫자)
  
삼항연산자
 ? X : Y
*/