class Data2 {
	
	int i = 0; // 공유자원
	
}

class AA2 extends Thread {
	
	public void run() {
		
		for( int i=0;i<100000;i++) {
			
			synchronized (Ex08_동기화처리o.data) {
				Ex08_동기화처리o.data.i++;
			}
			
		}
		System.out.println("AA :" + Ex08_동기화처리o.data.i);
	}
	
}

class BB2 extends Thread {
	
	public void run() {
		
		for(int i=0;i<100000;i++) {

			synchronized (Ex08_동기화처리o.data) {
				Ex08_동기화처리o.data.i++;
			}
			
		}
		System.out.println("BB :" + Ex08_동기화처리o.data.i);
		
	}
	
}

public class Ex08_동기화처리o {

	static Data2 data =new Data2();
	
	public static void main(String[] args) {

		System.out.println("main 시작");
		
		AA2 a = new AA2();
		BB2 b = new BB2();
		
		a.start();
		b.start();
		
		System.out.println("main 종료");
		
	}

}
