import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ex03_Client {

	public static void main(String[] args) throws IOException {

		Socket socket = null;
		PrintWriter  pw = null;
		
		try {
			
			socket = new Socket("localhost",5555);
			pw = new PrintWriter(socket.getOutputStream());
			
		} catch (UnknownHostException e) {

			System.exit(1);
			
		} catch (IOException e) {

			System.exit(1);
			
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("input:");
		String fromClient = br.readLine(); 
		pw.print(fromClient);
		
		pw.close();
		socket.close();
		
		
		
		
	}

}
