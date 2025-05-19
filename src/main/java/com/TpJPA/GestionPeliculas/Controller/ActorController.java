package com.TpJPA.GestionPeliculas.Controller;

import com.TpJPA.GestionPeliculas.Model.Actor;
import com.TpJPA.GestionPeliculas.Service.ActorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping ("/actores")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @PostMapping()
    public ResponseEntity<?> save (@Valid @RequestBody Actor actor){
        Actor saved = actorService.saveActor(actor);
        return ResponseEntity.ok(saved);
    }

    @GetMapping ("/{id}")
    public ResponseEntity <?> getById (@PathVariable Long id){
        Optional<Actor> opt = actorService.findById(id);

        if (opt.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(opt.get());
    }

    @GetMapping
    public ResponseEntity<?> getAll (){
        List<Actor> actores = actorService.getAllActores();
        if (actores.isEmpty()){
         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(actores);
    }



}
