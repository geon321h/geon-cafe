package com.example.sample4.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "movie")
@Getter
@Setter
public class MovieEntity {

    @Id
    @GeneratedValue
    private int no; 

    private String user_id;
    private String name;
    private int age;
    private String genre;
    private String movie_time;
    private String people;
    private String movie_comment;

}
