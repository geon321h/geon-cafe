class Big implements Runnable {


	public void run() {

		for(char i='a';i<='z';i++) {

			try {
				
				System.out.println((char)i + " ");
				Thread.sleep(300);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
		}

	}

}

class Small extends Thread {

	public void run() {
		
		for(char i='A';i<='B';i++) {
			
			try {
				
				System.out.println((char)i + " ");
				Thread.sleep(300);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}

}

public class Ex03 {

	public static void main(String[] args) {

		Big b = new Big();
		Small s = new Small();
		Thread th = new Thread(b);
		
		th.start();
		s.start();

		for(int i=1;i<=30;i++) {

			System.out.println(i + " ");

		}

	}

}
