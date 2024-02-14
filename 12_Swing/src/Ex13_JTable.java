import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex13_JTable extends JFrame {

	String[] colName = {"이름","직업","나이"};
	Object[][] data = {
								{"성시경","가수",30},
								{"신동엽","개그맨",40},
								{"김연아","운동선수",20},
								{"전지현","배우",80}
							};
	
	public Ex13_JTable() {
		
		Container contentPane = getContentPane();
		
		JTable table = new JTable(data,colName);
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {

		Ex13_JTable ex = new Ex13_JTable();
		ex.setSize(500,300);
		ex.setVisible(true);
		
	}

}
