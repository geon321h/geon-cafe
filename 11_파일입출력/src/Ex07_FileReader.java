import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex07_FileReader {

	public static void main(String[] args) {

		FileWriter fw = null;
		BufferedWriter bw = null;
		FileReader fr	= null;
		BufferedReader br =null;
		
		try {
			
			fw = new FileWriter("write.txt");
			bw = new BufferedWriter(fw,5);
			bw.write("즐거운 자바수업~");
			bw.flush();
			// IOException 발생이유 : 경로에 해당하는 폴더가 없을 경우
			// false면 파일이 생성된다.
			// true면 기존 파일의 값을 추가한다.
			
			fr = new FileReader("write.txt");
			br =new BufferedReader(fr,5);
			int i ;
			while ((i=br.read())!=-1) {
				
				System.out.print((char)i);

			}
			
			
		} catch (IOException e) {

			e.printStackTrace();
		
		}finally {
			
			try {
			
				bw.close();
				br.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			
			}
			
		}
		
		
	}

}
