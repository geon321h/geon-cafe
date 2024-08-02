package com.example.sample_menu.service;

import com.example.sample_menu.bean.MenuBean;
import com.example.sample_menu.entity.MenuEntity;
import com.example.sample_menu.repository.MenuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    @Autowired
    MenuRepository menuRepository;

    public Page<MenuEntity> getMovieEntity(int page, int size, String keyword) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("menuDate").descending().and(Sort.by("menuNo").descending()));
        if (keyword == null ) {
            return menuRepository.findAll(pageable);
        }else{
            return menuRepository.findByRestaurantContainingOrFoodContainingOrderByMenuDateDescMenuNoDesc(pageable, keyword, keyword);
        }
    }

    public long getTotalCount() {
        return menuRepository.count();
    }

    private static ModelMapper modelMapper = new ModelMapper();

    public MenuEntity beanChangeEntity(MenuBean menu) {
        MenuEntity menuEntity = modelMapper.map(menu, MenuEntity.class);
        return menuEntity;
    }

    public void saveMenu(MenuEntity menuEntity) {
        menuRepository.save(menuEntity);
    }

    public int checkNickName(String nickName) {
        int cnt = -1;
        cnt = menuRepository.checkNickName(nickName);
        return cnt;
    }

    public void deleteByNo(int menuNo) {
        menuRepository.deleteById(menuNo);
    }

    public MenuEntity findMenuByNO(int menuNo) {
        return menuRepository.findMenuByNO(menuNo);
    }
}
