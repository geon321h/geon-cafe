
public class Ex12_break_continue {

	public static void main(String[] args) {

		int i;
		
		// break 개념 //
		for(i=1;i<=10;i++) {
			if(i==5) {
				break; // 가장 가까운 반복문을 빠져나간다.
			}
			System.out.println(i);
		} // for문
		System.out.println("for문 밖");
	
		// continue 개념 //
		for(i=1;i<=10;i++) {
			if(i==5) {
				continue; // 증감식으로 바로 간다.
			}
			System.out.println(i);
		}
		System.out.println("for문 밖");
		
	}

}
