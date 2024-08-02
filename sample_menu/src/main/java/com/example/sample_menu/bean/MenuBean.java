package com.example.sample_menu.bean;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuBean {

    private int menuNo;
    @NotBlank(message = "닉네임을 입력하세요.")
    private String nickName;
    @NotBlank(message = "식당명을 입력하세요.")
    private String restaurant;
    @NotBlank(message = "음식을 선택하세요.")
    private String food;
    @NotBlank(message = "식사 시간대를 선택하세요.")
    private String menuTime;
    @NotBlank(message = "식사 날짜를 선택하세요.")
    private String menuDate;

}
