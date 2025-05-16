package com.TpJPA.GestionPeliculas.Service;

import com.TpJPA.GestionPeliculas.Model.Genero;
import com.TpJPA.GestionPeliculas.Repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    public List<Genero> getAllGeneros(){
        return generoRepository.findAll();
    }

    public Optional<Genero> updateGenero (Long id, Genero newGenero){
        return generoRepository.findById(id)
                .map(existing -> {
                    existing.setNombre(newGenero.getNombre());
                    return generoRepository.save(existing);
                });
    }


    public Optional<Genero> findById (Long id){
        return generoRepository.findById(id);
    }

    public Genero saveGenero (Genero genero){
        return generoRepository.save(genero);
    }






}
