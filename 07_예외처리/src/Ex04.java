
public class Ex04 {

	public static void main(String[] args) {

		try {

			call();
			System.out.println("정상 처리 되었습니다.");
			
		} catch (Exception e) {
		
			System.out.println("예외발생");
			
		}
		
	}

	public static void call() {
		
		
		try {
			
			int x = 10/0;
			System.out.println(x);
			
		} catch (Exception e) {

			System.out.println("call()에서 예외 발생");
			throw e;
			
		}
		
		return;
		
	}
	
}
