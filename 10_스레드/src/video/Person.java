package video;

public class Person extends Thread {

	String name;

	public Person(String name) {
		super(name);
	}

	public void run() {
		
		try {
			String v = ThreadMain.vShop.lendVideo();
			System.out.println(getName() + ":" + v + "빌린다.");
			System.out.println(getName() + ":" + v + "보는중.");
			sleep(3000);
			System.out.println(getName() + ":" + v + "반납.");
			ThreadMain.vShop.returnVideo(v);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
