
public class Ex03 {

	public static void main(String[] args) {
		
		String s = null;
		
		try {

			System.out.println(s.length()); // new NullPointerException
			System.out.println(3/0); // new ArrayIndexOutOfBoundsException
			// Exception e = new NullPointerException
			// Exception e = new ArrayIndexOutOfBoundsException
			
		} catch (NullPointerException e) {

			System.out.println("NullPointerException e:" + e);
		
		} catch (ArithmeticException e) {
		
			System.out.println("ArithmeticException e:" + e);
		
		} catch (Exception e) {
		
			System.out.println("Exception e:" + e);
		
		}
		
	}

}
