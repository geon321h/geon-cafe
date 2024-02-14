import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class Ex14 extends JFrame{
	
	Vector<String> colNames = null;
	Vector<Vector<String>> rowData =null;
	int cnt = 1;
	JButton btn = new JButton("출력");
	JPanel p1 = new JPanel();

	public Ex14() {

		setSize(500,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		colNames = new Vector<>();
		rowData = new Vector<>();
		
		getFile();
		compose();
		
	
	}

	private void compose() {

		Container contentPane = getContentPane();
		JTable table = new JTable(rowData,colNames);
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane);
		btn.addActionListener(new TablePrint(table));
		contentPane.add(btn,BorderLayout.SOUTH);
		
		setVisible(true);
		
	}

	
	private void getFile() {

		FileReader fr;
		BufferedReader br = null;
		try {
		
			fr = new FileReader("c:\\sun\\table.txt");
			br = new BufferedReader(fr);
			String str;
			while((str =br.readLine())!= null) {
				
				System.out.println(str);
				tableMake(str);
				
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		
		} catch (IOException e) {

			e.printStackTrace();
			
		}finally {
			
			try {
				
				br.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	private void tableMake(String str) {

		String[] item = str.split("/");
		
		if(cnt++ == 1) {
			
			for(String a : item) {
				
				colNames.add(a);
				
			}

		}else {
			
			Vector<String> one = new Vector<>();
			
			for(String a : item) {
				
				one.add(a);
				
			}
			
			rowData.add(one);
			
		}
		
		return;
		
	}
	
} // Ex14

class TablePrint implements ActionListener {

	JTable table;
	
	public TablePrint(JTable table) {
		
		this.table = table;
	
	}
	
	public void actionPerformed(ActionEvent e) {
		// System.out.println("버튼눌림");
		
		int rowCount = table.getRowCount();
		int colCount = table.getColumnCount();
		
		for(int i=0;i<colCount;i++) {
			
			String colName = table.getColumnName(i);
			System.out.print(colName + "\t");
			
		}
		System.out.println();
		
		
		for(int i=0;i<rowCount;i++) {
			
			for(int j=0;j<colCount;j++) {
				
				Object obj = table.getValueAt(i, j);
				System.out.print(obj + "\t");

			}
			System.out.println();
		}
		
	}
	
}

public class Ex14_JTable {

	public static void main(String[] args) {

		new Ex14();
		
	}

}
