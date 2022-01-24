package com.supmti.ecommerceappspringboot.Services.implementations;

import com.supmti.ecommerceappspringboot.Dao.UserDao;
import com.supmti.ecommerceappspringboot.Models.User;
import com.supmti.ecommerceappspringboot.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {


    private final UserDao userDao;


    @Override
    public List<User> getAll(){
        return userDao.getAll();
    }

    @Override
    public User getById(Integer id){
        return userDao.getById(id)
                .orElseThrow(()->new EntityNotFoundException("user with id "+ id+" not exist"));
    }

    @Override
    public User save(User user){

        return userDao.save(user);
    }

    @Override
    public User getByEmail(String email){

        return userDao.getByEmail(email).orElseThrow(()->new EntityNotFoundException("user with email "+ email+" not exist"));
    }


    @Override
    public void  remove(int id){
        userDao.remove(id);
    }


}
