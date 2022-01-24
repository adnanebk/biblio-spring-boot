package com.supmti.ecommerceappspringboot.Dao.implementations;

import com.supmti.ecommerceappspringboot.Dao.LivreDao;
import com.supmti.ecommerceappspringboot.Models.Livre;
import com.supmti.ecommerceappspringboot.Repositories.LivreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class LivreDaoImp implements LivreDao {

    private final LivreRepository livreRepository;


    @Override
    public List<Livre> getAll(){
        return livreRepository.findAll();
    }
    @Override
    public Page<Livre> getAll(Pageable pageable) {
        return livreRepository.findAll(pageable);
    }
    @Override
    public Optional<Livre> getById(Integer id){
        return livreRepository.findById(id);
    }

    @Override
    public Livre save(Livre livre){
        return livreRepository.save(livre);
    }

    @Override
    public void  remove(int id){
        livreRepository.deleteById(id);
    }

    @Override
    public boolean isExist(int id) {
        return livreRepository.existsById(id);
    }


}
