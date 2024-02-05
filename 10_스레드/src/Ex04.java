import java.util.Iterator;

import javax.swing.JOptionPane;

class ThreadEx extends Thread {
	
	public void run() {
		
		for (int i = 10; i >0; i--) {
			
			System.out.println(i + " ");
			try {
				
				Thread.sleep(300);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
}

public class Ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input =  JOptionPane.showInputDialog("아무값이나 입력하세요");
		System.out.println("입력한 값은 " + input + "입니다.");

		ThreadEx ex = new ThreadEx();
		ex.start();
		
		
		
	}

}
