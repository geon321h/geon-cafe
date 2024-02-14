import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class QuizServer {

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		
		try {
			
			serverSocket = new ServerSocket(9191);
			clientSocket = serverSocket.accept();
			
		} catch (IOException e) {
			
			System.exit(1);
			
		}

		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
		
		BufferedReader in = new BufferedReader(
				new InputStreamReader(clientSocket.getInputStream()));
		
		String outputLine, inputLine;
		QuizBank bank = new QuizBank();
		outputLine = bank.process(null);
		out.println(outputLine);
		
		while((inputLine = in.readLine()) != null) {
			
			outputLine = bank.process(inputLine);
			out.println(outputLine);
			
			if(outputLine.equals("quit")) {
				break;
			}
			
		}
		
		if(out!=null) {
			out.close();
		}
		in.close();
		clientSocket.close();
		serverSocket.close();
	
	}

}
