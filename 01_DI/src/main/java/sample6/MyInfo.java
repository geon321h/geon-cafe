package sample6;

public class MyInfo {

	private Person per;
	private Student stu;
	
	public Person getPer() {
		return per;
	}
	public void setPer(Person per) {
		this.per = per;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	
	public void personPrint() {
		System.out.println("이름: "+per.getName());
		System.out.println("나이: "+per.getAge());
		System.out.println("키: "+per.getHeight());
		System.out.println("취미: "+per.getHobby());
	}
	
	public void studentInfo() {
		System.out.println("kor: "+stu.getKor());
		System.out.println("eng: "+stu.getEng());
		System.out.println("학생 정보\n 이름:"+stu.getPer().getName()+" 나이:"+stu.getPer().getAge()+" 키:"+stu.getPer().getHeight()+" 취미:"+stu.getPer().getHobby());
	}
	
}
