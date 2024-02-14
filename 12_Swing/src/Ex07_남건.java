import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

class Ex07_ng extends Frame implements ItemListener {
	
	String[]  대륙 = {"아시아","유럽","아프리카"};
	
	String[][] 나라 = {
								{"한국","일본","중국"},
								{"영국","스위스","프랑스"},
								{"이집트","콩고","우간다"},
							};
	
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	Panel p3 = new Panel();

	Label lb1 = new Label("대륙과 나라를 선택하세요");
	Label lb2 = new Label("");
	
	Choice ch1 = new Choice();
	Choice ch2 = new Choice();
	
	public Ex07_ng(String title) {

		super.setTitle(title);
		setSize(300,200);
		setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
		
			@Override
			public void windowClosing(WindowEvent e) {

				System.exit(0);
				
			}
		
		});
		
		p2.setBackground(Color.pink);
		
		lb1.setBackground(Color.CYAN);
		lb2.setBackground(Color.yellow);
		
		for(String a : 대륙) {
			
			ch1.add(a);
			
		}

		ch2.add("               ");
		
		super.add(lb1,"North");
		super.add(p2,"Center");
		super.add(lb2,"South");

		p2.add(ch1);
		p2.add(ch2);
		
		ch1.addItemListener(this);
		ch2.addItemListener(this);
		
		
	}

	public void itemStateChanged(ItemEvent e) {
		
		Object obj = e.getSource();
		
		if(obj.equals(ch1)) {
			
			int i=0;
			int index = ch1.getSelectedIndex();
			String item = ch1.getItem(index);
			
			switch (item) {
			case "아시아": i=0;
				break;
			case "유럽": i=1;
				break;
			case "아프리카": i=2;
				break;
			default:break;
			
			}
			
			ch2.removeAll();
			
			for(String a : 나라[i]) {
				ch2.add(a);
			}
			
		}else {

			int index = ch2.getSelectedIndex();
			String item = ch2.getItem(index);
			lb2.setText("선택한 나라 " + item);
			
		}
		
	}
	
}

public class Ex07_남건 {

	public static void main(String[] args) {

		// 1패널 2패널 핑크 3패널
		// 1라벨 하늘 "대륙과 나라를 선택하세요"
		// 3라벨 노랑
		// 2패널 초이스 2개 첫번째 초이스에 따라 두번째 초이스 목록생성
		
		Frame ng = new Ex07_ng("대륙과 나라 과제	");
		
	}

}
