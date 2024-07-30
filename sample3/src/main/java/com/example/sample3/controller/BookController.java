    package com.example.sample3.controller;

    import com.example.sample3.Bean.BkBean;
    import com.example.sample3.Entity.BookEntity;
    import com.example.sample3.service.BookService;
    import jakarta.validation.Valid;
    import lombok.RequiredArgsConstructor;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.validation.BindingResult;
    import org.springframework.web.bind.annotation.*;

    import java.util.LinkedList;
    import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);
    private final BookService bookService;

    @GetMapping(value = {"/","books"})
    public String select(Model model){
        List<BookEntity> booklist = bookService.findByOrderByNoDesc();
        model.addAttribute("bookList",booklist);
        return "book/select";
    }

    @GetMapping("/book/insert")
    public String insert(Model model){
        model.addAttribute("bookBean", new BkBean());
        return "book/insert";
    }

    @PostMapping("/book/insert")
    public String insertPost(@ModelAttribute(value = "bookBean") @Valid BkBean bookBean, BindingResult result, Model model){

        if (result.hasErrors()){
            model.addAttribute("bookBean",bookBean);
            return "book/insert";
        }

        BookEntity bookEntity = bookService.insertBook(bookBean);
        bookService.saveBook(bookEntity);

        return "redirect:/books";
    }

    @GetMapping("/book/detail")
    public String detail(@RequestParam("no") int no, Model model){

        BookEntity bookEntity = bookService.findByNo(no);
        model.addAttribute("book", bookEntity);
        return "book/detail";
    }

    @GetMapping("/book/delete")
    public String delete(@RequestParam("no") int no, Model model){

        bookService.deleteByNo(no);
        return "redirect:/books";
    }

    @PostMapping("/book/checkDelete")
    public String checkDelete(@RequestParam("row") int[] row){
        //System.out.println("checkDelete row : " + row);
        //System.out.println("checkDelete row : " + row.length);

        for(int r : row){
            bookService.deleteByNo(r);
        }
        return "redirect:/books";
    }

    @GetMapping("/book/update/{no}")
    public String update(@PathVariable("no") int no, Model model){
        String[] bookstoreList = {"교보문고","알라딘","yes24","인터파크"};
        BookEntity bookEntity = bookService.findByNo(no);
        model.addAttribute("bookBean", bookEntity);
        model.addAttribute("bookstoreList", bookstoreList);
        model.addAttribute("kindList", kind());
        return "book/update";
    }

    @PostMapping("/book/update")
    public String updatePost(@ModelAttribute(value = "bookBean") @Valid BkBean bookBean, BindingResult result, Model model){

        if (result.hasErrors()){
            model.addAttribute("bookBean",bookBean);
            return "book/update";
        }

        BookEntity bookEntity = bookService.insertBook(bookBean);
        bookService.saveBook(bookEntity);

        return "redirect:/books";
    }
    
    public List<String> kind(){
        List<String> kindList = new LinkedList<>();
        kindList.add("유료");
        kindList.add("무료");
        return kindList;
    }

}
