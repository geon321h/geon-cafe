import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class Ex10 extends Frame {
	
	public Ex10() {

		this.addWindowListener(new WindowAdapter() {
			
			public void windowActivated(WindowEvent e) {
				
				System.out.println("창이 활성화됨");
				
			}
			
			public void windowClosing(WindowEvent e) {
				
				System.out.println("x버튼 클릭함");
				System.exit(0);;
				
			}
			
		});
		
	}// 생성자
	
} // Ex10

public class Ex10_WindowAdapter {

	public static void main(String[] args) {

		Ex10 ex = new Ex10();
		ex.setSize(300,200);
		ex.setTitle("WindowAdapter 예제");
		ex.setVisible(true);
		
	}

}
