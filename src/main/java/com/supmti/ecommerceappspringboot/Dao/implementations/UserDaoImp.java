package com.supmti.ecommerceappspringboot.Dao.implementations;

import com.supmti.ecommerceappspringboot.Dao.LivreDao;
import com.supmti.ecommerceappspringboot.Dao.UserDao;
import com.supmti.ecommerceappspringboot.Models.Livre;
import com.supmti.ecommerceappspringboot.Models.User;
import com.supmti.ecommerceappspringboot.Repositories.LivreRepository;
import com.supmti.ecommerceappspringboot.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class UserDaoImp implements UserDao {

    private final UserRepository userRepository;


    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(Integer id){
        return userRepository.findById(id);
    }

    @Override
    public User save(User user){
        return userRepository.save(user);
    }

    @Override
    public void  remove(int id){
        userRepository.deleteById(id);
    }

    @Override
    public boolean isExist(int id) {
        return userRepository.existsById(id);
    }


    @Override
    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }


}
