package com.supmti.ecommerceappspringboot.Controllers;

import com.supmti.ecommerceappspringboot.Dto.LivreDto;
import com.supmti.ecommerceappspringboot.Mappers.Mapper;
import com.supmti.ecommerceappspringboot.Models.Livre;
import com.supmti.ecommerceappspringboot.Services.LivreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor // initalize final properties by using constructor
@RequestMapping("/api/livres")
public class LivreController {

    private final LivreService livreService;


    @GetMapping
    public List<LivreDto> getAll(){
      return   livreService.getAll().stream().map(livre -> Mapper.entityToDto(livre)).collect(Collectors.toList());
    }

    @GetMapping("/byPage")
    public Page<LivreDto> getAllByPage(@RequestParam(defaultValue = "0") Integer pageNo,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 @RequestParam(defaultValue = "createdDate") String sortBy){
        return livreService.getAllByPage(PageRequest.of(pageNo,pageSize, Sort.by(sortBy)))
                .map(livre -> Mapper.entityToDto(livre));
    }

    @GetMapping("/{id}") //
    public LivreDto getById(@PathVariable Integer id){
        System.out.println("livre id "+ id);
        return Mapper.entityToDto(livreService.getById(id));
    }

    @PostMapping
    public ResponseEntity<LivreDto> addLivre(@Valid @RequestBody LivreDto livreDto){
        Livre livre = Mapper.dtoToEntity(livreDto);
        livreDto=Mapper.entityToDto(livreService.save(livre));
     return  ResponseEntity.created(URI.create("/"+livreDto.getId())).body(livreDto);
    }

    @PutMapping
    public LivreDto updateLivre(@Valid @RequestBody LivreDto livreDto){
        Livre livre = Mapper.dtoToEntity(livreDto);
        return Mapper.entityToDto(livreService.save(livre));
    }
    @DeleteMapping
    public ResponseEntity<?> removeLivre(int id){
         livreService.remove(id);
         return ResponseEntity.noContent().build();
    }

    @GetMapping("/test")
    public String test(){
        return   "test 1";
    }
}
