class Car {
	
	String color = "white";
	int door = 4;
	
	void drive() {
		
		System.out.println("drive~");
		
	}
	
	void stop() {
		
		System.out.println("stop!");
		
	}
	
}

class FireEngine extends Car {
	
	int door = 6;
	int wheel = 10;
	
	void drive() { // 오버라이딩
		
		System.out.println("FEdrive~");
		
	}
	
	void water() {
		
		System.out.println("water!!!");
		
	}
	
}

public class Ex10_다형성 {

	public static void main(String[] args) {

		Car c = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		fe.water	();
		
		System.out.println(fe.door);
		System.out.println(fe.color);
		
		c = fe;		
		// c = (car)fe; 자식 -> 부모 업캐스팅		
		System.out.println(c.door);
		System.out.println(c.color);
		// System.out.println(c.wheel); // 에러 : 부모타입에 없고 자식타입에만 있을경우 불가
		
		fe.water();
		fe.drive();
		fe.stop();

		c.drive(); // FE
		// c.water();
		c.stop();
		
		if(c instanceof FireEngine) {

			System.out.println("다운캐스팅 가능");
			fe2 =(FireEngine)c; // 부모 -> 자식 : 다운캐스팅 자동 x
			
		}else {
			
			System.out.println("다운캐스팅 불가능");
			
		}
		
		fe2.water();
		fe2.drive();
		fe2.stop(); 
		
		
	}

}

/*
자식 객체를 부모 타입의 변수에 넣었을 때
부모타입의 변수로 접근가능한 곳
변수: 부모가 물려준 변수에 접근 가능하다.
메서드: 부모가 물려준 메서드나 부모와 자식모두있으면 자식에 있는 메서드에 접근할 수 있다.
*/



