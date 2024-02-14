import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class Ex02_IP주소 {

	public static void main(String[] args) {

		System.out.print("웹사이트 주소를 입력하세요=>");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			String url = br.readLine();
			InetAddress[] addr =  InetAddress.getAllByName(url);
			for(int i=0;i<addr.length;i++) {
				
				System.out.println(addr[i]);
				
			}
			
		} catch (IOException e) {

			e.printStackTrace();
			
		}
		
	}

}
