import java.util.ArrayList;
import java.util.Scanner;

public class ProductsMain {

	ProductsDao pDao = new ProductsDao();
	ProductsDto pDto = null;
	Scanner sc = new Scanner(System.in);
	ArrayList<ProductsDto> lists =null;
	public ProductsMain() {

		init();
		
	}
	
	private void init() {

		while(true) {
			
			System.out.println("===메뉴 선택하기===");
			System.out.println("1.모든 상품 조회");
			System.out.println("2.아이디 조건 조회");
			System.out.println("3.아이디 조건 조회2");
			System.out.println("4.카테고리 조건 조회");
			System.out.println("5.상품 추가");
			System.out.println("6.상품 수정");
			System.out.println("7.상품 삭제");
			System.out.println("8.프로그램 종료");
			System.out.print("번호 입력>>");
			int menu = sc.nextInt();
			
			switch(menu){
				case 1:
					lists = pDao.getAllProducts();
					showProducts(lists);
					break;
				case 2:
					getProductsById();
					break;
				case 3:
					getProductsById2();
					break;
				case 4:
					getProductsByCategory();
					break;
				case 5:
					insertProduct();
					break;
				case 6:
					updateProduct();
					break;
				case 7:
					deleteProduct();
					break;
				case 8:
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
				default:
					System.out.println("1~7의 번호만 입력가능합니다.");
				break;
			}
			
		}
		
	}

	private void deleteProduct() {

		System.out.print("삭제할 아이디를 선택해주세요:");
		int id = sc.nextInt();
		
		int result = pDao.deleteProduct(id);
		if(result == 0) {
			System.out.println("일치하는 아이디가 없습니다.");
		}else if(result == -1){
			System.out.println("삭제 실패");
		}else{
			System.out.println("삭제 성공");
		}

	}

	private void updateProduct() {

		System.out.print("수정할 아이디를 선택해주세요:");
		int id = sc.nextInt();

		System.out.print("수정할 상품명을 입력하세요:");
		String name = sc.next();

		System.out.print("수정할 재고를 입력하세요:");
		int stock = sc.nextInt();
		
		System.out.print("수정할 단가를 입력하세요:");
		int price = sc.nextInt();
		
		System.out.print("수정할 카테고리를 입력하세요:");
		String category = sc.next();
		
		System.out.print("수정할 입고일자를 입력하세요:");
		String inputdate = sc.next();
		
		pDto = new ProductsDto();
		pDto.setId(id);
		pDto.setName(name);
		pDto.setStock(stock);
		pDto.setPrice(price);
		pDto.setCategory(category);
		pDto.setInputdate(inputdate);
		
		int result = pDao.updateProduct(pDto);
		if(result == 0) {
			System.out.println("일치하는 아이디가 없습니다.");
		}else if(result == -1){
			System.out.println("수정 실패");
		}else{
			System.out.println("수정 성공");
		}
		
	}

	private void insertProduct() {

		System.out.println("아이디는 자동생성됩니다.");
		System.out.print("상품명을 입력하세요:");
		String name = sc.next();

		System.out.print("재고를 입력하세요:");
		int stock = sc.nextInt();
		
		System.out.print("단가를 입력하세요:");
		int price = sc.nextInt();
		
		System.out.print("카테고리를 입력하세요:");
		String category = sc.next();
		
		System.out.print("입고일자를 입력하세요:");
		String inputdate = sc.next();
		
		pDto = new ProductsDto();
		pDto.setName(name);
		pDto.setStock(stock);
		pDto.setPrice(price);
		pDto.setCategory(category);
		pDto.setInputdate(inputdate);
		
		int result = pDao.insertProduct(pDto);
		if(result == 0) {
			System.out.println("입력 실패");
		}else{
			System.out.println("입력 성공");
		}
		
	}

	private void getProductsByCategory() {

		System.out.print("찾는 카테고리 입력:");
		String inputCategory = sc.next();
		lists = pDao.getProductsByCategory(inputCategory);
		if(lists.size() == 0) {
			System.out.println("일치하는 카테고리가 없습니다.");
		}else {
			showProducts(lists);
		}
		
	}
	
	private void getProductsById2() {
		
		System.out.print("찾는 아이디 입력:");
		int inputId = sc.nextInt();
		pDto = pDao.getProductsById2(inputId);
		if(pDto == null) {
			System.out.println("일치하는 아이디가 없습니다.");
		}else {
			System.out.println(pDto.getId()+"\t"+pDto.getName()+"\t"+pDto.getStock()+"\t"+pDto.getPrice()+"\t"+pDto.getCategory()+"\t"+pDto.getInputdate());
		}
		
	}

	private void getProductsById() {
		
		System.out.print("찾는 아이디 입력:");
		int inputId = sc.nextInt();
		lists = pDao.getProductsById(inputId);
		if(lists.size() == 0) {
			System.out.println("일치하는 아이디가 없습니다.");
		}else {
			showProducts(lists);
		}
		
	}

	private void showProducts(ArrayList<ProductsDto> lists) {

		System.out.println("아이디\t"+"상품명\t"+"재고\t"+"단가\t"+"카테고리\t"+"입고일자\t");
		for(int i=0;i<lists.size();i++) {
			pDto = lists.get(i);
			System.out.println(pDto.getId()+"\t"+pDto.getName()+"\t"+pDto.getStock()+"\t"+pDto.getPrice()+"\t"+pDto.getCategory()+"\t"+pDto.getInputdate());
		}
		
	}

	public static void main(String[] args) {

		ProductsMain prod = new ProductsMain(); // 객체를 생성하면 생성자로 넘어간다.
		
	}

}
