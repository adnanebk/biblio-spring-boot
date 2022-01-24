package com.supmti.ecommerceappspringboot.Controllers;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.supmti.ecommerceappspringboot.Models.Category;
import com.supmti.ecommerceappspringboot.Models.Category;
import com.supmti.ecommerceappspringboot.Services.LivreService;
import com.supmti.ecommerceappspringboot.Services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.supmti.ecommerceappspringboot.Models.Livre;
import com.supmti.ecommerceappspringboot.Repositories.CategoryRepository;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor // initalize final properties by using constructor
@RequestMapping("/api/categories")
public class CategoryController {
        private final CategoryService categoryService;
    @GetMapping
    public List<Category> getAll(){
        return categoryService.getAll();
    }
    @GetMapping("/{id}") //
    public Category getById(@PathVariable Integer id){
        return categoryService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@Valid @RequestBody Category category){
        category=categoryService.save(category);
        return  ResponseEntity.created(URI.create("/"+category.getId())).body(category);
    }

    @PutMapping
    public Category updateCategory(@Valid @RequestBody Category category){
        return categoryService.save(category);
    }
    @DeleteMapping
    public ResponseEntity<?> removeCategory(int id){
        categoryService.remove(id);
        return ResponseEntity.noContent().build();
    }
}