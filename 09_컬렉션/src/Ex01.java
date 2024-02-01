class Top {
	
	private String data;
	
	public void setData(String data) {
		
		this.data = data;
		
	}
	
	public String getData() {
		
		return data;
		
	}
	
}

class Top2 {
	
	private Integer data;
	
	public void setData(Integer data) {
		
		this.data = data;
		
	}
	
	public Integer getData() {
		
		return data;
		
	}
	
}



public class Ex01 {

	public static void main(String[] args) {

		Top t = new Top();
		Top2 t2 = new Top2();

		String str = "hello";
		t.setData(str);
		
		String str2 = t.getData();
		System.out.println(t.getData());
		System.out.println(str2);
		
		t2.setData(10);
		System.out.println(t2.getData());
		
		Integer i2 = t2.getData();
		System.out.println(i2);
		
		
	}

}
