package com.supmti.ecommerceappspringboot.Models;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
    @Table(name = "users")
    @Getter
    @Setter
    @NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    @NotEmpty
    private String first_name;

    @Column(name = "last_name")
    @NotEmpty
    private String last_name;

    @Column(name = "phone")
    private String phone;


    @Column(name = "email",unique = true)
    @Email
    @NotEmpty
    private String email;

    @Column(name = "password")
    @NotEmpty
    @Length(min = 6)
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "CIN")
    private String CIN;
    @Column(name = "is_enabled")
    private boolean isEnabled;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role", referencedColumnName = "id_role")
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Commande> commandes=new HashSet<>();


    public User(String first_name, String last_name, String phone, String email, String password, String address, String CIN, Role role, boolean isEnabled) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.address = address;
        this.isEnabled = isEnabled;
        this.CIN = CIN;
        this.role = role;
    }


    public void setCommande(Commande commande) {
        this.commandes.add(commande);
    }
}

