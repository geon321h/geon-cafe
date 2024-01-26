class MyFather {  
	
	public String name;   
	private String nickname; 
	
	public MyFather(){   
		name = "아버지";   
		nickname = "대장";  
	}  
	
	public String getNickName(){   
		return nickname;  
	} 
	
} 
class MySon extends MyFather {   

	/*
	 	MySon(){
	 	 super(); 
	 	}
	 	가 생략되어 있지만 객체를 생성할때 자동으로 실행되므로 아버지와 대장이 담긴다.
	*/	
	public void sayFatherNames() {   
		
		System.out.println(name);   
		System.out.println(getNickName()); 
		
	}

}
public class Ex08{
	public static void main(String[] args) {   
		
		MySon m = new MySon();   
		m.sayFatherNames();  
	} 
}
