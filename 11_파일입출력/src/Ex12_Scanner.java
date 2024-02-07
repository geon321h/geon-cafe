import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex12_Scanner {

	public static void main(String[] args) {

		// Scanner sc = new Scanner(System.in);
		// Scanner(InputStream source)
		
		int num, sum=0;
		
		try {
			
			Scanner sc = new Scanner(new File("input.txt"));
			// Scanner(File source)
			
			sc.useDelimiter(",");
			
			while(sc.hasNextInt()) {
				
				num = sc.nextInt();
				System.out.println(num);
				sum += num;
				
			}
			System.out.println("sum:" + sum);
			
			sc.close();
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			
		}
		
	}

}
