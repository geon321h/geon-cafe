import java.util.Enumeration;
import java.util.Vector;

public class Ex06_Vector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vector<String> v = new Vector<String>();
		v.add("봄");
		v.add(new String("여름"));
		v.add(new String("봄"));
		v.add(new String("겨울"));
		
		System.out.println("v:" + v);
		System.out.println(v.get(0));
		
		for(String s : v) {
			
			System.out.println(s);
			
		}
		
		// Iterator : 양쪽 모두가능
		
		// Enumeration : Vector에서만 가능
		
		System.out.println();
		
		// v:[봄, 여름, 봄, 겨울]
		
		Enumeration<String> en = v.elements();
		
		while(en.hasMoreElements()) {
			
			String s = en.nextElement();
			System.out.println(s);
			
		}
		
		
	}

}
