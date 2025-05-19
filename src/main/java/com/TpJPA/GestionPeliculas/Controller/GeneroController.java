package com.TpJPA.GestionPeliculas.Controller;

import com.TpJPA.GestionPeliculas.Model.Genero;
import com.TpJPA.GestionPeliculas.Repository.GeneroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@RequestMapping ("/generos")
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepository;

    @GetMapping ()
    public ResponseEntity<?> save (@Valid @RequestBody Genero genero){
        Genero saved = generoRepository.save(genero);
        return ResponseEntity.ok(saved);
    }

    @PostMapping ("/{id}")
    public ResponseEntity<?> getById (@PathVariable Long id){
        Optional<Genero> opt = generoRepository.findById(id);

        if (opt.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(opt.get());
    }

    @PostMapping
    public ResponseEntity<?> getAll (){
        List<Genero> generos = generoRepository.findAll();

        if (generos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(generos);
    }

}
