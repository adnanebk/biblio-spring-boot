package com.supmti.ecommerceappspringboot.Dto;

import com.supmti.ecommerceappspringboot.Models.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class LivreDto {


    private Integer id;

    @NotEmpty
    private String name;
    @NotEmpty
    private String description;




    @Min(1)
    private Double price;
    @NotEmpty
    private String imageUrl;

    @NotNull
    private Integer categoryId;
}
