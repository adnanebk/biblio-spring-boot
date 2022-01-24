package com.supmti.ecommerceappspringboot.Dao.implementations;

import com.supmti.ecommerceappspringboot.Dao.CategoryDao;
import com.supmti.ecommerceappspringboot.Models.Category;
import com.supmti.ecommerceappspringboot.Repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class CategoryDaoImp implements CategoryDao {

    private final CategoryRepository categoryRepository;



    @Override
    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getById(Integer id){
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category){
        return categoryRepository.save(category);
    }

    @Override
    public void  remove(int id){
        categoryRepository.deleteById(id);
    }

    @Override
    public boolean isExist(int id) {
        return categoryRepository.existsById(id);
    }
}
