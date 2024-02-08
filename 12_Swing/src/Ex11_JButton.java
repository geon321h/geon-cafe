import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Ex11 extends JFrame {
	
	public Ex11(){
		
		Container contentPane = getContentPane();
		
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		p1.setBackground(Color.yellow);
		p2.setBackground(Color.cyan);

		JTextField text1 = new JTextField(5);
		JTextField text2 = new JTextField(5);
		JTextField text3 = new JTextField(5);
		
		p1.add(text1);
		p1.add(new JLabel("+"));
		p1.add(text2);
		p1.add(new JLabel("="));
		p1.add(text3);
		
		JButton btn1 = new JButton("확인");
		JButton btn2 = new JButton("취소");
		
		p2.add(btn1);
		p2.add(btn2);
		
		btn1.addActionListener(new OkButton(text1, text2, text3));
		btn2.addActionListener(new CanselButton(text1, text2, text3));
		
		contentPane.add(p1,BorderLayout.CENTER);
		contentPane.add(p2,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창만 닫히는게 아닌 프로그램도 종료처리한다.
		
		pack();
		super.setVisible(true);
		
	}
	
} // Ex11

class OkButton implements ActionListener {

	JTextField text1;
	JTextField text2;
	JTextField text3;
	
	OkButton(JTextField text1,JTextField text2,JTextField text3){
		
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
		
	}

	public void actionPerformed(ActionEvent e) {
		
		try {

			String s1 = text1.getText();
			int i1 = Integer.parseInt(s1);
			int i2 = Integer.parseInt(text2.getText());
			int sum = i1+i2;
			text3.setText(String.valueOf(33));
			
		}catch (NumberFormatException e2) {
			
			JOptionPane.showMessageDialog(null, "숫자만 입력 가능");
			
			text1.setText("");
			text2.setText("");
			
		}
		
	}
	
}

class CanselButton implements ActionListener {

	JTextField text1;
	JTextField text2;
	JTextField text3;
	
	CanselButton(JTextField text1,JTextField text2,JTextField text3){
		
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		text1.setText("");
		text2.setText("");
		text3.setText("");
		
	}
	
}

public class Ex11_JButton {

	public static void main(String[] args) {

		new Ex11();
		
	}

}
