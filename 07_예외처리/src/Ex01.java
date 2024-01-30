
public class Ex01 {

	public static void main(String[] args) {

		try {
			
			String str = null;
			System.out.println(str);
			// System.out.println(str.length()); //  new NullPointerException
			System.out.println("예외처리"); 

			int[] arr = new int[2];
			arr[2] = 10; // new ArrayIndexOutOfBoundsException
			
		} catch (NullPointerException e) { // NullPointerException e = new NullPointerException()

			System.out.println("e:" +  e);
			
		}catch (ArrayIndexOutOfBoundsException e) { // ArrayIndexOutOfBoundsException e = new ArrayIndexOutOfBoundsException()
		
			System.out.println("e:" +  e);
		
		}finally {
			
			System.out.println("프로그램 종료");

		}
		
	}

}

// 예외가 발생하면 갑자기 관련된 객체가 생성된다.
// catch문에 잡아내고 싶은 예외를 넣어두면된다.
// NullPointerException e = new NullPointerException();
