import java.util.ArrayList;
import java.util.Scanner;

public class BookMain {

	Scanner sc = new Scanner(System.in);
	BookDao bDao = new BookDao();
	BookDto bDto = null;
	ArrayList<BookDto> lists = null;
	
	public BookMain() {

		init();
		
	}
	
	private void init() {

		while(true) {			
			System.out.println("=====메뉴 선택하기=====");
			System.out.println("1.전체 정보 조회");
			System.out.println("2.조건 조회");
			System.out.println("3.정보 수정");
			System.out.println("4.정보 삭제");
			System.out.println("5.정보 추가");
			System.out.println("6.프로그램 종료");
			System.out.print(">>메뉴 번호 입력 : ");
			int menu = sc.nextInt();
			
			switch (menu) {
			case 1:
				lists = bDao.getAllBooks();
				showBooks(lists);
				break;
			case 2:
				getBookByChoice();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("1~6까지의 번호를 입력해주세요.");
			}
		}
		
	}

	private void getBookByChoice() {

		String column = null;
		
		System.out.print("제목:1 \t저자:2 \t출판사:3 \t번호입력>>");
		int Choice = sc.nextInt();
		sc.nextLine();
		
		switch (Choice) {
		case 1:
			System.out.print("조회할 제목 : ");
			column = "title";
			break;
		case 2:
			System.out.print("조회할 저자 : ");
			column = "author";
			break;
		case 3:
			System.out.print("조회할 출판사 : ");
			column = "publisher";
			break;
		default:
			System.out.println("1~3까지의 번호를 입력해주세요.");
			return; // 아래 메서드가 사용되지 않도록 다시 메뉴로 돌아가게 한다.
		}
		String input = '%'+sc.nextLine()+'%';
		lists = bDao.getBookByChoice(input,column);
		if (lists.size() == 0) {
			System.out.println("해당 검색어는 존재하지 않습니다.");
		}else {
			System.out.println("검색된 항목은 : "+lists.size()+" 권 입니다.");
			showBooks(lists);
		}
		
	}

	private void showBooks(ArrayList<BookDto> lists) {

		System.out.println("번호\t"+"책제목\t"+"저자\t"+"출판사\t"+"가격\t"+"출간일");
		for(BookDto bd : lists) {
			System.out.println(bd.getNo()+"\t"+bd.getTitle()+"\t"+bd.getAuthor()+"\t"+bd.getPublisher()+"\t"+bd.getPrice()+"\t"+bd.getDay());
		}
		
	}

	public static void main(String[] args) {
		
		BookMain bm = new BookMain();
		
	}

}
