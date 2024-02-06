import java.io.File;
import java.io.IOException;

public class Ex04_File {

	public static void main(String[] args) {

		File f1 = new File("A");
		File f2 = new File("B");
		File f3 = new File("C");
		File f4 = new File(f1,"aa.txt");

		if(f1.exists()) {
			
			f1.renameTo(f2);
			
		}else {
			
			f1.mkdir();
			try {
				
				f4.createNewFile();
				System.out.println("파일생성함");
				
			} catch (IOException e) {

				e.printStackTrace();
				
			}
			System.out.println("폴더생성함");
			
		}
		
		if(f3.exists()) {
			
			f3.delete(); // 폴더안에 파일이 있으면 삭제가 안된다.
			
		}
		
		
		
	}

}
