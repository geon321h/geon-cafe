import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

class Person implements Serializable {
	
	String name = "정국";
	int age = 40;
	
}

public class Ex11_Serializable {

	public static void main(String[] args) {

		Person p = new Person();
		
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		
		try {
			
			fos = new FileOutputStream("object.txt"); // FNE
			oos = new ObjectOutputStream(fos); // IOE
			
			oos.writeObject(p);
			oos.writeObject(new Date());
			
			fis = new FileInputStream("object.txt");
			ois = new ObjectInputStream(fis);
			
			Person obj  = (Person)ois.readObject();
			System.out.println(obj.name + "," + obj.age);
			
			Date d = (Date)ois.readObject();
			System.out.print(d);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				
				oos.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
		
	}

}
