package com.supmti.ecommerceappspringboot.Services.implementations;

import com.supmti.ecommerceappspringboot.Dao.UserDao;
import com.supmti.ecommerceappspringboot.Exceptions.AuthException;
import com.supmti.ecommerceappspringboot.Jwt.JwtTokenUtil;
import com.supmti.ecommerceappspringboot.Models.User;
import com.supmti.ecommerceappspringboot.Repositories.UserRepository;
import com.supmti.ecommerceappspringboot.Services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService {

    private final UserDao userDao;
    private final JwtTokenUtil jwtTokenUtil;
    private final PasswordEncoder passwordEncode;


    @Value("${jwt.expiration-time}")
    private long expirationTime;


    public Map<String,Object> handleLogin(User user){
        User currentUser  = userDao.getByEmail(user.getEmail()).get();


        if(currentUser==null || !passwordEncode.matches(user.getPassword(),currentUser.getPassword()))
            throw new AuthException("Invalid username or password");
        return generateToken(currentUser);
    }



    public Map<String,Object> handleRegister(User user)
    {
        user.setPassword(passwordEncode.encode(user.getPassword()));
        user= userDao.save(user);

        return generateToken(user);
    }


    private Map<String, Object> generateToken(User user) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> claims = new HashMap<>();
        claims.put("email",user.getEmail());
        map.put("token", this.jwtTokenUtil.generateToken(user.getEmail(),claims));
        map.put("user", user);
        return map;
    }


}
