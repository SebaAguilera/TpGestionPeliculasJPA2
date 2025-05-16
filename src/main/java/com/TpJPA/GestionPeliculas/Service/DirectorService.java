package com.TpJPA.GestionPeliculas.Service;

import com.TpJPA.GestionPeliculas.Model.Director;
import com.TpJPA.GestionPeliculas.Repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    public List<Director> getAllDirectores (){
        return directorRepository.findAll();
    }

    public Optional<Director> updateDirector (Long id, Director newDirector){
        return directorRepository.findById(id)
                .map(existing -> {
                    existing.setNombre(newDirector.getNombre());
                    return directorRepository.save(existing);
                });
    }

    public Optional<Director> findById (Long id){
        return directorRepository.findById(id);
    }

    public Director saveDirector (Director director){
        return directorRepository.save(director);
    }

}
