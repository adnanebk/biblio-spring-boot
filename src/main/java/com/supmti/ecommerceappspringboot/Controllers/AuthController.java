package com.supmti.ecommerceappspringboot.Controllers;



import com.supmti.ecommerceappspringboot.Models.User;
import com.supmti.ecommerceappspringboot.Services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.net.URI;
import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;
    



    @PostMapping(value = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> register(@RequestBody @Valid User user)   {
        return  authService.handleRegister(user);

    }
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody @Valid User user) {
    return authService.handleLogin(user);
}

}
