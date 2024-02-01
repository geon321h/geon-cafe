class Top3<T> {
	
	private T data;
	
	public void setData(T data) {
		
		this.data = data;
		
	}
	
	public T getData() {
		
		return data;
		
	}
	
} 

public class Ex02_Generic {
	
	public static void  main(String[] args) {

		Top3<String> t = new Top3<String>();
		String str = "hello";

		t.setData(str);
		String str2 = t.getData();
		System.out.println(t.getData());
		
		Top3<Integer> t2 = new Top3<Integer>();
		t2.setData(10);
		System.out.println(t2.getData());
		
		Integer i2 = t2.getData();
		System.out.println(i2);
	
		Top3<Double> t3 = new Top3<Double>();
	
	}

}
