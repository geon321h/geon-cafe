interface Camera {
	
	void takePhoto();
	
}

interface MP3 {
	
	void playMp3();
	
}

interface DMB {
	
	void viewTv();
	
}

class Shape2 {
	
	private int size;
	private String color;
	
	Shape2(int size, String color) {

		this.size = size;
		this.color = color;
		
	}
	
	void setSize(int size) {
		
		this.size = size;
		
	}
	
	public int getSize() {
		
		return size;
		
	}
	
	void setColor(String color) {
		
		this.color = color;
		
	}
	
	public String getColor() {
		
		return color;
		
	}
	
}

class Phone extends Shape2 implements Camera,DMB,MP3 { // 클래스 먼저 상속 후 인터페이스 상속
	
	Phone(int size, String color) {

		super(size, color);
		
	}

	public void playMp3() {
		
		System.out.println("음악 감상");
		
	}

	public void viewTv() {
		
		System.out.println("TV 시청");
		
	}

	public void takePhoto() {
		
		System.out.println("사진 찍기");
		
	}
	
	
	
}

public class Ex15_인터페이스 {

	public static void main(String[] args) {

		Phone p = new Phone(7, "blue");
		
		p.playMp3();
		p.viewTv();
		p.takePhoto();
		
	}

}
