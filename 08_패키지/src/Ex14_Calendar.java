import java.util.Calendar;

public class Ex14_Calendar {

	public static void main(String[] args) {

		// Calendar cal = new Calendar(); // protected이기 때문에 생성불가
		// cal.메서드명();
		// Calendar.메서드명();
		
		Calendar cal = Calendar.getInstance();
		System.out.println("cal:" + cal.toString());
		
		// public static final int YEAR = 1
		int x= cal.get(Calendar.YEAR);
		System.out.print("오늘 날짜는 " + x + "년 ");
		System.out.print(cal.get(Calendar.MONTH) + 1 + "월 ");
		System.out.println(cal.get(Calendar.DATE) + "일 ");
		System.out.print("현재 시간은 " + cal.get(Calendar.HOUR) + "시 ");
		System.out.print(cal.get(Calendar.MINUTE) + "분 ");
		System.out.println(cal.get(Calendar.SECOND) + "초 입니다.");
		// 현재 시간은 2시 40분 50초 입니다.
		
		int yoil = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(yoil); // 1(일)2345(목)
	
		String[] week = {" ","일","월","화","수","목","금","토"};
		System.out.println(week[yoil] + "요일");
		System.out.println(week[cal.get(Calendar.DAY_OF_WEEK)] + "요일");
		
	
	}

}

