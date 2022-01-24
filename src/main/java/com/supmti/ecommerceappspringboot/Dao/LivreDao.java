package com.supmti.ecommerceappspringboot.Dao;

import com.supmti.ecommerceappspringboot.Models.Livre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LivreDao  extends CrudDao<Livre>{

    Page<Livre> getAll(Pageable pageable);

}
