package com.supmti.ecommerceappspringboot.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String name;

    private String description;

    private LocalDateTime createdDate=LocalDateTime.now();

    private Double price;

    @ManyToMany(mappedBy = "livres")
    @JsonIgnore
    private Set<Commande> commandes=new HashSet<>();

    private String imageUrl;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

}
