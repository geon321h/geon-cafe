package com.example.sample_menu.repository;

import com.example.sample_menu.entity.MenuEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MenuRepository extends JpaRepository<MenuEntity, Integer> {


    Page<MenuEntity> findByRestaurantContainingOrFoodContainingOrderByMenuDateDescMenuNoDesc(Pageable pageable, String keyword, String keyword1);

    @Query( value = "SELECT COUNT(*) FROM menu WHERE nick_name = :nickName" , nativeQuery = true)
    int checkNickName(String nickName);

    @Query(value = "SELECT * FROM menu WHERE menu_no = :menuNo",nativeQuery = true)
    MenuEntity findMenuByNO(int menuNo);
}
