import java.util.ArrayList;
import java.util.InputMismatchException;
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
			System.out.println("3.정보 추가");
			System.out.println("4.정보 수정");
			System.out.println("5.정보 삭제");
			System.out.println("6.프로그램 종료");
			System.out.print(">>메뉴 번호 입력 : ");
			int menu = 0;
			try {			
				menu = sc.nextInt();
			} catch (InputMismatchException e) {
				sc.nextLine();
			}
			switch (menu) {
			case 1:
				lists = bDao.getAllBooks();
				showBooks(lists);
				break;
			case 2:
				getBookByChoice();
				break;
			case 3:
				insertBook();
				break;
			case 4:
				updateBook();
				break;
			case 5:
				deleteBook();
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

	private void deleteBook() {
		int no =0;
		
		while(true) {
			try {			
				System.out.print("삭제할 책 번호를 입력하세요:");
				no = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("번호는 숫자로 입력하세요");
				sc.nextLine();
			}
		}
		
		int result = bDao.deleteBook(no);
		if(result == 0) {
			System.out.println("일치하는 번호가 없습니다.");
		}else if(result == -1){
			System.out.println("삭제 실패");
		}else {
			System.out.println("삭제 성공");
		}
		
	}

	private void updateBook() {
		int no =0;
		int price = 0;
		
		while(true) {
			try {			
				System.out.print("수정할 책 번호를 입력하세요:");
				no = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("번호는 숫자로 입력하세요");
				sc.nextLine();
			}
		}
		
		System.out.print("책제목:");
		sc.nextLine();
		String title = sc.nextLine();

		System.out.print("저자명:");
		String author = sc.next();
		
		System.out.print("출판사:");
		sc.nextLine();
		String publisher = sc.nextLine();
		
		while(true) {
			try {			
				System.out.print("가격:");
				price = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("가격은 숫자로 입력하세요");
				sc.nextLine();
			}
		}
		
		System.out.print("출간일:");
		String day = sc.next();
		
		bDto = new BookDto();
		bDto.setNo(no);
		bDto.setTitle(title);
		bDto.setAuthor(author);
		bDto.setPublisher(publisher);
		bDto.setPrice(price);
		bDto.setDay(day);
		
		int result = bDao.updateBook(bDto);
		if(result == 0) {
			System.out.println("일치하는 번호가 없습니다.");
		}else if(result == -1){
			System.out.println("수정 실패");
		}else {
			System.out.println("수정 성공");
		}
	}

	private void insertBook() {
		System.out.println("번호는 자동생성됩니다.");
		System.out.print("책제목:");
		sc.nextLine();
		String title = sc.nextLine();
		// br.readLine()을 이용해서 문자열을 받아도된다.

		System.out.print("저자명:");
		String author = sc.next();
		
		System.out.print("출판사:");
		sc.nextLine();
		String publisher = sc.nextLine();
		
		int price = 0;
		while(true) {
			try {			
				System.out.print("가격:");
				price = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("가격은 숫자로 입력하세요");
				sc.nextLine();
			}
		}
		
		System.out.print("출간일:");
		String day = sc.next();
		
		bDto = new BookDto();
		bDto.setTitle(title);
		bDto.setAuthor(author);
		bDto.setPublisher(publisher);
		bDto.setPrice(price);
		bDto.setDay(day);
		
		int result = bDao.insertBook(bDto);
		if(result == 0) {
			System.out.println("입력 실패");
		}else{
			System.out.println("입력 성공");
		}
		
	}

	private void getBookByChoice() {

		String column = null;
		
		System.out.print("제목:1 \t저자:2 \t출판사:3 \t번호입력>>");
		int Choice = 0;
			try {			
				Choice = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("1~3까지의 번호를 입력해주세요.");
				sc.nextLine();
				return;
			}
		
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
		sc.nextLine();
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
