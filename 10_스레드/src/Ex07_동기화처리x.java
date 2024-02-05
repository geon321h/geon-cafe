class Data {
	
	int i = 0;
	
}

class AA extends Thread {
	
	public void run() {
		
		for( int i=0;i<100000;i++) {
			
			Ex07_동기화처리x.data.i++;
			
		}
		System.out.println("AA :" + Ex07_동기화처리x.data.i);
	}
	
}

class BB extends Thread {
	
	public void run() {
		
		for(int i=0;i<100000;i++) {
			
			Ex07_동기화처리x.data.i++;
			
		}
		System.out.println("BB :" + Ex07_동기화처리x.data.i);
		
	}
	
}

public class Ex07_동기화처리x {

	static Data data =new Data();
	
	public static void main(String[] args) {

		System.out.println("main 시작");
		
		AA a = new AA();
		BB b = new BB();
		
		a.start();
		b.start();
		
		System.out.println("main 종료");
		
	}

}
