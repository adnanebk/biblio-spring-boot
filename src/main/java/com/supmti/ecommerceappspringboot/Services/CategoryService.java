package com.supmti.ecommerceappspringboot.Services;

import com.supmti.ecommerceappspringboot.Models.Livre;
import com.supmti.ecommerceappspringboot.Models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAll();

    Category getById(Integer id);

    Category save(Category category);

    void remove(int id);
}
