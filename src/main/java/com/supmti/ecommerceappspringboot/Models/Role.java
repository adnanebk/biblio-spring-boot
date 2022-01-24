package com.supmti.ecommerceappspringboot.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id_role;

        private String role;


    }