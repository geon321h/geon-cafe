
public class Ex07_Wrapper {

	public static void main(String[] args) {

		int[] n = {1,2,3,4,5};
		int i;
		int sum = 0;
		
		for(i=0;i<n.length;i++) {
			
			sum += n[i];
			
		}
		System.out.println("sum: " + sum);
		
		// 문자열을 숫자로 바꾸어 합 계산 //
		
		String[] n2 = {"1",	"2","3","4","5"};
		sum = 0;
		
		for(i=0;i<n2.length;i++) {
			
			// sum += Integer.valueOf(n2[i]);
			sum += Integer.parseInt(n2[i]);
			
		}
		System.out.println("sum: " + sum);
		
		// 점수 합계 //
		
		int index;
		String temp;
		sum = 0;
		String[] str = {"민아:70","아이유:80","최강창민:90"};
		
		for(i=0;i<str.length;i++) {
			
			index = str[i].indexOf(":");
			temp = str[i].substring(index+1);
			sum += Integer.valueOf(temp);
			
		}
		System.out.println("sum: " + sum);
		System.out.println();

		sum = 0;
		for(i=0;i<str.length;i++) {
			
			String[] arr = str[i].split(":");
			sum += Integer.parseInt(arr[1]);
			
		}
		System.out.println("sum: " + sum);

	}

}
