interface RemoteControl { // interface 안에 모든 변수, 메서드는 public이다.
	
	void turnOn();
	void turnOff();

}

public class Ex13_익명클래스 {

	public static void main(String[] args) {

		RemoteControl rc = new RemoteControl() {
			
			public void turnOn() {
				
				System.out.println("TV를 켠다.");
				
			}
			
			public void turnOff() {
				
				System.out.println("TV를 끈다.");

			}

		};
		
		rc.turnOn();
		rc.turnOff();
		
	}

}

// interface 
// 모든 메서드가 추상 메서드다.
// 변수는 public final 변수다.
// 다중 상속이 가능하다.
// implements로 상속한다.

// public, protected, x, private