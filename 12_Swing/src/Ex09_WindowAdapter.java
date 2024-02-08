import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class Ex09 extends Frame {
	
	public Ex09() {

		this.addWindowListener(new MyWindow());
		
	}
	
	class MyWindow extends WindowAdapter {
		
		public void windowActivated(WindowEvent e) {
			
			System.out.println("창이 활성화됨");
			
		}
		
		public void windowClosing(WindowEvent e) {
			
			System.out.println("x버튼 클릭함");
			System.exit(0);;
			
		}
		
	}
	
}

public class Ex09_WindowAdapter {

	public static void main(String[] args) {

		Ex09 ex = new Ex09();
		ex.setSize(300,200);
		ex.setTitle("WindowAdapter 예제");
		ex.setVisible(true);
		
	}

}
