
public class Ex05 {

	public static void main(String[] args) {

		try {
			
			sub(); // ArithmeticException 발생했다.
			
		} catch (Exception e) {

			System.out.println("예외발생");
			
		}
		
	}

	public static void sub() throws ArithmeticException {
		
		int result = 3/0;
		System.out.println(result);
		
	}
	
}
