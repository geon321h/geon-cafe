import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex08_InputStreamReader {
	
	public static void main(String[] args) {
	
		InputStreamReader ir = null;
		BufferedReader br = null;
		
		System.out.print("데이터 입력:");
		InputStream is = System.in; // 바이트를 입력받는 스트림
		
		try {
			
			// ir = new InputStreamReader(is); // 바이트스트림 => 문자스트림 변경
			br = new BufferedReader(ir = new InputStreamReader(System.in));
			String str = br.readLine(); // 공백포함 한줄만 읽을수있다.(개행전까지) 
			// 문자를 읽는 InputStreamReader에 입력을하고 버퍼를 통해 문자를 개행전까지 읽어 문자열을 만들고 한번에 보낸다.
			
			System.out.println("str:" + str);
			
		} catch (IOException e) {

			e.printStackTrace();
		
		}finally {
			
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
