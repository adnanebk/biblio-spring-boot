package com.supmti.ecommerceappspringboot.Mappers;

import com.supmti.ecommerceappspringboot.Dto.LivreDto;
import com.supmti.ecommerceappspringboot.Models.Category;
import com.supmti.ecommerceappspringboot.Models.Livre;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

public class Mapper {

    public static Livre  dtoToEntity(LivreDto livreDto){
        Category category=new Category();
                 category.setId(livreDto.getCategoryId());
                 Livre livre = new Livre();
        BeanUtils.copyProperties(livreDto,livre);
        livre.setCategory(category);
         return livre;
    }
    public static LivreDto  entityToDto(Livre livre){
    LivreDto livreDto = new LivreDto();
        BeanUtils.copyProperties(livre,livreDto);
        if(livre.getCategory()!=null)
        livreDto.setCategoryId(livre.getCategory().getId());
        return livreDto;
    }
}
