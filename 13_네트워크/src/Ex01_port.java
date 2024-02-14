import java.io.IOException;
import java.net.ServerSocket;

public class Ex01_port {

	public static void main(String[] args) {

		
		ServerSocket ss = null;
		
		for(int i=0;i<65535;i++) {
			
			try{
				
				ss = new ServerSocket(i);
				ss.close();
				
			} catch (IOException e) {
				
				System.out.println(i + "번 포트번호는 이미 사용중입니다.");
				
			}
			
		}
		
		
		
	}

}
