class Robot {
	
}

class SingRobot extends Robot {
	
	void sing() {
		System.out.println("노래를 부릅니다.");
	}
	
}

class DanceRobot extends Robot {
	
	void dance() {
		System.out.println("춤을 춥니다.");
	}
	
}

class DrowRobot extends Robot {
	
	void draw() {
		System.out.println("그림을 그립니다.");
	}
	
}

public class Ex11_다형성 {

	public static void main(String[] args) {

		// DanceRobot r1 = new DanceRobot();
		// Robot r2 = new SingRobot();
		// Robot r3 = new DrowRobot();
		
		Robot[] r = new Robot[3];
		r[0] = new DanceRobot();
		r[1] = new SingRobot();
		r[2] = new DrowRobot();
		
		action(r[0]);
		action(r[1]);
		action(r[2]);
		
		for(Robot a : r ) {
			action(a);
		}
		
	}

	public static void action(Robot r) {
		
		// r.dance(); // 오류 : 부모에게 메서드가 없기때문에 자식의 메서드를 호출할 수 없다.
		
		if(r instanceof DanceRobot) {
			
			DanceRobot r1 = (DanceRobot)r;
			r1.dance();
			
		}else if(r instanceof SingRobot) {
			
			SingRobot r1 = (SingRobot)r;
			r1.sing();
			
		}else if(r instanceof DrowRobot) {
			
			DrowRobot r1 = (DrowRobot)r;
			r1.draw();
			
		}
		
	}
	
}






