package com.example.sample3.Bean;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BkBean {

    private int no;

    @NotBlank(message = "제목을 입력해주세요.")
    private String title;
    @NotBlank(message = "저자를 입력해주세요.")
    private String author;
    @NotBlank(message = "출판사를 입력해주세요.")
    private String publisher;
    @NotNull(message = "가격을 입력해주세요.")
    private Integer price;
    @NotBlank(message = "입고일을 입력해주세요.")
    private String buy;
    @NotBlank(message = "배송비를 선택해주세요.")
    private String kind;
    @NotBlank(message = "구입 가능 서점을 선택해주세요.")
    private String bookstore;
    @NotNull(message = "수량을 선택해주세요.")
    private Integer count;

}
