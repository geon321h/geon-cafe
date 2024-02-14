package JTable성적처리;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RemoveRecord implements ActionListener {

	JTable table;
	
	public RemoveRecord(JTable table) {

		this.table = table;
	
	}
	
	public void actionPerformed(ActionEvent e) {
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		int index = table.getSelectedRow();
		
		if(index == -1) {
			
			return;
			
		}else {
			
			model.removeRow(index);
			
		}
		
	}

}
