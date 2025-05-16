package com.TpJPA.GestionPeliculas.Service;

import com.TpJPA.GestionPeliculas.Model.Resenia;
import com.TpJPA.GestionPeliculas.Repository.ReseniaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReseniaService {

    @Autowired
    private ReseniaRepository reseniaRepository;

    public List<Resenia> getAllResenias(){
        return reseniaRepository.findAll();
    }

    public Optional<Resenia> updateResenia (Long id, Resenia newResenia){
        return reseniaRepository.findById(id)
                .map(existing -> {
                    existing.setComentario(newResenia.getComentario());
                    existing.setPelicula(newResenia.getPelicula());
                    existing.setPuntuacion(newResenia.getPuntuacion());
                    return reseniaRepository.save(existing);
                });
    }

    public Optional <Resenia> findById (Long id){
        return reseniaRepository.findById(id);
    }

    public Resenia saveResenia (Resenia resenia){
        return reseniaRepository.save(resenia);
    }

}
