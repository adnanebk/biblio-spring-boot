package com.supmti.ecommerceappspringboot.Services;

import com.supmti.ecommerceappspringboot.Models.Commande;

import java.util.List;

public interface CommandeService   {

    List<Commande> getAll();

    Commande getById(Integer id);

    Commande save(Commande  commande,String email);

    void remove(int id);

}
