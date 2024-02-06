import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex06_FileOutputStream {

	public static void main(String[] args) {

		FileInputStream fis = null;
		FileOutputStream fos  = null;
		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
		int a;
		
		try {
			
			fos  = new FileOutputStream("data.txt");
			bos = new BufferedOutputStream(fos,5); 
			// Buffer란 임시저장소로 n개의 size를 정하고 해당 size가 초과될때 FOS로 입력받은 값을 보낸다. ( 사이즈 지정안할시 8192byte ) 
			
			for(int i=1;i<=9;i++) {
				
				bos.write(i+48); // '0' (48)
			
			}
			
			bos.flush();
			
			fis  = new FileInputStream("data.txt");
			bis = new BufferedInputStream(fis,5);

			while((a = bis.read()) != -1) {
				
				System.out.print((char)a);
				
			}
			
			
		}catch (FileNotFoundException e) {
			
			e.printStackTrace();

		}catch (IOException e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				
				bos.close();
				fis.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}

}
