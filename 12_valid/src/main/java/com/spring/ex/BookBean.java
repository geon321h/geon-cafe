package com.spring.ex;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class BookBean {

	@NotEmpty(message = "제목 입력 누락")
	private String title;
	
	@NotBlank(message = "저자 입력 누락")
	@Length(min = 5, message = "저자는 5글자 이상 입력해주세요")
	private String author;
	
	@Length(min = 3,max = 5, message = "가격은 3~5글자 사이로 입력해주세요")
	@Pattern(regexp = "^[0-9]+$",message = "가격은 숫자로만 입력해주세요")
	private String price;
	
	@NotBlank(message = "출판사 입력 누락")
	private String publisher;
	
	@NotNull(message = "구입가능서점 체크 누락")
	private String bookstore;
	
	@NotBlank(message = "배송비 체크 누락")
	private String kind;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getBookstore() {
		return bookstore;
	}
	public void setBookstore(String bookstore) {
		this.bookstore = bookstore;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
}
