class Music {

	private String title;
	private String singer;
	private String genre;
	private int price;

	Music(){
		title = "신호등";
		singer = "이무진";
		genre = "발라드";
		price = 2000;
	}
	
	Music(String title, String singer, String genre, int price){
		this.title = title;
		this.singer = singer;
		this.genre = genre;
		this.price = price;
	}
	
	void setTitle(String title) {
		this.title = title;
	}
	
	void setSinger(String singer) {
		this.singer = singer;
	}
	
	void setGenre(String genre) {
		this.genre = genre;
	}
	
	void setPrice(int price) {
		this.price = price;
	}
	
	String getTitle() {
		return title;
	}
	
	String getSinger() {
		return singer;
	}
	
	String getGenre() {
		return genre;
	}
	
	int getPrice() {
		return price;
	}
	
	void display(){
		System.out.println("노래제목: " + title);
		System.out.println("가수: " + singer);
		System.out.println("장르: " + genre);
		System.out.println("가격: " + price + "원");
		System.out.println("-----------------------");
	}
	
}

public class Ex17_남건 {

	public static void main(String[] args) {

		// Music m1; 생성자 통한 초기화 (신호등,이무진,발라드,2000)
		// Music m2; setter 통한 초기화 (숲,최유리,발라드,3000)
		// Music m3; 매개변수 4개있는 생성자 통한 초기화 (다이너마이트,bts,트로트,5000)
		
		// 생성자를 통한 초기화 //
		
		System.out.println("- 객체를 만들어서 출력 -");
		Music m1 = new Music();
		m1.display();

		// setter 통한 초기화 //
		
		Music m2 = new Music();
		m2.setTitle("숲");
		m2.setSinger("최유리");
		m2.setGenre("발라드");
		m2.setPrice(3000);
		m2.display();
		
		// 매개변수 4개있는 생성자 통한 초기화 //
		
		Music m3 = new Music("다이너마이트", "bts", "트로트", 5000);
		m3.display();
		
		// 위 3개의 객체를 배열로 만들어서 출력 //
		
		System.out.println();
		System.out.println("- 객체를 배열로 만들어서 출력 -");
		
		Music[] m = {new Music(),new Music(),new Music("다이너마이트", "bts", "트로트", 5000)};

		m[1].setTitle("숲");
		m[1].setSinger("최유리");
		m[1].setGenre("발라드");
		m[1].setPrice(3000);
		
		for(int i=0;i<m.length;i++) {
			m[i].display();
		}
		
	}

}










