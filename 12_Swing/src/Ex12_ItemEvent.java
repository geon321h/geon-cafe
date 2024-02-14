import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

class Ex12 extends JFrame{
	
	ImageIcon[] image = {
										new ImageIcon("images/apple.jpg"),
										new ImageIcon("images/cherry.jpg"),
										new ImageIcon("images/pear.jpg")
									};
	
	String[] fruit = {"사과","배","체리"};
	JRadioButton[] radio = new JRadioButton[3];
	// JRadioButton radio1;
	// JRadioButton radio2;
	// JRadioButton radio3;
	JPanel radioPanel = new JPanel();
	JLabel imageLabel = new JLabel();
	ButtonGroup group = new ButtonGroup();
	Font font = new Font("궁서",Font.BOLD,30);
	
	public Ex12() {

		setTitle("ItemEvent 예제");
		
		Container contentPane = getContentPane(); // 기본적으로 borderLayout 이다.
		
		radioPanel.setBackground(Color.gray);
		contentPane.add(radioPanel,BorderLayout.NORTH);
		
		contentPane.add(imageLabel,BorderLayout.CENTER);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		for(int i=0;i<radio.length;i++) {
			
			radio[i] = new JRadioButton(fruit[i]);
			radio[i].setFont(font);
			group.add(radio[i]);
			radioPanel.add(radio[i]);
			radio[i].addItemListener(new MyItem());
			
		}
		
		setSize(350,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	class MyItem implements ItemListener {
		
		public void itemStateChanged(ItemEvent e) {
			
			if(radio[0].isSelected()) {
				
				imageLabel.setIcon(image[0]);
				
			}else if(radio[1].isSelected()) {
				
				imageLabel.setIcon(image[1]);
				
			}else {

				imageLabel.setIcon(image[2]);
				
			}
				
		}
		
	} // MyItem
	
} // Ex12


public class Ex12_ItemEvent {

	public static void main(String[] args) {

		new Ex12();
		
		
	}

}
