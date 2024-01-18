
public class Ex10_for {

	public static void main(String[] args) {

		int i,j,k;
		
		for(i=0;i<5;i++) {
			
			for(j=0;j<=i;j++) {
			
				System.out.print("*");
				
			}
			System.out.println();
		}
		/* 부연설명
		i=1 : System.out.print("*");
		i=2 : System.out.print("**");
		i=3 : System.out.print("***");
		i=4 : System.out.print("****");
		i=5 : System.out.print("*****");
		처럼 i가 늘어남에 따라 j 즉 한 줄당 *출력량이 늘어나면서 다음 줄로 넘어간다.
		*/	

		for(i=0;i<5;i++) {
			
			for(k=4;k>i;k--) {
				
				System.out.print(" ");

			}
			
			for(j=0;j<=i;j++) {
				
				System.out.print("*");
				
			}
			System.out.println();
		}
		
	}

}
