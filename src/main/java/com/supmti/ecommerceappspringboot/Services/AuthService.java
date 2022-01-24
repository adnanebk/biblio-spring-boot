package com.supmti.ecommerceappspringboot.Services;

import com.supmti.ecommerceappspringboot.Models.User;

import java.util.Map;

public interface AuthService {
    Map<String,Object> handleLogin(User user);
    Map<String,Object> handleRegister(User user);
}
