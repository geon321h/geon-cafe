class DaemonTest extends Thread {

	public void run() {
		
		while(true) {
			
			try {
				
				sleep(3*1000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(Ex06_데몬쓰레드.autoSave == true) {
				autoSave();
			}
			
		}
		
	}
	
	public void autoSave() {
		System.out.println("작업파일이 자동저장되었습니다.");
	}
	
}

public class Ex06_데몬쓰레드 {

	static boolean autoSave = false;
	
	public static void main(String[] args) {

		DaemonTest dt = new DaemonTest();
		
		dt.setDaemon(true);
		dt.start();
		
		for(int i=1;i<=20;i++) {
			
			try {
				
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.print(i + " ");
			
			if(i==5) {
				
				autoSave = true;
				
			}
			
		}
		System.out.println("프로그램을 종료");
		
	}

}
