import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Ex13_남건 {

	public static void main(String[] args) {

		// lyrics.txt
		// 읽기위한 스트림 형성
		// 파일의 끝까지 한줄(String line)씩 읽기
		// [] = lin.splits(" ")
		// 특수문자 제거후 다시 넣기
		// let it be
		// HashMap<String,Integer> hm = new Hash<>(); 로 개수 넣기
		// HashMap출력
		
		BufferedReader br = null;
		String read; // 읽은 한 문장을 담아둘 문자열
		int index; // 쉼표를 제거할때 쉼표의 위치를 담아두는 변수
		String[] word; // 쪼갠 단어를 넣어두는 배열
		Map<String,Integer> hm = new HashMap<>(); // 단어 별로 개수를 저장할 Map을 생성한다.
		
		try {
			
			// 문장을 ,기준으로 잘라서 Map에 넣기 //
			
			br = new BufferedReader(new FileReader("lyrics.txt")); // "lyrics.txt"를 읽기위한 스트림생성
			
			while((read = br.readLine()) != null){ // lyrics.txt를 한문장씩 문장이 끝날때까지 읽는다
				
				word = read.split(" "); // 문장에서 " "을 기준으로 단어들만 나누어 배열에 넣는다
				for(String a : word) { // 생긴 배열의 개수만큼 반복하여 Map으로 단어별로 개수를 저장한다

					if((index = a.indexOf(",")) != -1) { // 문자에 있는 ,를 모두 제거하고 없는 문자를 다시 넣는다.
						a = a.substring(0,index); // 쉼표가 나오기 전까지의 문자가 담는다.
					}
					
					if(hm.containsKey(a) == true) { // Map에 이미 있는 단어는 기존 개수에서 1증가하여 재입력
						
						hm.put(a, (hm.get(a)+1));
						
					}else { // 단어를 처음 넣을때 개수를 1로 초기화하여 입력
						
						hm.put(a,1);
						
					}
					
				}
				
			}
			
			// Map에 들어간 단어와 개수를 출력 //
			
			for(String b : hm.keySet()) {
				
				System.out.println(b + ":" + hm.get(b));
				
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {

			e.printStackTrace();
		
		}finally {
			
			try {
				
				br.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
		}

		
		
	}

}
