package com.supmti.ecommerceappspringboot.Services.implementations;

import com.supmti.ecommerceappspringboot.Dao.CommandeDao;
import com.supmti.ecommerceappspringboot.Models.Commande;
import com.supmti.ecommerceappspringboot.Models.User;
import com.supmti.ecommerceappspringboot.Services.CommandeService;
import com.supmti.ecommerceappspringboot.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CommandeServiceImp implements CommandeService {

    private final CommandeDao commandeDao;

    private final UserService userService;


    @Override
    public List<Commande> getAll(){
        return commandeDao.getAll();
    }

    @Override
    public Commande getById(Integer id){
        return commandeDao.getById(id)
                .orElseThrow(()->new EntityNotFoundException("commande with id "+ id+" not exist"));
    }

    @Override
    public Commande save(Commande commande, String email){
       User user = userService.getByEmail(email);
       user.setCommande(commande);
       commande.setUser(user);
        return commandeDao.save(commande);
    }


    @Override
    public void  remove(int id){
        commandeDao.remove(id);
    }


}
