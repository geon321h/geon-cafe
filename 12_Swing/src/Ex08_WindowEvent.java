import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class Ex08 extends Frame implements WindowListener{
	
	public Ex08() {

		this.addWindowListener(this);
		
	}

	public void windowOpened(WindowEvent e) {
		
		System.out.println("windowOpened");
		
	}

	public void windowClosing(WindowEvent e) {
		
		System.out.println("x버튼 클릭함");
		System.exit(0);;
		
	}

	public void windowClosed(WindowEvent e) {
		
		System.out.println("windowOpened");

		
	}

	public void windowIconified(WindowEvent e) {
		
		System.out.println("windowIconified");

		
	}

	public void windowDeiconified(WindowEvent e) {
		
		System.out.println("windowDeiconified");

		
	}

	public void windowActivated(WindowEvent e) {
		
		System.out.println("창이 활성화됨");
		
	}

	public void windowDeactivated(WindowEvent e) {

		System.out.println("창이 최소화됨");
		
	}
	
}

public class Ex08_WindowEvent {

	public static void main(String[] args) {

		Ex08 ex = new Ex08();
		ex.setSize(300,200);
		ex.setTitle("WindowEvent");
		ex.setVisible(true);
		
	}

}
