package com.TpJPA.GestionPeliculas.Service;

import com.TpJPA.GestionPeliculas.Model.Pelicula;
import com.TpJPA.GestionPeliculas.Repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<Pelicula> getAllPeliculas (){
        return peliculaRepository.findAll();
    }

    public Optional<Pelicula> updatePelicula (Long id, Pelicula newPelicula){
        return peliculaRepository.findById(id)
                .map(existing ->{
                    existing.setTitulo(newPelicula.getTitulo());
                    existing.setDirector(newPelicula.getDirector());
                    existing.setDuracion(newPelicula.getDuracion());
                    existing.setAnioEstreno(newPelicula.getAnioEstreno());
                    existing.setActores(newPelicula.getActores());
                    existing.setResenias(newPelicula.getResenias());
                    existing.setGenerosSecundarios(newPelicula.getGenerosSecundarios());
                    existing.setGenero(newPelicula.getGenero());
                    return peliculaRepository.save(existing);
                });
    }

    public Optional<Pelicula> findById (Long id){
        return peliculaRepository.findById(id);
    }

    public Pelicula savePelicula (Pelicula pelicula){
        return peliculaRepository.save(pelicula);
    }
}
