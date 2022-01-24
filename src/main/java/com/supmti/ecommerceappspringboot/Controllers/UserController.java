package com.supmti.ecommerceappspringboot.Controllers;

import com.supmti.ecommerceappspringboot.Models.User;
import com.supmti.ecommerceappspringboot.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {



    private final UserService userService;



    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id, HttpServletRequest httpRequest){

        User user = userService.getById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody @Valid User user){

        User updateUser = userService.save(user);
        return ResponseEntity.ok(updateUser);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeleteUser(@PathVariable int id){
       userService.remove(id);
        return ResponseEntity.noContent().build();

    }
}
