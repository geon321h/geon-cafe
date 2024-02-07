import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex09_InputStreamReader {

	public static void main(String[] args) {

		// 키보드로 입력받지만 문자스트림으로 바꾸기
		
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = null;
		BufferedReader br = null;
		String fileName, input, read;
		
		try {
			
			// 파일명 입력 //
			
			System.out.print("파일명을 입력하세요=>");
			fileName = kb.readLine();
			FileWriter fw = new FileWriter(fileName); // 파일 생성
			bw = new BufferedWriter(fw);
			
			// 파일 내용 입력 //
			// 파일명을 키보드로 입력 : 키보드와 스트림 형성
			// 그 파일에 글자 쓰기 : 파일과 출력스트림 형성
			//입력한 문장을 파일에 반복해서 출력하기 (exit 입력시 종료 or ctrl+z 반복 종료)
			
			System.out.println("파일에 저장할 내용을 입력하세요.");
			
			while((input = kb.readLine()) != null) {
				
				if(input.equals("exit")) { // 대신 ctrl+z하면 입력 종료
					break;
				}
				bw.write(input);
				bw.newLine();
				
			}
			bw.flush();
			
			// 파일 내용 출력 //
			// 파일에서 문장 한줄씩 읽어와서 : 파일과 입력스트림 형성
			// 콘솔에 출력
			

			br = new BufferedReader(new FileReader(fileName));
			
			while((read = br.readLine()) != null){ // 문자열 한줄씩 읽기 때문에 개행후 빈문장이 나오면 종료
				
				System.out.print(read);
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
			try {
				
				kb.close();
				bw.close();
				br.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

}
