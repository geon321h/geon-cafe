package JTable성적처리;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTable;

public class FilePrint implements ActionListener {

	JTable table = null;
	FileWriter fw = null;
	BufferedWriter bw = null;
	
	public FilePrint(JTable table) {

		this.table = table;
	
	}
	
	public void actionPerformed(ActionEvent e) {
		// 파일에 출력하기 //
		
		try {
		
			fw = new FileWriter("c:\\sun\\table2.txt");
			bw = new BufferedWriter(fw);
			
			int rowCount = table.getRowCount();
			int colCount = table.getColumnCount();
			
			for(int i=0;i<colCount;i++) {
				
				String colName = table.getColumnName(i);
				System.out.print(colName + "\t");
				
				if(i==0) {

					bw.write(colName);
					
				}else {
					
					bw.write("/" + colName);

				}
				
			}
			bw.newLine();
			System.out.println();
			
			for(int i=0;i<rowCount;i++) {
				
				for(int j=0;j<colCount;j++) {

					Object obj = table.getValueAt(i, j);
					System.out.print(obj + "\t");
					
					if(j==0) {
						
						bw.write((String)obj);
						
					}else {
						
						bw.write("/" + obj);
						
					}

				}
				bw.newLine();
				System.out.println();
			}

		} catch (IOException e1) {

			e1.printStackTrace();
		
		}finally {
			
			try {
				
				bw.close();
				
			} catch (IOException e1) {

				e1.printStackTrace();
				
			}
			
		}
		
	}

}
