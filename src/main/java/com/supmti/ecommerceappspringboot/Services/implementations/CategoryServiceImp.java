package com.supmti.ecommerceappspringboot.Services.implementations;

import com.supmti.ecommerceappspringboot.Dao.CategoryDao;
import com.supmti.ecommerceappspringboot.Models.Category;
import com.supmti.ecommerceappspringboot.Services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


    @Service
    @RequiredArgsConstructor
    public class CategoryServiceImp implements CategoryService {

        private final CategoryDao categoryDao;




        @Override
        public List<Category> getAll(){
            return categoryDao.getAll();
        }

        @Override
        public Category getById(Integer id){
            return categoryDao.getById(id)
                    .orElseThrow(()->new EntityNotFoundException("category with id "+ id+" not exist"));
        }

        @Override
        public Category save(Category category){
            return categoryDao.save(category);
        }


        @Override
        public void  remove(int id){
            categoryDao.remove(id);
        }


}
