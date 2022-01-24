package com.supmti.ecommerceappspringboot.Repositories;

import com.supmti.ecommerceappspringboot.Models.Role;
import com.supmti.ecommerceappspringboot.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    @Query("SELECT count(*) FROM User u WHERE u.email = ?1")
    int getCountByEmail(String email);
}
