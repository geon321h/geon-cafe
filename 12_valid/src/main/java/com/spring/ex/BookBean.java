package com.spring.ex;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class BookBean {

	@NotEmpty(message = "���� �Է� ����")
	private String title;
	
	@NotBlank(message = "���� �Է� ����")
	@Length(min = 5, message = "���ڴ� 5���� �̻� �Է����ּ���")
	private String author;
	
	@Length(min = 3,max = 5, message = "������ 3~5���� ���̷� �Է����ּ���")
	@Pattern(regexp = "^[0-9]+$",message = "������ ���ڷθ� �Է����ּ���")
	private String price;
	
	@NotBlank(message = "���ǻ� �Է� ����")
	private String publisher;
	
	@NotNull(message = "���԰��ɼ��� üũ ����")
	private String bookstore;
	
	@NotBlank(message = "��ۺ� üũ ����")
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
