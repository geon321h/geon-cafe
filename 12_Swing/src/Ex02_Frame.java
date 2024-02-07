import java.awt.Frame;

class HelloFrame extends Frame {
	
	public HelloFrame(String str) {

	
	}
	
}

public class Ex02_Frame {

	public static void main(String[] args) {

		Frame f = new HelloFrame("제목");
		
		f.setTitle("프레임 만들기");
		f.setSize(500,300);
		f.setVisible(true);
		
	}

}
