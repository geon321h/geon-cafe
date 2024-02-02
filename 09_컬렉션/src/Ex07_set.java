import java.util.HashSet;
import java.util.Set;

public class Ex07_set {

	public static void main(String[] args) {

		//Set<E> s = new Set<E>() {};
		HashSet<String> s = new HashSet<String>();
		
		System.out.println(s.size());
		s.add("orange");
		s.add("apple");
		s.add("orange");
		s.add("banana");
		System.out.println(s.size());
		System.out.println("s:" + s.toString());

		boolean result = s.contains("apple");
		System.out.println("result:" + result);
		
		s.remove("apple");
		System.out.println("s:" + s);
		
		s.clear();
		System.out.println("s:" + s);
		boolean result2 = s.isEmpty();
		System.out.println("result2:" + result2);
		
		
	}

}
