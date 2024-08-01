package com.example.sample4.repository;

import com.example.sample4.Entity.MovieEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {

    @Query(value = "SELECT * FROM movie ORDER BY no DESC"  , nativeQuery = true)
    List<MovieEntity> findMovieOrderByNo();

    @Query(value = "SELECT count(*) FROM movie where user_id = :uId"  , nativeQuery = true)
    int checkMovieUserId(String uId);

    @Query(value = "SELECT * FROM movie where no = :no"  , nativeQuery = true)
    MovieEntity findByNo(int no);

    Page<MovieEntity> findByNameContainingOrGenreContainingOrderByNoDesc(Pageable pageable, String keyword,String keyword1);

    @Query(value = "SELECT * FROM movie WHERE name LIKE '%:keyword%' OR genre LIKE '%:keyword%' ORDER BY no DESC", nativeQuery = true)
    Page<MovieEntity> findByNameGenreOrder(String keyword, Pageable pageable);
}
