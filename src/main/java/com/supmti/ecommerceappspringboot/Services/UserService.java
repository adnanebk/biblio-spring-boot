package com.supmti.ecommerceappspringboot.Services;

import com.supmti.ecommerceappspringboot.Models.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getById(Integer id);

    User save(User user);

    User getByEmail(String email);

    void  remove(int id);
}
