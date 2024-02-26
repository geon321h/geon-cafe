import java.util.ArrayList;
import java.util.Scanner;

public class PersonMain {
	
	PersonDao dao = new PersonDao();
	PersonBean pb = new PersonBean();
	Scanner sc = new Scanner(System.in);
	
	public PersonMain() {
		
		System.out.println("PersonMain 생성자");
		init();
		
	}
	
	private void init()	{
		
		while(true) {
			
			System.out.println("----메뉴 선택하기-----");
			System.out.println("1.전체 정보 조회");
			System.out.println("2.성별로 조회");
			System.out.println("3.정보 수정");
			System.out.println("4.정보 삭제");
			System.out.println("5.정보 추가");
			System.out.println("6.프로그램 종료");
			System.out.print(">> 메뉴 번호 입력: ");
			int menu = sc.nextInt();
			
			switch(menu){
			
				case 1:
					getAllPerson();
					break;
				case 2:
					getPersonByGender();
					break;
				case 3:
					updatePerson();
					break;
				case 4:
					deletePerson();
					break;
				case 5:
					insertPerson();
					break;
				case 6:
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
				default:
					System.out.println("1~6의 번호만 입력가능합니다.");
					break;
					
			}
			
		}
		
	}

	private void getAllPerson() {
		
		ArrayList<PersonBean> lists = dao.getAllPerson();
		for(int i=0;i<lists.size();i++) {
			PersonBean pb = lists.get(i);
			System.out.println(pb.getNum()+"\t"+pb.getName()+"\t"+pb.getAge()
					+"\t"+pb.getGender()+"\t"+pb.getBirth());
		}
		
	}
	
	private void getPersonByGender() {

		System.out.print("찾는 성별 입력: ");
		String genderInput = sc.next();
		ArrayList<PersonBean> lists = dao.getPersonByGender(genderInput);
		
		for(int i=0;i<lists.size();i++) {
			PersonBean pb = lists.get(i);
			System.out.println(pb.getNum()+"\t"+pb.getName()+"\t"+pb.getAge()
					+"\t"+pb.getGender()+"\t"+pb.getBirth());
		}
		
	}
	
	private void insertPerson() {
		
		System.out.println("num은 시퀀스로 자동입력됩니다.");
		System.out.print("이름 입력:");
		String name = sc.next();
		
		System.out.print("나이 입력:");
		int age = sc.nextInt();
		
		System.out.print("성별 입력:");
		String gender = sc.next();
		
		System.out.print("생일 입력:");
		String birth = sc.next();
		
		int result = dao.insertPerson(name,age,gender,birth);
		if(result == 0) {
			System.out.println("추가 실패");
		}else {
			System.out.println("추가 성공");
		}
		
	}
	
	private void deletePerson() {

		System.out.print("삭제할 번호 입력:");
		int num = sc.nextInt();

		int result = dao.deletePerson(num);
		if(result == 0) {
			System.out.println("조건에 맞는 레코드가 없음");
		}else if(result == -1) {
			System.out.println("삭제 실패");
		}else {
			System.out.println("삭제 성공");
		}
		
	}
	
	private void updatePerson() {

		System.out.print("수정할 번호 입력:");
		int num = sc.nextInt();
		System.out.print("이름 입력:");
		String name = sc.next();
		
		System.out.print("나이 입력:");
		int age = sc.nextInt();
		
		System.out.print("성별 입력:");
		String gender = sc.next();
		
		System.out.print("생일 입력:");
		String birth = sc.next();

		int result = dao.updatePerson(num,name,age,gender,birth);
		if(result == 0) {
			System.out.println("조건에 맞는 레코드가 없음");
		}else if(result == -1) {
			System.out.println("수정 실패");
		}else {
			System.out.println("수정 성공");
		}
			
	}

	public static void main(String[] args) {

		PersonMain per = new PersonMain();
		
	}

}
