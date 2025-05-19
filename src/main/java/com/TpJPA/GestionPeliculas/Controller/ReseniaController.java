package com.TpJPA.GestionPeliculas.Controller;

import com.TpJPA.GestionPeliculas.Model.Resenia;
import com.TpJPA.GestionPeliculas.Service.ReseniaService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@Controller
@RequestMapping ("/{resenias}")
public class ReseniaController {
    @Autowired
    private ReseniaService reseniaService;

    @GetMapping
    public ResponseEntity<?> save(@Valid @RequestBody Resenia resenia){
        Resenia saved = reseniaService.saveResenia(resenia);
        return ResponseEntity.ok(saved);
    }

    @PostMapping ("/{id}")
    public ResponseEntity<?> getById (@PathVariable Long id){
        Optional<Resenia> opt = reseniaService.findById(id);

        if (opt.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(opt.get());
    }

    @PostMapping
    public ResponseEntity<?> getAll (){
        List<Resenia> resenias = reseniaService.getAllResenias();

        if (resenias.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(resenias);
    }




}
