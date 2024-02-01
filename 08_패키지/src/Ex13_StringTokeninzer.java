import java.util.StringTokenizer;

public class Ex13_StringTokeninzer {

	public static void main(String[] args) {

		StringTokenizer str =new StringTokenizer("2024/02|01,12:02", ", :");
		System.out.println("str:" + str);
		
		int count = str.countTokens();
		System.out.println("count:" + count);
		
		// str => "2024/02|01,12:02", ","
		
		while(str.hasMoreTokens()) {
			
			String s = str.nextToken();
			System.out.println("s:" + s);
		
		}	
		System.out.println("-----------------------------------------");

		StringTokenizer str2 =new StringTokenizer("3+8+7+2","+");
		int count2 = str2.countTokens();
		int sum =0;

		while(str2.hasMoreTokens()) {

			sum += Integer.parseInt(str2.nextToken());

		}	
		System.out.println("\nStringTokenizer => 합계:" + sum);
		
		String s = "3+8+7+2";
		String[] arr = s.split("\\+");
		sum = 0;
		
		for(String a : arr) {
			
			sum += Integer.parseInt(a);
			
		}
		System.out.println("split => 합계:" + sum);
		System.out.println("-----------------------------------------");
		
		sum = 0;
		String[] s_arr = {"민아:70","아이유:80","최강창민:90"};
		
		for(String a : s_arr) {
			
			StringTokenizer str3 =new StringTokenizer(a.substring(a.indexOf(":")+1));
			while(str3.hasMoreTokens()) {
				sum += Integer.parseInt(str3.nextToken());
			}	
			
		}
		System.out.println("\nStringTokenizer => 합계:" + sum);
		
		sum = 0;

		for(String a : s_arr) {
			
			String[] arr1 = a.split(":");
			sum += Integer.parseInt(arr1[1]);
			
		}
		System.out.println("split => 합계:" + sum);
		
	}

}
