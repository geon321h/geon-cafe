package com.example.sample3.service;

import com.example.sample3.Bean.BkBean;
import com.example.sample3.Entity.BookEntity;
import com.example.sample3.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    private static ModelMapper modelMapper = new ModelMapper();

    public BookEntity insertBook(BkBean bookBean) {
        System.out.println(bookBean.getAuthor());
        // bean => entity => save => insert
        BookEntity bookEntity = modelMapper.map(bookBean, BookEntity.class);
        return bookEntity;
    }

    public void saveBook(BookEntity bookEntity) {
        bookRepository.save(bookEntity);
    }

    public List<BookEntity> findByOrderByNoDesc() {
        List<BookEntity> bookList = bookRepository.findByOrderByNoDesc();
        return bookList;
    }

    public BookEntity findByNo(int no) {
        BookEntity bookEntity = bookRepository.findByNo(no);
        return bookEntity;
    }

    public void deleteByNo(int no) {
        bookRepository.deleteById(no);
    }

}
