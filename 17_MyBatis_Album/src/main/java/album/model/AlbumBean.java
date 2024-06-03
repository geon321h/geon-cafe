package album.model;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class AlbumBean {
	
	private int num;
	
	@NotEmpty(message = "노래 제목 입력 누락")
	private String title;
	
	@Length(min = 3, max =7, message = "3~7자리를 입력해주세요")
	private String singer;
		
	@Min(value = 1000, message = "1000원 이상 입력해주세요")
	@NotEmpty(message = "가격 입력 누락")
	private String price;
	private String day;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}

	
	

}
