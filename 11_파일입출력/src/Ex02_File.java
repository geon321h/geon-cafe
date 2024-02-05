import java.io.File;

public class Ex02_File {

	public static void main(String[] args) {

		// File f1 = new File("c:\\sun\\abc.txt");
		// File f1 = new File("c:\\sun\\","abc.txt");
		File dir = new File("c:"+File.separator+"sun");
		File f1 = new File(dir,"abc.txt");
		
		
		System.out.println("f1:" + f1);
		System.out.println(f1.length()); // enter는 맨앞으로 이동후 한칸아래 이동 2가지 기능을 하여 길이가 2
		
		
		
	}

}
