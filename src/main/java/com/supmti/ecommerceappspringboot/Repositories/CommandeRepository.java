package com.supmti.ecommerceappspringboot.Repositories;

import com.supmti.ecommerceappspringboot.Models.Category;
import com.supmti.ecommerceappspringboot.Models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,Integer> {
}
