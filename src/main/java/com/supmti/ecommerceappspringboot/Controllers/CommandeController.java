package com.supmti.ecommerceappspringboot.Controllers;


import com.supmti.ecommerceappspringboot.Exceptions.AuthException;
import com.supmti.ecommerceappspringboot.Models.Commande;
import com.supmti.ecommerceappspringboot.Services.CommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.net.URI;
import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor // initalize final properties by using constructor
@RequestMapping("/api/commandes")
public class CommandeController {

    private final CommandeService commandeService;

    @GetMapping
    public List<Commande> getAll(){
        return commandeService.getAll();
    }

    @GetMapping("/{id}") //
    public Commande getById(@PathVariable Integer id){
        return commandeService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Commande> addCommande(@Valid @RequestBody Commande commande, Principal principal){
       if(principal!=null) {
           String email = principal.getName();
           commande = commandeService.save(commande,email);
           return  ResponseEntity.created(URI.create("/"+commande.getId())).body(commande);
       }
       throw new AuthException("user is not authenticated");
    }


    @DeleteMapping
    public ResponseEntity<?> removeCommande(int id){
         commandeService.remove(id);
         return ResponseEntity.noContent().build();
    }
}
