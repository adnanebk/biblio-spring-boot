package com.supmti.ecommerceappspringboot.Dao;

import java.util.List;
import java.util.Optional;


public interface CrudDao<T> {

    List<T> getAll();

    Optional<T> getById(Integer id);

    T save(T entity);

    void remove(int id);

    boolean isExist(int id);

}
