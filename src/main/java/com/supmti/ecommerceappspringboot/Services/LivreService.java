package com.supmti.ecommerceappspringboot.Services;

import com.supmti.ecommerceappspringboot.Models.Livre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LivreService {
    Page<Livre> getAllByPage(Pageable pageData);

    List<Livre> getAll();

    Livre getById(Integer id);

    Livre save(Livre livre);

    void remove(int id);
}
