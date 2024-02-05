class ThreadRun2 extends Thread	{

	public void run() {
		
		int i;
		
		for(i=0;i<50;i++) {
			
			System.out.print(i + " ");
			
			try {

				Thread.sleep(500); // new InterruptedException
				
			} catch (InterruptedException e) {

				e.printStackTrace();
				
			}
			
		}
		
	}
	
}

public class Ex02 {

	public static void main(String[] args) {

		System.out.println("프로그램 시작");
		
		ThreadRun2 th = new ThreadRun2();
		th.start();

		
		System.out.println("프로그램 끝");
		
		
	}

}
