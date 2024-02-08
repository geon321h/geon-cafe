import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class Ex06 extends Frame implements ItemListener{

	// Panel //
	// 기본 레이아웃이 FlowLayout
	
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	Panel p3 = new Panel();
	
	
	// Label //
	
	Label lb = new Label("꽃을 선택하세요");
	Label lb2 = new Label("               ");
	
	
	// Choice //
	
	Choice ch = new Choice();
	//ch.add("진달래");
	//ch.add("벚꽃");
	//ch.add("장미");
	//ch.add("국화");
	//ch.add("개나리");
	String[] flower = {"진달래","벚꽃","장미","국화","개나리"};

	public Ex06(String title){
		
		super.setTitle(title);
		setSize(300,200);
		setVisible(true);
		
		p1.setLayout(new BorderLayout());
		
		p1.setBackground(Color.green);
		p2.setBackground(Color.pink);
		
		lb.setBackground(Color.orange);
		lb2.setBackground(Color.yellow);

		// add //
		
		super.add(p1,"North");
		super.add(p2,"Center");
		super.add(p3,"South");

		for(String a : flower) {
			ch.add(a);
		}
		// super.add(ch);
		
		p1.add(lb,"Center");
		p1.add(ch,BorderLayout.SOUTH);
		p2.add(lb2);
		ch.addItemListener(this); // Choice가 변경이 됐을 때 갑자기 new ItemEvent가 생성되고 이 객체를 가지고 itemStateChanged를 호출함
	
	}

	public void itemStateChanged(ItemEvent e) {
		
		int index = ch.getSelectedIndex();
		String item = ch.getItem(index);
		lb2.setText(item);
		lb2.setAlignment(Label.CENTER);
		System.out.println(index + "/"  + item);
		
	}
	
}

public class Ex06_ItemEvent {

	public static void main(String[] args) {

		Frame ex = new Ex06("ItemEvent");
		
	}

}
