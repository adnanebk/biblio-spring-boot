package com.supmti.ecommerceappspringboot.Dao.implementations;

import com.supmti.ecommerceappspringboot.Dao.CommandeDao;
import com.supmti.ecommerceappspringboot.Models.Commande;
import com.supmti.ecommerceappspringboot.Repositories.CommandeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class CommandeDaoImp implements CommandeDao {

    private final CommandeRepository commandeRepository;



    @Override
    public List<Commande> getAll(){
        return commandeRepository.findAll();
    }

    @Override
    public Optional<Commande> getById(Integer id){
        return commandeRepository.findById(id);
    }

    @Override
    public Commande save(Commande commande){
        return commandeRepository.save(commande);
    }

    @Override
    public void  remove(int id){
        commandeRepository.deleteById(id);
    }

    @Override
    public boolean isExist(int id) {
        return commandeRepository.existsById(id);
    }
}
