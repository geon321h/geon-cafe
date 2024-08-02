package com.example.sample_menu.controller;

import com.example.sample_menu.bean.MenuBean;
import com.example.sample_menu.entity.MenuEntity;
import com.example.sample_menu.service.MenuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping(value = {"/","menus"})
    public String select(
            @RequestParam(defaultValue = "0") int page, // 0이여야 1페이지
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(required = false) String keyword,
            Model model){

        Page<MenuEntity> menuList = menuService.getMovieEntity(page,size,keyword);
        long totalCount = menuService.getTotalCount();
        System.out.println("totalPages:"+menuList.getTotalPages());

        model.addAttribute("keyword", keyword);
        model.addAttribute("getTotalElements", menuList.getTotalElements());
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("size", size);
        model.addAttribute("page", page);
        model.addAttribute("menuList", menuList);

        return "menu/select";
    }

    @GetMapping("/menu/insert")
    public String insertForm(Model model){
        model.addAttribute("menu", new MenuBean());
        model.addAttribute("foodList", foodList());
        model.addAttribute("timeList", timeList());
        return "menu/insert";
    }

    @PostMapping("/menu/insert")
    public String insert(
            @ModelAttribute("menu") @Valid MenuBean menu,
            BindingResult result,
            Model model){

        if(result.hasErrors()){
            model.addAttribute("foodList", foodList());
            model.addAttribute("timeList", timeList());
            return "menu/insert";
        }

        MenuEntity menuEntity = menuService.beanChangeEntity(menu);
        menuService.saveMenu(menuEntity);

        return "redirect:/menus";
    }

    @PostMapping("/menu/check")
    @ResponseBody
    public String check(
            @RequestParam("nick_name") String nick_name){

        int count = menuService.checkNickName(nick_name);

        if(count>0){
            return "fail";
        }else {
            return "success";
        }

    }

    @GetMapping("/menu/delete")
    public String delete(
            @RequestParam("menuNo") int menuNo
    ){

        menuService.deleteByNo(menuNo);
        return "redirect:/menus";
    }

    @PostMapping("/menu/checkDelete")
    public String delete(@RequestParam("row") int[] row){

        for (int r : row){
            menuService.deleteByNo(r);
        }
        return "redirect:/menus";
    }

    @GetMapping("/menu/detail")
    public String detail(
            @RequestParam("menuNo") int menuNo,
            Model model){

        MenuEntity menu = menuService.findMenuByNO(menuNo);
        model.addAttribute("menu", menu);
        return "menu/detail";
    }

    @GetMapping("/menu/update")
    public String updateForm(
            @RequestParam("menuNo") int menuNo,
            Model model){

        MenuEntity menu = menuService.findMenuByNO(menuNo);
        model.addAttribute("menu", menu);
        model.addAttribute("foodList", foodList());
        model.addAttribute("timeList", timeList());
        return "menu/update";
    }

    @PostMapping("/menu/update")
    public String update(
            @ModelAttribute("menu") @Valid MenuBean menu,
            BindingResult result,
            Model model){

        if(result.hasErrors()){
            model.addAttribute("foodList", foodList());
            model.addAttribute("timeList", timeList());
            return "menu/update";
        }

        MenuEntity menuEntity = menuService.beanChangeEntity(menu);
        menuService.saveMenu(menuEntity);

        return "redirect:/menus";
    }

    public List<String> foodList(){
        List<String> foodList = new LinkedList<>();
        foodList.add("치킨");
        foodList.add("피자");
        foodList.add("백반");
        foodList.add("국");
        foodList.add("찌개");
        foodList.add("족발");
        foodList.add("탕");
        foodList.add("짜장면");
        foodList.add("탕수육");
        foodList.add("햄버거");
        foodList.add("스테이크");
        foodList.add("돈까스");
        foodList.add("회");
        foodList.add("초밥");
        foodList.add("고기");
        foodList.add("빵");
        foodList.add("떡볶이");
        return foodList;
    }

    public List<String> timeList(){
        List<String> timeList = new LinkedList<>();
        timeList.add("아침");
        timeList.add("점심");
        timeList.add("저녁");
        timeList.add("야식");
        return timeList;
    }



}
