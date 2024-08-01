package com.example.sample4.bean;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieBean {

    private int no;

    @NotBlank(message = "아이디를 입력해주세요.")
    private String user_id;
    @NotBlank(message = "이름을 입력해주세요.")
    private String name;
    @NotNull(message = "나이를 입력해주세요.")
    private int age;
    @NotBlank(message = "장르를 선택해주세요.")
    private String genre;
    @NotBlank(message = "즐겨 보는 시간대를 선택해주세요.")
    private String movie_time;
    @NotNull(message = "동반 관객수를 선택해주세요.")
    private String people;
    @NotBlank(message = "개선사항을 입력해주세요.")
    private String movie_comment;

}
