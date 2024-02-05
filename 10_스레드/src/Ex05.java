class Horizontal	extends Thread {

	public void run() {

		for(int i=1;i<=300;i++) {

			System.out.print("-");

			if(i%50 == 0) {
				
				System.out.println();
				
			}
			
			try {

				Thread.sleep(30);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}

	}
	
}

class Vertical extends Thread {
	
	public void run() {
		
		for(int i=1;i<=300;i++) {
			
			System.out.print("|");

			if(i%50 == 0) {
				
				System.out.println();
				
			}
			
			try {
				
				Thread.sleep(30);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
}

public class Ex05 {

	public static void main(String[] args) {

		Horizontal h = new Horizontal();
		
		Vertical v = new Vertical();
		
		v.setPriority(7);
		System.out.println(h.getPriority());
		System.out.println(v.getPriority());
		h.setName("정현");
		v.setName("뷔");
		System.out.println(h.getName());
		System.out.println(v.getName());
		
		h.start();
		v.start();
		
	}

}
