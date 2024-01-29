abstract class Empl {
	
	private String empno;
	private String name;
	private int pay;
	protected double result;
	
	public abstract double getMonthPay();
	
	Empl(String empno, String name, int pay){
		
		this.empno = empno;
		this.name = name;
		this.pay = pay;
		
	}
	
	void display() {
		
		System.out.print(empno +"번 " + name + "의 월급: " );
		
	}
	
}

class FullTime extends Empl { // 정규직
	
	private int bonus;
	
	FullTime(String empno, String name, int pay, int bonus) {

		super(empno, name, pay);
		this.bonus = bonus;
		
		result = (pay/(double)12) + (bonus/(double)12);
		
	}
	
	public double getMonthPay() {

		return result;
	
	}	
	
}

class Contract extends Empl { // 계약직
	
	private int hireYear;
	
	Contract(String empno, String name, int pay, int hireYear) {
	
		super(empno, name, pay);
		this.hireYear = hireYear;
		
		result =pay/(double)12*hireYear;
		
	}
	
	public double getMonthPay() {

		return result;
		
	}
	
}

class PartTime extends Empl { // 일용직
	
	private int workDay;
	
	PartTime(String empno, String name, int pay, int workDay) {

		super(empno, name, pay);
		this.workDay = workDay;
	
		result = pay*workDay;
		
	}
	
	public double getMonthPay() {

		return  result;
		
	}
	
}

public class Ex13_남건 {

	public static void main(String[] args) {

		FullTime f = new FullTime("fo1","이효리",300,70);
		Contract c = new Contract("co1","수현",200,3);
		PartTime p = new PartTime("po1","아이유",500,20);
		
		System.out.println("- 클래스별 객체만들기 -");
		f.display();
		System.out.println(f.getMonthPay());
		c.display();
		System.out.println(c.getMonthPay());
		p.display();
		System.out.println(p.getMonthPay());
		
		System.out.println("-------------------------");
		
		// 배열로 생성하여 출력하기 //
		
		Empl[] e = new Empl[3];
		System.out.println("- 배열로 객체만들기 -");
		e[0] = new FullTime("fo1","이효리",300,70);
		e[1] = new Contract("co1","수현",200,3);
		e[2] = new PartTime("po1","아이유",500,20);
		
		for(Empl a : e) {
			a.display();
			System.out.println(a.getMonthPay());
		}
		
	}

}
