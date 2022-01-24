package com.supmti.ecommerceappspringboot.Services.implementations;

import com.supmti.ecommerceappspringboot.Dao.CategoryDao;
import com.supmti.ecommerceappspringboot.Dao.LivreDao;
import com.supmti.ecommerceappspringboot.Models.Livre;
import com.supmti.ecommerceappspringboot.Services.LivreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LivreServiceImp implements LivreService {

    private final LivreDao livreDao;

    private final CategoryDao categoryDao;



    @Override
    public Page<Livre> getAllByPage(Pageable pageData){
    return livreDao.getAll(pageData);
    }

    @Override
    public List<Livre> getAll() {
        return livreDao.getAll();
    }

    @Override
    public Livre getById(Integer id){
        return livreDao.getById(id).orElseThrow(()->
                new  EntityNotFoundException("livre with id "+ id+" not exist"));
    }


    @Override
    public Livre save(Livre livre){
        Integer livreId=livre.getId();
        if(livreId!=null &&  !livreDao.isExist(livreId))
       throw new  EntityNotFoundException("livre with id "+ livreId+" not exist");

        int categoryId=livre.getCategory().getId();
        verifyCategory(categoryId);
        return livreDao.save(livre);
    }



    @Override
    public void  remove(int id){
        if(!livreDao.isExist(id))
            throw new EntityNotFoundException("livre with id "+ id+" not exist");

        livreDao.remove(id);
    }

    private void verifyCategory(int categoryId) {
        if(!categoryDao.isExist(categoryId))
            throw new EntityNotFoundException("category with id "+ categoryId+" not exist");
    }
}
