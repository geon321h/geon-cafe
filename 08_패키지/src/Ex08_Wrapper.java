
public class Ex08_Wrapper {

	public static void main(String[] args) {

		int i, sum=0;
		boolean point;
		String[] str = {"20","50","3.5","80"};
		
		for(i=0;i<str.length;i++) {
			
			try {
					
				sum += Integer.parseInt(str[i]);
						
			}catch (NumberFormatException e) {
				
				System.out.println(i + "번 방 정수 변환 불가");
				
			}
			
		}
		
		System.out.println("sum: " + sum);
		
	}

}
