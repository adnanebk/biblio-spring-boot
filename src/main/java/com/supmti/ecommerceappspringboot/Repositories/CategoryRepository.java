package com.supmti.ecommerceappspringboot.Repositories;

import com.supmti.ecommerceappspringboot.Models.Livre;
import com.supmti.ecommerceappspringboot.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
