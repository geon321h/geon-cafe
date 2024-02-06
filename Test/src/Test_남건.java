import java.util.ArrayList;
import java.util.Scanner;

class Person_ng {

	private String name;
	private int age;

	public Person_ng() {

	}
	
	public Person_ng(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public void setAge(int age) {
		
		this.age = age;
		
	}
	
	public String getName() {
		
		return name;
		
	}

	public int getAge() {
		
		return age;
		
	}
	
}

class Student_ng extends Person_ng{
	
	Scanner sc = new Scanner(System.in);
	
	private int java;
	private int jsp;
	
	public Student_ng() {

	}
	
	public Student_ng(String name, int age,int java, int jsp) {
		super(name,age); // 부모 클래스에 있는 name과 age를 접근해서 생성자의 name과 age값을 넣기위한 코드
		this.java = java;
		this.jsp = jsp;
	}
	
	public Student_ng input() { // 정보를 입력받기 위한 메서드
		
		System.out.print("이름입력:");
		setName(sc.next()); // 부모클래스의 setName을 통하여 입력받은 name값을 넣는다 
		System.out.print("나이입력:");
		setAge(sc.nextInt()); // 부모클래스의 setAge을 통하여 입력받은 age값을 넣는다 
		System.out.print("자바입력:");
		java = sc.nextInt();
		System.out.print("jsp입력:");
		jsp = sc.nextInt();
		return new Student_ng(getName(),getAge(),java,jsp); 
		// Student객체를 생성하는 코드를 호출한곳에 반환하여 ArrayList에 넣는다.  
		
	}
	
	public void find(ArrayList<Student_ng>lists, Student_ng s) {
		
		String inputName;
		boolean flag = false; // 입력받은 이름이 있는 상황과 없는 상황을 구분하기 위한 변수
		System.out.print("찾는 이름:");
		inputName = sc.next();
		
		for(int i=0;i<lists.size();i++) {
			s = lists.get(i); // 입력한 이름을 갖고있는 요소 각각의 비교하기 위해 반복문을 통하여 비교하기위해 객체에 넣어둔다.
			if(s.getName().equals(inputName)) { // 요소를 넣어둔 객체의 이름과 입력한 이름이 같으면 실행한다.
				
				System.out.println(lists.get(i)); // 이름이 같은 현재의 요소를 이름제외 3가지를 출력한다.
				flag = true; // 입력받은 이름과 같은 이름이 있기에 아래 if문을 가지않도록 flag값을 true로 설정한다.
				
			}
			
		}
		
		if(flag ==  false) { // 입력받은 이름과 같은 이름이 없을 경우 flag가 true로 바뀌지않아 실행된다.
			
			System.out.println("없음");
			
		}
		
	}
	
	public void listAll(ArrayList<Student_ng>lists,Student_ng s) {
		
		for(int i=0;i<lists.size();i++) { // 전체 리스트를 한번씩 출력하기 위해 리스트사이즈만큼 진행한다.
			s = lists.get(i); // 리스트안에 자바와 jsp의 총합을 요소 하나씩 평균내기위해 객체에 집어넣는다.
			double avg = (s.java+s.jsp)/(double)2; // 객체를 이용하여 평균값을 구해낸다.
			System.out.println(s.getName() + "," + s + " 평균:" + avg); // 오버라이딩하였던 toString을 이름과 평균을 추가하여 출력한다.
		}
		
	}
	
	public String toString() { // 기본 toString을 오버라이딩하여 기본적으로 3가지를 출력하도록 변경한다.
		
		return getAge()+","+java+","+jsp;
		
	}
	
	public boolean continueChoice() { // 게속 진행을 할지 결정하는 메서드
		String answer; // 입력받은 값을 비교하기위해 생성한 문자열

		System.out.println("계속(y|n)?");
		answer = sc.next(); 
		if(answer.equals("y")) { // y를 입력받을시 호출한곳에서 반복문을 게속 진행하도록 false로 반환한다.

			return false; // 리턴값을 보내 호출한곳에서 반복문을 진행되도록한다.

		}else if(answer.equals("n")) {  // n를 입력받을시 호출한곳에서 반복문을 게속 진행하지못하도록 true로 반환한다.

			return true; // 리턴값을 보내 호출한곳에서 반복문을 진행되지못하도록한다.

		}else { // y혹은n 값을 입력하지않았을 경우 재반복하기위해 해당 메세지를 출력하고 재귀호출하여 메서드를 반복한다.
			
			System.out.println("y혹은 n을 입력하세요");
			return continueChoice(); // 올바른 값이 입력되도록 해당 메서드를 재귀호출하여 반복한다. 

		}			
			
	}
	
}

public class Test_남건 {

	public static void main(String[] args) {

		// n 할때까지 
		// ArrayList 사용한결과 
		// list 4개에 평균까지
		// 찾는 이름 : 
		// 있으면 3개 없으면 없음
		// n 할때까지 
		// 프로그램종료

		 
		ArrayList<Student_ng> lists = new ArrayList<>(); 
		// 입력받은 학생 정보를 담아둘 크기가 정해지지않는 ArrayList를 이용하여 반복해서 저장할수 있도록한다.
		Student_ng s = new Student_ng();
		// Student_ng 클래스의 메서드를 사용하고 메서드에서 사용하기 위한 빈 객체를 하나 생성한다.
		
		
		do { // 원하는 만큼 학생정보를 입력받기 위해 무한반복으로 설정하고 진행여부를 정하는 메서드로 값을 받아 종료한다.
			
			lists.add(s.input()); // 학생정보를 입력받아 lists에 넣기위해 input메서드를 호출하고 메서드내에서
			if(s.continueChoice() == true ) { // continueChoice()메서드에서 반복문의 진행여부를 리턴받아 참이면 반복문을 종료한다.
				break; // 반복문에서 빠져나간다.
			}
			
		}while(true);

		System.out.println("ArrayList 사용한결과");
		s.listAll(lists,s); // 전체 리스트를 출력하는 메서드를 호출하여, 리스트와 해당 메서드에서 비교를 위해 사용될 객체를 임시로 보낸다.
		
		do { // 원하는 만큼 학생정보를 검색하기 위해 무한반복으로 설정하고 진행여부를 정하는 메서드로 값을 받아 종료한다.
			
			s.find(lists,s); // 원하는 요소의 name을 찾아 다른 값을 출력하기위한 메서드를 호출하여, 리스트와 해당 메서드에서 값을 저장해둘 객체를 임시로 보낸다.
			if(s.continueChoice() == true ) { // continueChoice()메서드에서 반복문의 진행여부를 리턴받아 참이면 반복문을 종료한다.
				break; // 반복문에서 빠져나간다.
			}
			
		}while(true);
		System.out.println("프로그램을 종료합니다."); // 모든 실행이 종료된후 마지막으로 출력한다.
		
	}

}

// 2:50분 제출 
// youn1223@daum.net
