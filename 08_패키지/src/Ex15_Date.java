import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex15_Date {

	public static void main(String[] args) {

		Date now = new Date();
		
		System.out.println("now:" + now.toString());
		System.out.println(now.getYear() + 1900); // 1900년도부터 시작
		System.out.println(now.getMonth() + 1);
		System.out.println(now.getDate());
		System.out.println(now.getDay()); // 0(일)12345(금)6요일
		System.out.println(now.getHours());
		
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("yyyy-MM-E일");
		System.out.println(sdf.format(now));
		
		SimpleDateFormat sdf2;
		sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일 hh:mm:ss a");
		System.out.println(sdf2.format(now));
		
	}

}
