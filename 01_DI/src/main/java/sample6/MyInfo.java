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
		System.out.println("�̸�: "+per.getName());
		System.out.println("����: "+per.getAge());
		System.out.println("Ű: "+per.getHeight());
		System.out.println("���: "+per.getHobby());
	}
	
	public void studentInfo() {
		System.out.println("kor: "+stu.getKor());
		System.out.println("eng: "+stu.getEng());
		System.out.println("�л� ����\n �̸�:"+stu.getPer().getName()+" ����:"+stu.getPer().getAge()+" Ű:"+stu.getPer().getHeight()+" ���:"+stu.getPer().getHobby());
	}
	
}
