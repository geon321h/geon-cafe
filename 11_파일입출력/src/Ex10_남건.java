import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex10_남건 {

	public static void main(String[] args) {

		BufferedReader isbr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = null;
		BufferedReader br = null;
		
		String input, searchInput; // 단어와 뜻을 입력받을 변수, 검색할 단어를 담아둘 변수
		int num; // 메뉴 선택을 위한 입력받을 변수
		boolean flag; // 검색한 단어의 유무를 나타낼 변수
		
		try {
			
			FileWriter fw = new FileWriter("voca.txt"); // 사용할 파일을 담아둠
			bw = new BufferedWriter(fw); // 단어를 적기위해 생성
			
			do {

				System.out.print("1.단어입력 2.단어검색 3.종료"); // 입력을 받아 숫자로 변경하고 메뉴에 따른 실행
				num = Integer.parseInt(isbr.readLine());

				switch (num) {
					
					case 1: // 단어와 뜻을 입력하여 voca.txt에 한줄씩 저장
						System.out.print("단어/뜻 입력>>");
						input = isbr.readLine();
						bw.write(input); 
						bw.newLine();
						bw.flush();
						break;
						
					case 2: // 검색할 단어의 유무를 찾고 단어와 뜻 출력
						System.out.print("검색단어 입력 >>");
						searchInput = isbr.readLine();
						br = new BufferedReader(new FileReader("voca.txt")); // 단어를 검색하기 위해 읽기위한 스트림생성
						
						flag = false; // 초기화
						
						while((input = br.readLine()) != null) { // voca.txt에 저장된 단어/뜻 세트를 한문장씩 가져온다

							String[] word = input.split("/"); // 가져온 단어와 뜻을 쪼개서 [단어0] [뜻1]으로 만든다.
							
							if (word[0].equals(searchInput) == true) { // 단어가 검색한 단어와 같은지 검사하고 같으면 출력

								System.out.println("단어>" + word[0]);
								System.out.println("뜻>" + word[1]);
								flag = true; // 검색된 단어가 있다.
							
							}
							
						}
						
						if(flag == false) { // 검색된 단어가 없으면 출력
							
							System.out.println("찾는 단어 없음");
							
						}
						
						break;
						
					case 3: // 반복하지않고 시스템 종료
						System.out.println("프로그램을 종료합니다.");
						System.exit(0);
						break;
						
					default: System.out.println("1~3까지 번호를 선택해 주세요.");
					
				}
				
			}while(true);
			
		} catch (IOException e) {

			e.printStackTrace();
		
		}finally {
			
			try {
				
				isbr.close();
				bw.close();
				br.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}

// voca.txt
// 1. 단어입력 2.단어검색 3.종료 >> 
// 1. 단어입력 //
// 단어/뜻 입력 >>  apple/사과
// 검색 단어 입력 >> apple
// 단어 >> apple
// 단어의 뜻 >> 사과
// 2.단어검색 //
// 키보드로 한글입력하기 위해 Stream형성
// voca.txt 에 쓰기 , 읽기 Stream 형성
// 한줄 읽고 /기준으로 구분하여 (split) [단어0] [뜻1]
// [0]번방과 입력한 단어 비교하여 같으면 [1]번방 뜻 출력 같지않으면 찾는단어없음
// 프로그램을 종료합니다.