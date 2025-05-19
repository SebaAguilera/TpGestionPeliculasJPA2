package com.TpJPA.GestionPeliculas.Controller;

import com.TpJPA.GestionPeliculas.Model.Director;
import com.TpJPA.GestionPeliculas.Service.DirectorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping ("/directores")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @PostMapping
    public ResponseEntity<?> save (@Valid @RequestBody Director director){
        Director saved = directorService.saveDirector(director);
        return ResponseEntity.ok(saved);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<?> getById (@PathVariable Long id){
        Optional <Director> opt = directorService.findById(id);

        if (opt.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(opt.get());
    }

    @GetMapping
    public ResponseEntity<?> getAll (){
        List<Director> directores = directorService.getAllDirectores();

        if (directores.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(directores);
    }

}
