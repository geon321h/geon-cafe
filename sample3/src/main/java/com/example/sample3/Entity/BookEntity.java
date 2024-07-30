package com.example.sample3.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book")
@Setter
@Getter
public class BookEntity {

    @Id
    @GeneratedValue
    private int no;

    private String title;
    private String author;
    private String publisher;
    private Integer price;
    private String buy;
    private String kind;
    private String bookstore;
    private Integer count;

}
