package com.example.sample4.service;

import com.example.sample4.Entity.MovieEntity;
import com.example.sample4.Entity.QMovieEntity;
import com.example.sample4.bean.MovieBean;
import com.example.sample4.repository.MovieRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    private static ModelMapper modelMapper = new ModelMapper();

    public MovieEntity beanChangeEntity(MovieBean movie) {

        MovieEntity movieEntity = modelMapper.map(movie, MovieEntity.class);
        return movieEntity;

    }


    public void saveMovie(MovieEntity movieEntity) {
        movieRepository.save(movieEntity);
    }

    public List<MovieEntity> findMovieOrderByNo() {
        List<MovieEntity> movieList = movieRepository.findMovieOrderByNo();
        return movieList;
    }

    public int checkMovieUserId(String user_id) {
        int cnt = -1;
        cnt = movieRepository.checkMovieUserId(user_id);
        System.out.println("cnt:"+cnt);
        return cnt;
    }

    public MovieEntity findByNo(int no) {
        MovieEntity movieEntity = movieRepository.findByNo(no);
        return movieEntity;
    }

    public void deleteByNo(int no) {
        movieRepository.deleteById(no);
    }

    public Page<MovieEntity> getMovieEntity(int page, int size, String keyword) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("no").descending());
        if (keyword == null ) {
            return movieRepository.findAll(pageable);
        }else{

            // query method
            // return movieRepository.findByNameContainingOrGenreContainingOrderByNoDesc(pageable, keyword, keyword);

            // query annotation
            // return movieRepository.findByNameGenreOrder(keyword,pageable);

            // query dsl
            return findByNameGenreOrder2(keyword,pageable);

        }
    }

    @PersistenceContext
    EntityManager em;

    private Page<MovieEntity> findByNameGenreOrder2(String keyword, Pageable pageable) {

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QMovieEntity qMovie = QMovieEntity.movieEntity;
        JPAQuery<MovieEntity> query = queryFactory
                .selectFrom(qMovie)
                .where(qMovie.name.like("%"+keyword+"%"))
                .where(qMovie.genre.like("%"+keyword+"%"))
                .orderBy(qMovie.no.desc());
        List<MovieEntity> movieList = query.fetch(); // 리스트로 받기
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("no").descending());
        int start = (int)pageRequest.getOffset();
        int end = Math.min((start + pageRequest.getPageSize()),movieList.size());

        Page<MovieEntity> page = new PageImpl<MovieEntity>(movieList.subList(start, end));
        // subList : 리스트중 일부만 가져올 수 있는 메서드

        return page;
    }

    public long getTotalCount() {
        return movieRepository.count();
    }
}
