
public class Ex10_Math {

	public static void main(String[] args) {

		int i;
		
		// 정수난수 5번 발생 //
		
		for(i=0;i<5;i++) {
			
			int a = (int)(Math.random()*9)+5;
			System.out.println("a:" + a);
			
		}

		for(i=0;i<5;i++) {
			
			// char  alp = (char)(Math.random()*26+65);
			int  alp = (char)(Math.random()*26)+65; // + 할시 정수형으로 바뀌어 char(2byte)에 들어갈수 없음
			System.out.println("alp:" + (char)alp);
			
		}

		
		
	}

}
