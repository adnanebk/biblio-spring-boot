package com.supmti.ecommerceappspringboot.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private final LocalDate dateAchat=LocalDate.now();
    @ManyToMany
    @NotNull
    private Set<Livre> livres=new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
}
