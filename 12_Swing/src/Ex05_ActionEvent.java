import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Ex05 extends Frame implements ActionListener	{
	
	Button btn1 = new Button("노란색");
	Button btn2 = new Button("빨간색");
	Button btn3 = new Button("파란색");
	
	public Ex05(String title) {

		super(title);
		super.setSize(500,400);
		super.setVisible(true);

		this.addWindowListener(new WindowAdapter() {
		
			public void windowClosing(WindowEvent e) {
				
				System.out.println("x버튼 클릭함");
				System.exit(0);;
				
			}
			
		});
		
		
		setLayout(new FlowLayout());
		
		btn1.addActionListener(this); // 자동으로 actionPerformed 메서드를 호출한다.
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
		/*
		 버튼을 눌렀을 때 발생하는 이벤트 이름이 ActionEvent, event 클래스 객체가 생성된다. new ActionEvent();
		  마우스를 클릭할 때 발생하는 이벤트 이름은 MouseEvent, new MouseEvent();
		 Frame 크기를 조절할 때 발생하는 이벤트 이름은 WindowEvent, new WindowEvent();
		 */
		
		btn1.setBackground(Color.YELLOW);
		btn3.setForeground(Color.blue);
		
		add(btn1);
		add(btn2);
		add(btn3);
	
	}

	public void actionPerformed(ActionEvent e) { // 이벤트가 발생한 컴퍼넌트: 이벤트 소스(event source)
		
		// System.out.println("버튼 눌림");
		
		Object obj = e.getSource();
		
		if(obj == btn1) {
			
			super.setBackground(Color.yellow);
			
		}else if (obj == btn2) {
			
			super.setBackground(Color.red);
			
		}else {

			super.setBackground(Color.blue);
			
		}
		
	}
	
}

public class Ex05_ActionEvent {

	public static void main(String[] args) {

		Frame ex = new Ex05("AWT예제");
		
	}

}
