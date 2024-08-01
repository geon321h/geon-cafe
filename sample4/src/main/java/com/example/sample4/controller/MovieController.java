package com.example.sample4.controller;

import com.example.sample4.Entity.MovieEntity;
import com.example.sample4.bean.MovieBean;
import com.example.sample4.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    /* //검색어 페이지 없을때
    @GetMapping(value = {"/","movies"})
    public String select(Model model){
        List<MovieEntity> movieList = movieService.findMovieOrderByNo();
        model.addAttribute("movieList", movieList);
        return "movie/select";
    }*/
    
    /*검색어 페이지 있을때*/
    @GetMapping(value = {"/","movies"})
    public String select(
            @RequestParam(defaultValue = "0") int page, // 0이여야 1페이지
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(required = false) String keyword,
            Model model){

        Page<MovieEntity> movieList = movieService.getMovieEntity(page,size,keyword);
        long totalCount = movieService.getTotalCount();
        System.out.println("page:" + page);
        System.out.println("size:" + size);
        System.out.println("keyword:" + keyword);

        // 사이즈
        System.out.println("movieList.getSize:" + movieList.getSize());
        // 검색된 총 레코드 갯수
        System.out.println("movieList.getTotalElements:" + movieList.getTotalElements());
        // 검색된 현재 페이지 레코드 갯수
        System.out.println("movieList.getNumberOfElements:" + movieList.getNumberOfElements());
        // 현재 페이지 번호
        System.out.println("movieList.getNumberOfElements:" + movieList.getNumber());

        model.addAttribute("keyword", keyword);
        model.addAttribute("getTotalElements", movieList.getTotalElements());
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("size", size);
        model.addAttribute("page", page);
        model.addAttribute("movieList", movieList);
        return "movie/select";
    }

    @GetMapping("/movie/insert")
    public String insertForm(Model model){

        model.addAttribute("peopleList", people());
        model.addAttribute("genreList", genre());
        model.addAttribute("movie", new MovieBean());
        return "movie/insert";
    }

    @PostMapping("/movie/insert")
    public String insert(
            @ModelAttribute(value = "movie") @Valid MovieBean movie,
            BindingResult result,
            Model model){

        if (result.hasErrors()){
            model.addAttribute("peopleList", people());
            model.addAttribute("genreList", genre());
            model.addAttribute("movie",movie);
            return "movie/insert";
        }

        MovieEntity movieEntity = movieService.beanChangeEntity(movie);
        movieService.saveMovie(movieEntity);

        return "redirect:/movies";
    }

    @PostMapping("/movie/check")
    @ResponseBody
    public String checkUserId(
            @RequestParam("user_id") String user_id,
            Model model){
        int count = movieService.checkMovieUserId(user_id);
        System.out.println(count);
        String msg = "success";
        if (count > 0){
            msg = "fail";
        }
        return msg;
    }

    @GetMapping("/movie/detail")
    public String detail(
            @RequestParam("no") int no,
            Model model){

        MovieEntity movie = movieService.findByNo(no);
        model.addAttribute("movie", movie);
        return "movie/detail";
    }

    @GetMapping("/movie/delete")
    public String delete(@RequestParam("no") int no){

        movieService.deleteByNo(no);
        return "redirect:/movies";
    }

    @PostMapping("/movie/checkDelete")
    public String delete(@RequestParam("row") int[] row){

        for (int r : row){
            movieService.deleteByNo(r);
        }
        return "redirect:/movies";
    }

    @PostMapping("/movie/update")
    public String update(
            @ModelAttribute("movie") @Valid MovieBean movie,
            BindingResult result,
            Model model){

        if (result.hasErrors()){
            model.addAttribute("peopleList", people());
            model.addAttribute("genreList", genre());
            model.addAttribute("movie",movie);
            return "movie/update";
        }

        MovieEntity movieEntity = movieService.beanChangeEntity(movie);
        movieService.saveMovie(movieEntity);

        return "redirect:/movies";
    }

    @GetMapping("/movie/update")
    public String updateForm(
            @RequestParam("no") int no,
            Model model){

        model.addAttribute("peopleList", people());
        model.addAttribute("genreList", genre());
        MovieEntity movie = movieService.findByNo(no);
        model.addAttribute("movie", movie);
        return "movie/update";
    }

    public List<Integer> people(){
        List<Integer> peopleList = new LinkedList<>();
        for(int i=1; i<=5; i++){
            peopleList.add(i);
        }
        return peopleList;
    }

    public List<String> genre(){
        List<String> genreList = new LinkedList<>();
        genreList.add("공포");
        genreList.add("코미디");
        genreList.add("액션");
        genreList.add("애니메이션");
        return genreList;
    }

}
