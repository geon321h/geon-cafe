
public class QuizBank {

	final int WATING = 0;
	final int PROBLEM = 1;
	final int ANSWER = 2;
	int state = WATING;
	int currentProblem = 0;
	
	String[] problems = {"네트워크 처리 패키지는?",
									"서버쪽 소켓 클래스는?", 
									"인터넷에서 컴퓨터를 식별하는 주소는?"
								   };
	
	String[] answers = {"java.net",
								  "ServerSocket",
								  "IP주소"
								 };
	
	public String process(String input) {
		
		String output = null;
		
		if(state == WATING) {
			
			output = "퀴즈를 시작합니다.(y/n)";
			state = PROBLEM;
			
		}else if(state == PROBLEM) {
			
			if(input.equals("y")) {
				
				output = problems[currentProblem];
				state = ANSWER;
				
			}else {
				
				state = WATING;
				output = "quit";
				
			}
			
		}else if(state == ANSWER) {
			
			if(input.equals(answers[currentProblem])) {
				
				output = "정답입니다. 계속하시겠습니까? (y/n)";
				state = PROBLEM;
				
			}else {
				
				output = "오답입니다. 계속하시겠습니까? (y/n)";
				state = PROBLEM;
				
			}
			
			currentProblem = (currentProblem + 1) % problems.length;
			
		}
	
		return output;
		
	}
	
}
