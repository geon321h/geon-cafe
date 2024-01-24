
public class Ex09_재귀호출 {

	public static void main(String[] args) {

		show(3); // 호출 (1)
		
		
	}

	static void show(int cnt) { // (2) (5) (8)
		
		System.out.println("Hi~" + cnt); // (3) (6) (9)
		
		if(cnt == 1) { // (10)
			return;
		}
		
		show(--cnt); // 재귀 호출 (4) (7)
		
	}
	
	// main => show(3) => show(2) => show(1) {=> show(2) => show(3)} => main 
	
}





