package JTable성적처리;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AddRecord implements ActionListener {

	JTable table = null;
	JTextField[] text = null;
	
	public AddRecord(JTable table, JTextField[] text) {

		this.table = table;
		this.text = text;
	
	}
	
	public void actionPerformed(ActionEvent e) {
		// 텍스트 필드에 입력한 값 가져와서 테이블에 넣기 //
	
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		 // table 추가는 JTable에 없으므로 getModel을 이용해야하는데 DefaultTableModel가 Model의 자식클래스이므로 다운캐스팅한다.
		
		String strArray[] = new String[4];
		
		for(int i=0;i<text.length;i++) {

			strArray[i] = text[i].getText();
			
		}
		model.addRow(strArray);
		for(int i=0;i<text.length;i++) {

			text[i].setText("");
			
		}
		text[0].requestFocus();
		
	}

}
