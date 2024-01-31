
public class Ex04_남건 {

	public static void main(String[] args) {

		// 알파뱃의 갯수 각각을 배열에 넣기 // 
		
		String saying = "Slow and steady Wins the Race";
		
		
		// String lowSaying = saying.toLowerCase(); // 처음부터 소문자로 변경
		
		int i , j;
		int[] num = new int[26];
		
		for(i=0;i<num.length;i++) {
			
			for(j=0;j<saying.length();j++) {
				
				if((97+i) == (int)saying.toLowerCase().charAt(j)) { // 비교할때 소문자로 변경
					
					num[i]++;
					
				}
				
			}
			
			System.out.println((char)(97+i) + ":" + num[i]);
			
		}
		
	}

}
