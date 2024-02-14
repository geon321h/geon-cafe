import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class QuizClient {

	public static void main(String[] args){

		Socket clientSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		BufferedReader kb = null;
		
		try {
			
			clientSocket = new Socket("localhost",9191);

			out = new PrintWriter(clientSocket.getOutputStream(),true);
			
			in = new BufferedReader(
					new InputStreamReader(clientSocket.getInputStream()));
			
			kb = new BufferedReader(
					new InputStreamReader(System.in));
			
			String fromServer, fromClient;
			
			while((fromServer = in.readLine()) != null) {
				
				System.out.println("    :"  + fromServer);
				if(fromServer.equals("quit")) {
					
					break;
				}
				
				
				fromClient = kb.readLine();
				if(fromClient != null) {
					
					System.out.println("Ŭ   ̾ Ʈ:"  + fromClient);
					out.println(fromClient);
			
				}
				
			}

		} catch (UnknownHostException e) {

			e.printStackTrace();
			
		} catch (IOException e) {

			e.printStackTrace();
			
		}finally {
			
			try {

				if(out!=null) {
					out.close();
				}
				in.close();
				kb.close();
				clientSocket.close();
				
			} catch (IOException e) {

				e.printStackTrace();
				
			}
			
		}
		
		
		
	}

}
