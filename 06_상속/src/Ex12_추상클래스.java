abstract class Shape { // 추상 클래스 
	
	Shape(){
		
		System.out.println("Shape 생성자");
		
	}
	
	public void make() { // {} 메서드 정의
		
		System.out.println("도형 그리기");
		
	}
	
	public abstract void draw(); // 미완성 메서드 정의
		
	public abstract void delete();
	
}

class Circle extends Shape {
	
	Circle() {

		System.out.println("Circle 생성자");
		
	}
	
	public void draw() {
		
		System.out.println("원을 그린다.");
		
	}
	
	public void delete() {
		
		System.out.println("원을 지운다.");
		
	}
	
}

class Triangle extends Shape {
	
	Triangle() {

		System.out.println("Triangle 생성자");
		
	}
	
	public void draw() {
		
		System.out.println("삼각형을 그린다.");
		
	}
	
	public void delete() {
		
		System.out.println("삼각형을 지운다.");
		
	}
	
}


public class Ex12_추상클래스 {

	public static void main(String[] args) {

		// Shape s = new Shape(); // 미완성 메서드가 있으면 객체를 만들수 없다.
		// s.make(); // () 호출은 {} 없이
		
		Circle c = new Circle();
		c.draw();
		c.delete();
		System.out.println();
		
		Triangle t = new Triangle();
		t.draw();
		t.delete();
		System.out.println("---------------------------");
		
		Shape[] s = new Shape[2];
		s[0] = new Circle();
		s[1] = new Triangle();
		
		for(Shape a : s) {
			
			a.draw();
			a.delete();
			System.out.println();
			
		}
		
	}

}









