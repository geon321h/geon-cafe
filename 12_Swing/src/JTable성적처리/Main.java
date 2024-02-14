package JTable성적처리;

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
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

class Ex15 extends JFrame implements ActionListener{
	
	FileReader fr = null;
	BufferedReader br = null;

	JTable table = null;
	JScrollPane scrollPane = null;
	JButton btnAdd = null;
	JButton btnRemove = null;
	JButton btnFout = null;
	JButton btnExit = null;
	JLabel lb = null;
	// JTextField 객체 관리자 4개 배열로 생성
	JTextField[] text = new JTextField[4];
	
	Vector<Vector<String>> rowData =null;
	Vector<String> colNames = null;
	String[] caption = {"이름:", "국어:", "영어:", "수학:"};
	int readCount = 1;
	
	public Ex15() {
		
		
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		
		getFile();
		compose();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

	private void compose() {
		
		setTitle("성적처리 프로그램");
		setSize(700,300);

		Container contentPane = getContentPane();
		table = new JTable(rowData,colNames);
		scrollPane = new JScrollPane(table);
		contentPane.setLayout(null); // 배치관리자를 사용하지않음
		contentPane.add(scrollPane);
		scrollPane.setBounds(250,30,400,200);
		
		for(int i=0;i<caption.length;i++) {
			
			lb = new JLabel();
			lb.setText(caption[i]);
			contentPane.add(lb);
			lb.setBounds(10, (i+1)*30, 50, 20);
			
			text[i] = new JTextField();
			text[i].setBounds(80, (i+1)*30, 90, 20);
			contentPane.add(text[i]);
			
		}
		
		btnAdd = new JButton("추가");
		btnRemove = new JButton("삭제");
		btnFout = new JButton("출력");
		btnExit = new JButton("종료");
		
		contentPane.add(btnAdd);
		contentPane.add(btnRemove);
		contentPane.add(btnFout);
		contentPane.add(btnExit);
		
		btnAdd.setBounds(10, 160, 100, 20);
		btnRemove.setBounds(120, 160, 100, 20);
		btnFout.setBounds(10, 190, 100, 20);
		btnExit.setBounds(120, 190, 100, 20);
		
		btnAdd.addActionListener(new AddRecord(table,text));
		btnRemove.addActionListener(new RemoveRecord(table));
		btnFout.addActionListener(new FilePrint(table));
		btnExit.addActionListener(this);
		
		setVisible(true);
		
	}
	
	private void getFile() {

		try {
			
			fr = new FileReader("c:\\sun\\table2.txt");
			br = new BufferedReader(fr);
			
			String read;
			while((read = br.readLine()) != null) {
				
				tableMake(read);
				
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


	private void tableMake(String read) {

		String[] item = read.split("/");
		
		if(readCount++ == 1) {

			for(String str : item) {
				
				colNames.add(str);
				
			}
			
		}else {
			
			Vector<String> one = new Vector<>();
			
			for(String str : item) {
				
				one.add(str);
				
			}
			
			rowData.add(one);
			
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		System.exit(0);
		
	}
	
} // Ex 15

public class Main extends JFrame {
	public static void main(String[] args) {

		new Ex15();
		
		
		
	}

}
