import java.util.HashSet;

public class Ex08_HashSet {

	public static void main(String[] args) {

		HashSet<Integer> h = new HashSet<Integer>();

		h.add(10);
		h.add(20);
		h.add(30);
		
		System.out.println(h);

		HashSet<Integer> h2 = new HashSet<Integer>();

		
		for(int i=0;i<5;i++) {
			
			int a = (int)(Math.random()*10)+1;
			h2.add(a);
			
		}
		h.clear();
		
		int count = 0;
		do {
			
			count++;
			int a = (int)(Math.random()*10)+1;
			h2.add(a);
			
		}while(h2.size() < 5);
		
		System.out.println(h2.toString());
		
	}

}
