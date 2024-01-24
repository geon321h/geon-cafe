class Calc	{
	
	int x;
	int y;

	void sum() { // sum 메서드 정의
		System.out.println(x+y);
	}
	
	int mul() { // mul 메서드 정의
		return x*y;
	}
	
	int max() { // max 메서드 정의
		if(x>y) {
			return x;
		}else {
			return y;
		}
	}
	
	int min() { // min 메서드 정의
		if(x<y) {
			return x;
		}else{
			return y;
		}
	}
	
}

public class Ex05_메서드 {

	public static void main(String[] args) {

		int x = 10;
		int y = 20;
		
		Calc c = new Calc();
		c.x = x;
		c.y = y;
		int	result = c.mul();
		
		
		System.out.println(c.x + " " + c.y);
		c.sum();
		System.out.println(result);
		System.out.println(c.mul());
		
		result = c.max();
		System.out.println(result);
		
		result = c.min();
		System.out.println(result);
	}
	
}




