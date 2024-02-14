import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex03_Server {

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		
		try {
			
			serverSocket = new ServerSocket(5555);
			
		} catch (IOException e) {
			
			System.err.println("use");
			System.exit(1);
			
		}
		
		System.out.println("Server ready..");
		try {
			
			clientSocket = serverSocket.accept();
			System.out.println("connected");
			
		} catch (IOException e) {

			e.printStackTrace();
			
		}
		
		 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		 String line = in.readLine();
		 System.out.println("client data:" + line);
		 
		 in.close();
		 clientSocket.close();
		 serverSocket.close();
		 
	}

}
