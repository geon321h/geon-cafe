class ThreadRun implements Runnable	{
	
	public void run() {
		
		int i;
		for(i=0;i<50;i++) {
			
			System.out.print(i + " ");
			
		}
		
	}
	
}


public class Ex01 {

	public static void main(String[] args) {

		System.out.println("프로그램 시작");
		
		ThreadRun t = new ThreadRun();
		Thread th = new Thread(t);
		th.start();
		
		System.out.println("프로그램 끝");
		
	}

}
