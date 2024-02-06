import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex05_FileInputStream {

	public static void main(String[] args) {

		int i;
		FileInputStream fis = null;
		FileOutputStream fos = null ;
		
		try {
			
			fis = new FileInputStream("from.txt");
			
			fos = new FileOutputStream("to.txt");
			
			while(true) {
				
				i = fis.read();
				if(i==-1) {
					break;
				}

				System.out.print((char)i);
				fos.write(i);
				
			}
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();

		}catch (IOException e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				fis.close(); 
				// fis cannot be resolved : 지역변수로 선언했을 경우 
				// Unhandled Exception : close()를 예외처리하지 않을 경우
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
	}

}
