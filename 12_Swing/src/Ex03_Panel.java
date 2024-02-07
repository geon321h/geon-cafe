import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

class ExPanel extends Frame	{
	
	ExPanel (String title){

		super(title);
		super.setSize(400,300);
		super.setVisible(true);
	
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		
		p1.setBackground(Color.green);
		p2.setBackground(Color.yellow);
		p3.setBackground(Color.pink);
		
		super.add(p1,"North");
		super.add(p2,"Center");
		super.add(p3,"South");
		
		Button b1 = new Button("버튼1");
		Button b2 = new Button("버튼2");
		Button b3 = new Button("버튼3");
		
		p1.add(b1);
		p2.add(b2);
		p3.add(b3);

	}
	
}

public class Ex03_Panel {

	public static void main(String[] args) {

		Frame ex = new ExPanel("Panel 예제");
		
		// ex.setSize(400,300);
		// ex.setVisible(true);
		
	}

}

// 한글깨짐 처리
// Run -  Run Configuration - common - other "MS949"
