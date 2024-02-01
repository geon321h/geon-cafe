
public class Ex12_StringBuffer {

	public static void main(String[] args) {

		String s1 = "Have ";
		String s2 = "a ";
		String s3 = "nice day";
		String s4 = s1 + s2 +s3;
		
		String s5 = s4.replace("nice","good");
		System.out.println("s5:" + s5);
		System.out.println();
		
		// Object toString() : 참조값(주소값)을 리턴
		// String toString() : 문자열을 리턴
		
		StringBuffer sb = new StringBuffer("Have ");
		sb.append("a ");
		sb.append("nice day");
		
		sb.replace(7, 11, "good");
		System.out.println("sb:" + sb.toString());
		
		sb.insert(7, "nice ");
		System.out.println("sb2:" + sb);
		
		sb.delete(0, 0); // a ~< b
		System.out.println("sb2:" + sb);
		
		sb.reverse();
		System.out.println("sb4" + sb);
		
		String str1 = "hello";
		String str2 = "hello";
		System.out.println(str1.equals(str2));
		
		StringBuffer sb1 = new StringBuffer("Have ");
		StringBuffer sb2 = new StringBuffer("Have ");
		System.out.println(sb1.equals(sb2));
		// Object equals : 주소값 비교
		// StringBuffer equals : 주소값 비교
		String ss1 = sb1.toString();
		String ss2 = sb2.toString();
		System.out.println(ss1.equals(ss2));
		
		
	}

}
