package com.supmti.ecommerceappspringboot.Dao;

import com.supmti.ecommerceappspringboot.Models.Category;
import com.supmti.ecommerceappspringboot.Models.User;

import java.util.Optional;

public interface UserDao extends CrudDao<User>{
    Optional<User> getByEmail(String email);
}
