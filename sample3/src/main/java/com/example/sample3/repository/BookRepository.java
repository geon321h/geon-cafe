package com.example.sample3.repository;

import com.example.sample3.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity,Integer> {

    @Query(value = "select * from book order by no desc", nativeQuery = true)
    List<BookEntity> findByOrderByNoDesc();

    @Query(value = "select * from book where no = :n", nativeQuery = true)
    BookEntity findByNo(int n);

}
