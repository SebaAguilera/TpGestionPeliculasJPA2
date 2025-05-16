package com.TpJPA.GestionPeliculas.Service;

import com.TpJPA.GestionPeliculas.Model.Actor;
import com.TpJPA.GestionPeliculas.Repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;

    public List<Actor> getAllActores(){
        return actorRepository.findAll();
    }

    public Optional<Actor> updateActor (Long id, Actor newData){
        return actorRepository.findById(id)
                .map(existing -> {
                    existing.setNacionalidad(newData.getNacionalidad());
                    existing.setNombre(newData.getNombre());
                    return actorRepository.save(existing);
                });
    }

    public Actor saveActor (Actor actor){
        return actorRepository.save(actor);
    }

    public Optional<Actor> findById (Long id){
        return actorRepository.findById(id);
    }



}
